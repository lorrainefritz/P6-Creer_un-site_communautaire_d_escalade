package com.openclassrooms.LesAmisDeLEscaladeApplication.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.openclassrooms.LesAmisDeLEscaladeApplication.dto.UserRegistrationDto;
import com.openclassrooms.LesAmisDeLEscaladeApplication.service.UserService;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
	private UserService userService;
	private final Logger logger = LoggerFactory.getLogger(CommentaireTopoLoginGestionController.class);

	public RegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}

	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto();
	}

	@GetMapping
	public String showRegistrationForm() {
		logger.info(" HTTP GET received at /registration");
		return "registration";
	}

	@PostMapping
	public String registerUserAccount(@Validated @ModelAttribute("user") UserRegistrationDto registrationDto,BindingResult bindingResult) {
		logger.info("HTTP POST received at /registration");
		if (bindingResult.hasErrors()) {
			logger.info("HTTP POST received at /registration in bindingResult.hasErrors");
			return "registration";
		} else {
		userService.save(registrationDto);
		}
		return "redirect:/monCompte";
	}
}
