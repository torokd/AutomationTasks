package tests;

import org.testng.annotations.Test;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import pageObjects.SearchResultsPage;
import resources.Base;

public class Dummy extends Base {

	@BeforeTest
	public void openBrowser() throws IOException {

		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.get(
				"https://www.google.hu/search?tbs=sbi:AMhZZivKqpRVKqpY1P7At4V_10yZhWHOolkEpSF_1MQu8G9YFJjAGCph6GR-FHU622xPEHLeDb7oE9M3ZhBZs-W9Ud-rRjoqQsFXOJUI1TXg1J_1SPPrkhzK38WvqAREWU8vgWgkVymh2FX0GPaomNjWROTVDa0JDyig5OssmfvlaK8cBvUTE16Kkpye26QmjrTRKi_1hTtAHnbhs4cN5TjBVMPKuq-g5eEdzXlkSqVJCeg1TPZ_1sp_1EM4HZ-ween0rqo4h1I2d8Ymo3PVkLsNMzqlNJl_1dsIKA2qcg41VYHK3h5N8TCQDYaUsGefj1QaOPelP8c86pUC1bmh8P92y8sIajfy2M9Z-sMhQ&hl=en-HU");

	}

	@Test
	public void test() throws IOException {

		
		SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
		driver.switchTo().frame(0);
		searchResultsPage.getCookieAllowButton().click();
		
		java.util.List<WebElement> talalatok = driver.findElements(By.xpath("//div[.//div[text()='Pages that include matching images'] and @class='ULSxyf']//*[name()='h3']"));
		System.out.println(talalatok.size());
		
		
		String talalatString = Base.visitResult(); 
		int i=Integer.parseInt(talalatString); 
		talalatok.get(i).click();
		
		
		
		
	}

}
