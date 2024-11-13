package com.EdwiserRemUI.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomPages extends BasePage{
	
	public CustomPages(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//div[@title='Add a new page']")
	public WebElement addNewPageButton;
	
	@FindBy(xpath = "//div[@class='epb_table_row-name name_editing']//input[@placeholder='Page name']")
	public WebElement pageNameField;
	
	@FindBy(xpath = "//div[@class='epb_table_row-name name_editing']//img[@alt='change name']")
	public WebElement savePageName;
	
	@FindBy(xpath = "(//div[@title = 'Edit page title'])[1]")
	public WebElement editPageTitle;
	
	@FindBy(xpath = "(//div[@title = 'Copy page url'])[1]")
	public WebElement copyPageURL;
	
	public List<WebElement> pageInList(String customPage){
		return driver.findElements(By.xpath("//a[@title='" + customPage + "']"));
	}
	
	public WebElement duplicateicon(String customPage) {
		return driver.findElement(By.xpath("//a[normalize-space()='"+ customPage +"']/../../../..//td[3]//div//div[@class='btn-icon btn-duplicate']"));
	}
	
	public WebElement duplicateCustomePage(String customPage) {
		return driver.findElement(By.xpath("//a[normalize-space()='"+ customPage + "_copy" + "']"));
	}
	
	@FindBy(xpath = "(//img[@alt='delete'])[1]")
	public WebElement deleteTopMostCustomPageInList;
	
	@FindBy(xpath = "//div[@class='modal moodle-has-zindex show']//button[@type='button'][normalize-space()='Yes']")
	public WebElement confirmDeletionYesButtton;
	
	public String deleteConfirmationMessage = "//div[normalize-space()='The page has been deleted.']";
	
	public String linkCopiedConfirmationMessage = "//div[normalize-space()='The page link copied.']";

	@FindBy(xpath = "(//div[@class='pagename_box'])[1]")
	public WebElement firstCustomePage;
	
	public WebElement customPageSettingsIcon(String customPage) {
		return driver.findElement(By.xpath("//a[normalize-space()='"+ customPage + "']/../../../..//td[3]//div//a"));
	}
	
	@FindBy(xpath = "//textarea[@id='id_pagedesc']")
	public WebElement customPageDescription;
	
	@FindBy(xpath = "//fieldset[@id='id_displayinfo']")
	public WebElement expandPageDisaply;
	
	@FindBy(xpath = "//div[@id='id_pagecontenteditable']")
	public WebElement customPageContent;
	
	@FindBy(xpath = "//fieldset[@id='id_seoinfo']")
	public WebElement expandSEO;
	
	@FindBy(xpath = "//input[@id='id_seotag']")
	public WebElement customPageMetaTitle;
	
	@FindBy(xpath = "//textarea[@id='id_seodesc']")
	public WebElement customPageMetaDescription;
	
	@FindBy(xpath = "//input[@id='id_submitpublish']")
	public WebElement sumbitAndPublishbutton;

	@FindBy(xpath = "//input[@id='id_submitdraft']")
	public WebElement sumbitDraftbutton;

	@FindBy(xpath = "//meta[@name='description']")
	public WebElement customPageDespFrontend;
	
	@FindBy(xpath = "//div[@role = 'main']//div[@class = 'text_to_html']")
	public WebElement customPageContentFrontend;
	
	public WebElement customMetaFrontend(String CustomPageMetaTitle) {
		return driver.findElement(By.xpath("//meta[@name='"+ CustomPageMetaTitle +"']"));
	}


}
