package pageClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
import utilities.GeneralUtilities;

public class LoginPageClass {
	WebDriver driver;
	
	GeneralUtilities generalUtilities=new GeneralUtilities();
	
	public LoginPageClass(WebDriver driver)    //here we use constructor to declare two drivers in page class and test class & every page class should have this constroctor
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);  //this line is used when Pagefactory method, used to initialize all elemnets (this line is not used when used without pagefactory) 
	}
	
	@FindBy(id = "username")     //@findBy is used for Pagefactory method
	WebElement userName;
	
	@FindBy(id = "password")
	WebElement passWord;
	
	@FindBy(xpath = "//li[text()='Registration Desk']")
	WebElement selectRegistrationDesk;
	
	@FindBy(id = "loginButton")
	WebElement loginButton;
	
	@FindBy(id = "error-message")
	WebElement errorMessage;
	
	
	public void loginAsRegistrationDesk(String uName, String pass)
	{
		generalUtilities.typeToAnElement(userName, uName);
		generalUtilities.typeToAnElement(passWord, pass);
		generalUtilities.clickOnElement(selectRegistrationDesk);
		generalUtilities.clickOnElement(loginButton);
	}
	public String getTextOfErrorMessage()
	{
		return generalUtilities.getTextOfElement(errorMessage);
	}
	public String readStringData(int a,int b) throws IOException
	{
		return ExcelReadClass.getStringData(a, b);
		
	}
	
	public String readIntegierData(int a, int b) throws IOException
	{
		return ExcelReadClass.getIntegerData(a, b);
		
	}

}
