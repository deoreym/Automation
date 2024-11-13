package com.EdwiserRemUI.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseFormatPage extends BasePage{

	public CourseFormatPage(WebDriver driver) {
		super(driver);
		
	}

	
	//course format section click
	@FindBy(xpath="//a[@id='collapseElement-2']")
	public WebElement CourseFormatSection;
	
	
	
	@FindBy(xpath="//div[@id='fitem_id_format']//div//div[@class='dropdown']//button")
	public WebElement courseformatbutton;
	
	@FindBy(xpath="//div[@class='p-2']//div//div//div//a[@data-value='remuiformat']")
	public WebElement remuiformat;
	
	@FindBy(xpath="//input[@id='id_saveanddisplay']")
	public WebElement saveanddisplay;
	
	@FindBy(xpath="//body[@id='page-course-view-remuiformat']")
	public List<WebElement> remuiformatoncp;
	
	@FindBy(xpath="//div[@id='fitem_id_hiddensections']//div//select//option[1]")
	public WebElement hiddenSectionAsNotAvailable;
	
	@FindBy(xpath="//div[@id='fitem_id_hiddensections']//div//select//option[2]")
	public WebElement hiddenSectionAsInvisible;
	
	@FindBy(xpath="//nav[@class='navbar fixed-top navbar-expand left  ']//div[@id='usernavigation']//li//form//div//div//input")
	public WebElement editmodetoggle;
	
	@FindBy(xpath="//div[@id='page']//div[@class='activities-wrapper d-flex flex-column']//div//ul//li[1]//div[@class='sectionbadges d-flex align-items-center']")
	public List<WebElement> checkbadge;
	
	@FindBy(xpath="//div[@class='activities-wrapper d-flex flex-column']//div//ul//li[1]//div[@class='p-0 action-availstatus-wrapper']//div//div[2]//div//div//div//a[@id='action-menu-toggle-3']")
	public WebElement ellipsismenu;
	
	@FindBy(xpath="//div[@id='action-menu-3-menu']//a//span[text()='Show']")
	public WebElement showbutton;
	
	
	@FindBy(xpath="//div[@id='action-menu-3-menu']//a//span[text()='Hide']")
	public WebElement Hidebutton;
	
	@FindBy(xpath="//div[@id='id_courseformathdrcontainer']//div[@id='fitem_id_remuicourseformat']//div//select//option[text()='Card Layout']")
	public WebElement cardlayoutoption;
	
	@FindBy(xpath="//div[@id='id_courseformathdrcontainer']//div[@id='fitem_id_remuicourseformat']//div//select//option[text()='List Layout']")
	public WebElement listlayoutoption;
	
	@FindBy(xpath="//div[@id='id_courseformathdrcontainer']//div[@id='fitem_id_hidegeneralsectionwhenempty']//div//select//option[text()='Show']")
	public WebElement showgeneralsectionasempty;
	
	@FindBy(xpath="//div[@id='id_courseformathdrcontainer']//div[@id='fitem_id_hidegeneralsectionwhenempty']//div//select//option[text()='Hide']")
	public WebElement Hidegeneralsectionasempty;
	
	@FindBy(xpath="//div[@id='id_courseformathdrcontainer']//div[@id='fitem_id_coursedisplay']//div//select//option[text()='Show all sections on one page']")
	public WebElement AllSectionInOnePage;
	
	@FindBy(xpath="//div[@id='id_courseformathdrcontainer']//div[@id='fitem_id_coursedisplay']//div//select//option[text()='Show one section per page']")
	public WebElement OneSectionPerPage;
	
	@FindBy(xpath="//div[@id='id_courseformathdrcontainer']//div[@id='fitem_id_sectiontitlesummarymaxlength']//div//input")
	public WebElement summarylength;
	
	@FindBy(xpath="//div[@class='course-content']//div[@id='card-container'][2]//ul[@class='sections row']//li[1]")
	public List<WebElement> cardlayoutoncp;
	
	@FindBy(xpath="//div[@class='course-content']//div[@id='list-container']")
	public List<WebElement> listlayoutoncp;
	
	@FindBy(xpath="//div[@class='course-content']//div//ul//li//div//div[@class='section-details']//h2")
	public List<WebElement> generalsectiononcp;
	
	@FindBy(xpath="//div[@class='course-content']//div[@class='remui-format-list all-section-format theme-remui mt-20']")
	public List<WebElement> allsectiononcp;
	
	@FindBy(xpath="//div[@class='course-content']//div[@class='remui-format-list one-section-format all-section theme-remui mt-20']")
	public List<WebElement> onesectiononcp;
	
	@FindBy(xpath="//div[@class='course-content']//div[@id='list-container']//ul//li//div//div//div[@class='summary card-text ']")
	public WebElement summarytextoncp;

	@FindBy(xpath="//div[@id='id_courseformathdrcontainer']//div[@id='fitem_id_remuicourseimage_filemanager']//..//span[text()='Add...']")
	public WebElement addfilebutton;
	
	@FindBy(xpath="//input[@id='fileurl']")
	public WebElement urlfield;
	
	@FindBy(xpath="//button[@class='fp-login-submit btn-primary btn']")
	public WebElement downloadbutton;
	
	@FindBy(xpath="//p[@class='fp-filename text-truncate']")
	public WebElement selectfilelink;
	
	@FindBy(xpath="//button[@class='fp-select-confirm btn-primary btn']")
	public WebElement selectbutton;
	
	@FindBy(xpath="//div[@class='course-content']//header")
	public WebElement headeroncp;
	
	@FindBy(xpath="//div[@id='id_courseformathdrcontainer']//div[@id='fitem_id_remuicourseimage_filemanager']//div//div[@class='fp-content']//div[@class='fp-file fp-hascontextmenu']")
	public List<WebElement> CheckImageispresent;
	
	@FindBy(xpath="//div[@id='id_courseformathdrcontainer']//div[@id='fitem_id_remuicourseimage_filemanager']//div//div[@class='fp-content']//div[@class='fp-file fp-hascontextmenu']//a[@class='d-block aabtn']")
	public WebElement Clickonaddedimage;
	
	@FindBy(xpath="//div[@aria-hidden='false']//div//div[@role='dialog']//div//div[@role='dialog']//form//div//button[contains(text(),'Delete')]")
	public WebElement deleteaddedimage;
	
	@FindBy(xpath="//button[@data-action='save']")
	public WebElement YesButton;

	@FindBy(xpath="//div[@id='id_courseformathdrcontainer']//div[@id='fitem_id_edw_format_hd_bgpos']//div//select//option[text()='bottom']")
	public WebElement bottombgimageposition;
	
	@FindBy(xpath="//div[@id='id_courseformathdrcontainer']//div[@id='fitem_id_edw_format_hd_bgpos']//div//select//option[text()='center']")
	public WebElement centerbgimageposition;
	
	@FindBy(xpath="//div[@id='id_courseformathdrcontainer']//div[@id='fitem_id_edw_format_hd_bgpos']//div//select//option[text()='top']")
	public WebElement topbgimageposition;
	
	@FindBy(xpath="//div[@id='id_courseformathdrcontainer']//div[@id='fitem_id_edw_format_hd_bgpos']//div//select//option[text()='left']")
	public WebElement leftbgimageposition;
	
	@FindBy(xpath="//div[@id='id_courseformathdrcontainer']//div[@id='fitem_id_edw_format_hd_bgpos']//div//select//option[text()='right']")
	public WebElement rightbgimageposition;
	
	@FindBy(xpath="//div[@class='rmuiformate-header-wrapper d-none ']//header[@id='page-header']")
	public WebElement headerpositiononcp;
}
