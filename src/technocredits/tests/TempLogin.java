package technocredits.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import technocredits.base.PredefinedActions;
import technocredits.constant.ConstantPath;
import technocredits.pages.HomePage;
import technocredits.pages.LoginPage;


public class TempLogin {


		@Test
		public void launchBrowser() {
			System.setProperty(ConstantPath.CHROMEDRIVER, ConstantPath.CHROMEDRIVEREXE);
			WebDriver driver = new ChromeDriver();
			driver.get("https://kratijain-trials71.orangehrmlive.com/");
			driver.manage().window().maximize();
			
			driver.findElement(By.id("txtUsername")).sendKeys("admin");
			driver.findElement(By.id("txtPassword")).sendKeys("4ZOe@WwNr1");

			
			driver.findElement(By.xpath("//input[@name='Submit']")).click();

		
		
			String ele = driver.findElement(By.xpath("//li[@class='page-title']")).getText();
			
			System.out.println(ele);
			
			//Assert.assertTrue(homePage.isDashboardDefaultTab(), "Default tab is not Dashboard");
			
			/*
			 * System.out.println("Number of Tabs on the Home Page :"+
			 * homePage.numberOfTabOnHome().size());
			 * Assert.assertEquals(homePage.numberOfTabOnHome().size(), 11,
			 * "11 tabs are not present on the Home page");
			 * System.out.println(homePage.numberOfTabOnHome());
			 * 
			 * PredefinedActions.closeBrowser();
			 */
		}
	}
