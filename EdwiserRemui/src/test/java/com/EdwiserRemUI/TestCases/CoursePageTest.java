package com.EdwiserRemUI.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.EdwiserRemUI.BaseTest.BaseClass;
import com.EdwiserRemUI.PageObjects.CoursePage;
import com.EdwiserRemUI.PageObjects.DashboardSettingPage;

public class CoursePageTest extends BaseClass{

	DashboardSettingPage dsp;
	CoursePage cp;
	@BeforeClass
	public void Before_class() {
		dsp =new DashboardSettingPage(driver);
		cp= new CoursePage(driver);
	}
	
	@Test
	public void verifycoursestatssettingwhenenableordisabled() {
		SoftAssert softAssert = new SoftAssert();
		cp.clickoncoursepagemenu();
		boolean status=cp.coursestatsstatus();
		//Assert.assertEquals(status, true,"Coursestats  setting on coursepage is not enabled by default");
		if(status==true) {
			driver.get(coursepage);
			softAssert.assertTrue(cp.coursestatsoncp.size() == 1,
					"Course stat option is not present even if setting is enabled ");
			
			}
		else {
			cp.coursestatlabel.click();
			cp.savechanges.click();
			driver.get(coursepage);
			softAssert.assertTrue(cp.coursestatsoncp.size() == 1,
					"Course stat option is not present even if setting is enabled ");
		softAssert.assertAll();	
	}
}
	
	@Test
	public void verifycoursestatswhendisabled() {
		SoftAssert softAssert = new SoftAssert();
		cp.clickoncoursepagemenu();
		cp.coursestatlabel.click();
		cp.savechanges.click();
		driver.get(coursepage);
		softAssert.assertTrue(cp.coursestatsoncp.size() == 0,
				"Course stat option is present even if setting is disabled ");
		softAssert.assertAll();	
	}
	
	@Test
	public void verifyenablefocusmodesetting() {
		SoftAssert softAssert = new SoftAssert();
		cp.clickoncoursepagemenu();
		boolean status=cp.focusmodestatus();
		if(status==true) {
			driver.get(coursepage);
			softAssert.assertTrue(cp.focusmodebuttononcp.size() == 1,
					"Enable focus mode button is not present even if setting is enabled ");
			
			}
		else {
			cp.focusmodelabel.click();
			cp.savechanges.click();
			driver.get(coursepage);
			softAssert.assertTrue(cp.focusmodebuttononcp.size() == 1,
					"Enable focus mode button is not present even if setting is enabled  ");
		softAssert.assertAll();	
	}
}
	@Test
	public void verifyenablefocusmodesettingwhendisabled() {
		SoftAssert softAssert = new SoftAssert();
		cp.clickoncoursepagemenu();
		cp.focusmodelabel.click();
		cp.savechanges.click();
		driver.get(coursepage);
		softAssert.assertTrue(cp.focusmodebuttononcp.size() == 0,
				"Enable focus mode button is  present even if setting is disabled ");
	
		softAssert.assertAll();	
	}
	
	
	
	
	@Test
	public void verifycourseselectedcount() throws InterruptedException {
		cp.clickoncoursepagemenu();
		String count=cp.selectcoursecount();
		//System.out.println("Count "+count);
		driver.get(coursearchive);
		cp.selectlistview.click();
		String coursecount=cp.coursecountonap();
		//System.out.println("coursecount "+coursecount);
		Assert.assertEquals(coursecount, count,"The Number of Courses to be Displayed Per Pages on Course Archive Page did not matched.");
		

	}	
	
	@Test
	public void verifywhenheaderdesign1selected() {
		SoftAssert softAssert = new SoftAssert();
		cp.clickoncoursepagemenu();
		cp.selectcourseheaderdesign1();
		cp.savechanges.click();
		driver.get(coursepage);
		softAssert.assertTrue(cp.headerdesignoncp.size() == 1,
				"Header design 1 on course page is not getting visible even if header design 1 is selected");
		softAssert.assertAll();	
		
	}
	
	@Test
	public void verifywhenheaderdesigndefaultselected() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		cp.clickoncoursepagemenu();
        cp.selectcourseheaderdefault();
	
		cp.savechanges.click();
		Thread.sleep(2000);
		driver.get(coursepage);
	
		softAssert.assertTrue(cp.headerdesignoncp.size()== 0,
				"default design on course page is not getting visible even if default design  is selected");
		softAssert.assertAll();	
		
	}
	
	@Test
	public void verifywhenEnableisselected() {
		SoftAssert softAssert = new SoftAssert();
		cp.clickoncoursepagemenu();
		cp.selectenablebuttonoption();
		cp.savechanges.click();
		driver.get(coursepage1);
		cp.clickonanyactivity.click();
		softAssert.assertTrue(cp.prevactivity.size() == 1,
				"prevactivity button is not getting visible even if setting is enabled");
	
		softAssert.assertTrue(cp.nextactivity.size() == 1,
				"nextactivity button is not getting visible even if setting is enabled");
		softAssert.assertAll();	
	}
	
	@Test
	public void verifywhendisableisselected() {
		SoftAssert softAssert = new SoftAssert();
		cp.clickoncoursepagemenu();
		cp.selectdisablebuttonoption();
		cp.savechanges.click();
		driver.get(coursepage1);
		cp.clickonanyactivity.click();
		softAssert.assertTrue(cp.prevactivity.size() == 0,
				"prevactivity button is  getting visible even if setting is disabled");
	
		softAssert.assertTrue(cp.nextactivity.size() == 0,
				"nextactivity button is  getting visible even if setting is disabled");
		softAssert.assertAll();	
	}
	
	@Test
	public void verifywhenenablewithactivitynameisselected() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		cp.clickoncoursepagemenu();
		cp.selectenablewithactivitybuttonoption();
		cp.savechanges.click();
		driver.get(coursepage1);
		String actnameprev=cp.getprevactivityname();
		//System.out.println( "actnameprev "+actnameprev);
		String actnamenext=cp.getnextactivityname();
		
		Thread.sleep(1000);
		cp.clickonanyactivity.click();
		softAssert.assertTrue(cp.prevactivity.size() == 1,
				"prevactivity button is not getting visible even if setting is enabled");
	
		softAssert.assertTrue(cp.nextactivity.size() == 1,
				"nextactivity button is not getting visible even if setting is enabled");
		String prevactap=cp.getpreviousactivitynameap();
		//System.out.println( "prevactap "+prevactap);
		String nextactap=cp.getnextactivitynameap();
		
		softAssert.assertEquals(actnameprev,prevactap,"The activity name on previous button didnt matched ");
		
		softAssert.assertEquals(actnamenext,nextactap,"The activity name on next button didnt matched ");
	
		//verify previous button on activity page is clickable and is redirecting to expected activity
		String currenturl=driver.getCurrentUrl();
		cp.prevactivitynameap.click();
		String prevactivitytitle1=cp.activitytitle.getText();
		String prevactivitytitle =prevactivitytitle1.replaceAll("\\s", "");
		
		softAssert.assertEquals(prevactivitytitle, prevactap,"On clicking the previous activity button it is not redirecting to expected activity");
		
		//verify next button on activity page is clickable and is redirecting to expected activity
		driver.get(currenturl);
		cp.nextactivitynameap.click();
		String nextactivitytitle1=cp.activitytitle.getText();
		String nextactivitytitle =nextactivitytitle1.replaceAll("\\s", "");
		softAssert.assertEquals(nextactivitytitle, nextactap,"On clicking the next activity button it is not redirecting to expected activity");
		
		softAssert.assertAll();	
	}
}
