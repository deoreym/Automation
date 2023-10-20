package com.EdwiserRemUI.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginLogoutPage extends BasePage {

	public LoginLogoutPage(WebDriver driver) {
		super(driver);
		
	}
	
	//Elements
	@FindBy(xpath="//a[@id='user-menu-toggle']")
	public WebElement clickonlogin;
	
	@FindBy(xpath="//input[@id='username']")
	public WebElement username;
	
	@FindBy(xpath="//input[@id='password']")
	public WebElement password;
	
	@FindBy(id="loginbtn")
	public WebElement loginbtn;
	
	@FindBy(xpath="//a[@title='Log out']")
	public WebElement logout;
	
	//Actions
	 public void clickloggintoggle() {
		 clickonlogin.click();
	 }
	 public void enterusername() {
		 username.sendKeys("admin");
	 }
	 
	 public void enterpassword() {
		 password.sendKeys("Golden0-");
	}
	 public void clickonlogin() {
		 loginbtn.click();
	 }
	 
	 public void clickonlogout() {
		 logout.click();
	 }
}
