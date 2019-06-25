package com.sf.qa.testcases;

import com.sf.qa.pages.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.sf.qa.base.TestBase;

public class LoginTests extends TestBase {

	LoginPage loginPage;
	
	//constructor
	public LoginTests() {
		super();
		
	}
	
	@BeforeTest
	public void TestInitialization()
	{
		initialization();
		loginPage = new LoginPage();
	}

	@Test
	public void loginTest() {
		
		loginPage.Login(prop.getProperty("Username"), prop.getProperty("Password"));
		System.out.println("open quore home page");
	}
	
	@AfterTest
	public void TestCleanup()
	{
		cleanup();
	}
}
