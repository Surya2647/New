package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_Campaign_Page
{
	@FindBy(xpath="//input[@name='property(Campaign Name)']")
	private WebElement cmpgnName;
	
	public Create_Campaign_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void setCmpgnName(String cgnName)
	{
		cmpgnName.sendKeys(cgnName);
	}

}
