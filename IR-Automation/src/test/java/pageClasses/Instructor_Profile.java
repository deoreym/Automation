package pageClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Instructor_Profile {

	WebDriver driver;
	WebDriverWait wait;

	// Constructor
	public Instructor_Profile(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Enable Profile Links Checkbox
	@FindBy(id = "ir_profile_enable")
	public WebElement Profile_Links;

	// Add New Section
	@FindBy(id = "ir-profile-add-setting-section")
	public WebElement AddNewSection;

	// Save Profile Settings
	@FindBy(id = "ir-profile-save-setting-section")
	public WebElement SaveProfileSettings;

	// Profile Section Title
	@FindBy(id = "ir-profile-update-title")
	public WebElement Title;

	// Profile Section Meta Key
	@FindBy(id = "ir-profile-update-metakey")
	public WebElement MetaKey;

	// Add Profile Section Button
	@FindBy(id = "ir-profile-update-add")
	public WebElement AddSectionButton;

	// Save Profile Section Button
	@FindBy(id = "ir-profile-update-save")
	public WebElement SaveSectionButton;

	// Profile Settings Page Section
	public List <WebElement> Profile_Field_in_Settings(String Name) {
		return driver
				.findElements(By.xpath("//span[contains(@id,'ir-profile-section-title') and text()='" + Name + "']"));
	}

	// Profile Settings Page Section Edit Link
	public WebElement Profile_Field_Edit_in_Settings(String Name) {
		return driver.findElement(By.xpath(
				"//span[contains(@id,'ir-profile-section-title') and text()='" + Name + "']/../..//a[@title='Edit']"));
	}

	// Profile Settings Page Section Delete Link
	public WebElement Profile_Field_Delete_in_Settings(String Name) {
		return driver.findElement(By.xpath("//span[contains(@id,'ir-profile-section-title') and text()='" + Name
				+ "']/../..//a[@title='Delete']"));
	}

	// Profile Edit Page Section Title
	public List<WebElement> Profile_Field_Title(String Name) {
		return driver.findElements(By.xpath("//label[contains(text(),'" + Name + "')]"));
	}

	// Profile Edit Page Section Title
	public WebElement Profile_Field_TextArea(String MetaName) {
		return driver.findElement(By.xpath("//textarea[@name='" + MetaName + "']"));
	}

	// DataType Select
	@FindBy(id = "ir-profile-update-datatype")
	public WebElement Filed_DataType;

	// Field DataType Select
	public Select Select_DataType() {
		Select select = new Select(Filed_DataType);
		return select;
	}

	// Image Select
	@FindBy(id = "ir-profile-update-image")
	public WebElement Filed_Image;

	// Field Image Select
	public Select Select_Image() {
		Select select = new Select(Filed_Image);
		return select;
	}

	// Icon Select
	@FindBy(id = "ir-profile-update-icon")
	public WebElement Filed_Icon;

	// Field Icon Select
	public Select Select_Icon() {
		Select select = new Select(Filed_Icon);
		return select;
	}

	// Visit_Profile_Tab
	public void Visit_Profile_Tab(String BaseURL) {
		driver.get(BaseURL + "wp-admin/admin.php?page=instuctor&tab=ir-profile");
	}

	// Visit_Profile_Edit_Page
	public void Visit_Profile_Edit_Page(String BaseURL) {
		driver.get(BaseURL + "wp-admin/profile.php");
	}

	// Other Extenssions Product list
	@FindBy(xpath = "//li[@class='product']")
	public List<WebElement> Other_Extensions_List;

}
