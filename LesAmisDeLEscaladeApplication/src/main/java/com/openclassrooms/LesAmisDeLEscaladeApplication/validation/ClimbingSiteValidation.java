package com.openclassrooms.LesAmisDeLEscaladeApplication.validation;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.openclassrooms.LesAmisDeLEscaladeApplication.domain.ClimbingSiteItem;

public class ClimbingSiteValidation {

	public static ClimbingSiteItem climbingSiteValidation(HttpServletRequest request) throws IOException {

		request.setCharacterEncoding("UFT-8");
		HashMap<String, String> inputError = new HashMap<>();
		//validation du titre
		String title = request.getParameter("title");
		if (title == null || title.trim().isEmpty()) {
			inputError.put("emptyTitle", "Merci de rentrer un titre");
		}
		if (title.length() > 10) {
			inputError.put("toLongTitle", "Merci de rentrer un titre < 10 charactères");
		}
		// validation de l'image
		String image = request.getParameter("image");
	}

}
