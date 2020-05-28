package com.openclassrooms.LesAmisDeLEscaladeApplication.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.openclassrooms.LesAmisDeLEscaladeApplication.domain.ClimbingSiteItem;

public class VerificationDuNombreDeVoiesValidator implements ConstraintValidator<VerificationDuNombreDeVoies, ClimbingSiteItem> {

	@Override
	public boolean isValid(ClimbingSiteItem value, ConstraintValidatorContext context) {
		
		return value.getNombreDeVoies()>1&& value.getNombreDeVoies()<100;
	}

	
}
