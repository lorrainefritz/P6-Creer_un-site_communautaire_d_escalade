package com.openclassrooms.LesAmisDeLEscaladeApplication.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.openclassrooms.LesAmisDeLEscaladeApplication.dto.UserRegistrationDto;
import com.openclassrooms.LesAmisDeLEscaladeApplication.entities.User;



public interface UserService extends UserDetailsService {
	User save(UserRegistrationDto registrationDto); 
}
