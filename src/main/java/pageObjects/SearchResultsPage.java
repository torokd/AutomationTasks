package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage {

	public WebDriver driver;

	By cookieAllowButton = By.xpath("//*[@id='introAgreeButton']/span/span");
	By chosenResult = By
			.xpath("//div[.//div[text()='Pages that include matching images'] and @class='ULSxyf']//*[name()='h3']");

	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getChosenResult() {
		return driver.findElement(chosenResult);
	}

	public WebElement getCookieAllowButton() {
		return driver.findElement(cookieAllowButton);
	}

}
