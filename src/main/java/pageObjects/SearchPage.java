package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {

	public WebDriver driver;

	By cameraIcon = By.className("BwoPOe");
	By uploadTab = By.linkText("Upload an image");
	By chooseFileButton = By.id("awyMjb");

	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getCameraIcon() {
		return driver.findElement(cameraIcon);
	}

	public WebElement getUploadTab() {
		return driver.findElement(uploadTab);
	}

	public WebElement getChooseFileButton() {
		return driver.findElement(chooseFileButton);

	}
}
