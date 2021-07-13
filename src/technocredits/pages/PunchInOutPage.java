package technocredits.pages;

import org.openqa.selenium.By;
import technocredits.base.PredefinedActions;

public class PunchInOutPage extends PredefinedActions {

	public void clickOnAttendance() {
		driver.findElement(By.xpath("//span[@class='left-menu-title'][text()='Attendance']//following-sibling::span"))
				.click();
	}

	public void clickOnPunchIn() {
		driver.findElement(By.xpath("//span[@class='left-menu-title'][text()='Punch In/Out']")).click();
	}
	public void clickCalendarIcon() {
	clickOnElement("xpath", "//span[@class='left-menu-title'][text()='Punch In/Out']", true);
		
		//driver.findElement(By.xpath("//i[@class='material-icons action-icon date-picker-open-icon'][text()='date_range']")).click();
	}

}
