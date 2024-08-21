package br.gov.caixa.sigic.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**.
 * Objetivo: Anotacao para mapear campos a serem enviados para um book cobol
 * Nome: In
 * @author c112460
 * @sicpc 06/08/2013
 * @version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Inherited
public @interface In {
	String nome() default "";
	int beginIndex();
	int length() default 1 ;
	boolean numeric() default false;
	String className() default "";
}
