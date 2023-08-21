package pageClasses;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ExcelReadClass;
import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class RegisterAPatient {
	
	WebDriver driver;
	GeneralUtilities generalUtilities=new GeneralUtilities();
	ExplicitWaitClass explicitWait=new ExplicitWaitClass();
	
	public RegisterAPatient(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "givenName")
	WebElement givenName;
	
	@FindBy(name = "familyName")
	WebElement familyName;
	
	@FindBy(id = "next-button")
	WebElement nextButton;
	
	@FindBy(id = "gender-field")
	WebElement genderSelect;
	
	@FindBy(xpath = "//input[@id='birthdateDay-field']")
	WebElement patientDayOfBirth;
	
	@FindBy(xpath = "//select[@id='birthdateMonth-field']")
	WebElement patientMonthOfBirthSelect;
	
	@FindBy(xpath = "//input[contains(@class,'year number numeric-range')]")
	WebElement patientYearOfBirth;
	
	@FindBy(id = "address1")
	WebElement patientaddress1;
	
	@FindBy(id = "cityVillage")
	WebElement patientCity;
	
	@FindBy(id = "stateProvince")
	WebElement patientState;
	
	@FindBy(id = "country")
	WebElement patientCountry; 
	
	@FindBy(id = "postalCode")
	WebElement patientPostalCode;
	
	@FindBy(xpath = "//input[@name='phoneNumber']")
	WebElement patientPhoneNumber;
	
	@FindBy(xpath = "//select[@id='relationship_type']")
	WebElement patientRelationType;
	
	@FindBy(xpath = "//input[contains(@class,'person-typeahead ng')]")
	WebElement patientPersonName;
	
	@FindBy(id = "submit")
	WebElement submitButton;
	
	@FindBy(xpath = "//*[contains(@class,'PersonName-g')]")
	WebElement registeredGiveName;
	
	@FindBy(xpath = "//*[contains(@class,'PersonName-f')]")
	WebElement registeredFamilyName;
	
	@FindBy(xpath = "//a[contains(@href,'javascript:delPatient.show')]")
	WebElement deleteRegisteredPatient;
	
	@FindBy(xpath = "//input[@id='delete-reason']")
	WebElement enterReason;
	
	@FindBy(xpath = "(//button[text()='Confirm'])[4]")
	WebElement confirmButton;
	
	@FindBy(xpath = "//ul[@id='breadcrumbs']//a[@href='/openmrs/index.htm']")
	WebElement homeButton;
	
	@FindBy(xpath = "//div[contains(text(),'Start Visit')]")
	WebElement startvisitButton;
	
	//@FindBy(xpath = "(//button[contains(text(),'Confirm')])[4]")
	@FindBy(xpath = "//button[@id='start-visit-with-visittype-confirm']")
	WebElement confirmStartvisitButton;
	
	public void enterFullName(String gname, String fname)
	{
		generalUtilities.typeToAnElement(givenName, gname);
		generalUtilities.typeToAnElement(familyName, fname);
		generalUtilities.clickOnElement(nextButton);
	}
	
	public void selectGeneder(int index)
	{
		generalUtilities.selectFromDropDownByIndex(genderSelect, index);
		generalUtilities.clickOnElement(nextButton);
	}
	
	public void selectDateOfBirth(String bDay, int index,String bYear )
	{
		generalUtilities.typeToAnElement(patientDayOfBirth, bDay);
		generalUtilities.selectFromDropDownByIndex(patientMonthOfBirthSelect, index);
		generalUtilities.typeToAnElement(patientYearOfBirth, bYear);
		generalUtilities.clickOnElement(nextButton);
	}
	
	public void selectPatientAddress(String address1,String city, String state, String county, String postCode )
	{
		generalUtilities.typeToAnElement(patientaddress1, address1);
		generalUtilities.typeToAnElement(patientCity, city);
		generalUtilities.typeToAnElement(patientState, state);
		generalUtilities.typeToAnElement(patientCountry, county);
		generalUtilities.typeToAnElement(patientPostalCode, postCode);
		generalUtilities.clickOnElement(nextButton);
	}
	
	public void selectPhoneNumber(String phoneNumber)
	{
		generalUtilities.typeToAnElement(patientPhoneNumber, phoneNumber);
		generalUtilities.clickOnElement(nextButton);
	}
	
	public void selectPatientRelated(int index,String pName )
	{
		generalUtilities.selectFromDropDownByIndex(patientRelationType, index);
		generalUtilities.typeToAnElement(patientPersonName, pName);
		generalUtilities.clickOnElement(nextButton);
	}
	
	public void selectPatientConfirm() throws InterruptedException
	{
		generalUtilities.clickOnElement(submitButton);
		generalUtilities.addSleep();
	}
	
	public String getTextOfRegisteredPatientGivenName()
	{
		return generalUtilities.getTextOfElement(registeredGiveName);
	}
	
	public String getTextOfRegisteredPatientFamilyName()
	{
		return generalUtilities.getTextOfElement(registeredFamilyName);
	}
	
	public String readStringData(int a,int b) throws IOException
	{
		return ExcelReadClass.getStringData(a, b);
		
	}
	
	public String readIntegierData(int a, int b) throws IOException
	{
		return ExcelReadClass.getIntegerData(a, b);
		
	}
	
	public void deletePatient(String reason)
	{
		generalUtilities.clickOnElement(deleteRegisteredPatient);
		generalUtilities.typeToAnElement(enterReason, reason);
		generalUtilities.clickOnElement(confirmButton);
	}
	
	public void clickOnHomeButton()
	{
		//explicitWait.elemnetToBeClicableWait(driver, homeButton);
		generalUtilities.clickOnElement(homeButton);
		
	}
	
	public void clickOnStartVisitButton() throws InterruptedException
	{
		//explicitWait.visibitlityOfElementWait(driver, startvisitButton);
		generalUtilities.clickUsinJs(driver, startvisitButton);
		generalUtilities.addSleep();
		
	}
	
	public void clickOnConfirmStartVisitButton() throws InterruptedException
	{
		//explicitWait.elemnetToBeClicableWait(driver, confirmStartvisitButton);
		
		generalUtilities.clickOnElement(confirmButton);
		generalUtilities.addSleep();
		
	}


}
