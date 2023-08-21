package pageClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class HomePageClass {
	
	WebDriver driver;
	GeneralUtilities generalUtilities=new GeneralUtilities();
	ExplicitWaitClass ewait = new ExplicitWaitClass();
	
	public HomePageClass(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h4[contains(text(),'Logged in as Super User')]")
	WebElement homeTextMessage;
	
	@FindBy(xpath = "//a[@class='btn btn-default btn-lg button app big align-self-center']")
	List<WebElement> allTiles;
	
	@FindBy(xpath = "//a[contains(@id,'referenceapplication-registrationapp')]")
	WebElement regesterAPatient;
	
	@FindBy(xpath = "//a[contains(@id,'module-coreapps-activeVisitsHomepageLink-extension')]")
	WebElement clickOnActiveListButton;
	
	@FindBy(xpath = "//img[@src='/openmrs/ms/uiframework/resource/uicommons/images/logo/openmrs-with-title-small.png']")
	WebElement logoDisplay;
	
	@FindBy(xpath = "//a[@id='coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension']")
	WebElement clickOnFindPatientRecord;
	
	public String getTextOfWelcomeMessage()
	{
		return generalUtilities.getTextOfElement(homeTextMessage);
	}
	
	public Boolean isAllTilesDisplayed()
	{
		for (WebElement webElement : allTiles) {
			generalUtilities.elemnetIsDisplayed(webElement);
			return true;
		}
		return false;
	}
	
	public void clickOnRegisterAPatient()
	{
		generalUtilities.clickOnElement(regesterAPatient);
	}
	
	public void clickOnActiveListButton()
	{
		generalUtilities.clickOnElement(clickOnActiveListButton);
	}
	
	public String getCurrentURL()
	{
		return generalUtilities.getCurrentUrlOfPage(driver);
	}
	
	public Boolean isLogoDisplayed()
	{
		return generalUtilities.elemnetIsDisplayed(logoDisplay);
	}
	
	public void clickOnFindAPatientButton()
	{
		ewait.presesceOfElemnetLocatedWaitXpath(driver, "//a[@id='coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension']");
		generalUtilities.clickOnElement(clickOnFindPatientRecord);
	}

}
