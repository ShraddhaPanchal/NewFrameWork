package com.sf.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sf.qa.base.TestBase;

public class LoginPage extends TestBase {

	JavascriptExecutor js;
	// PageFactory or OR
	@FindBy(id = "ctl00_ContentPlaceHolder1_usernm")
	WebElement UserName;

	@FindBy(id = "ctl00_ContentPlaceHolder1_adminpassword")
	WebElement Password;

	@FindBy(id = "ctl00_ContentPlaceHolder1_btn_go")
	WebElement Login;

	public LoginPage() {
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor)driver;
	}

	// Actions
	public boolean Login(String username, String password) {
		UserName.sendKeys(username);
		Password.sendKeys(password);
		if (Login.isEnabled()) {
			Login.click();
			return true;
		} else
			return false;
	}

}
