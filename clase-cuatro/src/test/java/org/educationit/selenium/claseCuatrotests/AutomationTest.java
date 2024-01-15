package org.educationit.selenium.claseCuatrotests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AutomationTest {
	String url = "http://www.automationpractice.pl/index.php";

	@Test
	public void testSignIn() throws Exception {
		String xpathBotonSignIn ="/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a";
		String xpathTxtEmail = "//*[@id=\"email_create\"]";
		String xpathBotonCreateAccount = "//*[@id=\"SubmitCreate\"]/span/i";
		String email = "mailprueba@gmail.com";
		
		WebDriver browser = new ChromeDriver();
		WebDriverWait waiter = new WebDriverWait(browser, Duration.ofSeconds(10));
		try {
			browser.get(url);
			WebElement signInButton = browser.findElement(By.xpath(xpathBotonSignIn));
			signInButton.click();
			
			WebElement txtEmail = waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathTxtEmail)));
			txtEmail.sendKeys(email);
			
			//Click en boton Create Account
			browser.findElement(By.xpath(xpathBotonCreateAccount)).click();
			
			// Espero que aparezca el elemento
			waiter.until(ExpectedConditions.elementToBeClickable(By.id("customer_firstname")));
			
			browser.findElement(By.id("customer_firstname")).sendKeys("Adriana");
			browser.findElement(By.id("customer_lastname")).sendKeys("Romero");
			browser.findElement(By.id("passwd")).sendKeys("12345");
			
			Thread.sleep(3000);
		} finally {
			browser.quit();
		}
	}
	
	@Test
	public void testMensajeError() throws Exception {
		String xpathBotonSignIn ="/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a";
		String xpathTxtEmail = "//*[@id=\"email_create\"]";
		String xpathBotonCreateAccount = "//*[@id=\"SubmitCreate\"]/span/i";
		String email = "pepe@gmail.com";
		String xpathMensajeError = "//*[@id=\"create_account_error\"]/ol/li";
		
		WebDriver browser = new ChromeDriver();
		WebDriverWait waiter = new WebDriverWait(browser, Duration.ofSeconds(10));
		try {
			browser.get(url);
			WebElement signInButton = browser.findElement(By.xpath(xpathBotonSignIn));
			signInButton.click();
			
			WebElement txtEmail = waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathTxtEmail)));
			txtEmail.sendKeys(email);
			
			//Click en boton Create Account
			browser.findElement(By.xpath(xpathBotonCreateAccount)).click();
			
			Thread.sleep(1000);
			
			WebElement mensajeError = browser.findElement(By.xpath(xpathMensajeError));
			
			
			Assert.assertEquals("An account using this email address has already been registered. Please enter a valid password or request a new one.",
					            mensajeError.getText());
			
			
			Thread.sleep(3000);
		} finally {
			browser.quit();
		}
	}
}
