package org.educationit.cursoSelenium.claseDos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;


class AutomationPracticeTest {

	// Atributos de la clase
	// Las variables y atributos "final" no se modifican
	static final String AUTOMATION_PRACTICE_HOME = "http://www.automationpractice.pl/index.php";

	@Test
	void testSearchForShirt() throws InterruptedException {

		// Variables del metodo - solo las podes usar dentro de este metodo
		final String SEARCH_INPUT_ID = "search_query_top";
		final String SEARCH_STRING = "shirt";
		final String SEARCH_BUTTON_NAME = "submit_search";
		final String SEARCH_RESULTS_EXPECTED_CLASSNAME = "heading-counter";
		final String SEARCH_RESULTS_EXPECTED_TEXT = "1 result has been found.";

		WebDriver browser = new ChromeDriver();
		try {
			browser.manage().window().maximize();
			browser.get(AUTOMATION_PRACTICE_HOME);
			browser.findElement(By.id(SEARCH_INPUT_ID)).sendKeys(SEARCH_STRING);
			browser.findElement(By.name(SEARCH_BUTTON_NAME)).click();

			Thread.sleep(1000); // No es una buena practica, pero por ahora.....

			assertEquals(SEARCH_RESULTS_EXPECTED_TEXT,
					browser.findElement(By.className(SEARCH_RESULTS_EXPECTED_CLASSNAME)).getText());
		} finally {
			browser.quit();
		}

	}

	@Test
	void testSearchForShit() throws InterruptedException {

		// Variables del metodo - solo las podes usar dentro de este metodo
		final String SEARCH_INPUT_ID = "search_query_top";
		final String SEARCH_STRING = "shit";
		final String SEARCH_BUTTON_NAME = "submit_search";
		final String SEARCH_RESULTS_EXPECTED_CLASSNAME = "heading-counter";
		final String SEARCH_RESULTS_EXPECTED_TEXT = "0 results have been found.";

		WebDriver browser = new ChromeDriver();
		try {
			browser.manage().window().maximize();
			browser.get(AUTOMATION_PRACTICE_HOME);
			browser.findElement(By.id(SEARCH_INPUT_ID)).sendKeys(SEARCH_STRING);
			browser.findElement(By.name(SEARCH_BUTTON_NAME)).click();

			Thread.sleep(1000); // No es una buena practica, pero por ahora.....

			assertEquals(SEARCH_RESULTS_EXPECTED_TEXT,
					browser.findElement(By.className(SEARCH_RESULTS_EXPECTED_CLASSNAME)).getText());
		} finally {
			browser.quit();
		}
	}
}
