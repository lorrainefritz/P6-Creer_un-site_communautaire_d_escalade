package com.openclassrooms.LesAmisDeLEscaladeApplication.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;



@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = VerificationDuNombreDeVoiesValidator.class)
public @interface VerificationDuNombreDeVoies {
	String message()default"Rentrez un nombre entre 1 et 100";
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default{};

}
