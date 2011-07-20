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

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.text.MessageFormat;

import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.ConstructorSignature;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class CheckArgumentsAspect {

  /**
   * Der Pointcut trifft auf alle Methoden in allen Packages zu, die
   * mindestens einen Parameter mit der Annotation {@link NotNull} besitzen.
   */
  @Around("execution(* *(..,@NotNull (*),..))")
  public Object checkArgsForMethod(ProceedingJoinPoint joinPoint)
      throws Throwable {

    if (joinPoint.getSignature() instanceof MethodSignature) {

      MethodSignature methodSignature = (MethodSignature) joinPoint
          .getSignature();
      Method method = methodSignature.getMethod();
      Class<?>[] parameterTypes = method.getParameterTypes();
      Annotation[][] parameterAnnotationArray = method
          .getParameterAnnotations();

      System.out.println("Prüfe Parameter der Methode '"
          + methodSignature.toLongString() + "' mit den Parameterwerten '"
          + joinPoint.getArgs() + "'.");

      // Prüft alle Parameter
      checkParameter(joinPoint.getArgs(), parameterTypes,
          parameterAnnotationArray, methodSignature.toLongString());
    }

    return joinPoint.proceed();
  }

  /**
   * Der Pointcut trifft auf alle Konstruktoren zu, die mindestens einen
   * Parameter mit der Annotation {@link NotNull} besitzen.
   */
  @Around("execution(new(..,@NotNull (*),..))")
  public Object checkArgsForConstructor(ProceedingJoinPoint joinPoint)
      throws Throwable {

    if (joinPoint.getSignature() instanceof ConstructorSignature) {

      ConstructorSignature constructorSignature = (ConstructorSignature) joinPoint
          .getSignature();
      Constructor<?> constructor = constructorSignature.getConstructor();
      Class<?>[] parameterTypes = constructor.getParameterTypes();
      Annotation[][] parameterAnnotationArray = constructor
          .getParameterAnnotations();

      System.out.println("Prüfe Parameter des Konstruktors '"
          + constructorSignature.toLongString()
          + "' mit den Parameterwerten '" + joinPoint.getArgs() + "'.");

      // Prüft alle Parameter
      checkParameter(joinPoint.getArgs(), parameterTypes,
          parameterAnnotationArray, constructorSignature.toLongString());
    }

    return joinPoint.proceed();
  }

  /**
   * Prüft alle Parameter.
   * 
   * @param parameter
   *          Alle Parameter.
   * @param parameterTypes
   *          Die Typen zu den Parametern.
   * @param parameterAnnotationArray
   *          Die Annotations zu den Parametern.
   * @param signature
   *          Die Signatur der Methode oder des Konstruktors.
   */
  private void checkParameter(Object[] parameter, Class<?>[] parameterTypes,
      Annotation[][] parameterAnnotationArray, String signature) {

    for (int i = 0; i < parameterTypes.length; i++) {

      Annotation[] parameterAnnotations = parameterAnnotationArray[i];

      for (Annotation annotation : parameterAnnotations) {

        if (annotation instanceof NotNull) {

          // Hier wird das Argument auf null geprüft
          checkNotNull(parameter[i], parameterTypes[i], i,
              ((NotNull) annotation).parameterName(), signature);
        }
      }
    }
  }

  /**
   * Prüft den Parameter auf null.
   * 
   * @param parameter
   *          Der Parameter.
   * @param parameterType
   *          Der Typ des Parameters.
   * @param parameterIndex
   *          Der Index des Parameters.
   * @param parameterName
   *          Der Name des Parameters.
   * @param signature
   *          Die Signatur der Methode oder des Konstruktors.
   */
  private void checkNotNull(Object parameter, Class<?> parameterType,
      int parameterIndex, String parameterName, String signature) {

    // Hier wird das Argument auf null geprüft
    if (parameter == null) {

      if (StringUtils.isBlank(parameterName)) {
        parameterName = "-";
      }

      String longMsg = MessageFormat.format(
          "Fehler: Der {0}. Parameter (Name: {1}, Typ: {2}) von {3} "
              + "ist null.", parameterIndex + 1, parameterName,
          parameterType.getName(), signature);
      throw new IllegalArgumentException(longMsg);
    }
  }
}
