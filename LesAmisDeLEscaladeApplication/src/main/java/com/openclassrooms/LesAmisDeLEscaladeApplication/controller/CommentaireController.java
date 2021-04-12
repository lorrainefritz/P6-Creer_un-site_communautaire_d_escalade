package com.openclassrooms.LesAmisDeLEscaladeApplication.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.openclassrooms.LesAmisDeLEscaladeApplication.entities.ClimbingSite;
import com.openclassrooms.LesAmisDeLEscaladeApplication.entities.Commentaire;
import com.openclassrooms.LesAmisDeLEscaladeApplication.entities.Topo;
import com.openclassrooms.LesAmisDeLEscaladeApplication.entities.User;
import com.openclassrooms.LesAmisDeLEscaladeApplication.service.ClimbingSiteService;
import com.openclassrooms.LesAmisDeLEscaladeApplication.service.CommentaireService;
import com.openclassrooms.LesAmisDeLEscaladeApplication.service.UserServiceImplementation;

@Controller
public class CommentaireController {
	@Autowired
	UserServiceImplementation userServiceImp;
	@Autowired
	ClimbingSiteService climbingSiteService;
	@Autowired
	CommentaireService commentaireService;
	ClimbingSite currentClimbingSite;
	User currentLoggedUser;
	private final Logger logger = LoggerFactory.getLogger(CommentaireController.class);
	
	
//	@GetMapping("/listeDesCommentaires")
//	public String getCommentaireList(Integer id, Model model) {
//	logger.info("HTTP GET request received at /listeDesCommentaires URL");
//	currentClimbingSite = climbingSiteService.getOneClimbingSiteById(id);
//	model.addAttribute("commentaires", currentClimbingSite.getCommentaires());
//	model.addAttribute("currentClimbingSiteId", id);
//	return("listeDesCommentaires");
//	}
	
//	@GetMapping("ajouterUnCommentaire")
//	public String ShowCommentaireForm(Model model) {
//		logger.info("HTTP GET request received at /ajouterUnCommentaire URL");
//		UserDetails userPrincipal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		currentLoggedUser = userServiceImp.findUserOnEmail(userPrincipal.getUsername());
//		Commentaire commentaire = new Commentaire();
//		commentaire.setCreationDateTime(new Date());
//		logger.info("NOM UTILISATEUR " + currentLoggedUser.getPrenom());
//		model.addAttribute("currentuser", currentLoggedUser);
//		model.addAttribute("commentaire",commentaire);
//		return ("ajouterUnCommentaire");
//	}
//	
//	@PostMapping("ajouterUnCommentaire")
//	public String submitCommentaireForm(@ModelAttribute("commentaire") Commentaire commentaire) {
//		logger.info("HTTP POST request received at /ajouterUnCommentaire URL");
//		logger.info("On ajoute le commentaire avec les valeurs suivantes : id " + commentaire.getId() + " titre " + commentaire.getTitle()
//		+ " content " + commentaire.getContent() + " date " + commentaire.getCreationDateTime());
//		userServiceImp.addUserCommentaire(currentLoggedUser,commentaire);
//		climbingSiteService.addClimbingSiteCommentaire(currentClimbingSite,commentaire);
//		return ("redirect:/listeDesCommentaires");
//	}
//	@GetMapping("/deleteCommentaire")
//	public String deleteCommentaire(Integer custStat, Integer id) {
//		logger.info("HTTP GET request received at /deleteCommentaire URL");
//		logger.info("on delete le commentaire avec l'id suivante" + id);
//		userServiceImp.deleteUserCommentaireWithId(currentLoggedUser,custStat);
//		climbingSiteService.deleteCommentaireWithId(currentClimbingSite,custStat);
//		commentaireService.deleteCommentaire(id);
//		return ("redirect:/listeDesCommentaires");
//		
//	}
	
}
