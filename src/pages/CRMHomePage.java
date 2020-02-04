package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CRMHomePage 
{
	@FindBy(xpath="//a[text()='Campaigns']")
	private WebElement cmpgn;
	
	public CRMHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void click()
	{
		cmpgn.click();
	}
	
}
