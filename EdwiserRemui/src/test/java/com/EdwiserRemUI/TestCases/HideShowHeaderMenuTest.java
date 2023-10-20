package com.EdwiserRemUI.TestCases;

import java.time.Duration;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.EdwiserRemUI.BaseTest.BaseClass;
import com.EdwiserRemUI.PageObjects.CustomizerPage;
import com.EdwiserRemUI.PageObjects.DashBoardPage;
import com.EdwiserRemUI.PageObjects.HeaderHideShowMenuPage;

public class HideShowHeaderMenuTest extends BaseClass{
	
	DashBoardPage dp;
	CustomizerPage cpp;
	HeaderHideShowMenuPage hsp;
	
	@BeforeClass
	public void Before_class() {
		dp =new DashBoardPage(driver);
		cpp= new CustomizerPage(driver);
		hsp= new HeaderHideShowMenuPage(driver);
	}

	//Check when home menu is hidden from customizer
	@Test(priority=1)
	public void verifyhidehomemenufromheader() throws InterruptedException  {
		SoftAssert softAssert = new SoftAssert();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		dp.remuimenu();
		cpp.customizertab.click();
		cpp.customizerbutton.click();
		hsp.headermenu.click();
		hsp.hideshowmenu.click();
		String present=hsp.homemenu.getAttribute("Checked");
		boolean status=Boolean.parseBoolean(present);
		System.out.println(status);
		if(status==true) {
			Thread.sleep(2000);
			driver.get(dashboard);
			softAssert.assertTrue(hsp.homemenuondp.size()==0,
					"Home menu is still visible even when hidden from customizer setting ");
		}
		else {
			hsp.homemenulabel.click();
			hsp.savebutton.click();
			Thread.sleep(2000);
			driver.get(dashboard);
			Thread.sleep(2000);
			softAssert.assertTrue(hsp.homemenuondp.size()==0,
					"Home menu is still visible even when hidden from customizer setting ");
		
		}
		softAssert.assertAll();
	}
	
	//Check when home menu is enabled
	@Test(priority=2)
	public void verifywhenhomeisenabled() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		dp.remuimenu();
		cpp.customizertab.click();
		cpp.customizerbutton.click();
		hsp.headermenu.click();
		hsp.hideshowmenu.click();
		String present=hsp.homemenu.getAttribute("Checked");
		boolean status=Boolean.parseBoolean(present);
		System.out.println(status);
		if(status==true) {
			hsp.homemenulabel.click();
			hsp.savebutton.click();
			Thread.sleep(2000);
			driver.get(dashboard);
			Thread.sleep(2000);
			softAssert.assertTrue(hsp.homemenuondp.size()==1,
					"Home menu is not visible even when shown from customizer setting ");
		}
		else {
			Thread.sleep(2000);
			driver.get(dashboard);
			Thread.sleep(2000);
			softAssert.assertTrue(hsp.homemenuondp.size()==1,
					"Home menu is not visible even when shown from customizer setting ");
		
		}
		softAssert.assertAll();
	}	
	
	//Check when mycourses  menu is hidden from customizer
		@Test(priority=3)
		public void verifyhidemycoursesmenufromheader() throws InterruptedException  {
			SoftAssert softAssert = new SoftAssert();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			dp.remuimenu();
			cpp.customizertab.click();
			cpp.customizerbutton.click();
			hsp.headermenu.click();
			hsp.hideshowmenu.click();
			String present=hsp.mycoursesmenu.getAttribute("Checked");
			boolean status=Boolean.parseBoolean(present);
			System.out.println(status);
			if(status==true) {
				Thread.sleep(2000);
				driver.get(dashboard);
				softAssert.assertTrue(hsp.mycoursesondp.size()==0,
						"My courses menu is still visible even when hidden from customizer setting ");
			}
			else {
				hsp.mycourseslabel.click();
				hsp.savebutton.click();
				Thread.sleep(2000);
				driver.get(dashboard);
				Thread.sleep(2000);
				softAssert.assertTrue(hsp.mycoursesondp.size()==0,
						"My courses menu is still visible even when hidden from customizer setting ");
			
			}
			softAssert.assertAll();
		}
		
		//Check when my courses menu is enabled 
		@Test(priority=4)
		public void verifywhenmycoursemenuisenabled() throws InterruptedException {
			SoftAssert softAssert = new SoftAssert();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			dp.remuimenu();
			cpp.customizertab.click();
			cpp.customizerbutton.click();
			hsp.headermenu.click();
			hsp.hideshowmenu.click();
			String present=hsp.mycoursesmenu.getAttribute("Checked");
			boolean status=Boolean.parseBoolean(present);
			System.out.println(status);
			if(status==true) {
				hsp.mycourseslabel.click();
				hsp.savebutton.click();
				Thread.sleep(2000);
				driver.get(dashboard);
				Thread.sleep(2000);
				softAssert.assertTrue(hsp.mycoursesondp.size()==1,
						"My courses menu is not visible even when shown from customizer setting ");
			}
			else {
				Thread.sleep(2000);
				driver.get(dashboard);
				Thread.sleep(2000);
				softAssert.assertTrue(hsp.mycoursesondp.size()==1,
						"My courses menu is not visible even when shown from customizer setting ");
			
			}
			softAssert.assertAll();
		}	
		
		
		//Check when category dropdown is hidden
		@Test(priority=5)
		public void verifywhencategoryddmenuishiddenfromheader() throws InterruptedException  {
			SoftAssert softAssert = new SoftAssert();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				dp.remuimenu();
				cpp.customizertab.click();
				cpp.customizerbutton.click();
				hsp.headermenu.click();
				hsp.hideshowmenu.click();
				Thread.sleep(2000);
				boolean status=hsp.categorytext.isDisplayed();
				System.out.println(status);
				if(status==true) {
					hsp.hidecategorydd.click();
					Thread.sleep(2000);
					hsp.savebutton.click();
					Thread.sleep(2000);
					driver.get(dashboard);
					softAssert.assertTrue(hsp.categoryondp.size()==0,
							"Category menu is not visible even when shown from customizer setting ");
				}
				else {
					driver.get(dashboard);
					softAssert.assertTrue(hsp.categoryondp.size()==0,
							"Category menu is not visible even when shown from customizer setting ");
			
				}
				softAssert.assertAll();
				
			
		}
		////Check when category dropdown is shown
		@Test(priority=6)
		public void verifywhencategoryddmenuisenabled() throws InterruptedException  {
			SoftAssert softAssert = new SoftAssert();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				dp.remuimenu();
				cpp.customizertab.click();
				cpp.customizerbutton.click();
				hsp.headermenu.click();
				hsp.hideshowmenu.click();
				Thread.sleep(2000);
				boolean status=hsp.categorytext.isDisplayed();
				System.out.println(status);
				if(status==false) {
					hsp.hidecategorydd.click();
					Thread.sleep(2000);
					hsp.categorytext.clear();
					hsp.categorytext.sendKeys("Course categories");
					String actual=hsp.categorytext.getAttribute("value");
					System.out.println(actual);
					Thread.sleep(2000);
					hsp.savebutton.click();
					Thread.sleep(2000);
					driver.get(dashboard);
					softAssert.assertTrue(hsp.categoryondp.size()==1,
							"Category menu is not visible even when shown from customizer setting ");
					
					}
				else {
					driver.get(dashboard);
					softAssert.assertTrue(hsp.categoryondp.size()==1,
							"Category menu is not visible even when shown from customizer setting ");
			
				}
				softAssert.assertAll();
				
			}
		//Check when recent menu is enabled 
		@Test(priority=7)
		public void verifywhenrecentmenuisenabled() throws InterruptedException {
			SoftAssert softAssert = new SoftAssert();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			dp.remuimenu();
			cpp.customizertab.click();
			cpp.customizerbutton.click();
			hsp.headermenu.click();
			hsp.hideshowmenu.click();
			String present=hsp.recentmenu.getAttribute("Checked");
			boolean status=Boolean.parseBoolean(present);
			System.out.println(status);
			if(status==true) {
				Thread.sleep(2000);
				driver.get(dashboard);
				Thread.sleep(2000);
				softAssert.assertTrue(hsp.recentondp.size()==1,
						" Recent menu is not visible even when shown from customizer setting ");
			}
			else {
				hsp.recentmenulabel.click();
				hsp.savebutton.click();
				Thread.sleep(2000);
				driver.get(dashboard);
				Thread.sleep(2000);
				softAssert.assertTrue(hsp.recentondp.size()==1,
						"recent menu is not visible even when shown from customizer setting ");
			
			}
			softAssert.assertAll();
		}	
		
		//Check when recent menu is disabled 
		@Test(priority=8)
		public void verifywhenrecentmenuisdisabled() throws InterruptedException {
			SoftAssert softAssert = new SoftAssert();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			dp.remuimenu();
			cpp.customizertab.click();
			cpp.customizerbutton.click();
			hsp.headermenu.click();
			hsp.hideshowmenu.click();
			String present=hsp.recentmenu.getAttribute("Checked");
			boolean status=Boolean.parseBoolean(present);
			System.out.println(status);
			if(status==true) {
				hsp.recentmenulabel.click();
				hsp.savebutton.click();
				Thread.sleep(2000);
				driver.get(dashboard);
				Thread.sleep(2000);
				softAssert.assertTrue(hsp.recentondp.size()==0,
						" Recent menu is getting visible even when hidden from customizer setting ");
			}
			else {
				
				Thread.sleep(2000);
				driver.get(dashboard);
				Thread.sleep(2000);
				softAssert.assertTrue(hsp.recentondp.size()==0,
						" Recent menu is getting visible even when hidden from customizer setting ");
			
			}
			softAssert.assertAll();
		}	
		
		//Check when dashboard menu is hidden from customizer
		@Test(priority=9)
		public void verifyhidedashboardmenufromheader() throws InterruptedException  {
			SoftAssert softAssert = new SoftAssert();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			dp.remuimenu();
			cpp.customizertab.click();
			cpp.customizerbutton.click();
			hsp.headermenu.click();
			hsp.hideshowmenu.click();
			String present=hsp.dashboardmenu.getAttribute("Checked");
			boolean status=Boolean.parseBoolean(present);
			System.out.println(status);
			if(status==true) {
				Thread.sleep(2000);
				driver.get(dashboard);
				softAssert.assertTrue(hsp.dashboardondp.size()==0,
						"dashboard menu is still visible even when hidden from customizer setting ");
			}
			else {
				hsp.dashboardmenulabel.click();
				hsp.savebutton.click();
				Thread.sleep(2000);
				driver.get(dashboard);
				Thread.sleep(2000);
				softAssert.assertTrue(hsp.dashboardondp.size()==0,
						"dashboard menu is still visible even when hidden from customizer setting ");
			
			}
			softAssert.assertAll();
		}
		
		//Check when dashboard menu is enabled
		@Test(priority=10)
		public void verifywhendashboardmenuisenabled() throws InterruptedException {
			SoftAssert softAssert = new SoftAssert();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			dp.remuimenu();
			cpp.customizertab.click();
			cpp.customizerbutton.click();
			hsp.headermenu.click();
			hsp.hideshowmenu.click();
			String present=hsp.homemenu.getAttribute("Checked");
			boolean status=Boolean.parseBoolean(present);
			System.out.println(status);
			if(status==true) {
				hsp.dashboardmenulabel.click();
				hsp.savebutton.click();
				Thread.sleep(2000);
				driver.get(dashboard);
				Thread.sleep(2000);
				softAssert.assertTrue(hsp.dashboardondp.size()==1,
						"Dashboard menu is not visible even when shown from customizer setting ");
			}
			else {
				Thread.sleep(2000);
				driver.get(dashboard);
				Thread.sleep(2000);
				softAssert.assertTrue(hsp.dashboardondp.size()==1,
						"Dashboard menu is not visible even when shown from customizer setting ");
			
			}
			softAssert.assertAll();
		}	

		
}
