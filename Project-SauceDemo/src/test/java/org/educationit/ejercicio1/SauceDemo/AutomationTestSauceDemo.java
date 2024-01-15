package org.educationit.ejercicio1.SauceDemo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class AutomationTestSauceDemo {
	static final String AUTOMATION_SAUCEDEMO = "https://www.saucedemo.com";

	@Test
	void testForLogin() throws InterruptedException {
		final String TITLE = "login_logo";
		final String PAGETITLE = "Swag Labs";
		final String USER_NAME_INPUT = "user-name";
		final String PASSWORD_INPUT = "password";
		final String USERNAME = "standard_user";
		final String PASSWORD = "secret_sauce";
		final String LOGINBUTTON = "login-button";
		final String TITLEPAGEPRODUCTS = "title";
		final String PAGETITLEAFTERLOGIN = "Products";
		
		WebDriver browser = new ChromeDriver();
		try {
			browser.get(AUTOMATION_SAUCEDEMO);
			browser.manage().window().maximize();
			browser.manage().deleteAllCookies();
			Thread.sleep(3000);
			if (browser.findElement(By.className(TITLE)).getText().equals(PAGETITLE)) {
				System.out.println("Estoy en la pagina correcta");
				browser.findElement(By.id(USER_NAME_INPUT)).sendKeys(USERNAME);
				browser.findElement(By.id(PASSWORD_INPUT)).sendKeys(PASSWORD);
				Thread.sleep(3000);
				browser.findElement(By.name(LOGINBUTTON)).click();	
				if (browser.findElement(By.className(TITLEPAGEPRODUCTS)).getText().equals(PAGETITLEAFTERLOGIN)) {
					System.out.println("Login successful");
					Thread.sleep(5000);
				} else {
					System.out.println("Login error");
				}
			} else {
				System.out.println("La pagina no es la correcta");
			}
		} finally {
			browser.quit();
		}		
	}
}


