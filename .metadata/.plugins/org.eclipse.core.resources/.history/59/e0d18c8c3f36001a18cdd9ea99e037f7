package com.makemytrip.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.makemytrip.qa.base.TestBase;
import com.makemytrip.qa.util.TestUtil;

public class LoginPage extends TestBase
{
	
	public static Actions act;

	@FindBy(xpath="//p[contains(text(),'Login or Create Account')]")
	WebElement loginOption;
	
	@FindBy(id="username")
	WebElement emailID;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//p[contains(text(),'Login or Create Account')]")
	WebElement loginElement;
	
	@FindBy(xpath="//img[@alt=\"Make My Trip")
	WebElement loginPageLogo;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	    act=TestUtil.callActionsClass();
	}
	
	//page actions
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateMakemyTripImage()
	{
		return loginPageLogo.isDisplayed();
	}
	
	public FlightsPage login(String un, String pwd)
	{
		loginOption.click();
		emailID.sendKeys(un);
		act.sendKeys(Keys.ENTER).perform();
		password.sendKeys(pwd);
		act.sendKeys(Keys.ENTER).perform();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", loginElement);    	
		return new FlightsPage();
}
}





