package pageClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Other_Extensions {

	WebDriver driver;
	WebDriverWait wait;

	// Constructor
	public Other_Extensions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

// Other Extension
	@FindBy(xpath = "//a[contains(text(),'Other Extensions')]")
	public WebElement Other_Extensions_Tab;

	// Browse all our extensions Button
	@FindBy(xpath = "//a[@class='browse-all']")
	public WebElement Browse_All;

	// Ratings, Reviews, and Feedback Product card
	@FindBy(xpath = "//li[@class='product']//h3[contains(text(),'Ratings, Reviews, and Feedback')]")
	public WebElement RRF_Card;

	// Ratings, Reviews, and Feedback Product card Link
	@FindBy(xpath = "//li[@class='product']//h3[contains(text(),'Ratings, Reviews, and Feedback')]/../../a")
	public WebElement RRF_Card_link;

	// Group Registration Product card
	@FindBy(xpath = "//li[@class='product']//h3[contains(text(),'Group Registration')]")
	public WebElement LDGR_Card;

	// Group Registration Product card Link
	@FindBy(xpath = "//li[@class='product']//h3[contains(text(),'Group Registration')]/../../a")
	public WebElement LDGR_Card_link;

	// Quiz Reporting Product card
	@FindBy(xpath = "//li[@class='product']//h3[contains(text(),'Quiz Reporting')]")
	public WebElement QRE_Card;

	// Quiz Reporting Product card Link
	@FindBy(xpath = "//li[@class='product']//h3[contains(text(),'Quiz Reporting')]/../../a")
	public WebElement QRE_Card_link;

	// Content Cloner Product card
	@FindBy(xpath = "//li[@class='product']//h3[contains(text(),'Content Cloner')]")
	public WebElement LDCC_Card;

	// Content Cloner Product card Link
	@FindBy(xpath = "//li[@class='product']//h3[contains(text(),'Content Cloner')]/../../a")
	public WebElement LDCC_Card_link;

	// eLumine - Theme Product card
	@FindBy(xpath = "//li[@class='product']//h3[contains(text(),'eLumine - Theme')]")
	public WebElement eLumine_Card;

	// eLumine - Theme Product card Link
	@FindBy(xpath = "//li[@class='product']//h3[contains(text(),'eLumine - Theme')]/../../a")
	public WebElement eLumine_Card_link;

	// Visit_Other_Extensions_Tab
	public void Visit_Other_Extensions_Tab(String BaseURL) {
		driver.get(BaseURL + "wp-admin/admin.php?page=instuctor&tab=wdm_ir_promotion");
	}

	// Other Extenssions Product list
	@FindBy(xpath = "//li[@class='product']")
	public List<WebElement> Other_Extensions_List;

}
