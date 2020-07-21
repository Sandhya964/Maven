package sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Reg {
	
	@Test
	public void RegisterUser() {
		WebDriverManager.chromedriver().setup();
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("http://magento.com");
		driver.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[9]/a/span[1]/div")).click();
		driver.findElement(By.id("register")).click();
		driver.findElement(By.id("firstname")).sendKeys("sandhya");
		driver.findElement(By.id("lastname")).sendKeys("kovelakuntla");
		driver.findElement(By.id("email_address")).sendKeys("kuppusala.sandy@gmail.com");

		Select type=new Select(driver.findElement(By.id("company_type")));
		// type.selectByIndex(3);  //
		// type.selectByValue("development");   //
		type.selectByVisibleText("Provides deployment, customization and integration services to merchants");

		Select role=new Select(driver.findElement(By.name("individual_role")));
		role.selectByValue("technical/developer");

		Select country=new Select(driver.findElement(By.id("country")));
		country.selectByValue("US");

		driver.findElement(By.id("password")).sendKeys("Welcome@123");
		driver.findElement(By.id("password-confirmation")).sendKeys("Welcome@123");

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@role='presentation']")));
		driver.findElement(By.className("recaptcha-checkbox-border")).click();
		System.out.println(driver.findElement(By.tagName("label")).getText());

		driver.switchTo().defaultContent();

		if(!driver.findElement(By.id("agree_terms")).isSelected())
		{
			driver.findElement(By.id("agree_terms")).click();	
		}
	}

}
