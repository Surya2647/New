package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import TestLoginPage.CRMLoginPage;
import generic.FWUtils;

public class TestInvalidCRMLoginPage extends FWUtils
{
	static
	{
		System.setProperty(CHROME_KEY, CHROME_VALUE);
	}

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(URL);
		
		CRMLoginPage clp=new CRMLoginPage(driver);
		int rowc=FWUtils.xl_row_count(path, "InvalidLogin");
		System.out.println(rowc);
		
		for(int i=1;i<=rowc;i++)
		{
			String unt=FWUtils.read_xl_path(path,"InvalidLogin", i, 0);
			String pwt=FWUtils.read_xl_path(path,"InvalidLogin", i, 1);
			clp.setUN(unt);
			clp.setPW(pwt);
			Thread.sleep(1000);
			clp.clickSignIn();
			clp.verify(driver);
		}
	}

}
