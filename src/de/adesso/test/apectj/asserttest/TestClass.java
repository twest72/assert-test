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
