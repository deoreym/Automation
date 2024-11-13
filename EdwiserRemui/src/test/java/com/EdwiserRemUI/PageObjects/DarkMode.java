package com.EdwiserRemUI.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.EdwiserRemUI.BaseTest.BaseClass;

public class DarkMode extends BaseClass {
	WebDriver driver;

	public DarkMode(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Dark Mode Settings DropDown
	// Values 1. disable 2.allowonallpages 3. excludepages 4. includepages
	@FindBy(id = "id_s_theme_remui_enabledarkmode")
	public WebElement DarkModeSettingsDropDown;

	// Testarea for Dark mode Exclude Pages
	@FindBy(id = "id_s_theme_remui_darkmodeexcludepages")
	public WebElement ExcludePagesTestArea;

	// Testarea for Dark mode Include Pages
	@FindBy(id = "id_s_theme_remui_darkmodeincludepages")
	public WebElement IncludePagesTestArea;

	// Settings Save Changes
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	public WebElement savechanges;

	@FindBy(xpath = "//div[contains(@class,'nav-darkmode')]")
	public List<WebElement> DarkModeNavMenu;

	public void DarkModeSetting(String Option) {
		Select DropDown = new Select(DarkModeSettingsDropDown);
		DropDown.selectByValue(Option);
	}

	// Dark Mode Icon
	@FindBy(xpath = "//span[contains(@class,'darkmodeicon')]")
	public WebElement DarkModeIcon;

	// Light Mode Icon
	@FindBy(xpath = "//span[contains(@class,'lightmodeicon')]")
	public WebElement LightModeIcon;

	// Dark Mode Menu
	@FindBy(xpath = "//div[contains(@class,'nav-darkmode')]")
	public WebElement DarkModeMenu;

	// HTML TAG in DOM
	@FindBy(xpath = "//html")
	public WebElement HTML;

}
