package com.openclassrooms.LesAmisDeLEscaladeApplication.validation;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.ModelAndView;

import com.openclassrooms.LesAmisDeLEscaladeApplication.controller.ClimbingSiteFormAndListController;
import com.openclassrooms.LesAmisDeLEscaladeApplication.entities.ClimbingSite;

@Component
public class ClimbingSiteValidator implements Validator {
	private final Logger logger = LoggerFactory.getLogger(ClimbingSiteFormAndListController.class);
	private ModelAndView error;

	@Override
	public boolean supports(Class<?> clazz) {
		return ClimbingSite.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		error = new ModelAndView();
		logger.info("verification du formulaire via le validator");
		ClimbingSite climbingSiteItem = (ClimbingSite) target;

//		Integer id = climbingSiteItem.getId();
		String title = climbingSiteItem.getTitle();
//		String image = climbingSiteItem.getImage();
		String secteur= climbingSiteItem.getSecteur();
		int longueur= climbingSiteItem.getLongueur();
		String difficulty = climbingSiteItem.getDifficulty();
		boolean tagged= climbingSiteItem.isTagged();
		int nombreDeVoies= climbingSiteItem.getNombreDeVoies();
		ValidationUtils.rejectIfEmpty(errors, "title", "climbingSite.title.empty",
				"Le titre est vide(généré depuis le validator)");

		//validation du titre
		if (title == null || title.trim().isEmpty()) {
			errors.rejectValue("title", "climbingSite.empty");
			error.addObject("title", "le champs de titre est vide merci de rentrer un titre");
			logger.info("le titre est vide");
		}
		if (title.length() > 10) {
			errors.rejectValue("title", "climbingSite.title.too.long");
			error.addObject("title", "Le titre est trop long. Merci de rentrer un titre plus court.");
			logger.info("titre trop grand");
		}
		
//		//validation de l'image
//		if (image == null || image.trim().isEmpty()) {
//			errors.rejectValue("image", "image.empty");
//			error.addObject("image", "le champs d'image est vide. Merci de rentrer une image.");
//			logger.info("l'image est vide");
//		}
//		 if(!image.contains(".png")&&!image.contains(".jpeg")&& image.length()<5){
//			errors.rejectValue("image", "image.wrong.format");
//			error.addObject("image","Merci de rentrer une image qui est au format jpeg ou png.");
//			logger.info("l'image est au mauvais format");
//		 }
		 
		 //validation du secteur
		 if (secteur == null || secteur.trim().isEmpty()) {
				errors.rejectValue("secteur", "secteur.empty");
				error.addObject("secteur", "le champs du secteur est vide. Merci de rentrer un secteur.");
				logger.info("le secteur est vide");
			}
		 //validation du nombre de voies
		 if(nombreDeVoies<=0) {
			 errors.rejectValue("nombreDeVoies", "nombreDeVoies.empty.or.negativ");
				error.addObject("nombreDeVoies", "Merci de rentrer un nombre de voies supérieur à 0.");
				logger.info("nombre de voies");
		 }
		 if(nombreDeVoies>10) {
			 errors.rejectValue("nombreDeVoies", "nombreDeVoies.too.long");
				error.addObject("nombreDeVoies", "Merci de rentrer un nombre de voies inférieur à 10.");
				logger.info("nombre de voies");
		 }
		 //validation de la longueur
		 if(longueur<=0) {
			 errors.rejectValue("longueur", "longueur.empty.or.negativ");
				error.addObject("longueur", "Merci de rentrer une longueur de parcours supérieure à 0.");
				logger.info("longueur <ou = à 0");
		 }
		 if(longueur>100) {
			 errors.rejectValue("longueur", "longueur.width");
				error.addObject("longueur", "Merci de rentrer une longueur de parcours inférieure à 1000.");
				logger.info("longueur > 1000");
		 }
		 
	}

	public ModelAndView getError() {
		return error;
	}

}
