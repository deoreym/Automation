package com.EdwiserRemUI.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class FooterSocialMediaLinkPage extends BasePage {

	public FooterSocialMediaLinkPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath="//h6[text()='Footer']")
	public WebElement footermenu;
	
	@FindBy(xpath="//h6[text()='Social media links']")
	public WebElement socialmedialink;
	
	@FindBy(xpath="//input[@id='id_facebooksetting']")
	public WebElement fb;
	
	@FindBy(xpath="//input[@id='id_s_theme_remui_facebooksetting']")
	public WebElement fb_theme;
	
	@FindBy(xpath="//input[@id='id_twittersetting']")
	public WebElement twitter;
	
	@FindBy(xpath="//input[@id='id_s_theme_remui_twittersetting']")
	public WebElement twitter_theme;
	
	
	@FindBy(xpath="//input[@id='id_linkedinsetting']")
	public WebElement linkedin;
	
	@FindBy(xpath="//input[@id='id_s_theme_remui_linkedinsetting']")
	public WebElement linkedin_theme;
	
	@FindBy(xpath="//input[@id='id_gplussetting']")
	public WebElement googleplus;
	
	@FindBy(xpath="//input[@id='id_s_theme_remui_gplussetting']")
	public WebElement ggplus_theme;
	
	@FindBy(xpath="//input[@id='id_youtubesetting']")
	public WebElement youtube;
	
	@FindBy(xpath="//input[@id='id_s_theme_remui_youtubesetting']")
	public WebElement youtube_theme;
	
	@FindBy(xpath="//input[@id='id_instagramsetting']")
	public WebElement instagram;
	
	@FindBy(xpath="//input[@id='id_s_theme_remui_instagramsetting']")
	public WebElement instagram_theme;
	
	@FindBy(xpath="//input[@id='id_pinterestsetting']")
	public WebElement pintrest;
	
	@FindBy(xpath="//input[@id='id_s_theme_remui_pinterestsetting']")
	public WebElement pinterest_theme;
	
	@FindBy(xpath="//input[@id='id_quorasetting']")
	public WebElement quora;
	
	@FindBy(xpath="//input[@id='id_s_theme_remui_quorasetting']")
	public WebElement quora_theme;
	
	@FindBy(xpath="//h6[text()='Main footer area']")
	public WebElement mainfooterareamenu;
	
	@FindBy(xpath="//h6[text()='Widget 1']")
	public WebElement widget1menu;
	
	@FindBy(xpath="//h6[text()='Widget 2']")
	public WebElement widget2menu;
	
	@FindBy(xpath="//select[@id='id_footercolumn1type']")
	public WebElement selecttypemenu;
	
	@FindBy(xpath="//select[@id='id_footercolumn1type']//option")
	public WebElement selectedtype;
	
	
	public void selectdropdownoption() {
		Select type=new Select(selecttypemenu);
		type.selectByValue("customhtml");
	}
	
	@FindBy(xpath="//select[@id='id_footercolumn2type']")
	public WebElement selecttypemenu2;
	
	@FindBy(xpath="//select[@id='id_footercolumn2type']//option")
	public WebElement selectedtype2;
	
	
	public void selectdropdownoptionasmenu() {
		Select type=new Select(selecttypemenu2);
		type.selectByValue("menu");
	}
	
	@FindBy(xpath="//input[@id='id_footercolumn1title']")
	public WebElement footercolumtitle;
	
	@FindBy(xpath="//input[@id='id_footercolumn2title']")
	public WebElement footercolumtitle2;
	
	@FindBy(xpath="//button[@data-name='footercolumn2menu']")
	public WebElement menubutton;
	
	@FindBy(xpath="//input[@class='form-control menu-text']")
	public WebElement textfield;
	
	@FindBy(xpath="//input[@class='form-control menu-address']")
	public WebElement address;
	
	@FindBy(xpath="//button[@data-action='save']")
	public WebElement savebutton;
	
	@FindBy(xpath="//div[@id='fitem_id_footercolumn2menu']//div[@class='customizer-menu-item-list w-100']//div[1]//a")
	public WebElement menulinkfromcustomizer;
	
	@FindBy(xpath="(//div[@id='footer-column-2']//div[@class='footer-menu-list']//a)[1]")
	public WebElement menulinkfromfooter;
	
	@FindBy(xpath="(//div[@id='footer-column-2']//div//h6[@class='h-semibold-6 mb-0 ftr-column-title'])[1]")
	public WebElement menutitlefromfooter;
	
	@FindBy(xpath="//div[@id='id_footercolumn1customhtmleditable']")
	public WebElement footercontenteditor;
	
	@FindBy(xpath="//div[@id='fitem_id_socialmediaiconcol1']//div[@class='d-flex align-items-center flex-gap-d5']")
	public WebElement sociallabel;
	
	@FindBy(xpath="//input[@id='id_socialmediaiconcol1']")
	public WebElement socialchkbx;
	
	@FindBy(xpath="//div[@class='setting-item setting-type-checkbox']")
	public WebElement outsideelement;
	
	@FindBy(xpath="//select[@id='id_footercolumn1social']")
	public WebElement socialicondd;
	
	public void selectsocialoption() {
		Select type=new Select(socialicondd);
		type.selectByValue("facebook");
		type.selectByValue("twitter");
		
	}
	
	@FindBy(xpath="//div[@id='admin-footercolumn1type']//div//div//select//option")
	public WebElement selectedsocialicon;
	
	@FindBy(id="id_s_theme_remui_footercolumn1title")
	public WebElement titlefromtheme;
	
	@FindBy(id="id_s_theme_remui_footercolumn1customhtmleditable")
	public WebElement contentfromtheme;
	
	@FindBy(xpath="//div[@class='contenthtml']//h6[@class='h-semibold-6 mb-0 ftr-column-title'][normalize-space()='Title 1']")
	public WebElement titlefromfooter;
	
	@FindBy(xpath="//div[@id='footer-column-1']//div//div//p")
	public WebElement contentfromfooter;
	
	@FindBy(xpath="//div[@class='contentsocial social-links ']//a[1]")
	public WebElement socialicon1stfromfooter;
}

