package org.educationit.ejercicio1.SauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_BonusTrack1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver webBrowser = new ChromeDriver();
		try {
			webBrowser.get("https://www.saucedemo.com");
			webBrowser.manage().window().maximize();
			webBrowser.manage().deleteAllCookies();
			Thread.sleep(3000);
			WebElement divSearchTitle = webBrowser.findElement(By.className("login_logo"));
			if (divSearchTitle.getText().equals("Swag Labs")) {
				System.out.println("Estoy en la pagina correcta");
				webBrowser.findElement(By.id("user-name")).sendKeys("standard_user");
				webBrowser.findElement(By.id("password")).sendKeys("secret_sauce");
				WebElement botonLogin = webBrowser.findElement(By.id("login-button"));
				Thread.sleep(3000);
				botonLogin.click();
				WebElement spanSearchTitle = webBrowser.findElement(By.className("title"));
				if (spanSearchTitle.getText().equals("Products")) {
					System.out.println("Login successful");
					Thread.sleep(5000);
				} else {
					System.out.println("Login error");
				}
			} else {
				System.out.println("La pagina no es la correcta");
			}
		} finally {
			webBrowser.quit();
		}
	}
}
