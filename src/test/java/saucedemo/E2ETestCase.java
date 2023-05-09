package saucedemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class E2ETestCase {

	WebDriver driver;

	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
	}

	@Test(priority = 1)
	public void login() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
	}

	@Test(priority = 2)
	public void totalCountOfProducts() {
		// div[@class='inventory_item']
		List<WebElement> totalProducts = driver.findElements(By.xpath("//div[@class='inventory_item']"));
		int totalCount = totalProducts.size();
		System.out.println(totalCount);
		Assert.assertEquals(totalCount==6, true,"Value is not 6");
	}

	@Test(priority = 3)
	public void verifyButtonVisibility() {
		List<WebElement> allAddToCartButtons = driver
				.findElements(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));
		for (WebElement e : allAddToCartButtons) {
			if (!e.isDisplayed()) {
				// Assert.assertEquals(e.isDisplayed(), false);
				System.out.println("Add to Cart button is not visible for this" + e);
				return;
			}
		}
		System.out.println("All the add to cart buttons are visible");
	}

	@Test(priority = 4)
	public void clickOnSpecificProduct() {
		// WebElement productWithprice$15 =
		// driver.findElement(By.xpath("(//div[@class='inventory_item_price'])[3]"));
//		List<WebElement> allAddToCartButtons = driver
//				.findElements(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));

		WebElement productWithprice$15 = driver
				.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']"));
		productWithprice$15.click();
	}

	@Test(priority = 5)
	public void clickonCartIcon_VerifySpecificProduct() {
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		boolean p = driver.findElement(By.xpath("//div[@class=\"inventory_item_price\"]")).isDisplayed();
		Assert.assertEquals(p, true);
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
