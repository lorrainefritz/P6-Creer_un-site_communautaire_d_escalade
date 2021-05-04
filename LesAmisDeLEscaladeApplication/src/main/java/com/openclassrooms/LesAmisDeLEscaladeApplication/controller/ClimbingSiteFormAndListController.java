package com.openclassrooms.LesAmisDeLEscaladeApplication.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.apache.tomcat.jni.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.openclassrooms.LesAmisDeLEscaladeApplication.entities.ClimbingSite;
import com.openclassrooms.LesAmisDeLEscaladeApplication.exception.DuplicateTitleException;
import com.openclassrooms.LesAmisDeLEscaladeApplication.service.ClimbingSiteService;

@Controller
public class ClimbingSiteFormAndListController {

	@Autowired
	private ClimbingSiteService climbingSiteService;
	private final Logger logger = LoggerFactory.getLogger(ClimbingSiteFormAndListController.class);
	private ClimbingSite currentClimbingSite;

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
			logger.info("site d'escalade ajouté avec les valeurs suivantes : " + "id= " + climbingSite.getId()
					+ " titre " + climbingSite.getTitle() + " lieu= " + climbingSite.getLieu() + " longueur="
					+ climbingSite.getLongueur() + " nombre de voies=" + climbingSite.getNombreDeVoies() + " secteur ="
					+ climbingSite.getSecteur() + " difficulté=" + climbingSite.getDifficulty() + " est taggé="
					+ climbingSite.isTagged());
			climbingSiteService.addClimbingSite(climbingSite);
			
		}
		return "redirect:/listeDesSitesDEscalade";
	}
	@Transactional
	@GetMapping("/ajouterUneImageAuSiteDescalade")
	public String showImageForm(Model model, Integer id) {
		logger.info("HTTP GET request received at /ajouterUneImageAuSiteDescalade");
		currentClimbingSite =climbingSiteService.getOneClimbingSiteById(id);
		model.addAttribute("climbingSite", currentClimbingSite );
		return "ajouterUneImageAuSiteDescalade";
	}

	@PostMapping("/ajouterUneImageAuSiteDescalade")
	public String submitImageForm(@RequestParam("fileImage") MultipartFile fileImage) {
		logger.info("HTTP POST request received at /ajouterUneImageAuSiteDescalade");
			logger.info("image ajoutée avec la valeur suivante" + fileImage.getContentType());
			climbingSiteService.addImageToClimbingSite(currentClimbingSite, fileImage);
		
		return "redirect:/listeDesSitesDEscalade";

	}


	@GetMapping("/listeDesSitesDEscalade")
	public String getClimbingSiteList(Model model, @Param("keyword") String keyword) {
		logger.info("HTTP GET request received at /listeDesSitesDEscalade");
		if (keyword != null) {
			logger.info("HTTP GET request received at /listeDesSitesDEscalade + keyword " + keyword);
			model.addAttribute("climbingSites", climbingSiteService.getClimbingSitesSearchingByKeyword(keyword));
			model.addAttribute("keyword", keyword);
		} else {
			model.addAttribute("climbingSites", climbingSiteService.getAllClimbingSites());
		}
		return "listeDesSitesDEscalade";
	}



	@GetMapping(path = "/editClimbingSite")
	public String editClimbingSite(Model model, Integer id) {
		logger.info("HTTP GET received at /editClimbingSite" + id);
		ClimbingSite climbingSite = climbingSiteService.getOneClimbingSiteById(id);
		model.addAttribute("climbingSite", climbingSite);
		return "ajouterDesSitesDEscalade";
	}

	@GetMapping("/deleteClimbingSite")
	public String deleteClimbingSite(Integer id) {
		logger.info("HTTP GET received at /deleteClimbingSite" + id);
		climbingSiteService.deleteClimbingSite(id);
		return "redirect:/listeDesSitesDEscalade";
	}

}
