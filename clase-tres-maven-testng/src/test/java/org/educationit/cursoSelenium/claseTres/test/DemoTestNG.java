package org.educationit.cursoSelenium.claseTres.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTestNG {
  @Test
  public void testSumar() {
	  int a = 3;
	  int b = 5;
	  Assert.assertEquals(8, a+b);
	  
  }
}
