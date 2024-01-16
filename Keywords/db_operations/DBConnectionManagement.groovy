package db_operations

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.sql.Connection
import java.sql.ResultSet
import java.sql.SQLException

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.ResultSetMetaData
import java.sql.SQLException
import java.sql.Statement
import com.kms.katalon.core.util.KeywordUtil
public class DBConnectionManagement {


	def Connection openConnection(String dbType) throws SQLException, ClassNotFoundException {

		Connection con = null;
		// Create Connection to DataBase
		String	dbUrl = "";
		String	username = "";
		String	password = "";

		if (dbType.equals(GlobalVariable.MCC_DB)){
			dbUrl = GlobalVariable.MCC_DB_URL;
			username =GlobalVariable.MCC_DB_Username;
			password =GlobalVariable.MCC_DB_Password;
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}else if (dbType.equals(GlobalVariable.SOF_DB)) {
			dbUrl =GlobalVariable.SOF_DBURL;
			username =GlobalVariable.SOF_DBUserName;
			password =GlobalVariable.SOF_DBPassword;
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		}
		
		//Class.forName("sqlserver.jdbc.driver.sqlserverDriver");
		

		//		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection(dbUrl, username, password);
		return con;
	}

	public ArrayList<ArrayList<Object>> executeQuery(Connection conn, String sqlQuery) throws SQLException {

		ArrayList<ArrayList<Object>> queryResults = new ArrayList<ArrayList<Object>>();
		Statement statement = conn.createStatement();
		ResultSet rs = statement.executeQuery(sqlQuery);
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		while(rs.next()) {
			ArrayList<Object> row = new ArrayList<Object>();
			for (int i = 1; i < columnsNumber + 1; i++) {
				Object columnValue = new Object();
				columnValue = rs.getObject(i);
				row.add(columnValue);
			}
			queryResults.add(row);
		}


		return queryResults;
	}

	public ResultSet executeQueryAndGetRS(Connection conn, String sqlQuery) throws SQLException {


		Statement statement = conn.createStatement();;
		ResultSet rs =  statement.executeQuery(sqlQuery);



		return rs;
	}


	public  void closeDBConnection(Connection con) throws SQLException {

		con.close();
	}
}
