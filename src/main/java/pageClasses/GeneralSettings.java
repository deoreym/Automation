package pageClasses;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import setUp.GeneralisedProjectOperations;

public class GeneralSettings {

	WebDriver driver;
	GeneralisedProjectOperations generalisedOps = new GeneralisedProjectOperations();
	WebDriverWait wait;

	// Constructor
	public GeneralSettings(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// General Settings Tab
	@FindBy(xpath = "//*[@class='nav-tab-wrapper']//a[@href='?page=instuctor&tab=settings']")
	public WebElement generalSettings;

	// Menu Settings Tab
	@FindBy(xpath = "//*[@class='nav-tab-wrapper']//a[@href='?page=instuctor&tab=menu_settings']")
	public WebElement menuSettings;

	// Overview Settings Tab
	@FindBy(xpath = "//*[@class='nav-tab-wrapper']//a[@href='?page=instuctor&tab=overview_settings']")
	public WebElement overviewSettings;

	// Overview Course Block
	@FindBy(xpath = "//input[@name='ir_overview_settings[course_block]']")
	public WebElement courseBlock;

	// Course Block Slider
	@FindBy(xpath = "//td[text()='Course block']/..//span[@class='wdm-slider round']")
	public WebElement courseBlockSlider;

	// Overview Student Block
	@FindBy(xpath = "//input[@name='ir_overview_settings[student_block]']")
	public WebElement studentBlock;

	// Student Block Slider
	@FindBy(xpath = "//td[text()='Student block']/..//span[@class='wdm-slider round']")
	public WebElement studentBlockSlider;

	// Overview Product Block
	@FindBy(xpath = "//input[@name='ir_overview_settings[product_block]']")
	public WebElement productBlock;

	// Product Block Slider
	@FindBy(xpath = "//td[text()='Products block							']/..//span[@class='wdm-slider round']")
	public WebElement productBlockSlider;

	// Overview Product Block
	@FindBy(xpath = "//input[@name='ir_overview_settings[earnings_block]']")
	public WebElement earningBlock;

	// Product Block Slider
	@FindBy(xpath = "//td[text()='Earnings block']/..//span[@class='wdm-slider round']")
	public WebElement earningBlockSlider;

	// Overview Course Report Block
	@FindBy(xpath = "//input[@name='ir_overview_settings[reports_block]']")
	public WebElement courseReportBlock;

	// Course Reports Block Slider
	@FindBy(xpath = "//td[text()='Course Reports block']/..//span[@class='wdm-slider round']")
	public WebElement courseReportBlockSlider;

	// Overview Submissions Block
	@FindBy(xpath = "//input[@name='ir_overview_settings[submission_block]']")
	public WebElement SubmissionsBlock;

	// Submissions Block Slider
	@FindBy(xpath = "//td[text()='Submissions block']/..//span[@class='wdm-slider round']")
	public WebElement SubmissionsBlockSlider;

	// No Overview Block Message
	@FindBy(xpath = "//input[@name='ir_overview_settings[no_blocks_prompt_message]']")
	public WebElement noBlockMessage;

	// No blocks Message on IR Dashboard
	@FindBy(xpath = "//*[@class='irbn-tile-content']")
	public WebElement overviewNoBlocks;

	// Overview Setting Save Button
	@FindBy(id = "ir-save-overview-settings")
	public WebElement overviewSaveSettings;

	// Overview course Block
	@FindBy(xpath = "//*[@class='irbn-tiles-wrap']//span[@class='irbn-text' and text()='Courses']")
	public WebElement OvCourseBlock;

	// Insight Block List
	@FindBy(xpath = "//*[@class='irbn-tiles-wrap']//span[@class='irbn-text']")
	public List<WebElement> insightBlockList;

	public boolean checkinsightBlock(String Blockname) {
		if (insightBlockList.size() > 0) {
			for (WebElement ib : insightBlockList) {
				if (ib.getText().equals(Blockname)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean checkOverviewBlock(String Blockname) {
		if (OverviewBlockList.size() > 0) {
			for (WebElement ib : OverviewBlockList) {
				if (ib.getText().equals(Blockname)) {
					return true;
				}
			}
		}
		return false;
	}

	// Overview Block List
	@FindBy(xpath = "//span[@class='irbn-header-text irbn-bold']")
	public List<WebElement> OverviewBlockList;

	/**
	 * Visit Instructor Settings
	 * 
	 * @param baseURL
	 */
	public void visitInstructorSettings(String baseURL) {
		driver.get(baseURL + "wp-admin/admin.php?page=instuctor");
	}

	// Select All From Listing Page
	@FindBy(id = "cb-select-all-1")
	public WebElement selectAllFromListing;

	@FindBy(id = "doaction")
	public WebElement bulkActionsApply;

}
