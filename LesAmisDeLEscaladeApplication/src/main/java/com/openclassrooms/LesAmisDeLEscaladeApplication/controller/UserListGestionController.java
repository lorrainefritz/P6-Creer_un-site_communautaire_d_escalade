package com.openclassrooms.LesAmisDeLEscaladeApplication.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.openclassrooms.LesAmisDeLEscaladeApplication.service.UserServiceImplementation;


@Controller
public class UserListGestionController {
	@Autowired
	UserServiceImplementation userServiceImp;
	private final Logger logger = LoggerFactory.getLogger(UserListGestionController.class);
	
	@GetMapping("/listeDesUsers")
	public ModelAndView getUserList() {
		logger.info("HTTP GET received at /listeDesUsers");
		String viewName= "listeDesUsers";
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("users",userServiceImp.getAllUsers());
		return new ModelAndView(viewName,model);
	}
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/deleteUser")
	public String deleteUser(Integer id) {
		logger.info("HTTP GET received at /deleteUser");
		userServiceImp.deleteUser(id);
		 return "redirect:/listeDesUsers";
	}
	
	
}
