package com.openclassrooms.LesAmisDeLEscaladeApplication.controller;

import java.security.Principal;
import java.time.Instant;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.hibernate.type.CalendarDateType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.openclassrooms.LesAmisDeLEscaladeApplication.entities.ClimbingSite;
import com.openclassrooms.LesAmisDeLEscaladeApplication.entities.Commentaire;
import com.openclassrooms.LesAmisDeLEscaladeApplication.entities.Topo;
import com.openclassrooms.LesAmisDeLEscaladeApplication.entities.User;
import com.openclassrooms.LesAmisDeLEscaladeApplication.service.ClimbingSiteService;
import com.openclassrooms.LesAmisDeLEscaladeApplication.service.CommentaireService;
import com.openclassrooms.LesAmisDeLEscaladeApplication.service.TopoService;
import com.openclassrooms.LesAmisDeLEscaladeApplication.service.UserServiceImplementation;

@Controller
public class IdentificationFormController {
	@Autowired
	UserServiceImplementation userServiceImp;
	@Autowired
	TopoService topoService;
	@Autowired
	ClimbingSiteService climbingSiteService;
	@Autowired
	CommentaireService commentaireService;

	private final Logger logger = LoggerFactory.getLogger(IdentificationFormController.class);
	private UserDetails userPrincipal;
	private User currentLoggedUser;
	private ClimbingSite currentClimbingSite;

	@GetMapping("/seConnecter")
	public String showLoginForm() {
		logger.info(" HTTP GET received at /login");
		return "seConnecter";
	}

	@GetMapping("/monCompte")
	public String showCompte(Authentication authentication, Model model) {
		logger.info(" HTTP GET received at /monCompte");
		userPrincipal = (UserDetails) authentication.getPrincipal();
		currentLoggedUser = userServiceImp.findUserOnEmail(userPrincipal.getUsername());
		model.addAttribute("curentuser", currentLoggedUser);
		model.addAttribute("principal", userPrincipal);
		model.addAttribute("topos", currentLoggedUser.getTopos());
		return "monCompte";
	}

//______________________________ Les Topos______________________________________	
	@GetMapping("/ajouterUnTopo")
	public String showTopoForm(Model model) {
		logger.info("HTTP GET received at /addTopoToList ");
		logger.info("user " + currentLoggedUser.getNom());
		model.addAttribute("topo", new Topo());
		return ("ajouterUnTopo");

	}

	@PostMapping("/ajouterUnTopo")
	public String submitTopoForm(@Validated @ModelAttribute("topo") Topo topo, BindingResult bindingResult) {
		logger.info("HTTP POST received at /addTopoToList");
		if (bindingResult.hasErrors()) {
			logger.info("HTTP POST received at /addTopoToList in bindingResult.hasErrors");
			return "/ajouterUnTopo";
		} else {
			logger.info("On ajoute le topo avec les valeurs suivantes : id " + topo.getId() + " titre "
					+ topo.getTitle() + " content " + topo.getContent() + " est disponible à l'emprunt "
					+ topo.isFreeForBorrow());
			topo.setOwnerMail(currentLoggedUser.getEmail());
			userServiceImp.addUserTopo(currentLoggedUser, topo);
			logger.info("juste avant le topoService ou on addTopo");
		}
		return ("redirect:/monCompte");
	}

	@GetMapping("/deleteTopo")
	public String deleteTopo(Integer custStat, Integer id) {
		logger.info("HTTP POST received at /deleteTopo ");
		logger.info("On delete le topo avec les valeurs suivantes : id " + id);
		userServiceImp.deleteUserTopoWithId(currentLoggedUser, custStat);
		topoService.deleteTopo(id);
		return ("redirect:/monCompte");
	}

	@GetMapping("/editTopo")
	public String editTopo(Model model, Integer id) {
		logger.info("HTTP GET received at /editTopo" + id);
		Topo topo = topoService.getOneTopoById(id);
		model.addAttribute("topo", topo);
		return "modifierUnTopo";
	}

	@PostMapping("/modifierUnTopo")
	public String submitTopoFormModification(@ModelAttribute("topo") Topo topo) {
		logger.info("HTTP POST received at /modifierUnTopo ");
		logger.info("On modifie le topo avec les valeurs suivantes : id " + topo.getId() + " titre " + topo.getTitle()
				+ " content " + topo.getContent() + " est disponible à l'emprunt " + topo.isFreeForBorrow());
		topoService.saveTopo(topo);
		return ("redirect:/monCompte");
	}

	// ______________________________ Les Commentaires______________________________________

	@GetMapping("/listeDesCommentaires")
	public String getCommentaireList(Integer id, Model model) {
		logger.info("HTTP GET request received at /listeDesCommentaires URL");
		currentClimbingSite = climbingSiteService.getOneClimbingSiteById(id);
		model.addAttribute("currentClimbingSite", currentClimbingSite);
		model.addAttribute("commentaires", currentClimbingSite.getCommentaires());
		return ("listeDesCommentaires");
	}

	@GetMapping("ajouterUnCommentaire")
	public String ShowCommentaireForm(Authentication authentication, Model model) {
		logger.info("HTTP GET request received at /ajouterUnCommentaire URL");
		Commentaire commentaire = new Commentaire();
		logger.info("climbingSite " + currentClimbingSite.getTitle());
		userPrincipal = (UserDetails) authentication.getPrincipal();
		currentLoggedUser = userServiceImp.findUserOnEmail(userPrincipal.getUsername());
		logger.info("NOM UTILISATEUR " + currentLoggedUser.getPrenom());
		model.addAttribute("currentuser", currentLoggedUser);
		model.addAttribute("commentaire", commentaire);
		return ("ajouterUnCommentaire");
	}

	@PostMapping("ajouterUnCommentaire")
	public String submitCommentaireForm(@Validated @ModelAttribute("commentaire") Commentaire commentaire,
			BindingResult bindingResult, Authentication authentication) {
		logger.info("HTTP POST request received at /ajouterUnCommentaire URL");
		if (bindingResult.hasErrors()) {
			logger.info("HTTP POST request received at /ajouterUnCommentaire URL in bindingResult.hasErrors");
			return "/ajouterUnCommentaire";
		} else {
			userPrincipal = (UserDetails) authentication.getPrincipal();
			currentLoggedUser = userServiceImp.findUserOnEmail(userPrincipal.getUsername());
			commentaire.setCreationDateTime(Date.from(Instant.now()));

			logger.info("On ajoute le commentaire avec les valeurs suivantes : id " + commentaire.getId() + " titre "
					+ commentaire.getTitle() + " content " + commentaire.getContent() + " date "
					+ commentaire.getCreationDateTime() + " et le prénom de l'utilisateur est "
					+ currentLoggedUser.getPrenom());

			commentaireService.addCommentaire(currentLoggedUser, commentaire);
			userServiceImp.addUserCommentaire(currentLoggedUser, commentaire);
			climbingSiteService.addClimbingSiteCommentaire(currentClimbingSite, commentaire);
		}
		return ("redirect:/listeDesSitesDEscalade");
	}

	@GetMapping("/deleteCommentaire")
	public String deleteCommentaire(Integer custStat, Integer id, Authentication authentication) {
		logger.info("HTTP GET request received at /deleteCommentaire URL");
		Commentaire commentaire = commentaireService.getOneCommentaireById(id);
		String email = commentaire.getAuthorEmail();
		User authorOfComment = userServiceImp.findUserOnEmail(email);
		logger.info("on delete le commentaire avec l'id suivante" + id + "le custStat suivant" + custStat
				+ " pour l'utilisateur suivant " + authorOfComment.getPrenom() + " pour le site d'escalade suivant"
				+ currentClimbingSite.getTitle());
		userServiceImp.deleteUserCommentaireWithCommentaire(authorOfComment,commentaire);
		climbingSiteService.deleteCommentaireWithId(currentClimbingSite, custStat);
		commentaireService.deleteCommentaire(id);
		return ("redirect:/listeDesSitesDEscalade");

	}

	// ______________________________ Authentification réussie______________________________________

	@GetMapping("/logSuccess")
	public String managersStatusCheck(Authentication authentication, Model model) {
		logger.info(" HTTP GET received at /logSuccess");
		userPrincipal = (UserDetails) authentication.getPrincipal();
		currentLoggedUser = userServiceImp.findUserOnEmail(userPrincipal.getUsername());
		;
		model.addAttribute("curentuser", currentLoggedUser);
		model.addAttribute("principal", userPrincipal);

		return "logSuccess";
	}

}
