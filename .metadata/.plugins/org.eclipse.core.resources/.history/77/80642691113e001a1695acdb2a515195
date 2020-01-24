package com.makemytrip.qa.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.makemytrip.qa.base.TestBase;

public class HotelsPage extends TestBase {

	
	@FindBy(xpath="//span[@data-cy='hotelCityLabel']")
	WebElement cityList;
	
	@FindBy(xpath="//div[@class='react-autosuggest__section-title']//following::li[@role='option']")
	List<WebElement> hotelSuggestions;
	
	@FindBy(xpath="//button[@id='hsw_search_button']")
	WebElement searchBtn;
	
	public HotelsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void searchHotel(String fromCity,String checkin,String checkout)
	{
		String checkinmonth=checkin.substring(3);
		String checkoutmonth=checkout.substring(3);
		String checkindate=checkin.substring(0,2);
		String checkoutdate=checkout.substring(0,2);
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
		
		searchBtn.click();
		
	}
	
}
