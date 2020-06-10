package com.openclassrooms.LesAmisDeLEscaladeApplication.validation;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.ModelAndView;

import com.openclassrooms.LesAmisDeLEscaladeApplication.controller.ClimbingSiteController;
import com.openclassrooms.LesAmisDeLEscaladeApplication.domain.ClimbingSiteItem;


@Component
public class ClimbingSiteValidator implements Validator {
	private final Logger logger = LoggerFactory.getLogger(ClimbingSiteController.class);
	private ModelAndView error;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return ClimbingSiteItem.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		error= new ModelAndView();
		logger.info("verification du formulaire via le validator");
		ClimbingSiteItem climbingSiteItem = (ClimbingSiteItem) target;
		

//		Integer id = climbingSiteItem.getId();
		String title = climbingSiteItem.getTitle();
//		String image= climbingSiteItem.getImage();
//		String secteur= climbingSiteItem.getSecteur();
//		int longueur= climbingSiteItem.getLongueur();
//		String difficulty = climbingSiteItem.getDifficulty();
//		boolean tagged= climbingSiteItem.isTagged();
//		int nombreDeVoies= climbingSiteItem.getNombreDeVoies();
		ValidationUtils.rejectIfEmpty(errors, "title", "climbingSite.title.empty", "Le titre est vide(généré depuis le validator)");
if(title.length() > 10) {
	
	errors.rejectValue("title", "climbingSite.title.too.long");
	error.addObject("title","titre trop long");
	logger.info("titre trop grand");
}
		
		
		
		
	}

	public ModelAndView getError() {
		return error;
	}

	

}
