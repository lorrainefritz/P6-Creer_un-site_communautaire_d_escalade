package com.openclassrooms.LesAmisDeLEscaladeApplication.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ToposController {
	private final Logger logger = LoggerFactory.getLogger(ToposController.class);
	
@GetMapping("/listeDesTopos")	
	public ModelAndView getToposList() {
	logger.info("HTTP GET request received at /listeDesTopos URL");
	String viewName ="listeDesTopos";
	return new ModelAndView ();
	
}
	
}
