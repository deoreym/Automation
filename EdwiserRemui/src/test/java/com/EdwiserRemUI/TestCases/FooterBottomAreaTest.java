package com.EdwiserRemUI.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.EdwiserRemUI.BaseTest.BaseClass;
import com.EdwiserRemUI.PageObjects.FooterBottomAreaPage;

public class FooterBottomAreaTest extends BaseClass {

	FooterBottomAreaPage fbap;

	@BeforeClass
	public void Before_class() {
		System.out.println("In Footer Bottom Area Test Class - FooterBottomAreaTest");
		fbap = new FooterBottomAreaPage(driver);
	}

	@Test(priority = 1)
	public void showLogo_SameLogoAsHeader() throws InterruptedException {
		driver.get(customizer);
		fbap.footerMenu.click();
		fbap.footerBottomArea.click();

		if (!fbap.showLogo.isSelected()) {
			fbap.showLogoToggle.click();
		}

		if (!fbap.useTheSameLogoFromHeader.isSelected()) {
			fbap.useTheSameLogoFromHeaderToggle.click();
		}
		fbap.saveButton.click();
		Thread.sleep(3000);
		driver.get(siteurl);

		Assert.assertTrue(fbap.sameFooterIconAsHeader.getAttribute("class").contains("fa fa-graduation-cap"),
				"The Footer icon is not same as Header icon even after 'Use the same logo from header' is enabled");

	}

	/**
	 * FIle Upload Not added so Commented this test
	 * 
	 * @throws InterruptedException
	 */
//	@Test(priority = 2)
	public void showLogo_DifferentLogoForFooter() throws InterruptedException {
		driver.get(customizer);
		fbap.footerMenu.click();
		fbap.footerBottomArea.click();

		if (!fbap.showLogo.isSelected()) {
			fbap.showLogoToggle.click();
		}

		if (fbap.useTheSameLogoFromHeader.isSelected()) {
			fbap.useTheSameLogoFromHeaderToggle.click();
		}
		fbap.saveButton.click();
		Thread.sleep(3000);
		driver.get(siteurl);

		Assert.assertTrue(fbap.differentFooterLogo.getAttribute("src").contains("/logo-web.png"),
				"The Footer icon is not getting displayed or the icon is not same as selected in customization when 'Use the same logo from header' is disabled.");

	}

	@Test(priority = 3)
	public void Disable_PrivacyPolicy() throws InterruptedException {
		driver.get(customizer);
		fbap.footerMenu.click();
		fbap.footerBottomArea.click();

		if (fbap.showPrivacyPolicy.isSelected()) {
			fbap.showPrivacyPolicyToggle.click();
		}

		fbap.saveButton.click();
		Thread.sleep(3000);
		driver.get(siteurl);

		Assert.assertTrue(fbap.f_privacypolicy.getCssValue("display").contains("none"),
				"Privacy policy  is  visible even when hidden from customizer setting ");
	}

	@Test(priority = 4)
	public void showPrivacyPolicy() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		String PPLink = "https://edwiser.org/privacy-policy/";
		driver.get(customizer);
		fbap.footerMenu.click();
		fbap.footerBottomArea.click();

		if (!fbap.showPrivacyPolicy.isSelected()) {
			fbap.showPrivacyPolicyToggle.click();
		}

		fbap.privacyPolicyLink.clear();
		fbap.privacyPolicyLink.sendKeys(PPLink);
		fbap.saveButton.click();
		Thread.sleep(3000);
		driver.get(siteurl);
		softAssert.assertTrue(fbap.f_privacypolicy.getCssValue("display").contains("block"),
				"Privacy policy  is not visible even when shown from customizer setting ");
		softAssert.assertEquals(fbap.privacyPoilcy.getAttribute("href"), PPLink);
		softAssert.assertAll();
	}

	@Test(priority = 5)
	public void Disable_TermsAndConditions() throws InterruptedException {
		driver.get(customizer);
		fbap.footerMenu.click();
		fbap.footerBottomArea.click();

		if (fbap.showTermsAndConditions.isSelected()) {
			fbap.showTermsAndConditionsToggle.click();
		}

		fbap.saveButton.click();
		Thread.sleep(3000);
		driver.get(siteurl);

		Assert.assertTrue(fbap.f_TnC.getCssValue("display").contains("none"),
				"Terms and condition  is  visible even when hidden from customizer setting");
	}

	@Test(priority = 6)
	public void showTermsAndConditions() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		String TCLink = "https://edwiser.org/terms-and-conditions/";
		driver.get(customizer);
		fbap.footerMenu.click();
		fbap.footerBottomArea.click();

		if (!fbap.showTermsAndConditions.isSelected()) {
			fbap.showTermsAndConditionsToggle.click();
			Thread.sleep(1500);
		}

		fbap.termsAndConditionContent.clear();
		fbap.termsAndConditionContent.sendKeys(TCLink);
		fbap.saveButton.click();
		Thread.sleep(3000);
		driver.get(siteurl);
		softAssert.assertTrue(fbap.f_TnC.getCssValue("display").contains("block"),
				"Terms and condition is not visible even when shown from customizer setting");
		softAssert.assertEquals(fbap.TermsandConditons.getAttribute("href"), TCLink);
		softAssert.assertAll();
	}

	@Test(priority = 7)
	public void Hide_showCopyrightContent() throws InterruptedException {
		driver.get(customizer);
		fbap.footerMenu.click();
		fbap.footerBottomArea.click();

		if (fbap.showCopyrightContent.isSelected()) {
			fbap.showCopyrightContentToggle.click();
		}
		fbap.saveButton.click();
		Thread.sleep(3000);
		driver.get(siteurl);

		Assert.assertTrue(fbap.CopyrightDiv.getCssValue("display").contains("none"),
				"Copy Right Conent is Not getting hidden from footer");

	}

	@Test(priority = 8)
	public void showCopyrightContent() throws InterruptedException {
		driver.get(customizer);
		fbap.footerMenu.click();
		fbap.footerBottomArea.click();

		if (!fbap.showCopyrightContent.isSelected()) {
			fbap.showCopyrightContentToggle.click();
		}
		fbap.copyrightContent.clear();
		fbap.copyrightContent.sendKeys("[site] © [year]. All rights reserved.");
		fbap.saveButton.click();
		Thread.sleep(3000);
		driver.get(siteurl);

		Assert.assertTrue(fbap.Copyright.getText().contains(CopyRightText),
				"The Text Added for Copyright is not same on home page as mentioned in customizer");

	}

	@Test(priority = 9)
	public void Hide_poweredByEdwiser() throws InterruptedException {
		driver.get(customizer);
		fbap.footerMenu.click();
		fbap.footerBottomArea.click();

		if (fbap.poweredByEdwiser.isSelected()) {
			fbap.poweredByEdwiserToggle.click();
		}
		fbap.saveButton.click();
		Thread.sleep(3000);
		driver.get(siteurl);
		Thread.sleep(1000);
		fbap.footerIcon.click();

		Assert.assertFalse(fbap.poweredByEdwiserFrontend.getText().contains("Powered by Edwiser RemUI"),
				"The Powered By Edwiser is not getting displayed even after enabling it from customizer");

	}

	@Test(priority = 10)
	public void Show_poweredByEdwiser() throws InterruptedException {
		driver.get(customizer);
		fbap.footerMenu.click();
		fbap.footerBottomArea.click();

		if (!fbap.poweredByEdwiser.isSelected()) {
			fbap.poweredByEdwiserToggle.click();
		}
		fbap.saveButton.click();
		Thread.sleep(3000);
		driver.get(siteurl);
		Thread.sleep(1000);
		fbap.footerIcon.click();

		Assert.assertTrue(fbap.poweredByEdwiserFrontend.getText().contains("Powered by Edwiser RemUI"),
				"The Powered By Edwiser is not getting displayed even after enabling it from customizer");

	}

}
