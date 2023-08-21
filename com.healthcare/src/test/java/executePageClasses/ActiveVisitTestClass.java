package executePageClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.ActiveVisit;
import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import pageClasses.RegisterAPatient;

public class ActiveVisitTestClass extends BaseClass {

	LoginPageClass lp;
	HomePageClass hp;
	RegisterAPatient rp;
	ActiveVisit ap;

	@Test(dataProviderClass = DataProvider1.class, dataProvider = "login", priority = 0)
	public void verifyThePatientIsNotDisplayedInActiveVisitsWhenVisitNotStarted(String uName, String password)
			throws IOException, InterruptedException {
		lp = new LoginPageClass(driver);

		lp.loginAsRegistrationDesk(uName, password);

		hp = new HomePageClass(driver);
		hp.clickOnRegisterAPatient();

		rp = new RegisterAPatient(driver);
		rp.enterFullName(rp.readStringData(5, 3), rp.readStringData(6, 3));
		rp.selectGeneder(1);
		rp.selectDateOfBirth(rp.readIntegierData(8, 1), 2, rp.readIntegierData(10, 1));
		rp.selectPatientAddress(rp.readStringData(11, 1), rp.readStringData(12, 1), rp.readStringData(13, 1),
				rp.readStringData(14, 1), rp.readIntegierData(15, 1));
		rp.selectPhoneNumber(rp.readIntegierData(16, 1));
		rp.selectPatientRelated(2, rp.readStringData(18, 1));
		rp.selectPatientConfirm();
		rp.clickOnHomeButton();

		hp.clickOnActiveListButton();

		ap = new ActiveVisit(driver);
		Boolean actualOutcome = ap.isPatientNameDisplayed(rp.readStringData(5, 3).concat(" ").concat(rp.readStringData(6, 3)));
		Assert.assertFalse(actualOutcome);
	}

	@Test(dataProviderClass = DataProvider1.class, dataProvider = "login", priority = 1)
	public void verifyThePatientIsInActiveVisitsWhenVisitStarts(String uName, String password)
			throws IOException, InterruptedException {
		lp = new LoginPageClass(driver);

		lp.loginAsRegistrationDesk(uName, password);

		hp = new HomePageClass(driver);
		hp.clickOnRegisterAPatient();

		rp = new RegisterAPatient(driver);
		String gname = rp.readStringData(5, 2);
		String fname = rp.readStringData(6, 2);
		rp.enterFullName(gname, fname);
		rp.selectGeneder(1);
		rp.selectDateOfBirth(rp.readIntegierData(8, 1), 2, rp.readIntegierData(10, 1));
		rp.selectPatientAddress(rp.readStringData(11, 1), rp.readStringData(12, 1), rp.readStringData(13, 1),
				rp.readStringData(14, 1), rp.readIntegierData(15, 1));
		rp.selectPhoneNumber(rp.readIntegierData(16, 1));
		rp.selectPatientRelated(2, rp.readStringData(18, 1));
		rp.selectPatientConfirm();
		rp.clickOnStartVisitButton();
		rp.clickOnConfirmStartVisitButton();
		rp.clickOnHomeButton();
		//rp.clickOnHomeButton();
		hp.clickOnActiveListButton();
		ap = new ActiveVisit(driver);
		Boolean actualOutcome = ap.isPatientNameDisplayed(gname.concat(" ").concat(fname));
		Assert.assertTrue(actualOutcome);

	}
}
