package com.EdwiserRemUI.TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.EdwiserRemUI.BaseTest.BaseClass;
import com.EdwiserRemUI.PageObjects.PageBuilderPage;

public class PageBuilderTest extends BaseClass {

	PageBuilderPage PBP;
	
	@BeforeClass
	public void Before_class() throws InterruptedException {
		System.out.println("In PageBuilder Test Class : PageBuilder");
		PBP = new PageBuilderPage(driver);

	}
	
	//@Test(priority =1)
	public void Verify_On_clicking_add_A_block() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		//click on edit mode
		PBP.editmodevalue.click();
		PBP.addablockbutton.click();
		Thread.sleep(2000);
		//verify  modal is visble on clicking add a block button
		softAssert.assertTrue(PBP.modal.size() > 0, "Modal is not getting opened or button is not clicable");
		PBP.closebutton.click();
		softAssert.assertAll();
		}
	
	//@Test(priority =2)
	public void Verify_On_clicking_RemUI_tab() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(2000);
		boolean status=PBP.editmodevalue.isSelected();
		System.out.println(status);
		if(!status) {
			PBP.editmodevalue.click();
		}
		PBP.addablockbutton.click();
		Thread.sleep(2000);
		//verify  RemUI tab content 
		softAssert.assertTrue(PBP.custombutton.size() > 0, "Static tab blocks are not getting visible");
		softAssert.assertAll();
		}
	
	//@Test(priority =3)
	public void Verify_On_clicking_Moodle_tab() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(2000);
		boolean status=PBP.editmodevalue.isSelected();
		System.out.println(status);
		if(!status) {
			PBP.editmodevalue.click();
		}
		PBP.addablockbutton.click();
		PBP.moodletab.click();
		Thread.sleep(2000);
		//verify  RemUI tab content 
		softAssert.assertTrue(PBP.moodleblocks.size() > 0, "Moodle blocks are not getting visible");
		softAssert.assertAll();
		}
	
	@Test
	public void Verify_on_Selecting_region_AndAddingAblock() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(2000);
		boolean status=PBP.editmodevalue.isSelected();
		System.out.println(status);
		if(!status) {
			PBP.editmodevalue.click();
		}
		PBP.resetbutton.click();
		PBP.editmodevalue.click();
		PBP.regionbutton.click();
		PBP.selectedregion.click();
		Thread.sleep(2000);
		PBP.addablockbutton.click();
		Thread.sleep(2000);
		PBP.selectcategory.click();
		PBP.selectedblock.click();
		
	}
	
}
