package com.example.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**.
 * Objetivo: Anotacao para mapear campos a serem enviados ou retornados de um book cobol
 * Nome: Collection
 * @author c112460
 * @sicpc 06/08/2013
 * @version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Inherited
public @interface Collection {
	int ocorrences();
	int length();
	String className() default "";
	Class<?> type() default Void.class;
}
