package executePageClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;

public class HomePageTestClass extends BaseClass {
	
	LoginPageClass lp;
	HomePageClass hp;
	
	
  @Test(dataProviderClass = DataProvider1.class, dataProvider = "login")
  public void verifyAllTilesAreDisplayedInHomePage(String uName, String Password) {
	  lp=new LoginPageClass(driver);
	  lp.loginAsRegistrationDesk(uName,Password);
	  
	  hp=new HomePageClass(driver);
	  Boolean actualOutcome=hp.isAllTilesDisplayed();
	  
	  Assert.assertTrue(actualOutcome);
  }
  
  @Test(dataProviderClass = DataProvider1.class, dataProvider = "login")
  public void verifyTheLogoIsDisplayedOrNotInHomePage(String uName, String Password) throws IOException {
	  lp=new LoginPageClass(driver);
	  lp.loginAsRegistrationDesk(lp.readStringData(2, 1),lp.readStringData(3, 1));
	  
	  hp=new HomePageClass(driver);
	  Boolean actualOutcome=hp.isLogoDisplayed();
	  
	  Assert.assertTrue(actualOutcome);
  }
  
}
