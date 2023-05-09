import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Codes {

	@Test
	void linkTest() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		WebElement hindiLink = driver.findElement(By.xpath("//a[text()='हिन्दी']"));
		hindiLink.click();
		
		String actual=driver.findElement(By.xpath("(//input[@value='आज मेरी किस्मत अच्छी है'])[2]")).getAttribute("value");
		
		try {
			Assert.assertEquals(actual,"आज मेरी किस्मत अच्छी है");
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.close();
	}
	
	//select ename,max(salary) from employee;

}
