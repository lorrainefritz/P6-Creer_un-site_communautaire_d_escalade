package com.openclassrooms.LesAmisDeLEscaladeApplication.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.openclassrooms.LesAmisDeLEscaladeApplication.domain.ClimbingSiteItem;
import com.openclassrooms.LesAmisDeLEscaladeApplication.exception.DuplicateTitleException;
import com.openclassrooms.LesAmisDeLEscaladeApplication.service.ClimbingSiteService;

@Controller
public class ClimbingSiteController {

	@Autowired
	private ClimbingSiteService climbingSiteService;
	private final Logger logger = LoggerFactory.getLogger(ClimbingSiteController.class);

	
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
	public ModelAndView submitClimbingSiteItemForm(@Valid ClimbingSiteItem climbingSiteItem,
			BindingResult bindingResult) {
		ModelAndView mw= new ModelAndView();
		mw.addObject("error", "global.error");
		mw.addObject("titleError", "Cornet de frites");
		
		logger.info("HTTP POST request received at /ajouterDesSitesDEscalade URL");
		if (bindingResult.hasErrors()) {
//			return new ModelAndView("ajouterDesSitesDEscalade");
			logger.info("HTTP POST request received at /ajouterDesSitesDEscalade URL with errors in the form");
			return mw;
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

	@GetMapping("/listeDesSitesDEscalade")
	
	public ModelAndView getClimbingSiteList() {
		logger.info("HTTP GET request received at /listeDesSitesDEscalade URL");
		String viewName = "listeDesSitesDEscalade";
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("climbingSiteItems", climbingSiteService.getClimbingSiteItems());
		model.put("numberOfclimbingSite", climbingSiteService.getClimbinSiteListSize());
		

		return new ModelAndView(viewName, model);
	}

}


