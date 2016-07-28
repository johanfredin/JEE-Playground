package se.fredin.playground;

import java.util.Set;

import javax.validation.ConstraintViolation;
import static org.junit.Assert.fail;

public class PropertyValidator<T> {
	
	public void assertPropertyIsInvalid(String property, Set<ConstraintViolation<T>> violations) {

		boolean errorFound = false;
		for (ConstraintViolation<T> constraintViolation : violations) {
			if (constraintViolation.getPropertyPath().toString().equals(property)) {
				errorFound = true;
				break;
			}
		}

		if (!errorFound) {
			fail("Expected validation error for '" + property + "', but no such error exists");
		}
	}

}
