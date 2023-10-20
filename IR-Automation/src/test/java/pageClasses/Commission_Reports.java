package pageClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Commission_Reports {

	WebDriver driver;
	WebDriverWait wait;

	// Constructor
	public Commission_Reports(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// IR Select DropDown
	// @FindBy(xpath = "//select[@name='wdm_instructor_id']")
	// public WebElement IR_Select;

	// Submit For Select Instructor
	@FindBy(xpath = "//input[@class='button-primary' and @value='Submit']")
	public WebElement Submit_For_Select;

	// Paid Earnings
	@FindBy(id = "wdm_total_amount_paid")
	public WebElement PaidEarning;

	// UnPaid Earnings
	@FindBy(id = "wdm_amount_paid")
	public WebElement unPaidEarning;

	// Pay Button
	@FindBy(id = "wdm_pay_amount")
	public WebElement payButton;

	// Add Amount to Pay
	@FindBy(id = "wdm_pay_amount_price")
	public WebElement payAmount;

	// Manual Payment
	@FindBy(id = "ir-commission-manual-payment-method")
	public WebElement manualPay;

	// Payment Note
	@FindBy(id = "ir_payout_note")
	public WebElement payNote;

	// Make Payment
	@FindBy(id = "ir_pay_click")
	public WebElement makePayment;

	// Visit_Commission_Reports_Tab
	public void Visit_Commission_Tab(String BaseURL) {
		driver.get(BaseURL + "wp-admin/admin.php?page=instuctor&tab=commission_report");
	}

	// Insight Block List
	@FindBy(xpath = "//*[@class='irbn-tiles-wrap']//span[@class='irbn-text']")
	public List<WebElement> insightBlockList;

}
