package executePageClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;


public class LoginPageTestClass extends BaseClass {
  
	LoginPageClass lp;
	HomePageClass hp;
	
	
	@Test(dataProviderClass = DataProvider1.class,dataProvider = "login")
  public void verifySuceesfullLogin(String uname1, String Password2) {
		
		lp=new LoginPageClass(driver);
		lp.loginAsRegistrationDesk(uname1, Password2);
		
		hp=new HomePageClass(driver);
		String actualResult=hp.getTextOfWelcomeMessage();
		String expectedResult="Logged in as Super User (admin) at Registration Desk.";
		
		Assert.assertEquals(actualResult, expectedResult, "Actual and Expectde outcome are not same");
		
  }
	
	
	@Test(dataProviderClass = DataProvider1.class,dataProvider = "dp")
public void verifyUnsuceesfullLoginDataProvider(String uname, String password1) {
		
		lp=new LoginPageClass(driver);
		lp.loginAsRegistrationDesk(uname, password1);
		
		String actualResult=lp.getTextOfErrorMessage();
		String expectedResult="Invalid username/password. Please try again.";
		
		Assert.assertEquals(actualResult, expectedResult, "Actual and Expectde outcome are not same");
	}
	
	@Test(dataProviderClass = DataProvider1.class,dataProvider = "login")
	public void verifyTheCorrectSiteIsLoadedWhileHittingTheURL(String uname, String password1) throws IOException
	{
		lp=new LoginPageClass(driver);
		
		lp.loginAsRegistrationDesk(lp.readStringData(2, 1), lp.readStringData(3, 1));
		hp=new HomePageClass(driver);
		
		String actualOutcome=lp.readStringData(22, 1);
		String expectedOutcome=hp.getCurrentURL();
		System.out.println(expectedOutcome);
		
		Assert.assertEquals(actualOutcome, expectedOutcome);
	
}

}