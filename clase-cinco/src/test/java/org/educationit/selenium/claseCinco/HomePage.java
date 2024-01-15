package org.educationit.selenium.claseCinco;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

		WebDriver browser;
		final String BASE_URL = "http://www.automationpractice.pl/index.php";
		
		//El constructor de la clase Homepage
		public HomePage(WebDriver browser) {
			this.browser = browser;
		}

		//Metodo que abre la pagina
		public void open() {
			this.browser.get(BASE_URL);
		}
		
		//Hace click en el boton y devuelve la pagina de signin
		public SignInPage clickSignInLink() {
			String xpathBotonSignIn ="/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a";
			WebElement signInButton = browser.findElement(By.xpath(xpathBotonSignIn));
			signInButton.click();
			
			SignInPage signIn = new SignInPage(browser);
			return signIn;
			
		}
}
