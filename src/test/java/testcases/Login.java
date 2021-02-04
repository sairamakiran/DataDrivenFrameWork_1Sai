package testcases;

import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

public class Login extends TestBase 
{
	

	public void Login_Creds(String email,String password)
	{
		type("emailID_ID",email);
		type("password_ID",password);
		click("loginbutton_ID");
	}
}
