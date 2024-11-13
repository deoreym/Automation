package com.EdwiserRemUI.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageBuilderPage  extends BasePage{

	public PageBuilderPage(WebDriver driver) {
		super(driver);
		
	}

	//edit mode toggle
	@FindBy(xpath="//input[@name='setmode']")
	public WebElement editmodevalue;
	
	@FindBy(xpath="//a[@class='btn btn-dark btn-lg d-flex align-items-center justify-content-center floating-add-block-button']")
	public WebElement addablockbutton;
	
	@FindBy(xpath="//div[@class='modal-dialog modal-dialog-scrollable']")
	public List<WebElement> modal;
	
	@FindBy(xpath="//div[@class='modal-header ']//button[@class='close']")
	public WebElement closebutton;
	
	@FindBy(xpath="//div//ul//li//a[@id='block-tab']")
	public WebElement remuitab;
	
	@FindBy(xpath="//div//ul//li//a[@id='moodleblock-tab']")
	public WebElement moodletab;
	
	@FindBy(xpath="//div[@class='card-wrapper advanceblockblocks  html static-block']//div[@class='card-item h-100 ']")
	public List<WebElement>custombutton;
	
	@FindBy(xpath="//div[@class='tab-pane moodleblocktab show active']")
	public List<WebElement> moodleblocks;
	
	@FindBy(xpath="//button[@class='btn btn-lg btn-dark dropdown-toggle dropdown-toggle-split add-block-split-icon-btn']")
	public WebElement regionbutton;
	
	@FindBy(xpath="//a[@class='dropdown-item btn btn-lg full-width-top-link activeregion']")
	public WebElement selectedregion;
	
	@FindBy(xpath="//button[text()='Reset page to default']")
	public WebElement resetbutton;
	
	//Change the xpath for particular category
	@FindBy (xpath="//div//ul//li[@class='category-list-item category-selector block-filter active']//a")
	public WebElement selectcategory;
	
	//Change the xpath for selecting the block
	@FindBy(xpath="//div[@data-blockid='144']")
	public WebElement selectedblock;
	
	
	
}
