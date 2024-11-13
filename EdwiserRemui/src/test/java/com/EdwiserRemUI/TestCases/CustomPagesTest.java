package com.EdwiserRemUI.TestCases;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.EdwiserRemUI.BaseTest.BaseClass;
import com.EdwiserRemUI.PageObjects.CustomPages;

public class CustomPagesTest extends BaseClass{
	
	CustomPages cp;
	SoftAssert softassert;
	Actions actions;
	String customPage = "Automation Test Page 2";
	WebDriverWait wait;
	final int TIMEOUT = 5;
	String CustomPageMetaTitle = "Custom Page Meta Title";
	String CustomPageMetaDescription = "Custom Page Meta Description";
	
	@BeforeClass
	public void Before_class() {
		System.out.println("In Custom Pages Test Class - CustomPagesTest");
		cp = new CustomPages(driver);
		actions = new Actions(driver);
		softassert = new SoftAssert();
		wait = new WebDriverWait(driver,Duration.ofSeconds(TIMEOUT));
	}
	
	
	// Helper method to check if an element is visible
    private boolean isElementVisible(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

	
	@Test(priority = 1)
	public void addNewCustomPages() throws InterruptedException{
		
		driver.get(customPagesURL);
		Thread.sleep(1500);
		cp.addNewPageButton.click();
		cp.pageNameField.sendKeys(customPage);
		cp.savePageName.click();
		
		Assert.assertTrue(cp.pageInList(customPage).size()==1,
				"The new added page is not getting displayed in the custom pages list OR Custom page is not getting created");
		
		driver.get(siteurl);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
		try {
			// Check for the unexpected alert
			Alert alert = driver.switchTo().alert();

			// Handle the alert (accept or dismiss)
			alert.accept();
		} catch (Exception e) {
			// No unexpected alert, continue with other actions
			System.out.println("No unexpected alert present");
		}
				
	}
	
	@Test(priority = 2)
	public void editPageTitle() throws InterruptedException {
		
		driver.get(customPagesURL);
		Thread.sleep(1500);
		actions.moveToElement(cp.firstCustomePage).perform();
		Thread.sleep(500);
		cp.editPageTitle.click();
		Thread.sleep(500);
		cp.pageNameField.sendKeys(" 001");
		cp.savePageName.click();
		
		Assert.assertEquals(cp.firstCustomePage.getText(), customPage + " 001",
				"The Custom Page title is not getting edited OR the Edited Title is not getting saved");
		Thread.sleep(2000);
		actions.moveToElement(cp.firstCustomePage).perform();
		Thread.sleep(500);
		cp.editPageTitle.click();
		cp.pageNameField.clear();
		cp.pageNameField.sendKeys(customPage);
		cp.savePageName.click();
		
		driver.get(siteurl);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
		try {
			// Check for the unexpected alert
			Alert alert = driver.switchTo().alert();

			// Handle the alert (accept or dismiss)
			alert.accept();
		} catch (Exception e) {
			// No unexpected alert, continue with other actions
			System.out.println("No unexpected alert present");
		}
		
	}
	
	
	@Test(priority = 3)
	public void copyPageURL() throws InterruptedException{
		
		driver.get(customPagesURL);
		Thread.sleep(1500);
		actions.moveToElement(cp.firstCustomePage).perform();
		Thread.sleep(500);
		cp.copyPageURL.click();
		
		boolean isPopupVisible = isElementVisible(By.xpath(cp.linkCopiedConfirmationMessage));
		Assert.assertTrue(isPopupVisible, 
				"After coping the Cutome Page URL the copied confirmation message is not getting dispalyed");
	}
	
	
	@Test(priority = 4)
	public void customPageSettings() throws InterruptedException{
		
		String CustomPageDesp = "Custom Page Description";
		String CustomPageContent = "Custom Page Content";
		driver.get(customPagesURL);
		Thread.sleep(1500);
		cp.customPageSettingsIcon(customPage).click();
		Thread.sleep(2000);
		cp.customPageDescription.clear();
		cp.customPageDescription.sendKeys(CustomPageDesp);
		Thread.sleep(1000);
		cp.expandPageDisaply.click();
		cp.customPageContent.clear();
		cp.customPageContent.sendKeys(CustomPageContent);
		Thread.sleep(1000);
		cp.expandSEO.click();
		cp.customPageMetaTitle.clear();
		cp.customPageMetaTitle.sendKeys(CustomPageMetaTitle);
		Thread.sleep(1000);
		cp.customPageMetaDescription.clear();
		cp.customPageMetaDescription.sendKeys(CustomPageMetaDescription);
		Thread.sleep(1000);
		cp.sumbitAndPublishbutton.click();
		Thread.sleep(2000);
		
		softassert.assertTrue(cp.customPageDespFrontend.getAttribute("content").contains("Custom Page Description"),
				"The set Custom Page Description in backend is not getting reflected on frontend custom page");
		
		softassert.assertTrue(cp.customPageContentFrontend.getText().contains("Custom Page Content"),
				"The set Custom Page Content in backend is not getting reflected on frontend custom page");
		
		softassert.assertTrue(cp.customMetaFrontend(CustomPageMetaTitle).getAttribute("name").contains("Custom Page Meta Title"),
				"The set Custom Page Meta Title in backend is not getting reflected on frontend custom page");
		
		softassert.assertTrue(cp.customMetaFrontend(CustomPageMetaTitle).getAttribute("content").contains("Custom Page Meta Description"),
				"The set Custom Page Meta Description in backend is not getting reflected on frontend custom page");
	
		
		softassert.assertAll();
	}
	
	@Test(priority = 5)
	public void duplicateCustomPages() throws InterruptedException{
		
		driver.get(customPagesURL);
		Thread.sleep(1500);
		cp.duplicateicon(customPage).click();
		Thread.sleep(1500);
		Assert.assertEquals(customPage+"_copy", cp.duplicateCustomePage(customPage).getText(), "Custom Page is not getting duplicated");
		
	}
	
	
	@Test(priority = 6)
	public void deleteCustomePage() throws InterruptedException{
		
		driver.get(customPagesURL);
		Thread.sleep(1500);
		cp.deleteTopMostCustomPageInList.click();
		Thread.sleep(500);
		cp.confirmDeletionYesButtton.click();
		
		// Check if the popup appears
        boolean isPopupVisible = isElementVisible(By.xpath(cp.deleteConfirmationMessage));
        Assert.assertTrue(isPopupVisible,
        		"After deleting the Custome Page, delete confimation popup is not getting displayed or The Custome Page is not getting deleted");
        
        cp.deleteTopMostCustomPageInList.click();
		Thread.sleep(500);
		cp.confirmDeletionYesButtton.click();
	
	}
	
	
	

}
