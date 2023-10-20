package com.EdwiserRemUI.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FootercustomizerPage extends BasePage {

	public FootercustomizerPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//h6[text()='Footer']")
	public WebElement footermenu;
	
	@FindBy(xpath="//h6[text()='Footer bottom area']")
	public WebElement fbottomareamenu;
	
	@FindBy(xpath="//div[@class='d-flex align-items-center flex-gap-d5']//label[@for='id_footershowlogo']")
	public WebElement c_showlogo;
	
	@FindBy(xpath="//div[@class='d-flex align-items-center flex-gap-d5']//label[@for='id_footerprivacypolicyshow']")
	public WebElement c_privacypolicy;
	
	@FindBy(xpath="//div[@class='custom-control custom-switch']//label[@for='id_footerprivacypolicyshow']")
	public WebElement privacypolicychbx;
	
	@FindBy(id="id_footerprivacypolicy")
	public WebElement c_privacypolicytext;

	@FindBy(xpath="//div[@class='d-flex align-items-center flex-gap-d5']//label[@for='id_footertermsandconditionsshow']")
	public WebElement c_tcshow;
	
	@FindBy(id="id_footertermsandconditions")
	public WebElement c_tcshowtext;
	
	@FindBy(xpath="//div[@class='d-flex align-items-center flex-gap-d5']//label[@for='id_footercopyrightsshow']")
	public WebElement c_copyright;
	
	@FindBy(id="id_footercopyrights")
	public WebElement c_copyrighttext;
	
	@FindBy(xpath="//div[@class='d-flex align-items-center flex-gap-d5']//label[@for='id_poweredbyedwiser']")
	public WebElement c_poweredbyed;
	
	@FindBy(xpath="//a[text()='Privacy Policy']")
	public List<WebElement> f_privacypolicy;
	
	@FindBy(linkText="Privacy Policy")
	public WebElement f_privacypolicy1;
		
	@FindBy(xpath="//a[text()='Terms & Conditions']")
	public List<WebElement> f_tc;
	
	@FindBy(linkText="Terms & Conditions")
	public WebElement f_termsandcond;
	
	@FindBy(xpath="//div[@class='copyright-content secondary-footer-copyright ']")
	public List<WebElement> f_copyright;
	
	@FindBy(xpath="//p[@class=' mb-0']")
	public WebElement copyrighttext; 
	
	@FindBy(xpath="//button[@class='btn btn-primary btn-floating d-none d-md-flex']")
	public WebElement f_helpicon;
	
	@FindBy(xpath="//div[@class='popover-body']//a[normalize-space()='Edwiser RemUI']")
	public List<WebElement> f_poweredby;
	
	@FindBy(xpath="//div[@class='popover-body']//a[normalize-space()='Edwiser RemUI']")
	public WebElement f_poweredbylink;
}
