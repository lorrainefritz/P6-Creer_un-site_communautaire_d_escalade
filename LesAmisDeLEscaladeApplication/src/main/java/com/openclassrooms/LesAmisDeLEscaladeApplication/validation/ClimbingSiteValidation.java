package com.openclassrooms.LesAmisDeLEscaladeApplication.validation;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.openclassrooms.LesAmisDeLEscaladeApplication.controller.ClimbingSiteController;
import com.openclassrooms.LesAmisDeLEscaladeApplication.domain.ClimbingSiteItem;

public class ClimbingSiteValidation {

	public static ClimbingSiteItem climbingSiteValidation(HttpServletRequest request) throws IOException {
		final Logger logger = LoggerFactory.getLogger(ClimbingSiteController.class);
		
		HashMap<String, String> inputError = new HashMap<>();
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String image = request.getParameter("image");
		String secteur = request.getParameter("secteur");
		int longueur=Integer.parseInt(request.getParameter("longueur"));
		String difficulty = request.getParameter("difficulty");
		boolean tagged = request.getParameter("tagged") != null;
		int nombreDeVoies = Integer.parseInt(request.getParameter("nombreDeVoies"));
		
		//validation du titre
		logger.info("validation du titre");
		
		if (title == null || title.trim().isEmpty()) {
			inputError.put("emptyTitle", "Merci de rentrer un titre");
		}
		if (title.length() > 10) {
			inputError.put("toLongTitle", "Merci de rentrer un titre < 10 charactères");
		}
		// validation de l'image
		logger.info("validation de l'image");
		
		 if (image == null || image.trim().isEmpty()) {
			 inputError.put("emptyImage", "Merci de rentrer une image");
		 }
		 if(!image.contains(".png")||!image.contains(".jpeg")) {
			 inputError.put("wrongFormatImage", "Merci de rentrer une image en jpeg ou en png");
		 }
		 //validation du secteur
		 logger.info("validation du secteur");
			if (secteur == null || secteur.trim().isEmpty()) {
				inputError.put("emptySecteur", "Merci de rentrer un Secteur");
			}
			if (secteur.length() > 10) {
				inputError.put("toLongSecteur", "Merci de rentrer un secteur < 10 charactères");
			}
		//validation longueur
			logger.info("validation de la longueur");
			try {
				longueur = Integer.parseInt(request.getParameter("longueur"));
				if(longueur>10000) {
				inputError.put("toLongLongueur", "Merci de rentrer une longueur < 10000 ");
				}
			
			} catch(NumberFormatException e){
				inputError.put("longueur", "La longueur est obligatoirement supérieure à 0");
			}
			if (inputError.size()==0) {
				return new ClimbingSiteItem(id, title,  image, secteur, longueur,  difficulty,
						 tagged,  nombreDeVoies);
			}
			else {
				request.setAttribute("inputError", inputError);
				return null;
			}
	}

}
