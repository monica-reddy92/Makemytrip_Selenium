package com.makemytrip.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.makemytrip.qa.base.TestBase;

public class FlightsPage extends TestBase {

	@FindBy(xpath="//p[@data-cy='loggedInUser']")
	public WebElement welcomeText;
	
	@FindBy(xpath="//p[@data-cy='returnDefaultText']")
	WebElement returnDate;
	
	@FindBy(xpath="//li[@data-cy='oneWayTrip']")
	public WebElement oneWayradioBtn;
	
	@FindBy(xpath="//label[@for='fromCity']")
	public WebElement fromBtn;
	
	@FindBy(xpath="//label[@for='toCity']")
	public WebElement ToBtn;
	
	@FindBy(xpath="//input[@type='text' and @placeholder='From'")
	public WebElement fromText;
	
	@FindBy(xpath="//input[@type='text' and @placeholder='To'")
	public WebElement toText;
	
	@FindBy(xpath="//span[@class='chNavIcon appendBottom2 chSprite chHotels ']")
	WebElement hotelsPage;
	
	public FlightsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//page actions
		public String validateFlightsPageTitle()
		{
			return driver.getTitle();
		}
	
		public String validateFlightsPageUserName()
		{
			return welcomeText.getText();
		}
	
		public String getReturnDateValue()
		{
			return returnDate.getText();
		}
		
		public HotelsPage clickHotelsPage()
		{
			//hotelsPage.click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", hotelsPage);
			return new HotelsPage();
		}
}
