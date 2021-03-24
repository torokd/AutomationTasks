package resources;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class Listeners extends Base implements ITestListener {

	public void onTestFailure(ITestResult result) {
		WebDriver driver = null;
		String testMethodName = result.getMethod().getMethodName();
		try {
			
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
		}
		try {
			takeScreenshotOnFailure(testMethodName, driver);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
