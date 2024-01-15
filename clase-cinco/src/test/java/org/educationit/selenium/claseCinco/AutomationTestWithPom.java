package org.educationit.selenium.claseCinco;

import java.util.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AutomationTestWithPom {
//String url = "http://www.automationpractice.pl/index.php";

	@Test
	public void testSignInEmptyEmail() throws Exception {
		WebDriver browser = new ChromeDriver();
		HomePage home = new HomePage(browser);
		try {
			home.open();
			SignInPage signIn = home.clickSignInLink();
			signIn.createAccountWithEmail("");
			Thread.sleep(500);
			Assert.assertEquals("Invalid email address.", signIn.getCreateAccountErrorText());
			Thread.sleep(5000);
		} finally {
			browser.quit();
		}
	}

	@Test
	public void testSignInDuplicatedEmail() throws Exception {
		WebDriver browser = new ChromeDriver();
		HomePage home = new HomePage(browser);
		try {
			home.open();
			SignInPage signIn = home.clickSignInLink();
			signIn.createAccountWithEmail("pepe@gmail.com");
			Thread.sleep(500);
			Assert.assertEquals(
					"An account using this email address has already been registered. Please enter a valid password or request a new one.",
					signIn.getCreateAccountErrorText());
			Thread.sleep(5000);
		} finally {
			browser.quit();
		}
	}

	
	@DataProvider(name ="invalid-emails")
	  public Object[][] getInvalidEmails(){
		  return new Object[][] {
			  {"","Invalid email address."},
			  {"pepe@gmail.com","An account using this email address has already been registered. Please enter a valid password or request a new one."}
		  };	  
	  }
	
	@Test (dataProvider = "invalid-emails")
	public void testSignInvaliddEmail(String email, String response) throws Exception {
		WebDriver browser = new ChromeDriver();
		HomePage home = new HomePage(browser);
		try {
			home.open();
			SignInPage signIn = home.clickSignInLink();
			signIn.createAccountWithEmail(email);
			Thread.sleep(500);
			Assert.assertEquals(response,signIn.getCreateAccountErrorText());
			Thread.sleep(5000);
		} finally {
			browser.quit();
		}
	}

	
	
	@DataProvider(name = "nombres")
	public Object[][] getNombres() {
		return new Object[][] { { "Mr","Conrado" }, {"Ms", "Adriana" }, { "Ms","Yoseline" } };
	}

	@Test(dataProvider = "nombres")
	public void testConParametros(String pref, String nombre) {
		System.out.println(pref + " " + nombre);
	}

	@Test
	public void testSignInSuccessfull() throws Exception {
		WebDriver browser = new ChromeDriver();
		HomePage home = new HomePage(browser);
		try {
			home.open();
			SignInPage signIn = home.clickSignInLink();
			signIn.createAccountWithEmail("pepe2028@gmail.com");
			signIn.completeCreateAccountForm(false, "Adriana", "Test", "root123", 20, 9, 1982, true);
			Thread.sleep(3000);
			Assert.assertEquals("Your account has been created.", signIn.getAccountCreationText().trim());
			Thread.sleep(5000);
		} finally {
			browser.quit();
		}

	}

	@Test
	public void testAlerta() throws Exception{
		  //file:///C:/Adriana/Alertas/Alerta.html
		    ChromeOptions options = new ChromeOptions();
		    //incognito, maximizar
		    options.addArguments("incognito", "start-maximized");
			WebDriver browser = new ChromeDriver(options);
			try {
				browser.get("file:///C:/Adriana/Alertas/Alerta.html");
				Alert alert = browser.switchTo().alert();
				Thread.sleep(3000);
				alert.accept();
			}finally {
				browser.quit();
			}	  
	  }
	
	@Test
	  public void testTabla() throws Exception{
			WebDriver browser = new ChromeDriver();
			try {
				browser.get("file:///C:/Adriana/Alertas/Tabla.html");
				Thread.sleep(1000);
				//mostrar un elemento
				System.out.println(browser.findElement(By.xpath("//*[@id=\"tabla\"]/tbody/tr[3]/td[2]")).getText());
				
				//iterar en la tabla
				List<WebElement> elements = browser.findElement(By.id("tabla")).findElements(By.tagName("td"));
				for(WebElement element : elements) {
					System.out.println(element.getText());
				}
				
			} finally {
				browser.quit();
			}
	  }
	
}
