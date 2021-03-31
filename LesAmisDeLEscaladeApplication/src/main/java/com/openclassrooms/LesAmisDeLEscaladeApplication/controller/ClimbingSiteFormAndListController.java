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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.openclassrooms.LesAmisDeLEscaladeApplication.entities.ClimbingSite;
import com.openclassrooms.LesAmisDeLEscaladeApplication.exception.DuplicateTitleException;
import com.openclassrooms.LesAmisDeLEscaladeApplication.service.ClimbingSiteService;

import com.openclassrooms.LesAmisDeLEscaladeApplication.validation.ClimbingSiteValidator;

@Controller
public class ClimbingSiteFormAndListController {

	@Autowired
	private ClimbingSiteService climbingSiteService;
	private final Logger logger = LoggerFactory.getLogger(ClimbingSiteFormAndListController.class);

	@GetMapping("/ajouterDesSitesDEscalade")
	public String showClimbingSiteForm(Model model) {
		logger.info("HTTP GET request received at /ajouterDesSitesDEscalade");
		model.addAttribute("climbingSite", new ClimbingSite());
		return "ajouterDesSitesDEscalade";
	}

	@PostMapping("/ajouterDesSitesDEscalade")
	public String submitClimbingSiteForm(@Validated @ModelAttribute("climbingSite") ClimbingSite climbingSite,
			BindingResult bindingResult) {
		logger.info("HTTP POST request received at /ajouterDesSitesDEscalade");
		if (bindingResult.hasErrors()) {
			logger.info("HTTP POST request received at /ajouterDesSitesDEscalade in bindingResult.hasErrors");
			return "/ajouterDesSitesDEscalade";
		} else {
			logger.info("chocolat ajouté avec les valeurs suivantes : " + "id= " + climbingSite.getId() + " titre "
					+ climbingSite.getTitle() + " lieu= " + climbingSite.getLieu() + " longueur="
					+ climbingSite.getLongueur() + " nombre de voies=" + climbingSite.getNombreDeVoies() + " secteur ="
					+ climbingSite.getSecteur() + " difficulté=" + climbingSite.getDifficulty() + " est taggé="
					+ climbingSite.isTagged());
			climbingSiteService.addClimbingSite(climbingSite);
		}
		return "redirect:/listeDesSitesDEscalade";
	}
	@GetMapping("/listeDesSitesDEscalade")
	public String getClimbingSiteList(Model model) {
		logger.info("HTTP GET request received at /listeDesSitesDEscalade");
		model.addAttribute("climbingSites", climbingSiteService.getAllClimbingSites());
		return "listeDesSitesDEscalade";
	}
	@GetMapping(path="/editClimbingSite")
	public String editClimbingSite(Model model, Integer id) {
		logger.info("HTTP GET received at /editClimbingSite" + id);
		ClimbingSite climbingSite = climbingSiteService.getOneClimbingSiteById(id);
		model.addAttribute("climbingSite",climbingSite);
		return "ajouterDesSitesDEscalade";
	}
	
	@GetMapping("/deleteClimbingSite")
	public String deleteClimbingSite(Integer id) {
		logger.info("HTTP GET received at /deleteClimbingSite" +id);
		climbingSiteService.deleteClimbingSite(id);
		 return "redirect:/listeDesSitesDEscalade";
	}
	
	
}
