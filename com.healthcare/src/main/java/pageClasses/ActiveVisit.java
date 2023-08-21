package pageClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ActiveVisit {
	WebDriver driver;
	GeneralUtilities generalUtilities=new GeneralUtilities();
	
	public ActiveVisit(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//table[@id='active-visits']//tr")
	List<WebElement> row;

	@FindBy(xpath = "//table[@id='active-visits']//th")
	List<WebElement> col;
	
	
	public Boolean isPatientNameDisplayed(String name) {
		int rowCount = row.size();   
		int colCount = col.size();	
		System.out.println(rowCount+"  "+colCount);   
		
		boolean flag = false;  
		
		for(int row = 1;row<rowCount;row++) {
			for(int col = 1;col<colCount;col++) {
				
				String actValue = driver.findElement(By.xpath("//table[@id='active-visits']//tr["+row+"]//td["+col+"]")).getText();
				if (actValue.equalsIgnoreCase(name)) {
					
					flag = true;  
					System.out.println(row+" : "+col); 
					break;
					
				}
			}
	}
		if (flag) {  
			return true;
		}
		return flag;
		
	}
	
	

}
