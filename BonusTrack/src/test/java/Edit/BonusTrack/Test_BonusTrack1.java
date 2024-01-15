package Edit.BonusTrack;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_BonusTrack1 {
	String url = "https://www.saucedemo.com/";
	String driverPath = "..\\EducacionIt\\Drivers\\chromedriver.exe";
	
	@Test
	public void lab1_e1() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		WebDriver driver = new ChromeDriver();
		driver.get(url);
	
		// Login
		WebElement txtUsername = driver.findElement(By.id("user-name"));
		txtUsername.sendKeys("standard_user");
		
		WebElement txtPassword = driver.findElement(By.id("password"));
		txtPassword.sendKeys("secret_sauce");
		
		WebElement btnLogin = driver.findElement(By.id("login-button"));
		btnLogin.click();
	}
}
