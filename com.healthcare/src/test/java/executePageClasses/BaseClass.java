package executePageClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ScreenShotClass;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseClass {
	
	WebDriver driver;
	ScreenShotClass sc;
	
	public static Properties property;
	
	public static void readProperty() throws IOException
	{
		property=new Properties();
		FileInputStream f=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		property.load(f); //this is to load the file
	}
	
	@Parameters("browser")

	@BeforeMethod
	public void beforeMethod(String browserValue) throws IOException {
		
		readProperty();
		
		if(browserValue.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();  //this is to take correct version
			driver = new ChromeDriver();
		}
		else if(browserValue.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();  //this is to take correct version
			driver = new EdgeDriver();
		}
		driver.get(property.getProperty("url")); //admin Admin123
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	

	@AfterMethod
	public void afterMethod(ITestResult itr) throws IOException {  //ITestResult is interface
		
		if(itr.getStatus()==ITestResult.FAILURE) //if ITestResult status and our test result is failed
		{
			sc=new ScreenShotClass();
			sc.takeScreenShot(driver, itr.getName());
		}
		//driver.quit();
	}
	
	@BeforeSuite(alwaysRun = true)  //this code should run always so write as 'alwaysRun = true'
	public void createExtendReport(final ITestContext testContext)
	{
		extendReport.ExtentManager.createInstance().createTest(testContext.getName(),"message");
	}

}
