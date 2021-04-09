package com.openclassrooms.LesAmisDeLEscaladeApplication.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.openclassrooms.LesAmisDeLEscaladeApplication.entities.Topo;
import com.openclassrooms.LesAmisDeLEscaladeApplication.entities.User;
import com.openclassrooms.LesAmisDeLEscaladeApplication.service.TopoService;
import com.openclassrooms.LesAmisDeLEscaladeApplication.service.UserServiceImplementation;

@Controller
public class TopoController {
	
	@Autowired
	UserServiceImplementation userServiceImp;
	@Autowired
	TopoService topoService;
	private User user;
	private final Logger logger = LoggerFactory.getLogger(TopoController.class);

	@GetMapping("/listeDesTopos")	
	public String getToposList(Model model) {
	logger.info("HTTP GET request received at /listeDesTopos URL");
	model.addAttribute("topos", topoService.getAllTopos());
	return ("listeDesTopos");
	}
	
}
