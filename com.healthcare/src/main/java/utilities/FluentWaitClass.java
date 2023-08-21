package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FluentWaitClass {

	public Wait<WebDriver> wait;

	public void presenceOfElementLocatedWaitXpath(WebDriver driver, String xpathValue) {
		wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue)));
	}
	
	public void presenceOfElementLocatedWaitID(WebDriver driver, String idValue) {
		wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(idValue)));
	}
	
	public void presenceOfElementLocatedWaitName(WebDriver driver, String nameValue) {
		wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name(nameValue)));
	}
	
	public void elemnetToBeClicableWait(WebDriver driver, WebElement element)
	{
		wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void visibitlityOfElementWait(WebDriver driver, WebElement element)
	{
		wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
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