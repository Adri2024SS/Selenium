package org.educationit.cursoSelenium.claseDos;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class Program {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Bienvenido clase dos");
		WebDriver webBrowser = new ChromeDriver();
		try {
			webBrowser.get("http://www.automationpractice.pl/index.php");
			// Busco un elemento por id
			// Opcion 1 - Guardo el resultado en una variable
			// WebElement inputSearch = webBrowser.findElement(By.id("search_query_top"));
			// inputSearch.sendKeys("shirt");

			// Opcion 2
			webBrowser.findElement(By.id("search_query_top")).sendKeys("shirt");

			// Busco un elemento por Name
			// Opcion 1 - Encuentro el elemento
			WebElement botonBuscar = webBrowser.findElement(By.name("submit_search"));
			botonBuscar.click();
			
			
			Thread.sleep(3000);
			WebElement spanSearchResult = webBrowser.findElement(By.className("heading-counter"));
			//System.out.println(spanSearchResult.getText());
			if (spanSearchResult.getText().equals("1 result has been found.")) {
				System.out.println("Obtuve el resultado esperado");
			}else {
				System.out.println("La pagina no me devolvio lo que queria");
			}

			// Opcion 2 - El elemento no existe
			//String nombreBotonBuscar = "submit_serach_noexiste";
			//try {
			//	WebElement botonBuscar = webBrowser.findElement(By.name("submit_search_noexiste"));
			//	botonBuscar.click();
			//} catch (Exception ex) {
			//	System.out.println("El elemento " + nombreBotonBuscar + " no existe");
			//}

			// Espero 5 segundos
			Thread.sleep(5000);
		} finally {
			webBrowser.quit();
		}
	}
}
