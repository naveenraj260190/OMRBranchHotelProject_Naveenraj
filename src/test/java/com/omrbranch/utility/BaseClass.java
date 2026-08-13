
package com.omrbranch.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	public static WebDriver driver;
	Select select;
	JavascriptExecutor executor;
	Actions actions;
	Alert alert;

	public byte[] screenshot() {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		byte[] source = screenshot.getScreenshotAs(OutputType.BYTES);
		return source;
	}

	public static String getProjectPath() {
		String path = System.getProperty("user.dir");
		return path;

	}

	public static String getPropertyFileValue(String key) throws IOException {
		Properties properties = new Properties();
		FileInputStream fileInputStream = new FileInputStream(
				getProjectPath() + "\\src\\test\\resources\\config\\config.properties");
		properties.load(fileInputStream);
		String value = properties.getProperty(key);
		return value;
	}

	public void dragAndDrop(WebElement source, WebElement target) {
		actions = new Actions(driver);
		actions.dragAndDrop(source, target).perform();
	}

	public void visibilityOfElement(WebElement element) {
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driverWait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void implicitWait(int secs) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(secs));
	}

	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	public void switchToChildWindow() {
		String windowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String eachWindowId : windowHandles) {
			if (!windowHandle.equals(eachWindowId)) {
				driver.switchTo().window(eachWindowId);
				break;
			}
		}
	}

	public void screenshot(File destFile, WebElement element) throws IOException {
		File source = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, destFile);
	}

	public void screenshot(File destFile) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, destFile);
	}

	public void sendKeysElementJS(WebElement element, String data) {
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value','" + data + "')", element);
	}

	public List<String> getAllOptionsText(WebElement element) {
		List<String> allOptionsText = new ArrayList<>();
		select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (WebElement webElement : options) {
			String text = webElement.getText();
			allOptionsText.add(text);

		}
		return allOptionsText;
	}

	public void selectOptionByIndex(WebElement element, int index) {
		visibilityOfElement(element);
		select = new Select(element);
		select.selectByIndex(index);
	}

	public void selectOptionByText(WebElement element, String text) {
		visibilityOfElement(element);
		select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void selectOptionByValue(WebElement element, String attributeValue) {
		visibilityOfElement(element);
		select = new Select(element);
		select.selectByValue(attributeValue);
	}

	public static void browserLaunch(String browserType) {
		String type = browserType.toUpperCase();

		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.default_content_setting_values.geolocation", 2);
		// prefs.put("")
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" })
				.addArguments("--disable-notifications").addArguments("--incognito").addArguments("--start-maximized")
				.addArguments("--headless").setImplicitWaitTimeout(Duration.ofSeconds(30))
				.setExperimentalOption("prefs", prefs);

		
		switch (type) {
		case "CHROME":
			driver = new ChromeDriver(chromeOptions);
			break;
		case "FIREFOX":
			driver = new FirefoxDriver();
			break;
		case "EDGE":
			driver = new EdgeDriver();
			break;

		default:
			break;
		}

	}

	public static void enterApplicationUrl(String url) {
		driver.get(url);
	}

	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public void sendKeysElementEnter(WebElement element, String data) {
		visibilityOfElement(element);
		if (isDisplayedElement(element) && isEnabledElement(element)) {
			clearTextBox(element);
			element.sendKeys(data, Keys.ENTER);
		}
	}

	public void sendKeysElement(WebElement element, String data) {
		visibilityOfElement(element);
		if (isDisplayedElement(element) && isEnabledElement(element)) {
			clearTextBox(element);
			element.sendKeys(data);
		}
	}

	public static void closeAllWindows() {
		driver.quit();
	}

	public void clickElement(WebElement element) {
		visibilityOfElement(element);
		if (isDisplayedElement(element) && isEnabledElement(element)) {
			element.click();
		}
	}

	public String getApplicationTitle() {
		String title = driver.getTitle();
		return title;
	}

	public WebElement findLocatorById(String attributeValue) {
		WebElement element = driver.findElement(By.id(attributeValue));
		return element;
	}

	public WebElement findLocatorByName(String attributeValue) {
		WebElement element = driver.findElement(By.name(attributeValue));
		return element;

	}

	public WebElement findLocatorByClassName(String attributeValue) {
		WebElement element = driver.findElement(By.className(attributeValue));
		return element;

	}

	public WebElement findLocatorByXpath(String exp) {
		WebElement element = driver.findElement(By.xpath(exp));
		return element;
	}

	public String getApplicationUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public String getTextElement(WebElement element) {
		String text = element.getText();
		return text;
	}

	public String getDomPropertyElement(WebElement element) {
		String domProperty = element.getDomProperty("value");
		return domProperty;
	}

	public String getDomPropertyElement(WebElement element, String attributeName) {
		String domProperty = element.getDomProperty(attributeName);
		return domProperty;
	}

	public boolean isDisplayedElement(WebElement element) {
		boolean displayed = element.isDisplayed();
		return displayed;
	}

	public boolean isEnabledElement(WebElement element) {
		boolean enabled = element.isEnabled();
		return enabled;
	}

	public boolean isSelectedElement(WebElement element) {
		boolean selected = element.isSelected();
		return selected;
	}

	public void clearTextBox(WebElement element) {
		element.clear();
	}

	public void acceptAlert() {
		alert = driver.switchTo().alert();
		alert.accept();

	}

	public void DismissAlert() {
		alert = driver.switchTo().alert();
		alert.dismiss();

	}

}
