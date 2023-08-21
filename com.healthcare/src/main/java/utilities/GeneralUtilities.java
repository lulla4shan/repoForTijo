package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {
	
	public void clickOnElement(WebElement element)
	{
		element.click();
	}
	public void clearAnElement(WebElement element)
	{
		element.clear();
	}
	
	public void typeToAnElement(WebElement element, String text)
	{
		element.sendKeys(text);
	}
	
	public String getCurrentUrlOfPage(WebDriver driver)
	{
		return driver.getCurrentUrl();
	}
	
	public Boolean elemnetIsDisplayed(WebElement element)
	{
		return element.isDisplayed();
	}
	
	public String getTextOfElement(WebElement element)
	{
		return element.getText();
	}
	
	public String getAttributeOfAnElement(WebElement element, String attributeType)
	{
		return element.getAttribute(attributeType);
	}
	
	public void clickUsinJs(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	public void scrollToAnElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public void selectFromDropDownByIndex(WebElement element, int index)
	{
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	
	public void aleretAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void clickAnElementUsingSendKeys(WebDriver driver, WebElement element)
	{
		Actions actions=new Actions(driver);
		actions.sendKeys(element,Keys.ENTER).build().perform();
	}
	
	public void dragAndDrop(WebElement element1, WebElement element2, WebDriver driver) 
	{
		Actions actions=new Actions(driver);
		actions.dragAndDrop(element1, element2).build().perform();
	}
	
	public void doubleClick(WebElement element, WebDriver driver) {
		Actions actions=new Actions(driver);
		actions.doubleClick(element);
	}
	
	
	public void addSleep() throws InterruptedException {
		Thread.sleep(3000);
	}

}
