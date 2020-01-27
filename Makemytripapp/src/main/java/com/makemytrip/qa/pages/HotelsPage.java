package com.makemytrip.qa.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.makemytrip.qa.base.TestBase;
import com.makemytrip.qa.util.TestUtil;

public class HotelsPage extends TestBase {

	
	@FindBy(xpath="//span[@data-cy='hotelCityLabel']")
	WebElement cityList;
	
	@FindBy(xpath="//div[@class='react-autosuggest__section-title']//following::li[@role='option']")
	List<WebElement> hotelSuggestions;
	
	@FindBy(xpath="//button[@id='hsw_search_button']")
	WebElement searchBtn;
	
	@FindBy(xpath="//div[@class='DayPicker-Caption']")
	WebElement dayPicker;
	
	@FindBy(xpath="//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")
	WebElement navigateBtn;
	
	@FindBy(xpath="//input[@id='checkin']")
	WebElement checkInBtn;
	
	@FindBy(xpath="//span[@data-cy='selectCheckOutDate']")
	WebElement checkOutBtn;
	
	@FindBy(xpath="//a[@class='primaryBtn']")
	WebElement searchHotels;
	
	@FindBy(xpath="//div[@id='hotelListingContainer']")
	List<WebElement> selectHotel;
	
	@FindBy(xpath="//body[@class='bodyFixed overlayWholeBlack']")
	WebElement selectHotelPage;
	
	@FindBy(xpath="//a[text()='BOOK THIS NOW']")
	WebElement bookTicket;
	
	@FindBy(xpath="//a[@class='primaryBtn btnPayNow']")
	WebElement payNow;
	
	@FindBy(id="fName")
	WebElement firstName;
	
	@FindBy(id="lName")
	WebElement lastName;
	
	@FindBy(xpath="//p[text()='Traveller Information']")
	WebElement userDetails;
	
	
	
	public HotelsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void searchHotel(String fromCity,String checkin,String checkout,String fstName,String lstName) throws InterruptedException
	{
		
		String xpath1 = "(//*[@class='DayPicker-Month'])[1]/div[3]/div[";
		String xpath2 = "]/div[";
		String xpath3 = "]";
		cityList.click();
		for (WebElement suggest_1 : hotelSuggestions) {
			String str = suggest_1.getText();

			if (str.contains(fromCity))

			{
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();", suggest_1);
				break;
			}
		}
		checkInBtn.click();
		Thread.sleep(5000);
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 7; j++) {
				String actual_xpath = xpath1 + i + xpath2 + j + xpath3;

				String str = driver.findElement(By.xpath(actual_xpath)).getText();
				if (str.contains(checkin))
				{
                 driver.findElement(By.xpath(actual_xpath)).click();       
                 continue;
				}	
				if (str.contains(checkout))
				{
                driver.findElement(By.xpath(actual_xpath)).click();
                break;
                 
				}
	}
		}
		
		searchBtn.click();
		Thread.sleep(5000);
		searchHotels.click();
		Thread.sleep(10000);
		selectHotelPage.click();
		Thread.sleep(5000);
		selectHotel.get(0).click();
		Thread.sleep(5000);
		Set<String> s1 = driver.getWindowHandles();
		ArrayList<String> obj = new ArrayList<String>(s1);
		driver.switchTo().window(obj.get(1));
		Thread.sleep(5000);
		bookTicket.click();
		Thread.sleep(10000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", userDetails);
		firstName.sendKeys(fstName);
		lastName.sendKeys(lstName);
		Thread.sleep(5000);
		js.executeScript("window.scrollTo(0, 0)");
		Thread.sleep(5000);
		payNow.click();
		Thread.sleep(5000);
		TestUtil.takeScreenshotAtEndOfTest(imgBookingSummary);
}
	

}