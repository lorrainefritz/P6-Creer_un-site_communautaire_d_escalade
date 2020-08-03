package com.openclassrooms.LesAmisDeLEscaladeApplication.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.openclassrooms.LesAmisDeLEscaladeApplication.entity.ClimbingSiteItem;
import com.openclassrooms.LesAmisDeLEscaladeApplication.exception.DuplicateTitleException;
import com.openclassrooms.LesAmisDeLEscaladeApplication.service.ClimbingSiteService;

import com.openclassrooms.LesAmisDeLEscaladeApplication.validation.ClimbingSiteValidator;

@Controller
public class ClimbingSiteController {

	@Autowired
	private ClimbingSiteService climbingSiteService;
	private final Logger logger = LoggerFactory.getLogger(ClimbingSiteController.class);

	@Autowired
	ClimbingSiteValidator climbingSiteValidator;

	@GetMapping("/ajouterDesSitesDEscalade")
	public ModelAndView showClimbingSiteItemForm(@RequestParam(required = false) Integer id) {
		logger.info("HTTP GET request received at /ajouterDesSitesDEscalade");

		String viewName = "ajouterDesSitesDEscalade";
		Map<String, Object> model = new HashMap<String, Object>();
		ClimbingSiteItem climbingSiteItem = climbingSiteService.findClimbingSiteById(id);
		if (climbingSiteItem == null) {
			model.put("ClimbingSiteItem", new ClimbingSiteItem());
		} else {
			model.put("ClimbingSiteItem", climbingSiteItem);
		}
		return new ModelAndView(viewName, model);
	}

	@PostMapping("/ajouterDesSitesDEscalade")
	public ModelAndView submitClimbingSiteItemForm(
			@Valid @ModelAttribute("climbingSiteItem") ClimbingSiteItem climbingSiteItem, BindingResult bindingResult) {

		climbingSiteValidator.validate(climbingSiteItem, bindingResult);

		ModelAndView mw = new ModelAndView();
//
		mw.addObject("error", "global.error");

		logger.info("HTTP POST request received at /ajouterDesSitesDEscalade URL");
		if (bindingResult.hasErrors()) {

			logger.info("HTTP POST request received at /ajouterDesSitesDEscalade URL with errors in the form");

//			return new ModelAndView("ajouterDesSitesDEscalade");
			return climbingSiteValidator.getError();
		}
		try {
			climbingSiteService.addOrUpdateClimbingSiteItem(climbingSiteItem);
		} catch (DuplicateTitleException e) {
			bindingResult.rejectValue("secteur", "", "Ce site d'escalade existe déjà");
			return new ModelAndView("ajouterDesSitesDEscalade");
		}
		RedirectView redirect = new RedirectView();
		redirect.setUrl("/listeDesSitesDEscalade");
		return new ModelAndView(redirect);
	}

	public ClimbingSiteValidator getClimbingSiteValidator() {
		return climbingSiteValidator;
	}

	public void setClimbingSiteValidator(ClimbingSiteValidator climbingSiteValidator) {
		this.climbingSiteValidator = climbingSiteValidator;
	}

	@GetMapping("/listeDesSitesDEscalade")
	public ModelAndView getClimbingSiteList() {
		logger.info("HTTP GET request received at /listeDesSitesDEscalade URL pour ClimbingSiteList");
		String viewName = "listeDesSitesDEscalade";
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("climbingSiteItems", climbingSiteService.getClimbingSiteItems());
		model.put("numberOfclimbingSite", climbingSiteService.getClimbinSiteListSize());
		return new ModelAndView(viewName, model);
	}
	
//	@GetMapping("/modifierUnSiteDEscalade")
//	public ModelAndView ShowAClimbingSiteItemForEdit(@RequestParam(required = false)Integer id) {
//		logger.info("HTTP GET request received at /modifierUnSiteDEscalade");
//	}
	
	
//	@PostMapping("/modifierUnSiteDEscalade")
//	public ModelAndView editClimbingSiteList(@Valid @ModelAttribute("climbingSiteItem") ClimbingSiteItem climbingSiteItem, BindingResult bindingResult) {
//		logger.info("HTTP POST request received at /listeDesSitesDEscalade URL pour ClimbingSiteList");
//		climbingSiteValidator.validate(climbingSiteItem, bindingResult);
//		ModelAndView mw = new ModelAndView();
//		
//		if(bindingResult.hasErrors()) {
//			logger.info("HTTP POST request received at /listeDesSitesDEscalade URL with errors in the form");
//			return climbingSiteValidator.getError();
//		}
//		
//	}

}
