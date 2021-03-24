package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageObjects.SearchPage;
import pageObjects.SearchResultsPage;
import resources.Base;

public class ImageSearchTest extends Base {

	@BeforeTest
	public void openBrowser() throws IOException {

		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.get(Base.getBaseUrl());

	}

	@Test
	public void imageSearch() throws IOException {

		SearchPage searchPage = new SearchPage(driver);
		SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

		searchPage.getCameraIcon().click();
		searchPage.getUploadTab().click();
		searchPage.getChooseFileButton().sendKeys(System.getProperty("user.dir") + Base.getOriginalPicture());

		driver.switchTo().frame(0);
		searchResultsPage.getCookieAllowButton().click();

		java.util.List<WebElement> talalatok = driver.findElements(By.xpath(
				"//div[.//div[text()='Pages that include matching images'] and @class='ULSxyf']//*[name()='h3']"));
		System.out.println(talalatok.size());

		String resultString = Base.visitResult();
		int resultInt = Integer.parseInt(resultString);
		talalatok.get(resultInt).click();

//		Ha resultInt-1 nagyobb mint talalatok.size akkor 
//		LOOP:
//		léptesse a kövi oldalra és adja hozzá az ottani h3 elemeket a talalatok listához
//		Majd hasonlítsa össze újra a számokat

//		ha nem akkor a loopot hajtsa végre újra
//		ha resultInt-1 kisebb mint a talatok summa akkor kattintson rá a resultIntben szereplő helyen állóra

		Base.takeScreenshot();

	}

	@AfterMethod
	@AfterTest
	public void tearDown() {

		driver.close();

	}

}
