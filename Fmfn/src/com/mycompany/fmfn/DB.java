package com.mycompany.fmfn;
import java.sql.Date;

import android.R.bool;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DB {
 
 private static final String LOG_TAG =  "myLogs";
 private static final String DB_NAME = "mydb";
 private static final int DB_VERSION = 1;
 
  //					TABLE OBJECT				\\
 //													 \\
 
 //----------------------USER---------------------\\  
 //Table name  t
 private static final String USER_TABLE = "user";
 //Attributes
 public static final String USER_COLUMN_ID 			= "_id";
 public static final String USER_COLUMN_NAME 		= "name";
 public static final String USER_COLUMN_GENDER 		= "gender";
 public static final String USER_COLUMN_DATEOFBIRTH = "day_of_birth";
 //Create table query
 private static final String USER_TABLE_CREATE = "CREATE TABLE "+ USER_TABLE + "("
		 				 + USER_COLUMN_ID + 		" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
	  					 + USER_COLUMN_NAME + 		" TEXT UNIQUE NOT NULL, " 
		 				 + USER_COLUMN_GENDER+		" TEXT, "
		 				 + USER_COLUMN_DATEOFBIRTH+ " TEXT "
	  					 +");";
 //----------------------FUND---------------------\\
 //Table name
 private static final String FUND_TABLE = "fund";
 //Attributes
 public static final String FUND_COLUMN_ID 		= "_id";
 public static final String FUND_COLUMN_NAME 	= "name";
//Create table query
 private static final String FUND_TABLE_CREATE = "CREATE TABLE "+ FUND_TABLE + "(" 
		 				+ FUND_COLUMN_ID		  +" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " 
		 				+ FUND_COLUMN_NAME		  +" TEXT UNIQUE NOT NULL " 
		 				+ ");";
 
 //----------------------EXPENSE---------------------\\
 //Table name
 private static final String EXPENSE_TABLE = "expense";
 //Attributes
 public static final String EXPENSE_COLUMN_ID		= "_id";
 public static final String EXPENSE_COLUMN_NAME 	= "name";

//Create table query
 private static final String EXPENSE_TABLE_CREATE = "CREATE TABLE "+ EXPENSE_TABLE + "(" 
		 				+ EXPENSE_COLUMN_ID	  +  " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " 
		 				+ EXPENSE_COLUMN_NAME +  " TEXT UNIQUE NOT NULL "  
		 				+ ");";
 
//----------------------INCOME---------------------\\
//Table name
private static final String INCOME_TABLE = "income";
//Attributes
public static final String INCOME_COLUMN_ID			= "_id";
public static final String INCOME_COLUMN_NAME		= "name";

//Create table query
private static final String INCOME_TABLE_CREATE = "CREATE TABLE "+ INCOME_TABLE + "(" 
		 				+ INCOME_COLUMN_ID	 +	" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " 
		 				+ INCOME_COLUMN_NAME +	" TEXT UNIQUE NOT NULL " + ");";

 //				TABLE RELATIONS					\\		
//												 \\		

//---------------RELATION-USERs-FUNDs-----------\\
//Table name
private static final String RLT_USERFUND_TABLE = "rlt_user_fund";
//Attributes
public static final String RLT_USERFUND_COLUMN_ID 		= "_id";
public static final String RLT_USERFUND_COLUMN_DATE 	= "date";
public static final String RLT_USERFUND_COLUMN_USER_ID	= "user_id";
public static final String RLT_USERFUND_COLUMN_FUND_ID	= "fund_id";
public static final String RLT_USERFUND_COLUMN_LIMIT 	= "limit";

//Create table query
private static final String RLT_USERFUND_TABLE_CREATE = "CREATE TABLE "+ RLT_USERFUND_TABLE + "("
		 				  + RLT_USERFUND_COLUMN_ID 	   	+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " 
		 				  + RLT_USERFUND_COLUMN_DATE	+" DATE DEFAULT CURRENT_DATE NOT NULL, "
		 				  + RLT_USERFUND_COLUMN_USER_ID	+" INTEGER NOT NULL REFERENCES "+ USER_TABLE +"("+USER_COLUMN_ID+"), "
		 				  + RLT_USERFUND_COLUMN_FUND_ID	+" INTEGER NOT NULL REFERENCES "+ FUND_TABLE +"("+FUND_COLUMN_ID+"), "
		 				  + RLT_USERFUND_COLUMN_LIMIT	+" INTEGER DEFAULT '150' NOT NULL "
		 				  +");";

//---------------RELATION-USER-INCOME-----------\\
//Table name
private static final String RLT_USERINCOME_TABLE = "rlt_user_income";
//Attributes
public static final String RLT_USERINCOME_COLUMN_ID			= "_id";
public static final String RLT_USERINCOME_COLUMN_DATE		= "date";
public static final String RLT_USERINCOME_COLUMN_USER_ID	= "user_id";
public static final String RLT_USERINCOME_COLUMN_FUND_ID	= "fund_id";
public static final String RLT_USERINCOME_COLUMN_INCOME_ID	= "income_id";
public static final String RLT_USERINCOME_COLUMN_COST		= "cost";


//Create table query
private static final String RLT_USERINCOME_TABLE_CREATE = "CREATE TABLE "+ RLT_USERINCOME_TABLE + "("
		 				  + RLT_USERINCOME_COLUMN_ID +" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
		 				  + RLT_USERINCOME_COLUMN_DATE	+" DATE DEFAULT CURRENT_DATE NOT NULL, "
		 				  + RLT_USERINCOME_COLUMN_USER_ID  +" INTEGER NOT NULL REFERENCES "+ USER_TABLE +"("+USER_COLUMN_ID+"), " 
		 				  + RLT_USERINCOME_COLUMN_INCOME_ID+" INTEGER NOT NULL REFERENCES "+ FUND_TABLE +"("+FUND_COLUMN_ID+"), "
		 				  + RLT_USERINCOME_COLUMN_FUND_ID+" INTEGER NOT NULL REFERENCES "+ FUND_TABLE+"("+ FUND_COLUMN_ID +"), "
		 				  + RLT_USERINCOME_COLUMN_COST	+" INTEGER DEFAULT '1000' NOT NULL"
		 				  + ");";
 
//---------------RELATION-USER-EXPENSE-----------\\
//Table name
private static final String RLT_USEREXPENSE_TABLE = "rlt_user_income";
//Attributes
public static final String RLT_USEREXPENSE_COLUMN_ID 		= "_id";
public static final String RLT_USEREXPENSE_COLUMN_DATE		= "date";
public static final String RLT_USEREXPENSE_COLUMN_TIME		= "time";
public static final String RLT_USEREXPENSE_COLUMN_USER_ID 	= "user_id";
public static final String RLT_USEREXPENSE_COLUMN_FUND_ID	= "fund_id";
public static final String RLT_USEREXPENSE_COLUMN_EXPENSE_ID= "expense_id";
public static final String RLT_USEREXPENSE_COLUMN_COST		= "cost";
public static final String RLT_USEREXPENSE_COLUMN_AMOUNT	= "amount";



//Create table query
private static final String RLT_USEREXPENSE_TABLE_CREATE = "CREATE TABLE "+ RLT_USEREXPENSE_TABLE + "("
		 				  + RLT_USEREXPENSE_COLUMN_ID 			+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
		 				  + RLT_USEREXPENSE_COLUMN_DATE			+" DATE DEFAULT CURRENT_DATE NOT NULL, "
		 				  + RLT_USEREXPENSE_COLUMN_TIME			+" TIME DEFAULT CURRENT_TIME NOT NULL, "
		 				  + RLT_USEREXPENSE_COLUMN_USER_ID  	+" INTEGER NOT NULL REFERENCES "+ USER_TABLE +"("+USER_COLUMN_ID+"), "
		 				  + RLT_USEREXPENSE_COLUMN_FUND_ID		+" INTEGER NOT NULL REFERENCES "+ FUND_TABLE +"("+FUND_COLUMN_ID+"), "
		 				  + RLT_USEREXPENSE_COLUMN_EXPENSE_ID	+" INTEGER NOT NULL REFERENCES "+ EXPENSE_TABLE +"("+EXPENSE_COLUMN_ID+"), " 
		 				  + RLT_USEREXPENSE_COLUMN_COST			+" INTEGER DEFAULT '100' NOT NULL, "
		 				  + RLT_USEREXPENSE_COLUMN_AMOUNT		+" INTEGER DEFAULT '1' NOT NULL "
		 				  + ");"; 

  private final Context mCtx;

  private DBHelper mDBHelper;
  private SQLiteDatabase mDB;

  public DB(Context ctx) {
    mCtx = ctx;
  }

  // ��������� �����������
  public void open() {
    mDBHelper = new DBHelper(mCtx, DB_NAME, null, DB_VERSION);
    mDB = mDBHelper.getWritableDatabase();
  }
  
  // ��������� �����������
  public void close() {
    if (mDBHelper != null)
      mDBHelper.close();
  }
  
////////////////////////////////////////////////////////////////////////////////////////////////
//---------------------PUBLIC INSERT METHODS-----------------------------------------------------//

//USER TABLE
//���������� ������ ������������ ���������� ID ����������� ������
public long userInsertTable(String value_column_name, String value_column_gender, String value_column_day_of_birth){
	  
	  ContentValues cv = new ContentValues();
	  cv.put(USER_COLUMN_NAME, value_column_name);
	  cv.put(USER_COLUMN_GENDER, value_column_gender);
	  cv.put(USER_COLUMN_DATEOFBIRTH, value_column_day_of_birth);
  
      long rowID = insertRow(USER_TABLE, cv);
      
      return rowID;
}
  
//FUND TABLE  
//���������� ������ ����� ���������� ID ����������� ������
public long fundInsertTable(String value_column_name){
	  
	  ContentValues cv = new ContentValues();
	  cv.put(FUND_COLUMN_NAME, value_column_name);
	  
      long rowID = insertRow(FUND_TABLE, cv);
      
      return rowID;
}
  
//EXPENSE TABLE  
public long expenseInsertTable(String value_column_name){
	  
	  ContentValues cv = new ContentValues();
	  cv.put(EXPENSE_COLUMN_NAME, value_column_name);
 
      long rowID = insertRow(EXPENSE_TABLE, cv);
      
      return rowID;
  }

//INCOME TABLE
public long incomeInsertTable(String value_column_name){
	  
	  ContentValues cv = new ContentValues();
	  cv.put(INCOME_COLUMN_NAME, value_column_name);
	  
	  long rowID = mDB.insert(INCOME_TABLE, null, cv);
    
	  return rowID;
}

//RLT_USER_FUND TABLE
public long rltUserFundInsertTable(String userName, String userFund, String userLimit){
	  
	  ContentValues cv = new ContentValues();
	  cv.put(RLT_USERFUND_COLUMN_USER_ID, userName);
	  cv.put(RLT_USERFUND_COLUMN_FUND_ID, userFund);
	  cv.put(RLT_USERFUND_COLUMN_LIMIT, userLimit);
	  long rowID = mDB.insert(RLT_USERFUND_TABLE, null, cv);
	  
	  return rowID;
}

//RLT_USER_INCOME TABLE
public long rltIncomeUserInsertTable(long value_column_user_id, long value_column_fund_id, long value_column_income_id , int value_column_cost){
	  
	  ContentValues cv = new ContentValues();
	  cv.put(RLT_USERINCOME_COLUMN_USER_ID, value_column_user_id);
	  cv.put(RLT_USERINCOME_COLUMN_FUND_ID, value_column_fund_id);
	  cv.put(RLT_USERINCOME_COLUMN_INCOME_ID, value_column_user_id);
	  cv.put(RLT_USERINCOME_COLUMN_COST, value_column_cost);

	  long rowID = insertRow(RLT_USERINCOME_TABLE, cv);
  
	  return rowID;
}

//RLT_USER_EXPENSE TABLE
public long rltExpenseUserInsertTable(long value_column_user_id, long value_column_fund_id, long value_column_income_id , int value_column_cost, int value_column_amount){
	  
	  ContentValues cv = new ContentValues();
	  cv.put(RLT_USEREXPENSE_COLUMN_USER_ID, value_column_user_id);
	  cv.put(RLT_USEREXPENSE_COLUMN_FUND_ID, value_column_fund_id);
	  cv.put(RLT_USEREXPENSE_COLUMN_EXPENSE_ID, value_column_user_id);
	  cv.put(RLT_USEREXPENSE_COLUMN_COST, value_column_cost);
	  cv.put(RLT_USEREXPENSE_COLUMN_AMOUNT, value_column_cost);
	  
	  long rowID = insertRow(RLT_USEREXPENSE_TABLE, cv); 
	   
	  return rowID;
}
////////////////////////////////////////////////////////////////////////////////////////////////
//---------------------PUBLIC UPDATE METHODS-----------------------------------------------------//

//USER TABLE
//���������� ������ ������������ ���������� ID ����������� ������
public long userUpdateTable(String value_column_name, String value_column_gender, String value_column_day_of_birth, String id){
	  
	  ContentValues cv = new ContentValues();
	  cv.put(USER_COLUMN_NAME, value_column_name);
	  cv.put(USER_COLUMN_GENDER, value_column_gender);
	  cv.put(USER_COLUMN_DATEOFBIRTH, value_column_day_of_birth);
	  String [] mas_id = new String[]{id };
    long rowID = updateRow(USER_TABLE, cv, USER_COLUMN_ID + " =?", mas_id);
    
    return rowID;
}

//FUND TABLE  
//���������� ������ ����� ���������� ID ����������� ������
public long fundUpdateTable(String value_column_name, String id){
	 
	//������������ ��������� �����
	  ContentValues cv = new ContentValues();
	  cv.put(FUND_COLUMN_NAME, value_column_name);
	  String [] mas_id = new String[]{id };
	  long rowID = updateRow(FUND_TABLE, cv, FUND_COLUMN_ID + " =?", mas_id);
    
    return rowID;
}

//EXPENSE TABLE  
public long expenseUpdateTable(String value_column_name, String id){
	  
	  ContentValues cv = new ContentValues();
	  cv.put(EXPENSE_COLUMN_NAME, value_column_name);
	  String [] mas_id = new String[]{id };
	  long rowID = updateRow(EXPENSE_TABLE, cv, EXPENSE_COLUMN_ID + " =?", mas_id);
    
    return rowID;
}

//INCOME TABLE
public long incomeUpdateTable(String value_column_name, String id){
	  
	  ContentValues cv = new ContentValues();
	  cv.put(INCOME_COLUMN_NAME, value_column_name);
	  String [] mas_id = new String[]{id };
	  long rowID = updateRow(INCOME_TABLE, cv, INCOME_COLUMN_ID + " =?", mas_id);
	  
	  return rowID;
}

//RLT_USER_FUND TABLE
public long rltUserFundUpdateTable(long value_column_user_id, long value_column_fund_id, int value_column_limit, String id){
	  
	  ContentValues cv = new ContentValues();
	  cv.put(RLT_USERFUND_COLUMN_USER_ID, value_column_user_id);
	  cv.put(RLT_USERFUND_COLUMN_FUND_ID, value_column_fund_id);
	  cv.put(RLT_USERFUND_COLUMN_LIMIT, value_column_limit);
	  String [] mas_id = new String[]{id };
	  long rowID = updateRow(RLT_USERFUND_TABLE, cv, RLT_USERFUND_COLUMN_ID + " =?",mas_id);
	  
	  return rowID;
}

//RLT_USER_INCOME TABLE
public long rltIncomeUserUpdateTable(long value_column_user_id, long value_column_fund_id, long value_column_income_id , int value_column_cost, String id){
	  
	  ContentValues cv = new ContentValues();
	  cv.put(RLT_USERINCOME_COLUMN_USER_ID, value_column_user_id);
	  cv.put(RLT_USERINCOME_COLUMN_FUND_ID, value_column_fund_id);
	  cv.put(RLT_USERINCOME_COLUMN_INCOME_ID, value_column_user_id);
	  cv.put(RLT_USERINCOME_COLUMN_COST, value_column_cost);
	  String [] mas_id = new String[]{id };
	  long rowID = updateRow(RLT_USERINCOME_TABLE, cv, RLT_USERINCOME_COLUMN_ID + " =?", mas_id);

	  return rowID;
}

//RLT_USER_EXPENSE TABLE
public long rltExpenseUserUpdateTable(String value_column_user_id, String value_column_fund_id, long value_column_income_id , String value_column_cost, int value_column_amount, String id){
	  
	 ContentValues cv = new ContentValues();
	  cv.put(RLT_USEREXPENSE_COLUMN_USER_ID, value_column_user_id);
	  cv.put(RLT_USEREXPENSE_COLUMN_FUND_ID, value_column_fund_id);
	  cv.put(RLT_USEREXPENSE_COLUMN_EXPENSE_ID, value_column_user_id);
	  cv.put(RLT_USEREXPENSE_COLUMN_COST, value_column_cost);
	  cv.put(RLT_USEREXPENSE_COLUMN_AMOUNT, value_column_cost);
	  String [] mas_id = new String[]{id };
	  long rowID = updateRow(RLT_USEREXPENSE_TABLE, cv, RLT_USEREXPENSE_COLUMN_ID + " = ", mas_id); 
	   
	  return rowID;
}
////////////////////////////////////////////////////////////////////////////////////////////////
//---------------------PUBLIC DELETE METHODS--------------------------------------------------//

public void delete_UserFundTable(long id) {
    mDB.delete(RLT_USERFUND_TABLE, RLT_USERFUND_COLUMN_ID + " = " + id, null);
  }
public void user_delete(long id){
    mDB.delete(USER_TABLE, USER_COLUMN_ID + " = " + id, null);
  }
////////////////////////////////////////////////////////////////////////////////////////////////
//---------------------PUBLIC GET METHODS-----------------------------------------------------//
 
  //GET USER LIST
  public Cursor getAllUserData() {
	  return mDB.query(USER_TABLE, null, null, null, null, null, null);
  }
  
  //GET FUND LIST
  public Cursor getAllFundData() {
	  return mDB.query(FUND_TABLE, null, null, null, null, null, null); 
  }
  
  //GET EXPENSE LIST
  public Cursor getAllExpenseData() {
	  return mDB.query(EXPENSE_TABLE, null, null, null, null, null, null);
  }
  
  //GET INCOME LIST
  public Cursor getAllIncomeData() {
	  return mDB.query(INCOME_TABLE, null, null, null, null, null, null);
  }
  
//GET RLT_USER_FUND LIST
  public Cursor getAllUserFundData() {
	  Cursor result = null;
	  try{
		  result = mDB.query(RLT_USERFUND_TABLE, null, null, null, null, null, null);
	  }catch(SQLException ex)
	  {
		  Log.d(LOG_TAG, " NOT GET!!!EXEPTION");
	  }
	  return result;
  }
  
//GET RLT_USER_INCOME LIST
  public Cursor getAllUserIncomeData() {
	  return mDB.query(RLT_USERINCOME_TABLE, null, null, null, null, null, null);
  }
  
//GET RLT_USER_EXPENSE LIST
  public Cursor getAllUserExpenseData() {
	  return mDB.query(RLT_USEREXPENSE_TABLE, null, null, null, null, null, null);
  }
  
  
  //GET RESULT OF QUERY
  public Cursor Query(String table,String [] columns,String selection,String [] selectionArgs,String groupBy,String having,String orderBy){
	  Cursor cur = null;
	  cur = mDB.query(table, columns, selection, selectionArgs, groupBy, having, orderBy);
	  return cur;
  }
  
  ////////////////////////////////////////////////////////////////
  //-------------------PRIVATE METHODS--------------------------//
  
  private long insertRow(String TABLE_NAME, ContentValues cv){
	  long rowID = -1;
	  mDB.beginTransaction();
	  try{
		  rowID = mDB.insert(TABLE_NAME, null, cv);
		  mDB.setTransactionSuccessful();
	  }
	  finally {
		  mDB.endTransaction();
	  }
	  return rowID;
  }
  
  private long updateRow(String TABLE_NAME, ContentValues cv, String column_name ,String[] id){
	  long rowID = -1;
	  mDB.beginTransaction();
	  try{
		  rowID = mDB.update(TABLE_NAME, cv, column_name, id);
		  mDB.setTransactionSuccessful();
	  }
	  finally {
		  mDB.endTransaction();
	  }
	  return rowID;
  }
  
  private ContentValues getColumns(String [] columns, String[] values){
	  ContentValues cv = new ContentValues();
	  for (int i = 0; i < columns.length ; i++){
		  cv.put(columns[i],values[i]);
	  }
	  return cv;
  }
  
  
  
  private class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context, String name, CursorFactory factory,
        int version) {
      super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      //ContentValues cv = new ContentValues();

      // ����� ������ (�����)
      //String[] companies = new String[] { "����", "������", "�����" };
      
      //CREATE USER TABLE
      try{
    	  db.execSQL(USER_TABLE_CREATE);
    	  Log.d(LOG_TAG, "--- CREATE TABLE "+ USER_TABLE+ ": ---");
      } catch(SQLException ex) {
    	  Log.d(LOG_TAG, USER_TABLE + " NOT CREATED");  
      };
      
      //CREATE FUND TABLE
      try{
      db.execSQL(FUND_TABLE_CREATE);
      Log.d(LOG_TAG, "--- CREATE TABLE "+ FUND_TABLE+ ": ---");
      } catch(SQLException ex) {
    	  Log.d(LOG_TAG, FUND_TABLE + " NOT CREATED"); 
      };
      
      //CREATE EXPENSE TABLE
      try{
      db.execSQL(EXPENSE_TABLE_CREATE);
      Log.d(LOG_TAG, "--- CREATE TABLE "+ EXPENSE_TABLE+ ": ---");
      } catch(SQLException ex) {
    	  Log.d(LOG_TAG, EXPENSE_TABLE + " NOT CREATED"); 
      };
      
      //CREATE INCOME TABLE
      try{
      db.execSQL(INCOME_TABLE_CREATE);
      Log.d(LOG_TAG, "--- CREATE TABLE "+ INCOME_TABLE+ ": ---");
      } catch(SQLException ex) {
    	  Log.d(LOG_TAG, INCOME_TABLE + " NOT CREATED"); 
      };
      
      //CREATE RLT_USERFUND TABLE
      try{
      db.execSQL(RLT_USERFUND_TABLE_CREATE);
      Log.d(LOG_TAG, "--- CREATE TABLE "+ RLT_USERFUND_TABLE+ ": ---");
      } catch(SQLException ex) {
    	  Log.d(LOG_TAG, RLT_USERFUND_TABLE + " NOT CREATED"); 
      };
      
      //CREATE RLT_USEREXPENSE TABLE
      try{
      db.execSQL(RLT_USEREXPENSE_TABLE_CREATE);
      Log.d(LOG_TAG, "--- CREATE TABLE "+ RLT_USEREXPENSE_TABLE + ": ---");
      } catch(SQLException ex) {
    	  Log.d(LOG_TAG, RLT_USEREXPENSE_TABLE + " NOT CREATED"); 
      };
      
      //CREATE RLT_USERINCOME TABLE
      try{
      db.execSQL(RLT_USERINCOME_TABLE_CREATE);
      Log.d(LOG_TAG, "--- CREATE TABLE "+ RLT_USERINCOME_TABLE+ ": ---");
      } catch(SQLException ex) {
    	  Log.d(LOG_TAG, RLT_USERINCOME_TABLE + " NOT CREATED :"); 
      };
      
      /*for (int i = 0; i < companies.length; i++) {
        cv.put(USER_COLUMN_ID, i + 1);
        cv.put(USER_COLUMN_NAME, companies[i]);
        db.insert(USER_TABLE, null, cv);
      }

      // �������� ��������� (���������)
      String[] phonesHTC = new String[] { "��������� �������", "������",
          "������" };
      String[] phonesSams = new String[] { "��������� �������", "������",
          "������" };
      String[] phonesLG = new String[] { "������������ ������", "������� �� ���",
          "����������", "������" };

      // ������� � ��������� ������� ���������
      
      cv.clear();
      /*for (int i = 0; i < phonesHTC.length; i++) {
        cv.put(FUND_COLUMN_RLTUSER, 1);
        cv.put(FUND_COLUMN_NAME, phonesHTC[i]);
        db.insert(FUND_TABLE, null, cv);
      }
      for (int i = 0; i < phonesSams.length; i++) {
        cv.put(FUND_COLUMN_RLTUSER, 2);
        cv.put(FUND_COLUMN_NAME, phonesSams[i]);
        db.insert(FUND_TABLE, null, cv);
      }
      for (int i = 0; i < phonesLG.length; i++) {
        cv.put(FUND_COLUMN_RLTUSER, 3);
        cv.put(FUND_COLUMN_NAME, phonesLG[i]);
        db.insert(FUND_TABLE, null, cv);
      }*/
   }
    
    //�������� �������
    /*//RLT_USER_EXPENSE TABLE
		public long rltExpenseUserUpdateTable(String value_column_user_id, String value_column_fund_id, long value_column_income_id , String value_column_cost, int value_column_amount){
	  
	  String [] columns = new String[]{RLT_USEREXPENSE_COLUMN_USER_ID,RLT_USEREXPENSE_COLUMN_FUND_ID,RLT_USEREXPENSE_COLUMN_EXPENSE_ID,RLT_USEREXPENSE_COLUMN_COST,RLT_USEREXPENSE_COLUMN_AMOUNT};
	  String [] values = new String[] {value_column_user_id, value_column_fund_id, value_column_user_id, value_column_cost, value_column_cost};
	  
	  ContentValues cv = getColumns(columns, values);
	  
	  long rowID = insertRow(RLT_USEREXPENSE_TABLE, cv); 
	   
	  return rowID;
 } */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
  }
}


