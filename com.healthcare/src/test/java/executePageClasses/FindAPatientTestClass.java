package executePageClasses;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.FindAPatientClass;
import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import pageClasses.RegisterAPatient;
import utilities.GeneralUtilities;

public class FindAPatientTestClass extends BaseClass {

	LoginPageClass lp;
	HomePageClass hp;
	RegisterAPatient rp;
	FindAPatientClass fp;

	@Test(dataProviderClass = DataProvider1.class, dataProvider = "login")
	public void verifyTheRegisteredPatientIsFoundOrNotInPatientRecordTable(String uName, String password)
			throws IOException, InterruptedException {
		lp = new LoginPageClass(driver);

		lp.loginAsRegistrationDesk(uName, password);

		hp = new HomePageClass(driver);
		hp.clickOnRegisterAPatient();

		rp = new RegisterAPatient(driver);
		String gname = rp.readStringData(5, 2);
		String fName = rp.readStringData(6, 2);
		rp.enterFullName(gname, fName);
		rp.selectGeneder(1);
		rp.selectDateOfBirth(rp.readIntegierData(8, 1), 2, rp.readIntegierData(10, 1));
		rp.selectPatientAddress(rp.readStringData(11, 1), rp.readStringData(12, 1), rp.readStringData(13, 1),
				rp.readStringData(14, 1), rp.readIntegierData(15, 1));
		rp.selectPhoneNumber(rp.readIntegierData(16, 1));
		rp.selectPatientRelated(2, rp.readStringData(18, 1));
		rp.selectPatientConfirm();
		rp.clickOnHomeButton();
		
		hp.clickOnFindAPatientButton();

		fp = new FindAPatientClass(driver);
		Boolean actualOutcome = fp.isPatientNameDisplayed(gname.concat(fName));

		System.out.println(gname);

		Assert.assertTrue(actualOutcome);
	}
}
