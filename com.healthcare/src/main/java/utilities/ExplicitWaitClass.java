package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitClass {
	
	public WebDriverWait wait;
	
	public void presesceOfElemnetLocatedWaitXpath(WebDriver driver, String xpathValue)
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue)));
	}
	public void presesceOfElemnetLocatedWaitID(WebDriver driver, String idValue)
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(idValue)));
	}
	public void presesceOfElemnetLocatedWaitName(WebDriver driver, String nameValue)
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name(nameValue)));
	}
	
	public void elemnetToBeClicableWait(WebDriver driver, WebElement element)
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void visibitlityOfElementWait(WebDriver driver, WebElement element)
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void alertPresentWait(WebDriver driver)
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	public void elemnetToBeSelected(WebDriver driver, WebElement element)
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}

}
