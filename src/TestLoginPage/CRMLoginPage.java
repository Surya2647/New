package TestLoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CRMLoginPage 
{

	@FindBy(id="userName")
	private WebElement unTB;
	
	@FindBy(id="passWord")
	private WebElement pwTB;
	
	@FindBy(xpath="//input[@title='Sign In']")
	private WebElement signInButton;
	
	@FindBy(xpath="//td[contains(text(),' No such')]")
	private WebElement errMSG;
	
	public CRMLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void setUN(String un)
	{
		unTB.sendKeys(un);
	}
	public void setPW(String pw)
	{
		pwTB.sendKeys(pw);
	}
	
	public void clickSignIn() 
	{
		signInButton.click();
	}
	
	public void verify(WebDriver driver) 
	{
		try
		{
			if(errMSG.isDisplayed())
			{
				System.out.println("Error message is displayed.");
			}
			else
			{
				driver.switchTo().alert().dismiss();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
