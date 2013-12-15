<?php

namespace Ibw\FamilyFinancesBundle\Controller;
use Symfony\Component\HttpFoundation\Response;

class HelloController
{
   public function getPieInfoAction()
	{
	$sql_connect= mysql_connect("localhost", "root","");
	mysql_select_db("FamilyFinances", $sql_connect);
	mysql_set_charset('utf8', $sql_connect);
	$query = mysql_query("SELECT 
						  SUM(a.cost) AS data,
						  b.name AS label,
						  0 AS OFFSET 
						  FROM  `userincome` AS a
						  LEFT JOIN income AS b ON a.income_id = b.id
						  GROUP BY
						  label");
	if ( $query != NULL ) {
		while ( $elem = mysql_fetch_assoc($query) ) {
			$elem['data'] = (int)$elem['data'];
			$elem['OFFSET'] = (int)$elem['OFFSET'];
			$pieinfo[] = $elem;
		}
	}
	mysql_close($sql_connect);
	
	return json_encode($pieinfo);
	//$pieinfo;
	}
}