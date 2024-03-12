package org.educationitSelenium.claseTres.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTestNG {
  @Test
  public void testSumar() {
	  int a = 2;
	  int b = 3;
	  Assert.assertEquals(5, a+b);
  }
  
  @Test
  public void testRestar() {
	  int a = 4;
	  int b = 3;
	  Assert.assertEquals(1, a-b);
  }
}
