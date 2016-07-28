package se.fredin.playground.validation.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import se.fredin.playground.validation.PhoneNumberValidator;

@Documented
@Retention(RUNTIME)
@Constraint(validatedBy = PhoneNumberValidator.class)
@Target({ FIELD, METHOD, PARAMETER })
public @interface PhoneNumber {

	String message() default "{validation.person.phone.invalid}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
	
}
