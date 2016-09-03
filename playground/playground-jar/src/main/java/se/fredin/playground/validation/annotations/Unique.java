package se.fredin.playground.validation.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import se.fredin.playground.validation.UniqueValidator;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=UniqueValidator.class)
@Target(ElementType.TYPE)
public @interface Unique {
	
	String message() default "Not a unique value";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
