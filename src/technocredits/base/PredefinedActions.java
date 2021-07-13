package technocredits.base;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.reporters.Files;

import technocredits.constant.ConstantPath;

public class PredefinedActions {

	protected static WebDriver driver;
	private static WebDriverWait wait;

	public static void start() {
		start("https://kratijain-trials71.orangehrmlive.com/", "admin", "4ZOe@WwNr1");
	}

	public static void start(String url, String uname, String pwd) {
		System.setProperty(ConstantPath.CHROMEDRIVER, ConstantPath.CHROMEDRIVEREXE);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, ConstantPath.AVGWAIT);
	}

	public WebElement getElement(String locatorType, String locator, boolean isWaitRequired) {
		WebElement element;
		WebDriverWait wait = new WebDriverWait(driver, ConstantPath.AVGWAIT);
		switch (locatorType.toUpperCase()) {
		case "XPATH":
			if (isWaitRequired) {
				System.out.println("Entered getElement WAIT in Prefefined actions");
				// element =
				// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='page-title']")));
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
			} else
				element = driver.findElement(By.xpath(locator));
			break;
		case "ID":
			if (isWaitRequired) {
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
			} else
				element = driver.findElement(By.id(locator));
			break;
		default:
			element = null;
			// throw new InvalidLocatorException;
			System.out.println("Invalid Locator Strategy");
		}
		return element;
	}

	public List<WebElement> getAllElements(String locatorType, String locator, boolean isWaitRequired) {
		List<WebElement> allElements;
		WebDriverWait wait = new WebDriverWait(driver, ConstantPath.AVGWAIT);
		switch (locatorType.toUpperCase()) {
		case "XPATH":
			if (isWaitRequired) {
				System.out.println("Entered getElement WAIT in Prefefined actions");
				// element =
				// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='page-title']")));
				allElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locator)));
			} else
				allElements = driver.findElements(By.xpath(locator));
			break;
		case "ID":
			if (isWaitRequired) {
				allElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(locator)));
			} else
				allElements = driver.findElements(By.id(locator));
			break;
		default:
			allElements = null;
			// throw new InvalidLocatorException;
			System.out.println("Invalid Locator Strategy");
		}
		return allElements;
	}

	protected boolean isElementDisplayed(WebElement element) {
		if (element.isDisplayed())
			return true;
		else {
			scrollToElement(element);
			return element.isDisplayed();
		}
	}

	protected boolean isElementDisplayed(String locatorType, String locator, boolean isWaitRequired) {
		try {
			WebElement element = getElement(locatorType, locator, isWaitRequired);
			return isElementDisplayed(element);
		} catch (Exception e) {
			return false;
		}
	}

	protected String getElementText(WebElement element) {
		scrollToElement(element);
		return element.getText();

	}

	protected String getElementText(String locatorType, String locator, boolean isWaitRequired) {
		return getElement(locatorType, locator, isWaitRequired).getText();
	}

	protected void enterText(String locatorType, String locator, boolean isWaitRequired, String textToBeEntered) {
		WebElement element = getElement(locatorType, locator, isWaitRequired);
		if (element.isEnabled())
			element.sendKeys(textToBeEntered);
		// else
		// throw new ElementIsNotEnabled("Element was not located for LocatorType : " +
		// locatorType + "locator value : " +locator);
	}

	protected void clickOnElement(String locatorType, String locator, boolean isWaitRequired) {
		WebElement element = getElement(locatorType, locator, isWaitRequired);
		element = wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	protected String getElementAttribute(String locatorType, String locator, boolean isWaitRequired, String attribute) {
		WebElement element = getElement(locatorType, locator, isWaitRequired);
		// element.getAttribute(attribute);
		return element.getAttribute(attribute);

	}

	protected void scrollToElement(WebElement element) {
		if (!element.isDisplayed()) {
			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("arguments[0].scrollIntoView(true)", element);
		}
	}

	public static void screenShots(String methodName) {
		TakesScreenshot screenShot = (TakesScreenshot) driver;
		File file = screenShot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file,
					new File("C:\\Users\\krjain\\Documents\\Selenium TechnoCred\\SeleniumProjects\\HybridFramework\\failedScreenShots\\" + methodName + ".jpeg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void closeBrowser() {
		driver.close();
	}

}
