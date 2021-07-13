package technocredits.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import technocredits.base.PredefinedActions;
import technocredits.constant.ConstantPath;
import technocredits.pages.HomePage;
import technocredits.pages.LoginPage;

public class LoginTest {

	@Test
	public void launchBrowser() {
		PredefinedActions.start();
	
		LoginPage loginPage = new LoginPage();
		System.out.println("Is Logo Displayed : " + loginPage.isLogoDisplayed());
		Assert.assertTrue(loginPage.isLogoDisplayed(), "Logo is not displayed");
		
		HomePage homePage = loginPage.doLogin("Admin", "4ZOe@WwNr1");

		boolean dashboardValidate = homePage.isDashboardDefaultTab();
		Assert.assertTrue(dashboardValidate, "Default tab is not Dashboard");
		
		List<String> actualWidgetList = homePage.numberOfTabOnHome();
		
		System.out.println("Number of Tabs on the Home Page :"+ actualWidgetList.size());
		Assert.assertEquals(actualWidgetList.size(), 11, "11 tabs are not present on the Home page");

		List<String> expectedWidgetList = new ArrayList<String>();
		expectedWidgetList.add("Quick Access");
		expectedWidgetList.add("Buzz Latest Posts");
		expectedWidgetList.add("Employee Job Details");
		expectedWidgetList.add("My Actions");
		expectedWidgetList.add("Headcount by Location");
		expectedWidgetList.add("Time At Work");
		expectedWidgetList.add("Employees on Leave Today");
		expectedWidgetList.add("Performance Quick Feedback");
		expectedWidgetList.add("Annual basic payment by Location, people");
		expectedWidgetList.add("Latest Documents");
		expectedWidgetList.add("Latest News");
		
		
		Collections.sort(actualWidgetList);
		Collections.sort(expectedWidgetList);
		System.out.println("Actual: " + actualWidgetList);
		System.out.println("Expected: " + expectedWidgetList);
		
		
		  for(String expectedTab : expectedWidgetList) {
		  Assert.assertTrue(actualWidgetList.contains(expectedTab), "This element is not present" + expectedTab);
		  }
		 
		//Assert.assertEquals(actualWidgetList, expectedWidgetList, "Actual :" + actualWidgetList + " Expected : " + expectedWidgetList);
				
		PredefinedActions.closeBrowser();
	}

	@AfterMethod
	public void screenShotsMethod(ITestResult result) {
	if(!result.isSuccess()) {
		String currentMethod = result.getMethod().getMethodName();
		PredefinedActions.screenShots(currentMethod);
	}
	}
}
