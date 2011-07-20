/* Copyright (c) 2011, Thomas Westphal
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 * 
 * - Redistributions of source code must retain the above copyright notice,
 *   this list of conditions and the following disclaimer.
 * 
 * - Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
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
