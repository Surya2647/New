package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import TestLoginPage.CRMLoginPage;
import generic.FWUtils;
import pages.CRMHomePage;

public class TestCrmHomePage extends FWUtils
{
	static
	{
		System.setProperty(CHROME_KEY, CHROME_VALUE);
	}

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(URL);
		
		String unt=FWUtils.read_xl_path(path,"ValidLogin", 1, 0);
		String pwt=FWUtils.read_xl_path(path,"ValidLogin", 1, 1);
		
		CRMLoginPage clp=new CRMLoginPage(driver);
		clp.setUN(unt);
		clp.setPW(pwt);
		clp.clickSignIn();
		
		CRMHomePage chp=new CRMHomePage(driver);
		chp.click();

	}

}
