package org.educationit.cursoSelenium.claseUno;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Programa {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Hola Mundo Selenium");
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("https://www.google.com");
			Thread.sleep(3000);
		} finally {
			driver.quit();

		}
	}
}
