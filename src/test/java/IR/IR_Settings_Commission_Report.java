package IR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageClasses.Commission_Reports;
import pageClasses.OverviewSettings;
import setUp.projectSetUp;

public class IR_Settings_Commission_Report {

	WebDriver driver;
	OverviewSettings OS_OB;
	Commission_Reports CR_OB;
	String baseURL;

	/**
	 * Before Class: THis Method does Admin Login
	 * 
	 * @param siteURL
	 * @param username
	 * @param password
	 * @throws Exception
	 */
	@Parameters({ "siteURL", "username", "password" })
	@BeforeClass
	public void DriverSetUP(String siteURL, String username, String password) throws Exception {
		driver = projectSetUp.driver;

		// Initializing Overview Settings Object
		OS_OB = new OverviewSettings(driver);
		
		// Initializing Commission_Reports Object
		CR_OB = new Commission_Reports(driver);
		// Setting Admin Details
		baseURL = siteURL;
		OS_OB.loginToDashboard(driver, baseURL, username, password);
	}

	/**
	 * Make Commission Payment
	 * 
	 * @throws Exception
	 */
	@Test(priority = 1)
	public void Set_Commission_For_I_R() throws Exception {

		// Visit Commission Reports Tab Tab in Settings
		CR_OB.Visit_Commission_Tab(baseURL);

		// Select Instructor Ir -- Here 7 is a User ID of I R User.
		Select IR_Select = new Select(driver.findElement(By.xpath("//select[@name='wdm_instructor_id']")));
		IR_Select.selectByValue("7");
		CR_OB.Submit_For_Select.click();

		// Store Paid and Unpaid Earnings
		Float Paid = Float.parseFloat(CR_OB.PaidEarning.getText());
		Float UnPaid = Float.parseFloat(CR_OB.unPaidEarning.getText());

		System.out.println(Paid + 1);
		System.out.println(UnPaid - 1);

		// Click Pay Button
		CR_OB.payButton.click();

		// Add Amount to Pay
		CR_OB.payAmount.clear();
		CR_OB.payAmount.sendKeys("1");

		// Select Manual Payment Method
		CR_OB.manualPay.click();

		CR_OB.payNote.clear();
		CR_OB.payNote.sendKeys("Making Manual Pay of 1 Doller");

		// Click Payment Button
		CR_OB.makePayment.click();
		Thread.sleep(1000);

		// Accept Alert
		Assert.assertEquals(driver.switchTo().alert().getText(), "Record added successfully",
				"Commission Paid Alert Message is not Matched");
		driver.switchTo().alert().accept();

		System.out.println(Float.parseFloat(CR_OB.PaidEarning.getText()));
		System.out.println(Float.parseFloat(CR_OB.unPaidEarning.getText()));

		Assert.assertEquals(Float.parseFloat(CR_OB.PaidEarning.getText()), Paid + 1,
				"Paid Commission not added in Paid Earnings");
		Assert.assertEquals(Float.parseFloat(CR_OB.unPaidEarning.getText()), UnPaid - 1,
				"Paid Commission not added in Paid Earnings");

	}

}
