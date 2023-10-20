package com.EdwiserRemUI.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.EdwiserRemUI.BaseTest.BaseClass;
import com.EdwiserRemUI.PageObjects.ColorConversion;
import com.EdwiserRemUI.PageObjects.DashBoardPage;
import com.EdwiserRemUI.PageObjects.HeaderHideShowMenuPage;
import com.EdwiserRemUI.PageObjects.ProfilePage;
import com.EdwiserRemUI.PageObjects.SettingsPage;

public class ProfilePageTest extends BaseClass {
	
	SettingsPage sp;
	DashBoardPage dp; 
	HeaderHideShowMenuPage hsp;
	ColorConversion cc;
	ProfilePage pp;
	
	@BeforeClass
	public void Before_class() {
		sp =new SettingsPage(driver);
		dp=new DashBoardPage(driver);
		hsp= new HeaderHideShowMenuPage(driver);
		cc=new ColorConversion();
		pp=new ProfilePage(driver);
	}
	
	@Test(priority=1)
	public void verifyblogentrieswhenenabled() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		dp.clicksiteadmin.click();
		pp.generaltab.click();
		pp.advancedfeaturemenu.click();
		Thread.sleep(2000);
		String present=pp.blogchbk.getAttribute("Checked");
		boolean status = Boolean.parseBoolean(present);
		System.out.println(status);
		if(status==true) {
			driver.get(profilepage);
			softAssert.assertTrue(pp.blogentriesonpp.size()==1,
					"Blog entries is not visible even when setting is enable from advanced feature");
			String actual=pp.blogcount.getAttribute("innerHTML");
			driver.get(blogpage);
			int count =pp.blogsize.size();
			String expected=Integer.toString(count);
			softAssert.assertEquals(actual, expected,"The blog entries count didnt matched ");
		
		}
		else {
			pp.lablelblog.click();
			sp.savebutton.click();
			driver.get(profilepage);
			softAssert.assertTrue(pp.blogentriesonpp.size()==1,
					"Blog entries is not visible even when setting is enable from advanced feature");
			String actual=pp.blogcount.getAttribute("innerHTML");
			driver.get(blogpage);
			int count =pp.blogsize.size();
			String expected=Integer.toString(count);
			softAssert.assertEquals(actual, expected,"The blog entries count didnt matched ");
		
		}
		softAssert.assertAll();
		
	}
	@Test(priority=2)
	public void verifyblogentrieswhendisabled() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		dp.clicksiteadmin.click();
		pp.generaltab.click();
		pp.advancedfeaturemenu.click();
		Thread.sleep(2000);
		String present=pp.blogchbk.getAttribute("Checked");
		boolean status = Boolean.parseBoolean(present);
		System.out.println(status);
		if(status==true) {
			pp.lablelblog.click();
			sp.savebutton.click();
			driver.get(profilepage);
			softAssert.assertTrue(pp.blogentriesonpp.size()==0,
					"Blog entries is  visible even when setting is disabled from advanced feature");
			
		}
		else {
			driver.get(profilepage);
			softAssert.assertTrue(pp.blogentriesonpp.size()==0,
					"Blog entries is  visible even when setting is disabled from advanced feature");
			
		}
		softAssert.assertAll();
	}
	
	@Test(priority=3)
	public void VerifyBadgewhenenabled() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		dp.clicksiteadmin.click();
		pp.generaltab.click();
		pp.advancedfeaturemenu.click();
		Thread.sleep(2000);
		String present=pp.badgechbk.getAttribute("Checked");
		boolean status = Boolean.parseBoolean(present);
		System.out.println(status);
		if(status==true) {
			driver.get(profilepage);
			softAssert.assertTrue(pp.badgeentriesonpp.size()==1,
					"Badge entries is not visible even when setting is enable from advanced feature");
			String actual=pp.badgecount.getAttribute("innerHTML");
			int count=pp.badgesize.size();
			String expected=Integer.toString(count);
			softAssert.assertEquals(actual, expected, "The badge entries count didnt matched ");
			
			
		}
		else {
			pp.lablelbadge.click();
			sp.savebutton.click();
			driver.get(profilepage);
			softAssert.assertTrue(pp.badgeentriesonpp.size()==1,
					"Badge entries is not visible even when setting is enable from advanced feature");
			String actual=pp.badgecount.getAttribute("innerHTML");
			int count=pp.badgesize.size();
			String expected=Integer.toString(count);
			softAssert.assertEquals(actual, expected, "The badge entries count didnt matched ");
			
			
		}
		softAssert.assertAll();
	}
	
	@Test(priority=4)
	public void verifybadgewhendisabled() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		dp.clicksiteadmin.click();
		pp.generaltab.click();
		pp.advancedfeaturemenu.click();
		Thread.sleep(2000);
		String present=pp.blogchbk.getAttribute("Checked");
		boolean status = Boolean.parseBoolean(present);
		System.out.println(status);
		if(status==true) {
			pp.lablelbadge.click();
			sp.savebutton.click();
			driver.get(profilepage);
			softAssert.assertTrue(pp.badgeentriesonpp.size()==0,
					"Badge entries is  visible even when setting is disabled from advanced feature");
			
		}
		else {
			driver.get(profilepage);
			softAssert.assertTrue(pp.badgeentriesonpp.size()==0,
					"Badge entries is  visible even when setting is disabled from advanced feature");
			
		}
		softAssert.assertAll();
	}
	
	@Test(priority=5)
	public void verifydiscussioncount() {
		driver.get(profilepage);
		String actual=pp.discussioncount.getAttribute("innerHTML");
		System.out.println(actual);
		driver.get(forumpage);
		int count=pp.discussionsize.size();
		String expected=Integer.toString(count);
		Assert.assertEquals(actual, expected, "Discussion count didnt matched ");
		
	}
	
//	@Test(priority=6)
//	public void verifycontactcount() throws InterruptedException {
//		driver.get(profilepage);
//		String actual=pp.contactcount.getAttribute("innerHTML");
//		pp.contactlink.click();
//		Thread.sleep(10000);
//		String expected=pp.countactcountonmsgpanel.getAttribute("innerHTML");
//		Assert.assertEquals(actual, expected,"contact count didnt matched");
//	}
	
}
