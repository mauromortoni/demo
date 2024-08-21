package com.example.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**.
 * Objetivo: Anotacao para mapear campos a serem validados no DTO
 * Nome: Coluna
 * @author Mauro Mortoni
 * @demo 20/08/2024
 * @version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Inherited
public @interface Coluna {
	String nome() default "";
	int min() default 1;
	int max() default 1;
	boolean anulavel() default false;
	TipoDadoEngineEnum tipo()  default TipoDadoEngineEnum.CHARACTER;
	String className() default "";
	String regexp() default "";
	String mensagem() default "";
}
/*
class User{
@NotNull
@Pattern(regexp=".+@.+\\.[a-z]+", message="Invalid email address!")
private String email;
}
 */
