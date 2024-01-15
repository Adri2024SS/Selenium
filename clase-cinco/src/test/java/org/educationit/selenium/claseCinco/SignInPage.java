package org.educationit.selenium.claseCinco;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {

	WebDriver browser;
	
	public SignInPage(WebDriver browser) {
		this.browser = browser;
	}
  
	public void createAccountWithEmail(String email) {
		String xpathBotonCreateAccount = "//*[@id=\"SubmitCreate\"]/span/i";
		String xpathTxtEmail = "//*[@id=\"email_create\"]";
		
		WebDriverWait waiter = new WebDriverWait(browser, Duration.ofSeconds(10));
		WebElement txtEmail = waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathTxtEmail)));
		txtEmail.sendKeys(email);
		
		//Hacer click luego en el boton Create Account
		browser.findElement(By.xpath(xpathBotonCreateAccount)).click();
		}
	
	public String getCreateAccountErrorText () {
		WebElement divCreateAccountError = this.browser.findElement(By.cssSelector("#create_account_error"));
		return divCreateAccountError.getText();
	}
	
	public void completeCreateAccountForm (
		boolean isMister,	
		String firstName,
		String lastName,
	    String password,
    	int diaNacimiento,
    	int mesNacimiento,
    	int anioNacimiento,
    	boolean NewsletterSelected) {
		
		WebDriverWait waiter = new WebDriverWait(browser, Duration.ofSeconds(10));
		waiter.until(ExpectedConditions.elementToBeClickable(By.id("customer_firstname")));
		
		if (isMister) {
			browser.findElement(By.id("id_gender1")).click();
		}else {
			browser.findElement(By.id("id_gender2")).click();
		}
		
		browser.findElement(By.id("customer_firstname")).sendKeys(firstName);
		browser.findElement(By.id("customer_lastname")).sendKeys(lastName);
		//browser.findElement(By.id("email")).sendKeys(email); se autocompleta
		browser.findElement(By.id("passwd")).sendKeys(password);
		
		Select selectDia = new Select(browser.findElement(By.id("days")));
		selectDia.selectByValue(Integer.toString(diaNacimiento));
		
		Select selectMes = new Select(browser.findElement(By.id("months")));
		selectMes.selectByValue(Integer.toString(mesNacimiento));
		
		Select selectAnio = new Select(browser.findElement(By.id("years")));
		selectAnio.selectByValue(Integer.toString(anioNacimiento));	
		
		if (NewsletterSelected) {
			browser.findElement(By.id("newsletter")).click();
					}
		String xpathBotonRegister = "//*[@id=\"submitAccount\"]/span";
		browser.findElement(By.xpath(xpathBotonRegister)).click();
	}

		public String getAccountCreationText () {
		WebElement divAccountCreationText = this.browser.findElement(By.xpath("//*[@id=\"center_column\"]/p[1]"));
		return divAccountCreationText.getText();
	}
}
