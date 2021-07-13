package technocredits.tests;

import org.testng.annotations.Test;

import technocredits.base.PredefinedActions;
import technocredits.pages.HomePage;
import technocredits.pages.LoginPage;
import technocredits.pages.PunchInOutPage;

public class PunchInOutTest {
	
	@Test
	public void calendarMethod() throws InterruptedException {
		
		PredefinedActions.start();
		LoginPage loginPage = new LoginPage();
		HomePage homePage = loginPage.doLogin("Admin", "4ZOe@WwNr1");
		PunchInOutPage punch = new PunchInOutPage();
		punch.clickOnAttendance();
		punch.clickOnPunchIn();
		Thread.sleep(3000);
		punch.clickCalendarIcon();
	}

}
