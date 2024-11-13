package com.EdwiserRemUI.TestCases;

import java.util.Random;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.EdwiserRemUI.BaseTest.BaseClass;
import com.EdwiserRemUI.PageObjects.RatingAndReviewPage;

public class RatingAndReviewTest extends BaseClass {

	RatingAndReviewPage rrp;
	SoftAssert softassert;
	Random random;
	int Rating = 3;
	String CourseTitle = "L2 Biology Test Course - 2";
	String User;
	String Pass;

	@Parameters({ "StudentUser2", "StudentPassword2" })
	@BeforeClass
	public void Before_class(String StudentUser2, String StudentPassword2) {

		rrp = new RatingAndReviewPage(driver);
		random = new Random();
		softassert = new SoftAssert();
		User = StudentUser2;
		Pass = StudentPassword2;
	}

	/** Course Page **/

	@Test(priority = 1)
	public void addingRatingAndReview() throws InterruptedException {

		driver.get(coursepage2);
		Thread.sleep(10000);
		WebElement button =rrp.writeAReviewButton ;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
		button.click();

		//rrp.writeAReviewButton.click();
		rrp.selectStars(Rating).click();
		int randomNumber = random.nextInt(900) + 100;
		rrp.reviewTextArea.clear();
		rrp.reviewTextArea.sendKeys(Rating + " Star Review Code: " + randomNumber);
		Thread.sleep(3000);
		rrp.sumbitButton.click();

		softassert.assertTrue(
				rrp.reviewSuccessfulSendMsg.getText()
						.contains("Thank you for submitting the review, your review will be published soon."),
				"After clicking on sumbit review button, the review is not getting sumbitted or review successful send message is not getting displayed");

		driver.get(siteurl + "blocks/edwiserratingreview/admin.php");
		Thread.sleep(1000);
		rrp.approveReviewInTable.click();
		Thread.sleep(1000);
		driver.get(coursepage2);
		Thread.sleep(1000);

		softassert.assertTrue(rrp.reviewOnCoursePage(Rating, randomNumber).size() == 1,
				"The approved review using check mark on the Approve Review Page table, is not getting displayed on the course Page");

		softassert.assertAll();
	}

	@Test(priority = 2)
	public void filterByStarRating() throws InterruptedException {

		driver.get(coursepage2);
		Select dropdown = new Select(rrp.ratingsDropdown);
		dropdown.selectByValue("4");
		Thread.sleep(2000);

//		for (WebElement Review : rrp.numberOfReviews) {
		for (int i = 1; i <= rrp.numberOfReviews.size(); i++) {
			softassert.assertEquals(rrp.selectedStar(i).size(), 4,
					"Filter by Star on Course Page is not working as expected");
		}

		softassert.assertAll();
	}

	@Test(priority = 3)
	public void upvoteReview() throws InterruptedException {

		driver.get(coursepage2);
		Thread.sleep(1500);
		rrp.voteUp.click();
		Thread.sleep(1000);

		softassert.assertEquals(rrp.voteUpCount.getText(), "1",
				"After clicking on thumbs-up icon for the review the count of upvote is not getting increased");

		softassert.assertAll();

	}

	@Test(priority = 4)
	public void downvoteReview() throws InterruptedException {

		driver.get(coursepage2);
		Thread.sleep(1500);
		rrp.downVote.click();
		Thread.sleep(1000);

		softassert.assertEquals(rrp.downVoteCount.getText(), "1",
				"After clicking on thumbs-down icon for the review the count of down-vote is not getting increased");

		softassert.assertAll();

	}

	@Test(priority = 5)
	public void RatingOnCourseArchivePage() throws InterruptedException {

		driver.get(coursepage2);
		Thread.sleep(1000);
		String RatingOnCoursePage = rrp.avgRatingCountOnCoursePage.getText();
		System.out.println(RatingOnCoursePage);

		driver.get(siteurl + "course/index.php?categoryid=all");
		Thread.sleep(1000);
		rrp.courseSearch.sendKeys(CourseTitle);
		rrp.courseSearch.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		String RatingOnArchivePage = rrp.avgCourseRatingOnArchivePage(CourseTitle).getText();
		
		// Convert to doubles for comparison
	    double expectedRating = Double.parseDouble(RatingOnCoursePage);
	    System.out.println(expectedRating);
	    double actualRating = Double.parseDouble(RatingOnArchivePage);
	    System.out.println(actualRating);
	    
		//softassert.assertEquals(RatingOnCoursePage, RatingOnArchivePage,
				//"Rating of Course on Course Page and Archive page does not match");

	    softassert.assertEquals(actualRating, expectedRating, 
	            "Rating of Course on Course Page: " + RatingOnCoursePage + " and Archive page: " + RatingOnArchivePage + " do not match.");

	    
		softassert.assertAll();

	}

	@Test(priority = 6)
	public void RatingOnCourseEnrolmentPage() throws InterruptedException {

		driver.get(coursepage2);
		Thread.sleep(1000);

		String avgRating = rrp.avgRatingCountOnCoursePage.getText();

		//adminbackendlogout();
		//studentLogin(User, Pass);
		driver.get(siteurl + "enrol/index.php?id=48");

		String avgRatingOnEnrolPage = rrp.courseRatingOnEnrolPage.getText();

		// Convert to doubles for comparison
	    double expectedRating = Double.parseDouble(avgRating);
	    System.out.println(expectedRating);
	    double actualRating = Double.parseDouble(avgRatingOnEnrolPage);
	    System.out.println(actualRating);
	    Thread.sleep(1000);
		//adminbackendlogout();
		Assert.assertEquals(expectedRating, actualRating,
				"Course Rating is not same on the Course Page and Course Enrol Page");
		
	}

	/** Approval Page **/

	@Test(priority = 7)
	public void viewPendingForApproval() throws InterruptedException {

	//	adminbackendLogin("admin", "Golden0-");

		driver.get(siteurl + "blocks/edwiserratingreview/admin.php");
		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", rrp.pendingForApproval);

		Thread.sleep(2000);
		for (WebElement Review : rrp.numberOfReviewsCheckMark) {
			softassert.assertTrue(Review.getAttribute("class").contains("instantapprove"),
					"After selecting pending for review not filtered");
		}

		softassert.assertAll();
	}

//	@Test(priority = 8)
	public void filterByDateRange() {

	}

	@Test(priority = 9)
	public void unapproveReview() throws InterruptedException {

		driver.get(siteurl + "blocks/edwiserratingreview/admin.php");
		String review = rrp.firstApprovedReviewText.getText();
		rrp.firstApprovedReviewCheckmark.click();
		Thread.sleep(1000);
		driver.get(coursepage2);
		Thread.sleep(2000);

		for (WebElement Review : rrp.reviewsOnCoursePage) {
			softassert.assertFalse(Review.getText().contains(review),
					"After unapproving the approved review, the review is still getting displayed on Course Page");
		}

		softassert.assertAll();

	}

	@Test(priority = 10)
	public void approveFromReviewPopup() throws InterruptedException {

		driver.get(coursepage2);
		rrp.writeAReviewButton.click();
		Thread.sleep(2000);
		rrp.selectStars(Rating).click();
		int randomNumber = random.nextInt(900) + 100;
		rrp.reviewTextArea.clear();
		rrp.reviewTextArea.sendKeys(Rating + " Star Review Code: " + randomNumber);
		rrp.sumbitButton.click();
		driver.get(siteurl + "blocks/edwiserratingreview/admin.php");
		Thread.sleep(1000);
		rrp.viewReviewFromTable.click();
		rrp.approveButton.click();
		driver.get(coursepage2);
		Thread.sleep(1000);

		softassert.assertTrue(rrp.reviewOnCoursePage(Rating, randomNumber).size() == 1,
				"The approved review using Review Popup from the Approve Review Page, is not getting displayed on the course Page or is not getting displayed on Course Page correctly");

		softassert.assertAll();

	}

	@Test(priority = 11)
	public void deleteReview() throws InterruptedException {

		driver.get(siteurl + "blocks/edwiserratingreview/admin.php");
		String review = rrp.firstReviewInReviewColumn.getText();
		rrp.deleteReview.click();
		Thread.sleep(500);
		rrp.confirmButton.click();
		driver.get(siteurl + "blocks/edwiserratingreview/admin.php");
		Thread.sleep(2000);

		softassert.assertFalse(rrp.firstReviewInReviewColumn.getText().contains(review),
				"After Deleting the approved review, review is still getting displayed on approval page");

		softassert.assertAll();
	}

	@Test(priority = 12)
	public void avgCourseRating() {

		driver.get(coursepage2);
		int index = 5;
		double value = 0;
		double CalculatedavgRating = 0;
		String avgRating = rrp.avgRatingCountOnCoursePage.getText();
		double avgRatingdigit = Double.parseDouble(avgRating);

		String totalCourseReviews = rrp.totalCourseReview.getText().replaceAll("[^\\d]", "");
		int totalCourseReviewsdigit = Integer.parseInt(totalCourseReviews);

		for (WebElement Review : rrp.percentOnRatingBars) {

			if (Review.getText().isEmpty()) {
				value = 0;

			} else {
				String percent = Review.getText().replaceAll("[^\\d]", "");
				value = Double.parseDouble(percent);

			}
			value = (value / 100) * totalCourseReviewsdigit;
			value = Math.round(value * 10.0) / 10.0;
			CalculatedavgRating = CalculatedavgRating + (index * value);
			index--;

		}
		double finalRating = CalculatedavgRating / totalCourseReviewsdigit;

		finalRating = Math.round(finalRating * 10.0) / 10.0;

		Assert.assertEquals(finalRating, avgRatingdigit,
				"Rating getting displayed on the Course Page is not correct(After calculating the rating, the displayed number does not match)");

	}

}
