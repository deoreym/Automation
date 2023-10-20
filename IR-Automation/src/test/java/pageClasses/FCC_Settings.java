package pageClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FCC_Settings {

	WebDriver driver;
	WebDriverWait wait;

	// Constructor
	public FCC_Settings(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// FCC Settings Tab
	@FindBy(xpath = "//a[contains(text(),'Frontend Course Creator')]")
	public WebElement FCC_Settings_Tab;

	// Enable Frontend Course Creator - Input
	@FindBy(xpath = "//input[@id='ir_enable_frontend_dashboard']")
	public WebElement Enable_FCC;

	// Disable LearnDash’s backend course creator for instructors - Input
	@FindBy(xpath = "//input[@id='ir_disable_ld_links']")
	public WebElement Disable_LD_Edit;

	// Enable Frontend Course Creator - Slider
	@FindBy(xpath = "//input[@id='ir_enable_frontend_dashboard']/../span[@class='ir-slider round']")
	public WebElement Enable_FCC_Slider;

	// Disable LearnDash’s backend course creator for instructors - Slider
	@FindBy(xpath = "//input[@id='ir_disable_ld_links']/../span[@class='ir-slider round']")
	public WebElement Disable_LD_Edit_Slider;

	// Save Settings
	@FindBy(id = "submit")
	public WebElement save_Settings;

	// Add New Course Via FCC Button
	@FindBy(id = "ir-fcb-create-new")
	public List<WebElement> Add_New_Via_FCC;

	// LD Add New Course Button
	@FindBy(xpath = "//a[@class='global-new-entity-button']")
	public List<WebElement> LD_Add_New_Course;

	// Edit Course Via FCC Button
	@FindBy(xpath = "//a[@class='ir-fcc-action-links']")
	public List<WebElement> Edit_Via_FCC;

	// Edit Course by LD
	@FindBy(xpath = "//span[@class='edit']//a[contains(@aria-label,'Edit')]")
	public List<WebElement> Edit_Via_LD;

	// Visit_FCC_Settings_Tab
	public void Visit_FCC_Settings_Tab(String BaseURL) {
		driver.get(BaseURL + "wp-admin/admin.php?page=instuctor&tab=ir-frontend-dashboard");
	}

}
