package GenericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {
	private String value;

	/**
	 * This method maximize the Webpage
	 * 
	 * @param driver
	 */

	public void maximizepage(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This method minimize the Webpage
	 * 
	 * @param driver
	 */
	public void minimize(WebDriver driver) {
		driver.manage().window().minimize();
	}

	/**
	 * This method wait the Webpage for certain time until the condition met
	 * 
	 * @param driver
	 */
	public void waitThePageImplicitly(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IpathConstant.implicitwaitduration));

	}

	public void visibleTheElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IpathConstant.explicitwaitduration));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void elementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IpathConstant.explicitwaitduration));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public void alterIsPresent(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IpathConstant.explicitwaitduration));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void titlePresent(WebDriver driver, String title) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IpathConstant.explicitwaitduration));
		wait.until(ExpectedConditions.titleContains(title));
	}

	public void urlPresent(WebDriver driver, String url) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IpathConstant.explicitwaitduration));
		wait.until(ExpectedConditions.urlContains(url));
	}

	public void ignoreException(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(IpathConstant.explicitwaitduration));
		wait.ignoring(NoSuchElementException.class);
	}

	public void handle1Dropdown(WebElement element, int index) {
		Select se = new Select(element);
		se.selectByIndex(index);
	}

	public void handle1Dropdown(WebElement element, String visibleText) {
		Select se = new Select(element);
		se.selectByValue(value);
	}

	public void handelDropdown(String visibleText, WebElement element) {
		Select se = new Select(element);
		se.selectByVisibleText(visibleText);

	}

	public void moveToElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();

	}

	public void rightClickAnyWhere(WebDriver driver) {
		Actions action = new Actions(driver);
		action.contextClick().perform();
	}

	public void rightClickOnElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}

	public void doubleClickOnElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	public void dragAndDrop(WebDriver driver, WebElement sourceelement, WebElement destinationelement) {
		Actions action = new Actions(driver);
		action.dragAndDrop(sourceelement, destinationelement).perform();
	}

	public void frame(int index, WebDriver driver) {
		driver.switchTo().frame(index);
	}

	public void frame(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	public void frame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	public void parentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	public void defaultFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void AcceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void DismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public String getTextFromAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	public void passTextIntoAlert(WebDriver driver, String text) {
		driver.switchTo().alert().sendKeys(text);
	}

	public void handelWindow(WebDriver driver, String partialTitle) {
		// capture all the window ids
		Set<String> Ids = driver.getWindowHandles();
		for (String winId : Ids) {
			// navigate to each window and capture the title
			String currentTitle = driver.switchTo().window(winId).getTitle();
			// compare the title with required window title
			if (currentTitle.contains(partialTitle)) {
				break;
			}
		}
	}

	public String screenshot(WebDriver driver, String screenshotname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		JavaUtility jutil = new JavaUtility();
		String currentdate = jutil.getModifiedSysDate();
		File dest = new File("./Screenshot/" + currentdate + screenshotname + ".png");
		Files.copy(src, dest);
		return dest.getAbsolutePath();// Extent report
	}

	public String screenshotElement(WebElement element, String screenshotname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) element;
		File src = ts.getScreenshotAs(OutputType.FILE);
		JavaUtility jutil = new JavaUtility();
		String currentdate = jutil.getModifiedSysDate();
		File dest = new File("./Screenshot/" + currentdate + screenshotname + ".png");
		Files.copy(src, dest);
		return dest.getAbsolutePath();// Extent report
	}
}
