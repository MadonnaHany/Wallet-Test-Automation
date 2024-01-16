package db_operations

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

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
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.ResultSetMetaData
import java.sql.SQLException
import java.sql.Statement
import com.kms.katalon.core.util.KeywordUtil
public class RechargeDBOperations extends DBConnectionManagement {

	@Keyword
	def GetDailyLimit(String Mobile) throws SQLException, ClassNotFoundException{
		Double dailyLimit;
		Connection conn=openConnection(GlobalVariable.SOF_DB)

		StringBuilder query = new StringBuilder();

		if (GlobalVariable.SOF_DBURL.toString().contains("sqlserver"))
			query.append("select DAILY_LIMIT from [POS_SOF].[dbo].[ACCOUNTS] where code='"+Mobile+"'");
		else
			query.append("select DAILY_LIMIT from accounts where code='"+Mobile+"'");
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(query.toString());

		while(result.next()){

			dailyLimit = result.getDouble("DAILY_LIMIT");

			KeywordUtil.logInfo("Daily limit is : " + dailyLimit)
		}
		result.close();
		statement.close();
		/*
		 ArrayList<ArrayList<Object>> rs=executeQuery(conn,query.toString());
		 String ActiveCode=rs.get(0).get(0).toString()
		 */
		closeDBConnection(conn);

		return dailyLimit;
	}


	@Keyword
	def GetBalance(String Mobile) throws SQLException, ClassNotFoundException{
		Double Balance;
		Connection conn=openConnection(GlobalVariable.SOF_DB)

		StringBuilder query = new StringBuilder();

		if (GlobalVariable.SOF_DBURL.toString().contains("sqlserver"))
			query.append("select Balance from [POS_SOF].[dbo].[ACCOUNTS] where code='"+Mobile+"'");
		else
			query.append("select Balance from accounts where code='"+Mobile+"'");
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(query.toString());

		while(result.next()){

			Balance = result.getDouble("Balance");

			KeywordUtil.logInfo("Balance is : " + Balance)
		}
		result.close();
		statement.close();

		closeDBConnection(conn);

		return Balance;
	}
	@Keyword
	def updateTheAccountBalance(double Amount,String Mobile) throws SQLException, ClassNotFoundException{

		Connection conn=openConnection(GlobalVariable.SOF_DB)

		StringBuilder query = new StringBuilder();

		if (GlobalVariable.SOF_DBURL.toString().contains("sqlserver")) {
			query.append("update [POS_SOF].[dbo].[ACCOUNTS] set balance="+Amount+"where code='"+Mobile+"'");
			Statement statement = conn.createStatement();
			statement.executeUpdate(query.toString());
		}
		else {

			query.append("update accounts set balance="+Amount+"where code='"+Mobile+"'");
			Statement statement = conn.createStatement();
			statement.executeQuery(query.toString());
		}

		closeDBConnection(conn);
	}


	// new one

	def String GetMobileNumForSendingMoney() throws SQLException, ClassNotFoundException{
		String BillingAcct =null;
		Connection conn=openConnection(GlobalVariable.SOF_DB)

		StringBuilder query = new StringBuilder();

		if (GlobalVariable.SOF_DBURL.toString().contains("sqlserver"))
			query.append("select TOP 1 CODE from [POS_SOF].[dbo].[ACCOUNTS] where TERMINAL_STATUS_ID = '1' AND PRIMARY_ACCT_ID IS NULL AND ACCOUNT_TYPE_ID = '2' ORDER BY CREATION_DATE DESC ");

		else
			query.append("SELECT CODE FROM (SELECT CODE FROM ACCOUNTS WHERE TERMINAL_STATUS_ID = 1 AND PRIMARY_ACCT_ID IS NULL AND ACCOUNT_TYPE_ID = 2 ORDER BY CREATION_DATE DESC)WHERE ROWNUM = 1");
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(query.toString());

		while(result.next()){

			BillingAcct = result.getString("CODE");

			System.out.println(BillingAcct);
		}
		result.close();
		statement.close();

		closeDBConnection(conn);

		return BillingAcct;
	}


	/////

	@Keyword
	def updateTheDailyLimit(double Amount,String Mobile) throws SQLException, ClassNotFoundException{

		Connection conn=openConnection(GlobalVariable.SOF_DB)

		StringBuilder query = new StringBuilder();

		if (GlobalVariable.SOF_DBURL.toString().contains("sqlserver")) {

			query.append("update [POS_SOF].[dbo].[ACCOUNTS] set DAILY_LIMIT="+Amount+"where code='"+Mobile+"'");
			Statement statement = conn.createStatement();
			statement.executeUpdate(query.toString());
		}
		else {
			query.append("update accounts set DAILY_LIMIT="+Amount+"where code='"+Mobile+"'");
			Statement statement = conn.createStatement();
			statement.executeQuery(query.toString());
		}

		closeDBConnection(conn);
	}


	@Keyword
	def updateTheDailycollectedAmt(double Amount,String Mobile) throws SQLException, ClassNotFoundException{

		Connection conn=openConnection(GlobalVariable.SOF_DB)

		StringBuilder query = new StringBuilder();

		if (GlobalVariable.SOF_DBURL.toString().contains("sqlserver")) {
			query.append("update [POS_SOF].[dbo].[ACCOUNTS] set DAILY_COLLECTED_AMOUNT="+Amount+"where code='"+Mobile+"'");
			Statement statement = conn.createStatement();
			statement.executeUpdate(query.toString());
		}
		else {
			query.append("update accounts set DAILY_COLLECTED_AMOUNT="+Amount+"where code='"+Mobile+"'");
			Statement statement = conn.createStatement();
			statement.executeQuery(query.toString());
		}

		closeDBConnection(conn);
	}


	@Keyword
	def Reset_DAILY_CREDIT_COLLECTED_AMOUNT(double Amount,String Mobile) throws SQLException, ClassNotFoundException{

		Connection conn=openConnection(GlobalVariable.SOF_DB)

		StringBuilder query = new StringBuilder();

		if (GlobalVariable.SOF_DBURL.toString().contains("sqlserver")) {
			query.append("update [POS_SOF].[dbo].[ACCOUNTS] set DAILY_CREDIT_COLLECTED_AMOUNT="+Amount+"where code='"+Mobile+"'");
			Statement statement = conn.createStatement();
			statement.executeUpdate(query.toString());
		}
		else {
			query.append("update accounts set DAILY_CREDIT_COLLECTED_AMOUNT="+Amount+"where code='"+Mobile+"'");
			Statement statement = conn.createStatement();
			statement.executeQuery(query.toString());
		}

		closeDBConnection(conn);
	}

	def update_Monthly_collectedAmt(double Amount,String Mobile) throws SQLException, ClassNotFoundException{

		Connection conn=openConnection(GlobalVariable.SOF_DB)

		StringBuilder query = new StringBuilder();

		if (GlobalVariable.SOF_DBURL.toString().contains("sqlserver")) {
			query.append("update [POS_SOF].[dbo].[ACCOUNTS] set MONTHLY_DEBIT_COLLECTED_AMOUNT="+Amount+"where code='"+Mobile+"'");
			Statement statement = conn.createStatement();
			statement.executeUpdate(query.toString());
		}
		else {
			query.append("update accounts set MONTHLY_DEBIT_COLLECTED_AMOUNT="+Amount+"where code='"+Mobile+"'");
			Statement statement = conn.createStatement();
			statement.executeQuery(query.toString());
		}

		closeDBConnection(conn);
	}


	def update_Weekly_collectedAmt(double Amount,String Mobile) throws SQLException, ClassNotFoundException{

		Connection conn=openConnection(GlobalVariable.SOF_DB)

		StringBuilder query = new StringBuilder();

		if (GlobalVariable.SOF_DBURL.toString().contains("sqlserver")) {
			query.append("update [POS_SOF].[dbo].[ACCOUNTS] set WEEKLY_DEBIT_COLLECTED_AMT="+Amount+"where code='"+Mobile+"'");
			Statement statement = conn.createStatement();
			statement.executeUpdate(query.toString());
		}
		else {
			query.append("update accounts set WEEKLY_DEBIT_COLLECTED_AMT="+Amount+"where code='"+Mobile+"'");
			Statement statement = conn.createStatement();
			statement.executeQuery(query.toString());
		}

		closeDBConnection(conn);
	}
}
