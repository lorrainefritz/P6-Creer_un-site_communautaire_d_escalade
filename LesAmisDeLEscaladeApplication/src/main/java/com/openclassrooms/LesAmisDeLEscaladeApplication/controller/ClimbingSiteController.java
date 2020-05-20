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

	@RequestMapping("/test")
	public String showHome() {
		String viewHome = "home";
		return viewHome;
	}
	
	@GetMapping("/climbingSiteItemForm")
	public ModelAndView showClimbingSiteItemForm(@RequestParam(required = false) Integer id) {
		logger.info("HTTP GET request received at /climbingSiteItemForm URL");

		String viewName = "climbingSiteItemForm";
		Map<String, Object> model = new HashMap<String, Object>();
		ClimbingSiteItem climbingSiteItem = climbingSiteService.findClimbingSiteById(id);
		if (climbingSiteItem == null) {
			model.put("ClimbingSiteItem", new ClimbingSiteItem());
		} else {
			model.put("ClimbingSiteItem", climbingSiteItem);
		}
		return new ModelAndView(viewName, model);
	}

	@PostMapping("/climbingSiteItemForm")
	public ModelAndView submitClimbingSiteItemForm(@Valid ClimbingSiteItem climbingSiteItem,
			BindingResult bindingResult) {
		logger.info("HTTP POST request received at /climbingSiteItemForm URL");
		if (bindingResult.hasErrors()) {
			return new ModelAndView("climbingSiteItemForm");
		}
		try {
			climbingSiteService.addOrUpdateClimbingSiteItem(climbingSiteItem);
		} catch (DuplicateTitleException e) {
			bindingResult.rejectValue("secteur", "", "Ce site d'escalade existe déjà");
			return new ModelAndView("climbingSiteItemForm");
		}
		RedirectView redirect = new RedirectView();
		redirect.setUrl("/climbingSiteList");
		return new ModelAndView(redirect);
	}

	@GetMapping("/climbingSiteList")
	public ModelAndView getClimbingSiteList() {
		logger.info("HTTP GET request received at /climbingSiteList URL");
		String viewName = "climbingSiteList";
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("climbingSiteItem", climbingSiteService.getClimbingSiteItems());
		model.put("numberOfclimbingSite", climbingSiteService.getClimbinSiteListSize());

		return new ModelAndView(viewName, model);
	}

}
