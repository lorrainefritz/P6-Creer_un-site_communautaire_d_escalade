package com.openclassrooms.LesAmisDeLEscaladeApplication.controller;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.openclassrooms.LesAmisDeLEscaladeApplication.entities.ClimbingSite;
import com.openclassrooms.LesAmisDeLEscaladeApplication.entities.Topo;
import com.openclassrooms.LesAmisDeLEscaladeApplication.entities.User;
import com.openclassrooms.LesAmisDeLEscaladeApplication.service.TopoService;
import com.openclassrooms.LesAmisDeLEscaladeApplication.service.UserServiceImplementation;



@Controller
public class IdentificationFormController {
	@Autowired
	UserServiceImplementation userServiceImp;
	@Autowired
	TopoService topoService;
	
	private final Logger logger = LoggerFactory.getLogger(IdentificationFormController.class);
	private UserDetails userPrincipal;
	private User currentLoggedUser ;

	@GetMapping("/seConnecter")
	public String showLoginForm() {
		logger.info(" HTTP GET received at /login");
		return "seConnecter";
	}

	@GetMapping("/monCompte")
	public String showCompte(Authentication authentication, Model model) {
		logger.info(" HTTP GET received at /monCompte");
		   userPrincipal = (UserDetails)authentication.getPrincipal();
		    currentLoggedUser = userServiceImp.findUserOnEmail(userPrincipal.getUsername());;
		    model.addAttribute("curentuser",currentLoggedUser);
		    model.addAttribute("principal",userPrincipal);
		    model.addAttribute("topos",currentLoggedUser.getTopos());
		return "monCompte";
	}
	
	@GetMapping("/ajouterUnTopo")
	public String showTopoForm(Model model) {
		logger.info("HTTP GET received at /addTopoToList ");
		logger.info("user " +currentLoggedUser.getNom());
		model.addAttribute("topo", new Topo());
		return ("ajouterUnTopo");
	
	}	
	
	
	@PostMapping("/ajouterUnTopo")
	public String submitTopoForm(@ModelAttribute("topo") Topo topo) {
		logger.info("HTTP POST received at /addTopoToList ");
		logger.info("On ajoute le topo avec les valeurs suivantes : id " + topo.getId() + " titre " + topo.getTitle()
				+ " content " + topo.getContent() + " est disponible à l'emprunt " + topo.isFreeForBorrow());
		userServiceImp.addUserTopo(currentLoggedUser, topo);
		logger.info("juste avant le topoService ou on addTopo");
	return ("redirect:/monCompte"); 
	}
	
	@GetMapping("/deleteTopo")
	public String deleteTopo(Integer custStat, Integer id) {
		logger.info("HTTP POST received at /deleteTopo ");
		logger.info("On delete le topo avec les valeurs suivantes : id " + id );
		userServiceImp.deleteUserTopoWithId(currentLoggedUser, custStat);
		topoService.deleteTopo(id);
		return ("redirect:/listeDesTopos"); //Redirection vers mon compte avec la liste perso plutot?
	}	
	
	@GetMapping("/editTopo")
	public String editTopo(Model model, Integer id) {
		logger.info("HTTP GET received at /editTopo" + id);
		Topo topo = topoService.getOneTopoById(id);
		model.addAttribute("topo",topo);
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
	
	
	@GetMapping("/logSuccess")
	public String managersStatusCheck(Authentication authentication, Model model) {
		logger.info(" HTTP GET received at /logSuccess");
	    userPrincipal = (UserDetails)authentication.getPrincipal();
	    currentLoggedUser = userServiceImp.findUserOnEmail(userPrincipal.getUsername());;
	    model.addAttribute("curentuser",currentLoggedUser);
	    model.addAttribute("principal",userPrincipal);
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
