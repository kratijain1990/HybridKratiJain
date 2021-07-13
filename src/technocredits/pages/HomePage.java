package technocredits.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import technocredits.base.PredefinedActions;

public class HomePage extends PredefinedActions {
	
	public boolean isWelcomeMessageDispayed() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		return isElementDisplayed("xpath", "//a[@id='welcome']", true);
	}
	
	public boolean isDashboardDefaultTab() {
		//String attValue = getElementAttribute("xpath","//li[@class='page-title']", true, "class");
		String attValue = getElementText("xpath","//li[@class='page-title']", true);
		return attValue.contains("Dashboard") ? true : false;
	}
	
	public List<String> numberOfTabOnHome() {
		List<WebElement> allTabsElements = getAllElements("xpath", "//div[@class='widget-header']", true);
		List<String> namesOfTabs = new ArrayList<String>();
		for(WebElement ele : allTabsElements) {
			namesOfTabs.add(ele.getText());
		}
		return namesOfTabs;
	}

}
