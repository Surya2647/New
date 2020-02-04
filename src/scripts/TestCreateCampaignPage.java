package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import TestLoginPage.CRMLoginPage;
import generic.FWUtils;
import pages.CRMHomePage;
import pages.CampaignListPage;
import pages.Create_Campaign_Page;

public class TestCreateCampaignPage extends FWUtils
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
		
		CampaignListPage cmpgnlist=new CampaignListPage(driver);
		cmpgnlist.clickNewCmpgn();
		
		Create_Campaign_Page ccp=new Create_Campaign_Page(driver);
		String cname = FWUtils.read_xl_path(path, "Sheet1",1,0);
		ccp.setCmpgnName(cname);
	}

}
