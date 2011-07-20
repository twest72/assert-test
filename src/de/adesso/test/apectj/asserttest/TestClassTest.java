package de.adesso.test.apectj.asserttest;

import junit.framework.Assert;

import org.junit.Test;

public class TestClassTest {

  private TestClass testClass = new TestClass();

  @Test
  public void testMethodWithOneNotNullArgInteger() {
    testClass.methodWithOneNotNullArg(1);
  }

  @Test
  public void testMethodWithOneNotNullArgIntegerNull() {
    try {
      testClass.methodWithOneNotNullArg(null);
      Assert.fail("Hier wurde eine IllegalArgumentException erwartet.");
    } catch (IllegalArgumentException e) {
      Assert.assertNotNull(e);
      System.err.println("    " + e.getMessage());
    }
  }

  @Test
  public void testMethodWithOneNotNullArgIntegerInteger() {
    testClass.methodWithOneNotNullArg(11l, 11);
  }

  @Test
  public void testMethodWithOneNotNullArgIntegerIntegerNull1() {
    testClass.methodWithOneNotNullArg(null, 11);
  }

  @Test
  public void testMethodWithOneNotNullArgIntegerIntegerNull2() {
    try {
      testClass.methodWithOneNotNullArg(11l, null);
      Assert.fail("Hier wurde eine IllegalArgumentException erwartet.");
    } catch (IllegalArgumentException e) {
      Assert.assertNotNull(e);
      System.err.println("    " + e.getMessage());
    }
  }

  @Test
  public void testMethodWithOneNotNullArgIntegerIntegerNullNull() {
    try {
      testClass.methodWithOneNotNullArg(null, null);
      Assert.fail("Hier wurde eine IllegalArgumentException erwartet.");
    } catch (IllegalArgumentException e) {
      Assert.assertNotNull(e);
      System.err.println("    " + e.getMessage());
    }
  }

  @Test
  public void testMethodWithTwoNotNullArg() {
    testClass.methodWithTwoNotNullArg(111, 111);
  }

  @Test
  public void testMethodWithTwoNotNullArgNull1() {
    try {
      testClass.methodWithTwoNotNullArg(null, 222);
      Assert.fail("Hier wurde eine IllegalArgumentException erwartet.");
    } catch (IllegalArgumentException e) {
      Assert.assertNotNull(e);
      System.err.println("    " + e.getMessage());
    }
  }

  @Test
  public void testMethodWithTwoNotNullArgNull2() {
    try {
      testClass.methodWithTwoNotNullArg(222, null);
      Assert.fail("Hier wurde eine IllegalArgumentException erwartet.");
    } catch (IllegalArgumentException e) {
      Assert.assertNotNull(e);
      System.err.println("    " + e.getMessage());
    }
  }

  @Test
  public void testMethodWithTwoNotNullArgNullNull() {
    try {
      testClass.methodWithTwoNotNullArg(null, null);
      Assert.fail("Hier wurde eine IllegalArgumentException erwartet.");
    } catch (IllegalArgumentException e) {
      Assert.assertNotNull(e);
      System.err.println("    " + e.getMessage());
    }
  }

  @Test
  public void testMethodWithoutNotNullArg() {
    testClass.methodWithoutNotNullArg(null);
  }

  @Test
  public void testMethodWithoutNotNullArgNull() {
    testClass.methodWithoutNotNullArg(null);
  }

  @Test
  public void testConstructorWithNotNullArg() {
    new TestClass(999);
  }

  @Test
  public void testConstructorWithNotNullArgNull() {
    try {
      new TestClass(null);
      Assert.fail("Hier wurde eine IllegalArgumentException erwartet.");
    } catch (IllegalArgumentException e) {
      Assert.assertNotNull(e);
      System.err.println("    " + e.getMessage());
    }
  }
}
