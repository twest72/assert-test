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

public class TestClass {

  public TestClass() {
    super();
  }

  public TestClass(@NotNull(parameterName = "kNotNull") Integer kNotNull) {
    super();
    System.out.println("    kNotNull: " + kNotNull);
  }

  public void methodWithOneNotNullArg(
      @NotNull(parameterName = "aNotNull") Integer aNotNull) {
    System.out.println("    aNotNull: " + aNotNull);
  }

  public void methodWithOneNotNullArg(Long b,
      @NotNull(parameterName = "cNotNull") Integer cNotNull) {
    System.out.println("    b       : " + b);
    System.out.println("    cNotNull: " + cNotNull);
  }

  public void methodWithTwoNotNullArg(
      @NotNull(parameterName = "dNotNull") Integer dNotNull,
      @NotNull Integer eNotNull) {
    System.out.println("    dNotNull: " + dNotNull);
    System.out.println("    eNotNull: " + eNotNull);
  }

  public void methodWithoutNotNullArg(Long f) {
    System.out.println("    f       : " + f);
  }
}
