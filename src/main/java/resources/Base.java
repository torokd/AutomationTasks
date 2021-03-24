package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Base {

	public static WebDriver driver;

	public WebDriver initializeDriver() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/java/resources/data.properties");
		prop.load(fis);

		String browserName = prop.getProperty("browser");
		String chromePath = prop.getProperty("chromepath");
		String firefoxPath = prop.getProperty("firefoxpath");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", chromePath);
			driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.FirefoxDriver.driver", firefoxPath);
			driver = new FirefoxDriver();

		} else if (browserName.equals("safari")) {
			driver = new SafariDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

	public static String getBaseUrl() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/java/resources/data.properties");
		prop.load(fis);

		String url = prop.getProperty("url");
		return url;

	}

	public static String getOriginalPicture() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/java/resources/data.properties");
		prop.load(fis);

		String opPath = prop.getProperty("originalpicturepath");
		return opPath;

	}

	public static void takeScreenshotOnFailure(String testCaseName, WebDriver driver) throws IOException {

		TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
		File failScreenshotSource = takeScreenshot.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "/screenshots/" + testCaseName + ".png";
		FileUtils.copyFile(failScreenshotSource, new File(destinationFile));

	}

	public static void takeScreenshot() throws IOException {

		File screenshotSource = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotSource,
				new File(System.getProperty("user.dir") + "/src/main/java/resources/searchResult.png"));

	}

	public static String visitResult() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/java/resources/data.properties");
		prop.load(fis);

		String visitresult = prop.getProperty("visitresult");
		return visitresult;
	}

}
