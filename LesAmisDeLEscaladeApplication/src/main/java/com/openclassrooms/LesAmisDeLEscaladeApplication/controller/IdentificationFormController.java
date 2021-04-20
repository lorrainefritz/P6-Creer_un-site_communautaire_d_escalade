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
		return ("redirect:/listeDesTopos"); // Redirection vers mon compte avec la liste perso plutot?
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
//		commentaire.setCreationDateTime(new Date());
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
			logger.info("NOM UTILISATEUR " + currentLoggedUser.getPrenom());
			logger.info("On ajoute le commentaire avec les valeurs suivantes : id " + commentaire.getId() + " titre "
					+ commentaire.getTitle() + " content " + commentaire.getContent() + " date "
					+ commentaire.getCreationDateTime());
			userPrincipal = (UserDetails) authentication.getPrincipal();
			currentLoggedUser = userServiceImp.findUserOnEmail(userPrincipal.getUsername());
			commentaire.setCreationDateTime(Date.from(Instant.now()));
			commentaireService.addCommentaire(commentaire);
			userServiceImp.addUserCommentaire(currentLoggedUser, commentaire);
			climbingSiteService.addClimbingSiteCommentaire(currentClimbingSite, commentaire);
		}
		return ("redirect:/listeDesSitesDEscalade");
	}

	@GetMapping("/deleteCommentaire")
	public String deleteCommentaire(Integer custStat, Integer id, Authentication authentication) {
		logger.info("HTTP GET request received at /deleteCommentaire URL");
		logger.info("on delete le commentaire avec l'id suivante" + id + "le custStat suivant" + custStat);
		userPrincipal = (UserDetails) authentication.getPrincipal();
		currentLoggedUser = userServiceImp.findUserOnEmail(userPrincipal.getUsername());
		// =>>> Cette ligne ce n'est pas le currentLogUser mais le user qui a laissé le
		// comm!!!!!
		userServiceImp.deleteUserCommentaireWithId(currentLoggedUser, custStat);
		climbingSiteService.deleteCommentaireWithId(currentClimbingSite, custStat);
		commentaireService.deleteCommentaire(id);
		return ("redirect:/listeDesSitesDEscalade");

	}

	@GetMapping("/logSuccess")
	public String managersStatusCheck(Authentication authentication, Model model) {
		logger.info(" HTTP GET received at /logSuccess");
		userPrincipal = (UserDetails) authentication.getPrincipal();
		currentLoggedUser = userServiceImp.findUserOnEmail(userPrincipal.getUsername());
		;
		model.addAttribute("curentuser", currentLoggedUser);
		model.addAttribute("principal", userPrincipal);
//	    logger.info("USERNAME ="+ userPrincipal.getUsername());  
//	    logger.info("PASSWORD ="+ userPrincipal.getPassword());
//	    logger.info("AUTHORITIES ="+ userPrincipal.getAuthorities());
//	    logger.info("NAME En passant par authentication ="+ authentication.getName());
//	    logger.info("DETAILS En passant par authentication ="+ authentication.getDetails());
//	    logger.info("USER EMAIL=" + currentLoggedUser.getEmail() );
//	    logger.info("USER NAME ="+ currentLoggedUser.getName() );
//	    logger.info("USER PASSWORD ="+ currentLoggedUser.getPassword() );
//	    logger.info("USER NAME ="+ currentLoggedUser.getId());
		return "logSuccess";
	}

//	@GetMapping("/logSuccess")
//	public ModelAndView showSuccessPage(Principal principal) {
//		logger.info(" HTTP GET received at /logSuccess");
//		UserDetails userdetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		ModelAndView mv = new ModelAndView("logSucess");
//		mv.addObject("fullname",userdetails.getUsername());
//		final String loggedInUserName = principal.getName() ;
//		return mv;
//	}

//	@GetMapping("/logSuccess")
//	public String showSuccessPage() {
//		logger.info(" HTTP GET received at /logSuccess");
//		return "logSuccess";
//	}
}
