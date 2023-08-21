package executePageClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.FindAPatientClass;
import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import pageClasses.RegisterAPatient;

public class RegisterAPatientTestClass extends BaseClass {
	
	LoginPageClass lp;
	HomePageClass hp;
	RegisterAPatient rp;
	FindAPatientClass fp;
	
  @Test(dataProviderClass = DataProvider1.class, dataProvider = "login")
  public void verifyToRegisteraAPatient(String uName, String password) throws IOException, InterruptedException {
	  lp=new LoginPageClass(driver);
	  
	  lp.loginAsRegistrationDesk(uName, password);
	  
	  hp=new HomePageClass(driver);
	  hp.clickOnRegisterAPatient();
	  
	  rp=new RegisterAPatient(driver);
	  rp.enterFullName(rp.readStringData(5, 2),rp.readStringData(6, 2) );
	  rp.selectGeneder(1);
	  rp.selectDateOfBirth(rp.readIntegierData(8, 1), 2, rp.readIntegierData(10, 1));
	  rp.selectPatientAddress(rp.readStringData(11, 1), rp.readStringData(12, 1), rp.readStringData(13, 1), rp.readStringData(14, 1), rp.readIntegierData(15, 1));
	  rp.selectPhoneNumber(rp.readIntegierData(16, 1));
	  rp.selectPatientRelated(2, rp.readStringData(18, 1));
	  rp.selectPatientConfirm();
	  
	  String ActualOutcome=rp.getTextOfRegisteredPatientGivenName().concat(" ").concat(rp.getTextOfRegisteredPatientFamilyName());
	  String ExpecetdOutcome= rp.readStringData(5, 2).concat(" ").concat(rp.readStringData(6, 2));
	  
	  Assert.assertEquals(ActualOutcome, ExpecetdOutcome);
	  System.out.println(ActualOutcome);
  }
  
  @Test(dataProviderClass = DataProvider1.class, dataProvider = "login")
 
	  public void verifyToDeleteARegisteredaAPatient(String uName, String password) throws IOException, InterruptedException {
		  lp=new LoginPageClass(driver);
		  
		  lp.loginAsRegistrationDesk(uName, password);
		  
		  hp=new HomePageClass(driver);
		  hp.clickOnRegisterAPatient();
		  
		  rp=new RegisterAPatient(driver);
		  String gname= rp.readStringData(5, 1);
		  String fName= rp.readStringData(6, 1);
		  rp.enterFullName(gname, fName);
		  rp.selectGeneder(1);
		  rp.selectDateOfBirth(rp.readIntegierData(8, 1), 2, rp.readIntegierData(10, 1));
		  rp.selectPatientAddress(rp.readStringData(11, 1), rp.readStringData(12, 1), rp.readStringData(13, 1), rp.readStringData(14, 1), rp.readIntegierData(15, 1));
		  rp.selectPhoneNumber(rp.readIntegierData(16, 1));
		  rp.selectPatientRelated(2, rp.readStringData(18, 1));
		  rp.selectPatientConfirm(); 
		  rp.deletePatient(rp.readStringData(20, 1));
		  
		  fp=new FindAPatientClass(driver);
		  Boolean actualOutcome= fp.isPatientNameDisplayed(gname.concat(fName));
		  
		  System.out.println(gname.concat(fName));
		  
		  Assert.assertFalse(actualOutcome);
		  
		  
		  
  }
  
  
}
