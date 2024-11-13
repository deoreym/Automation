package com.EdwiserRemUI.TestCases;

import java.time.Duration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.EdwiserRemUI.BaseTest.BaseClass;
import com.EdwiserRemUI.PageObjects.CourseFormatPage;


public class CourseFormatTest extends BaseClass {

	CourseFormatPage CFP;
	
	@BeforeClass
	public void Before_class() throws InterruptedException {
		System.out.println("In Course Format Test Class : CourseFormatTest");
		CFP = new CourseFormatPage(driver);

	}
	
	@Test(priority =1)
	public void Enable_Edwiser_Course_Format() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		//visit course setting page
		driver.get(CourseSettingPage);
		CFP.CourseFormatSection.click();
		Thread.sleep(10000);
		CFP.courseformatbutton.click();
		Thread.sleep(3000);
		//select remui format
		CFP.remuiformat.click();
		Thread.sleep(3000);
		//visit course page
		CFP.saveanddisplay.click();
		
		//verify remui course format applied on course page
		softAssert.assertTrue(CFP.remuiformatoncp.size() > 0, "RemUI course format is not  getting applied  on Course Page");
		
	} 
	
	
	
	@Test(priority =2)
	public void Verify_layout_as_card() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		//visit course setting page and enable card layout
				driver.get(CourseSettingPage);
				Thread.sleep(3000);
				CFP.CourseFormatSection.click();
				Thread.sleep(2000);
				CFP.courseformatbutton.click();
				//select remui format
				CFP.remuiformat.click();
				CFP.cardlayoutoption.click();
				Thread.sleep(3000);
				CFP.saveanddisplay.click();
				
				//Check card layout is getting applied on course page 
				softAssert.assertTrue(CFP.cardlayoutoncp.size() > 0, "Card Layout is not  getting applied  on Course Page");
				
				softAssert.assertAll();
				
		
	}
	
	@Test(priority =3)
	public void Verify_layout_as_List() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		//visit course setting page and enable list layout
				driver.get(CourseSettingPage);
				Thread.sleep(3000);
				CFP.CourseFormatSection.click();
				Thread.sleep(2000);
				CFP.courseformatbutton.click();
				//select remui format
				CFP.remuiformat.click();
				CFP.listlayoutoption.click();
				Thread.sleep(3000);
				CFP.saveanddisplay.click();
				
				//Check card layout is getting applied on course page 
				softAssert.assertTrue(CFP.listlayoutoncp.size() > 0, "List Layout is not  getting applied  on Course Page");
				softAssert.assertAll();
				
		
	}
	
	@Test(priority =4)
	public void Hide_General_Section_When_Empty() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//visit course setting page and enable list layout
		driver.get(CourseSettingPage);
		Thread.sleep(3000);
		CFP.CourseFormatSection.click();
		Thread.sleep(2000);
		CFP.courseformatbutton.click();
		//select remui format
		//CFP.remuiformat.click();
		CFP.Hidegeneralsectionasempty.click();
		Thread.sleep(3000);
		CFP.saveanddisplay.click();
		Thread.sleep(3000);
		softAssert.assertTrue(CFP.generalsectiononcp.size()==0, "General section is getting visible on Course Page");
		softAssert.assertAll();
		
	}
	
	@Test(priority =5)
	public void Show_General_Section_When_Empty() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//visit course setting page and enable list layout
		driver.get(CourseSettingPage);
		Thread.sleep(3000);
		CFP.CourseFormatSection.click();
		Thread.sleep(2000);
		CFP.courseformatbutton.click();
		//select remui format
		CFP.remuiformat.click();
		CFP.showgeneralsectionasempty.click();
		Thread.sleep(3000);
		CFP.saveanddisplay.click();
		softAssert.assertTrue(CFP.generalsectiononcp.size()==1, "General section is not  getting visible on Course Page");
		softAssert.assertAll();
		
	}
	
	@Test(priority =6)
	public void Enable_Course_Layout_As_AllSectionInPage_In_ListLayout() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//visit course setting page and enable list layout
		driver.get(CourseSettingPage);
		Thread.sleep(3000);
		CFP.CourseFormatSection.click();
		Thread.sleep(2000);
		CFP.courseformatbutton.click();
		//select remui format
		CFP.remuiformat.click();
		
		CFP.listlayoutoption.click();
		Thread.sleep(3000);
		CFP.AllSectionInOnePage.click();
		CFP.saveanddisplay.click();
		Thread.sleep(2000);
		softAssert.assertTrue(CFP.allsectiononcp.size()==1, "All Section in one page is not getting applied  Course Page");
		softAssert.assertAll();
		
	}
	
	@Test(priority =7)
	public void Enable_Course_Layout_As_OneSectionInPage_In_ListLayout() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		//visit course setting page and enable list layout
		driver.get(CourseSettingPage);
		Thread.sleep(3000);
		CFP.CourseFormatSection.click();
		Thread.sleep(2000);
		CFP.courseformatbutton.click();
		Thread.sleep(2000);
		//select remui format
		CFP.remuiformat.click();
		Thread.sleep(2000);
		CFP.listlayoutoption.click();
		Thread.sleep(3000);
		CFP.OneSectionPerPage.click();
	 	Thread.sleep(2000);
		CFP.saveanddisplay.click();
		Thread.sleep(2000);
		softAssert.assertTrue(CFP.onesectiononcp.size()==1, "One Section per page is not getting applied  Course Page");
		softAssert.assertAll();
		
	}
	
	@Test(priority =8)
	public void Verify_Section_Summary_length() throws InterruptedException {
		String text="6";
		String charToRemove="...";
		SoftAssert softAssert = new SoftAssert();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		//visit course setting page and enable list layout
		driver.get(CourseSettingPage);
		Thread.sleep(3000);
		CFP.CourseFormatSection.click();
		Thread.sleep(2000);
		CFP.courseformatbutton.click();
		//select remui format
		CFP.remuiformat.click();
		Thread.sleep(2000);
		CFP.summarylength.clear();
		CFP.summarylength.sendKeys(text);
		CFP.saveanddisplay.click();
		Thread.sleep(2000);
		String Length=CFP.summarytextoncp.getText();
		String modifiedString = Length.replace(String.valueOf(charToRemove),"");
		int lengthofstring=modifiedString.length();
		String length = Integer.toString(lengthofstring);
		System.out.println(length);
		softAssert.assertEquals(text, length,"The max length of description is not same as mentioned in the setting");
		softAssert.assertAll();
	}
	
	
	
}
