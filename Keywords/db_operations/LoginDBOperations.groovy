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


public class LoginDBOperations extends DBConnectionManagement {




	@Keyword
	def String returnActivationCode(String mobileNo) throws SQLException, ClassNotFoundException{
		String ActivationCode=null;
		Connection conn=openConnection(GlobalVariable.MCC_DB)

		StringBuilder query = new StringBuilder();

		//mobileNo = '2' + mobileNo

		query.append("SELECT ACTIVATION_CODE FROM (SELECT SUBSTR(body,LENGTH (body)-5, 5) AS ACTIVATION_CODE FROM FA_SMS WHERE SMS_TYPE = 'Activation' and RECEIVER_ADDRESS = '"+mobileNo+"' ORDER BY CREATED_DATE DESC) WHERE ROWNUM = 1");
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(query.toString());

		while(result.next()){

			ActivationCode = result.getString("ACTIVATION_CODE");

			System.out.println(ActivationCode);
		}
		result.close();
		statement.close();

		closeDBConnection(conn);

		return ActivationCode;
	}
}
