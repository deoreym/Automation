package com.EdwiserRemUI.TestCases;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.EdwiserRemUI.BaseTest.BaseClass;
import com.EdwiserRemUI.PageObjects.BrandColorPage;
import com.EdwiserRemUI.PageObjects.ColorConversion;
import com.EdwiserRemUI.PageObjects.CustomizerPage;
import com.EdwiserRemUI.PageObjects.DashBoardPage;
import com.EdwiserRemUI.PageObjects.FooterSocialMediaLinkPage;
import com.EdwiserRemUI.PageObjects.HeaderColorSettingPage;
import com.EdwiserRemUI.PageObjects.PrimaryButtonColorPage;
import com.EdwiserRemUI.PageObjects.SecondaryButtonColorPage;

public class FooterSocialMediaLinkTest extends BaseClass {

	public String URL = "https://www.example.com/";

	DashBoardPage dp;
	CustomizerPage cpp;
	BrandColorPage bcp;
	ColorConversion cc;
	PrimaryButtonColorPage pbcp;
	SecondaryButtonColorPage sbcp;
	HeaderColorSettingPage hcsp;
	FooterSocialMediaLinkPage fsmlp;

	@BeforeClass
	public void Before_class() {
		dp = new DashBoardPage(driver);
		cpp = new CustomizerPage(driver);
		bcp = new BrandColorPage(driver);
		cc = new ColorConversion();
		pbcp = new PrimaryButtonColorPage(driver);
		sbcp = new SecondaryButtonColorPage(driver);
		hcsp = new HeaderColorSettingPage(driver);
		fsmlp = new FooterSocialMediaLinkPage(driver);

	}

	@Test(priority = 1)
	public void Verifyenteredfooterlinkswithcustomizerandremuisetting() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();

		driver.get(customizer);
		Thread.sleep(1500);
		fsmlp.footermenu.click();
		fsmlp.socialmedialink.click();
		fsmlp.fb.clear();
		fsmlp.fb.sendKeys(URL);
		fsmlp.twitter.clear();
		fsmlp.twitter.sendKeys(URL);
		fsmlp.linkedin.clear();
		fsmlp.linkedin.sendKeys(URL);
		fsmlp.googleplus.clear();
		fsmlp.googleplus.sendKeys(URL);
		fsmlp.youtube.clear();
		fsmlp.youtube.sendKeys(URL);
		fsmlp.instagram.clear();
		fsmlp.instagram.sendKeys(URL);
		fsmlp.pintrest.clear();
		fsmlp.pintrest.sendKeys(URL);
		fsmlp.quora.clear();
		fsmlp.quora.sendKeys(URL);
		Thread.sleep(2000);
		bcp.save.click();
		Thread.sleep(2000);
		driver.get(remuifootersetting);

		String expectedfburl = fsmlp.fb_theme.getAttribute("value");
		softAssert.assertEquals(expectedfburl, URL,
				"The added URL from customizer is not matching with url in remuitheme setting");

		String expectedtwitterurl = fsmlp.twitter_theme.getAttribute("value");
		softAssert.assertEquals(expectedtwitterurl, URL,
				"The added URL from customizer is not matching with url in remuitheme setting");

		String expectedlinkedinurl = fsmlp.linkedin_theme.getAttribute("value");
		softAssert.assertEquals(expectedlinkedinurl, URL,
				"The added URL from customizer is not matching with url in remuitheme setting");

		String expectedggplusurl = fsmlp.ggplus_theme.getAttribute("value");
		softAssert.assertEquals(expectedggplusurl, URL,
				"The added URL from customizer is not matching with url in remuitheme setting");

		String expectedyturl = fsmlp.youtube_theme.getAttribute("value");
		softAssert.assertEquals(expectedyturl, URL,
				"The added URL from customizer is not matching with url in remuitheme setting");

		String expectedinstagramurl = fsmlp.instagram_theme.getAttribute("value");
		softAssert.assertEquals(expectedinstagramurl, URL,
				"The added URL from customizer is not matching with url in remuitheme setting");

		String expectedpinteresturl = fsmlp.pinterest_theme.getAttribute("value");
		softAssert.assertEquals(expectedpinteresturl, URL,
				"The added URL from customizer is not matching with url in remuitheme setting");

		String expectedquoraurl = fsmlp.quora_theme.getAttribute("value");
		softAssert.assertEquals(expectedquoraurl, URL,
				"The added URL from customizer is not matching with url in remuitheme setting");

		softAssert.assertAll();

	}

	@Test(priority = 2)
	public void Verifywidgetwhencontenttypeisselected() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		String title = "Title 1";
		String content = "Lorem ipsum dolor sit amet consectetur adipiscing elit r";
		driver.get(customizer);
		Thread.sleep(1500);
		fsmlp.footermenu.click();
		fsmlp.mainfooterareamenu.click();
		fsmlp.widget1menu.click();
		fsmlp.selectdropdownoption();
		fsmlp.footercolumtitle.clear();
		fsmlp.footercolumtitle.sendKeys(title);
		fsmlp.footercontenteditor.clear();
		fsmlp.footercontenteditor.sendKeys(content);
		Actions act = new Actions(driver);
		act.moveToElement(fsmlp.outsideelement).click().build().perform();
		bcp.save.click();
		String actualvalue = fsmlp.selectedtype.getAttribute("value");
		System.out.println(actualvalue);
		Thread.sleep(2000);
		fsmlp.footermenu.click();
		fsmlp.mainfooterareamenu.click();
		fsmlp.widget1menu.click();
		Thread.sleep(2000);
		String present = fsmlp.socialchkbx.getAttribute("checked");
		boolean status = Boolean.parseBoolean(present);
		System.out.println(status);
		if (status == true) {
			fsmlp.selectsocialoption();
			bcp.save.click();
			Thread.sleep(2000);
			fsmlp.footermenu.click();
			fsmlp.mainfooterareamenu.click();
			fsmlp.widget1menu.click();
			fsmlp.selectsocialoption();
			bcp.save.click();
			Thread.sleep(2000);
			driver.get(remuifootersetting);
			String Expectedvalue = fsmlp.selectedsocialicon.getAttribute("value");
			System.out.println(Expectedvalue);
			softAssert.assertEquals(actualvalue, Expectedvalue,
					"The selected widget type from customizer and theme setting didnt matched ");

			String expectedtitle = fsmlp.titlefromtheme.getAttribute("value");
			softAssert.assertEquals(title, expectedtitle,
					"The widget title from customizer and theme setting didnt matched");

			String expectedcontent = fsmlp.contentfromtheme.getAttribute("innerHTML");
			softAssert.assertEquals(content, expectedcontent,
					"The widget content from customizer and theme settings didnt matched ");

			String titlefromfooter = fsmlp.titlefromfooter.getAttribute("innerHTML");
			softAssert.assertEquals(title, titlefromfooter, "the title from footer and customizer didnt matched");

//			String text=fsmlp.contentfromfooter.getAttribute("innerHTML");
//			System.out.println("text "+text );

			String linkfromfooter = fsmlp.socialicon1stfromfooter.getAttribute("href");
			softAssert.assertEquals(URL, linkfromfooter,
					"the entered social icon url from customizer and footer didnt matched ");

			fsmlp.socialicon1stfromfooter.click();
			String expectedurl = driver.getCurrentUrl();
			softAssert.assertEquals(URL, expectedurl,
					"the entered social icon url from customizer and browser didnt matched ");
			driver.get(remuifootersetting);

			softAssert.assertAll();
		} else {
			fsmlp.sociallabel.click();
			bcp.save.click();
			Thread.sleep(2000);
			fsmlp.footermenu.click();
			fsmlp.mainfooterareamenu.click();
			fsmlp.widget1menu.click();
			fsmlp.selectsocialoption();
			bcp.save.click();
			Thread.sleep(2000);
			driver.get(remuifootersetting);
			String Expectedvalue = fsmlp.selectedsocialicon.getAttribute("value");
			System.out.println(Expectedvalue);
			softAssert.assertEquals(actualvalue, Expectedvalue,
					"The selected widget type from customizer and theme setting didnt matched ");

			String expectedtitle = fsmlp.titlefromtheme.getAttribute("value");
			softAssert.assertEquals(title, expectedtitle,
					"The widget title from customizer and theme setting didnt matched");

			String expectedcontent = fsmlp.contentfromtheme.getAttribute("innerHTML");
			softAssert.assertEquals(content, expectedcontent,
					"The widget content from customizer and theme settings didnt matched ");

			String titlefromfooter = fsmlp.titlefromfooter.getAttribute("innerHTML");
			softAssert.assertEquals(title, titlefromfooter, "the title from footer and customizer didnt matched");

//			String text=fsmlp.contentfromfooter.getAttribute("innerHTML");
//			System.out.println("text "+text );

			String linkfromfooter = fsmlp.socialicon1stfromfooter.getAttribute("href");
			softAssert.assertEquals(URL, linkfromfooter,
					"the entered social icon url from customizer and footer didnt matched ");

			fsmlp.socialicon1stfromfooter.click();
			String expectedurl = driver.getCurrentUrl();
			softAssert.assertEquals(URL, expectedurl,
					"the entered social icon url from customizer and browser didnt matched ");
			driver.get(remuifootersetting);

			softAssert.assertAll();
		}

	}

	@Test(priority = 3)
	public void Verifywidgetsettingswhenmenutypeisselected() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		String menutitle = "Menues";
		String menutext1 = "About Us";
		String menutext2 = "Contact Us";
		String menutext3 = "Privacy Policy1";
		String menuaddress = "https://www.google.com/";
		driver.get(customizer);
		Thread.sleep(1500);
		fsmlp.footermenu.click();
		fsmlp.mainfooterareamenu.click();
		fsmlp.widget2menu.click();
		fsmlp.selectdropdownoptionasmenu();
		fsmlp.footercolumtitle2.clear();
		fsmlp.footercolumtitle2.sendKeys(menutitle);
		fsmlp.menubutton.click();
		fsmlp.textfield.clear();
		fsmlp.textfield.sendKeys(menutext1);
		fsmlp.address.clear();
		fsmlp.address.sendKeys(menuaddress);
		fsmlp.savebutton.click();
		fsmlp.menubutton.click();
		fsmlp.textfield.clear();
		fsmlp.textfield.sendKeys(menutext2);
		fsmlp.address.clear();
		fsmlp.address.sendKeys(menuaddress);
		fsmlp.savebutton.click();
		fsmlp.menubutton.click();
		fsmlp.textfield.clear();
		fsmlp.textfield.sendKeys(menutext3);
		fsmlp.address.clear();
		fsmlp.address.sendKeys(menuaddress);
		fsmlp.savebutton.click();
		String actualmenu = fsmlp.menulinkfromcustomizer.getAttribute("innerHTML");

		bcp.save.click();
		Thread.sleep(2000);
		driver.get(dashboard);
		String expectedmenu = fsmlp.menulinkfromfooter.getAttribute("innerHTML");

		// verify added menu from customizer is getting added to footer
		softAssert.assertEquals(actualmenu, expectedmenu,
				"The added menu from customizer is not getting added to footer");

		// verify added menu title from customizer is getting added to footer
		String exppectedtitle = fsmlp.menutitlefromfooter.getAttribute("innerHTML");
		softAssert.assertEquals(menutitle, exppectedtitle,
				"THe added menu is not getting matched with title from footer");
		softAssert.assertAll();
	}
}
