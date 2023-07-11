package pageClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Menu_Settings {

	WebDriver driver;
	WebDriverWait wait;

	// Constructor
	public Menu_Settings(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Menu Settings Tab
	@FindBy(xpath = "//a[contains(text(),'Menu settings')]")
	public WebElement Menu_Settings_Tab;

	// Custom Menu Title - Input
	@FindBy(xpath = "//input[@name='custom_menu[title]']")
	public WebElement Custom_Menu_Title;

	// Custom Menu URL - Input
	@FindBy(xpath = "//input[@name='custom_menu[slug]']")
	public WebElement Custom_Menu_URL;

	// Custom Menu Icon - Input
	@FindBy(xpath = "//input[@name='custom_menu[icon]']")
	public WebElement Custom_Menu_Icon;

	// Save Custom Menu Settings
	@FindBy(id = "ir-save-custom-menu")
	public WebElement save_Custom_Menu;

	// Save Menu Settings
	@FindBy(id = "ir-save-menu")
	public WebElement save_Menu_Setting;

	// Reset Menu Settings
	@FindBy(id = "ir-menu-reset-settings")
	public WebElement Reset_Menu_Setting;

	public List<WebElement> Custom_Menu_In_Settings(String Cust_Menu_Name) {
		return driver.findElements(
				By.xpath("//*[contains(@class,'ir-parent-menu')]//span[text()='" + Cust_Menu_Name + "']"));
	}

	public WebElement Edit_Custom_Menu(String Cust_Menu_Name) {
		return driver
				.findElement(By.xpath("//span[text()='" + Cust_Menu_Name + "']/../*[contains(@class,'parent-edit')]"));
	}

	public WebElement Delete_Custom_Menu(String Cust_Menu_Name) {
		return driver.findElement(
				By.xpath("//span[text()='" + Cust_Menu_Name + "']/../*[contains(@class,'dashicons-trash')]"));
	}

	public WebElement Delete_Custom_Sub_Menu(String Sub_Menu_Name) {
		return driver.findElement(By.xpath("//*[contains(@class,'ir-sub-menu')]//span[text()='" + Sub_Menu_Name
				+ "']/..//span[contains(@name,'[delete]')]"));
	}

	public WebElement Add_Sub_Menu(String Menu_Name) {
		return driver
				.findElement(By.xpath("//span[text()='" + Menu_Name + "']/../*[contains(@class,'dashicons-plus')]"));
	}

	public WebElement Expand_Menu(String Menu_Name) {
		return driver
				.findElement(By.xpath("//span[text()='" + Menu_Name + "']/../*[contains(@class,'dashicons-arrow')]"));
	}

	public WebElement Custom_Sub_Menu_Title(String Menu_Name) {
		return driver.findElement(
				By.xpath("//span[text()='" + Menu_Name + "']/..//input[@type='text' and contains(@name,'[title]')]"));
	}

	public WebElement Custom_Sub_Menu_URL(String Menu_Name) {
		return driver.findElement(
				By.xpath("//span[text()='" + Menu_Name + "']/..//input[@type='url' and contains(@name,'[slug]')]"));
	}

	public WebElement Save_Custom_Sub_Menu(String Menu_Name) {
		return driver
				.findElement(By.xpath("//span[text()='" + Menu_Name + "']/..//input[@id='ir-save-custom-sub-menu']"));
	}

	public List<WebElement> Custom_Sub_Menu_In_Settings(String Menu_Name) {
		return driver.findElements(By.xpath("//*[contains(@class,'ir-sub-menu')]//span[text()='" + Menu_Name + "']"));
	}

	public WebElement Custom_Sub_Menu(String Menu_Name) {
		return driver.findElement(By.xpath("//*[contains(@class,'ir-sub-menu')]//span[text()='" + Menu_Name + "']"));
	}

	public WebElement Menu_Move_Icon(String Menu_Name) {
		return driver
				.findElement(By.xpath("//span[text()='" + Menu_Name + "']/../*[contains(@class,'dashicons-move')]"));
	}

	public WebElement IR_Dash_Menu(String Menu_Name) {
		return driver.findElement(By.xpath("//div[@class='wp-menu-name' and text()='" + Menu_Name + "']"));
	}

	public List<WebElement> IR_Dash_Menu_in_List(String Menu_Name) {
		return driver.findElements(By.xpath("//div[@class='wp-menu-name' and text()='" + Menu_Name + "']"));
	}

	public WebElement IR_Dash_Sub_Menu(String Menu_Name) {
		return driver.findElement(By.xpath("//ul[contains(@class,'wp-submenu')]/li/a[text()='" + Menu_Name + "']"));
	}

	public List<WebElement> IR_Dash_Sub_Menu_in_List(String Menu_Name) {
		return driver.findElements(By.xpath("//ul[contains(@class,'wp-submenu')]/li/a[text()='" + Menu_Name + "']"));
	}

	public WebElement Menu_Options(String Cust_Menu_Name) {
		return driver.findElement(
				By.xpath("//span[text()='" + Cust_Menu_Name + "']/../*[contains(@class,'dashicons-ellipsis')]"));
	}

	public WebElement LD_Menu_Options(String Sub_Menu_Name) {
		return driver.findElement(
				By.xpath("//li[contains(text(),'" + Sub_Menu_Name + "')]//*[contains(@class,'dashicons-ellipsis')]"));
	}

	public WebElement Hide_Menu(String Menu_Name) {
		return driver.findElement(By.xpath(
				"//span[text()='" + Menu_Name + "']/..//ul[@class='ir-action-menu']//input[contains(@name,'[hide]')]"));
	}

	public WebElement Hide_LD_Sub_Menu(String Sub_Menu_Name) {
		return driver.findElement(By.xpath("//li[contains(text(),'" + Sub_Menu_Name
				+ "')]//ul[@class='ir-action-submenu']//input[contains(@name,'[hide]')]"));
	}

	public WebElement Hide_and_Restrict_Menu(String Menu_Name) {
		return driver.findElement(By.xpath("//span[text()='" + Menu_Name
				+ "']/..//ul[@class='ir-action-menu']//input[contains(@name,'[hide_restrict]')]"));
	}

	public WebElement Hide_and_Restrict_LD_Sub_Menu(String Sub_Menu_Name) {
		return driver.findElement(By.xpath("//li[contains(text(),'" + Sub_Menu_Name
				+ "')]//ul[@class='ir-action-submenu']//input[contains(@name,'[hide_restrict]')]"));
	}

	public WebElement Hide_Menu_slider(String Menu_Name) {
		return driver.findElement(By.xpath("//span[text()='" + Menu_Name
				+ "']/..//ul[@class='ir-action-menu']//input[contains(@name,'[hide]')]/../span"));
	}

	public WebElement Hide_LD_Sub_Menu_slider(String Sub_Menu_Name) {
		return driver.findElement(By.xpath("//li[contains(text(),'" + Sub_Menu_Name
				+ "')]//ul[@class='ir-action-submenu']//input[contains(@name,'[hide]')]/../span"));
	}

	public WebElement Hide_and_Restrict_Menu_slider(String Menu_Name) {
		return driver.findElement(By.xpath("//span[text()='" + Menu_Name
				+ "']/..//ul[@class='ir-action-menu']//input[contains(@name,'[hide_restrict]')]/../span"));
	}

	public WebElement Hide_and_Restrict_LD_Sub_Menu_slider(String Sub_Menu_Name) {
		return driver.findElement(By.xpath("//li[contains(text(),'" + Sub_Menu_Name
				+ "')]//ul[@class='ir-action-submenu']//input[contains(@name,'[hide_restrict]')]/../span"));
	}

	// Restricted Message
	@FindBy(xpath = "//div[text()='Restricted page']")
	public List<WebElement> Restricted_Message;
	
	// Menu Settings Tab
		@FindBy(xpath = "//a[@href='#menu_settings']")
		public WebElement MenuSettings;
	

	/**
	 * Visit Backend Settings
	 * 
	 * @param baseURL
	 */
	public void visitBackendSettings(String baseURL) {
		driver.get(baseURL + "wp-admin/admin.php?page=instuctor&tab=backend-dashboard");
		MenuSettings.click();
	}
	

}
