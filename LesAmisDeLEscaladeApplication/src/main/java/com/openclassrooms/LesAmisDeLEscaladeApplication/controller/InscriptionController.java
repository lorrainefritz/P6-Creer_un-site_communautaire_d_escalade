package com.openclassrooms.LesAmisDeLEscaladeApplication.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InscriptionController {
	private final Logger logger = LoggerFactory.getLogger(AboutTheAssociationController.class);

	@GetMapping("/sInscrire")
	public ModelAndView getPageView() {
		logger.info("HTTP GET request received at /sInscrire URL");
		return new ModelAndView();
	}
}
