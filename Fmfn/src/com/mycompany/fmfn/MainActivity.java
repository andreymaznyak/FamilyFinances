package com.mycompany.fmfn;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.database.*;
import android.content.*;
import java.util.*;
import java.util.zip.*;
import org.xml.sax.*;
import android.graphics.drawable.*;
import java.io.*;
import android.view.View.*;
import android.widget.AdapterView.*;

public class MainActivity extends Activity
{
    public static DB db;
	private static final int IDM_ADD = 101;
	private static final int IDM_EDIT = 102;
	private static final int IDM_DELETE = 103;
	Cursor cursor;
	ListView listv;
	Activity act;
	private int currentPostion;
	private long currentId;
	
	/** Called when the activity is first created. */
    String status[] = {"Муж","Жена","Сын","Дочь","Близкий"};
	@Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		db = new DB(this);
		db.open();
		cursor = db.getAllUserData();
		act = this;
		//list adapter
		String[] from = {DB.USER_COLUMN_NAME , DB.USER_COLUMN_GENDER, DB.USER_COLUMN_ID};
		int[]  to = {R.id.itemTextView1, R.id.itemTextView2, R.id.itemTextView3};
		listv = (ListView) this.findViewById(R.id.userlist);
		listv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.item,cursor, from, to);
		listv.setAdapter(adapter);
		for(int i= 0 ; i < listv.getCount(); i++){
		sendShortText("pos = "+i+" id = "+listv.getItemIdAtPosition(i)
		             + " " + listv.getSelectedItemId());
		}
		sendShortText("hello");
		listv.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view, int position, long id){
				currentPostion = position;
				currentId = id;
				sendShortText("position = "+ position+" id = "+ id);
			}
		});
		
    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		menu.add(Menu.NONE, IDM_ADD, Menu.NONE, R.string.add)
		.setIcon(android.R.drawable.btn_plus)
		.setAlphabeticShortcut('a');
		menu.add(Menu.NONE, IDM_EDIT, Menu.NONE, R.string.edit)
		.setIcon(android.R.drawable.edit_text).setAlphabeticShortcut('e');
		menu.add(Menu.NONE, IDM_DELETE, Menu.NONE, R.string.delete).setIcon(android.R.drawable.ic_delete).setAlphabeticShortcut('d');
		return super.onCreateOptionsMenu(menu);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
		final long id = currentId; //listv.getItemIdAtPosition(currentPostion);
		//sendShortText("item.getItemId = "+ item.getItemId() + " id " + id);
		switch(item.getItemId()){	
			case IDM_ADD: {
				CallAddContactDialog();
			}
			break;
			case IDM_EDIT:
			if(id > 0){
				CallEditContactDialog(id);
			}
			else {
				Toast.makeText(this, "Пожалуйста выберите члена семьи ",Toast.LENGTH_SHORT).show();
			}
			break;
			case IDM_DELETE:
			if(id > 0) {
				CallDeleteContactDialog(id);
			}
			else {
				Toast.makeText(this, "Пожалуйста выберите члена семьи ",Toast.LENGTH_SHORT).show();
			}
		}
		return super.onOptionsItemSelected(item);
	}
	private void sendShortText(String text){
		Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
	}
	private void CallAddContactDialog(){
		LayoutInflater inflater = LayoutInflater.from(this);
		View root = inflater.inflate(R.layout.additem, null);
		
		final EditText textName = (EditText) root.findViewById(R.id.user_et);
		final Spinner spStatus = (Spinner) root.findViewById(R.id.user_sp_status);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, status);
		spStatus.setAdapter(adapter); 
		
		AlertDialog.Builder b = new AlertDialog.Builder(this);
		b.setView(root);
		b.setTitle(R.string.user);
		b.setPositiveButton(
		R.string.add, new DialogInterface.OnClickListener(){
			public void onClick(DialogInterface dialog, int whichButton){
		
			db.userInsertTable(textName.getText().toString(),spStatus.getSelectedItem().toString(), "");
			cursor.requery();
			}
		});
		b.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int withButton) {}
		});
		b.show();
	}
	private void CallEditContactDialog(final long id){
		LayoutInflater inflater = LayoutInflater.from(this);
		View root = inflater.inflate(R.layout.additem, null);
		
		final EditText userName = (EditText) root.findViewById(R.id.user_et);
		final Spinner userstatus = (Spinner) root.findViewById(R.id.user_sp_status);
		
		cursor.moveToPosition(currentPostion);
		userName.setText(cursor.getString(1));
		ArrayAdapter<String> adapter =new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, status);
		userstatus.setAdapter(adapter);
		String statusItem = cursor.getString(2);
		
		for(int i= 0; i < adapter.getCount(); i++){
			//sendShortText(statusItem.trim()+ "=" +status[i]+";" + (status[i].contentEquals(statusItem)));
			if(status[i].contentEquals(statusItem)){
				userstatus.setSelection(i);
			}
		}
		//userstatus.   (cursor.getString(2));
		
		AlertDialog.Builder b = new AlertDialog.Builder(this);
		b.setView(root);
		b.setTitle(R.string.user);
		
		b.setPositiveButton(
		R.string.add, new DialogInterface.OnClickListener(){
			public void onClick(DialogInterface dialog, int whichButton) {
				
				db.userUpdateTable(userName.getText().toString(),userstatus.getSelectedItem().toString(), "", "" + id);
				cursor.requery();
			}
		});
		b.setNegativeButton(
		android.R.string.cancel, new DialogInterface.OnClickListener(){
			public void onClick(DialogInterface dialog, int whichButton){}
			
		});
		b.show();
	}
	private void CallDeleteContactDialog(final long id){
		AlertDialog.Builder b = new AlertDialog.Builder(this);
		b.setTitle(R.string.user);
		b.setMessage("Удалить члена семьи?");
		
		b.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener(){
			public void onClick(DialogInterface dialog, int whichButton) {
				db.user_delete(id);
				cursor.requery();
			}
		});
		b.setNegativeButton(
		       android.R.string.cancel, new DialogInterface.OnClickListener() {
				   public void onClick(DialogInterface dialog, int whichButton) {}
			   });
	    b.show();
	}
}
