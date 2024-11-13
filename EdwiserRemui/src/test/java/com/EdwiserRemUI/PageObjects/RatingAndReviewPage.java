package com.EdwiserRemUI.PageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RatingAndReviewPage extends BasePage {

	public RatingAndReviewPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//a[@role='menuitem'][normalize-space()='My courses']")
	public WebElement myCourseTab;
	
	@FindBy(xpath = "//input[@name='q']")
	public WebElement courseSearch;
		
	public WebElement testCourse(String CourseTitle) {
		return driver.findElement(By.xpath("//a[contains(@title,'" + CourseTitle + "')]"));
	}
	
	@FindBy(xpath = "//div[@class='card-text content block-content-area edw-block-body']//button")
	public WebElement writeAReviewButton;
	
	public WebElement selectStars(int Rating) {
		return driver.findElement(By.xpath("//label[@for='rate-"+ Rating +"']//i[@class='fa fa-star star-icon']"));
	}
	
	@FindBy(xpath = "//textarea[@name='review']")
	public WebElement reviewTextArea;
	
	@FindBy(xpath = "//input[@name='submitreview']")
	public WebElement sumbitButton;
	
	@FindBy(xpath = "//div[@class='alert alert-warning alert-dismissible fade show']")
	public WebElement reviewSuccessfulSendMsg;
	
	@FindBy(xpath = "//a[normalize-space()='Approval Page']")
	public WebElement approvalPageButton;
	
	public WebElement reviewOnApprovePage(int Rating, int Code) {
		return driver.findElement(By.xpath("//div[normalize-space()='"+ Rating +" Star Review Code: "+ Code +"']"));
	}
	
	//div[normalize-space()='3 Star Review Code: 126']/../..//td[7]//div//span//i[@class='fa fa-check']
	@FindBy(xpath = "//tbody//tr[1]//td[7]//span[@class='instantapprove']")
	public WebElement approveReviewInTable;
	
	@FindBy(xpath = "(//div[@class = 'ellip ellip-5'])[1]")
	public List<WebElement> firstReviewInReviewColumnList;
	
	@FindBy(xpath = "(//div[@class = 'ellip ellip-5'])[1]")
	public WebElement firstReviewInReviewColumn;
	
	public List<WebElement> reviewOnCoursePage(int Rating, int Code) {
		return driver.findElements(By.xpath("//p[normalize-space()='"+ Rating +" Star Review Code: "+ Code +"']"));
	}
	
	@FindBy(xpath = "//div[@class='inner-flex align-items-center']//select")
	public WebElement ratingsDropdown;
	
	public List<WebElement> selectedStar(int index) {
		return driver.findElements(By.xpath("(//div[@class='review-card__rating'])["+ index +"]//i[@class='fa fa-star']"));
	}
	
	@FindBy(xpath = "//div[@class='review-card__rating']")
	public List<WebElement> numberOfReviews;
	
	@FindBy(xpath = "(//i[@class = 'fa fa-thumbs-up'])[1]")
	public WebElement voteUp;
	
	@FindBy(xpath = "(//span[@class = 'liked count'])[1]")
	public WebElement voteUpCount;
	
	@FindBy(xpath = "(//i[@class='fa fa-thumbs-down '])[1]")
	public WebElement downVote;
	
	@FindBy(xpath = "(//span[@class='dliked count'])[1]")
	public WebElement downVoteCount;
	
	@FindBy(xpath = "//div[@class = 'avg-rating__wrapper d-flex flex-column justify-content-center align-items-center']//h2")
	public WebElement avgRatingCountOnCoursePage;
	
	@FindBy(xpath = "//a[@title='L2 Biology Test Course - 2']/../../../..//div[2]//div//div[2]//div//div//div//span")
	public WebElement avgCourseRatingOnArchivePage;
	
	public WebElement avgCourseRatingOnArchivePage(String CourseTitle) {
		return driver.findElement(By.xpath("//a[@title='"+ CourseTitle +"']/../../../..//div[2]//div//div[2]//div//div//div//span"));
	}
	
	@FindBy(xpath = "//input[@id='pendingforapproval']")
	public WebElement pendingForApproval;
	
	@FindBy(xpath = "//div[@class='actionbuttons']/span[1]")
	public List<WebElement> numberOfReviewsCheckMark;
		
	@FindBy(xpath = "//tbody//tr[1]//td[7]//span[@class='reviewapprovebtn']")
	public WebElement viewReviewFromTable;
	
	@FindBy(xpath = "//button[normalize-space()='Approve']")
	public WebElement approveButton;
	
	@FindBy(xpath = "//tbody//tr[1]//td[7]//span[@class='reviewremovebtn']")
	public WebElement deleteReview;
	
	@FindBy(xpath = "//button[normalize-space()='Confirm']")
	public WebElement confirmButton;
	
	@FindBy(xpath = "//span[@class = 'ratings details--info']//div[@class = 'd-flex align-items-center']//span")
	public WebElement courseRatingOnEnrolPage;
	
	@FindBy(xpath = "(//span[@class='deniedapproval'])[1]")
	public WebElement firstApprovedReviewCheckmark;
	
	@FindBy(xpath = "(//span[@class='deniedapproval'])[1]/../../..//td[5]//div[@class='ellip ellip-5']")
	public WebElement firstApprovedReviewText;
	
	@FindBy(xpath = "//p[@class = 'review-card__review mb-0']")
	public List<WebElement> reviewsOnCoursePage;
	
	@FindBy(xpath = "//div[@class='avg-rating__wrapper d-flex flex-column justify-content-center align-items-center']//p")
	public WebElement totalCourseReview;
	
	@FindBy(xpath = "//div[@class='progress ']//div[@class='progress-bar']")
	public List<WebElement> percentOnRatingBars;
	
	
}
