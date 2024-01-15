package org.educationit.cursoSelenium.claseTres;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTestNg {
  @Test
  public void testSuma() {
	  int a = 3;
	  int b = 5;
	   Assert.assertEquals(8, a+b);
  }
}
