package GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.vtiger.ObjectRepositary.HomePage;
import com.crm.vtiger.ObjectRepositary.LoginPage;

public class BaseClass {
	public PropertyFileUtility putil = new PropertyFileUtility();
	public ExcelFileUtility eutil = new ExcelFileUtility();
	public JavaUtility jutil = new JavaUtility();
	public WebDriverUtility wutil = new WebDriverUtility();
	public WebDriver driver;
	public static WebDriver sdriver;//only for Listner

	@BeforeSuite
	public void bs_config() {
		System.out.println("database connection sucessfully");
	}
	@Parameters("browser")
	//@BeforeTest
	@BeforeClass(groups= {"smoke","Regression"})
	public void bc_config(/*String Browser*/) throws Throwable {
		//String Browser = putil.getPropertyFileData("Browser");
		String Browser = System.getProperty("Browser");
		String URL = putil.getPropertyFileData("URL");
		//String URL = System.getProperty("URL");
		
		if(Browser.equalsIgnoreCase("chrome")) {
		 driver = new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("invalid browse");
		}
		sdriver=driver;
		wutil.maximizepage(driver);
		wutil.waitThePageImplicitly(driver);
		driver.get(URL);
	}
	@BeforeMethod
	public void bm_config() throws Throwable {
		String UN = putil.getPropertyFileData("username");
		String PW = putil.getPropertyFileData("password");
		LoginPage lp=new LoginPage(driver);
		lp.login(UN, PW);
	}
	@AfterMethod
	public void am_config() {
		HomePage hp=new HomePage(driver);
		hp.logout(driver);
	}
	@AfterClass
	public void ac_config() {
		driver.quit();
	}
	@AfterSuite
	public void as_config() {
		System.out.println("close Database connection");
	}
}
