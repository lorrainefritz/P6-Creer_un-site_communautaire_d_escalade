package com.openclassrooms.LesAmisDeLEscaladeApplication.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.LesAmisDeLEscaladeApplication.entities.ClimbingSite;
import com.openclassrooms.LesAmisDeLEscaladeApplication.exception.DuplicateTitleException;
import com.openclassrooms.LesAmisDeLEscaladeApplication.repository.ClimbingSiteRepository;

@Service
public class ClimbingSiteService {
	private final Logger logger = LoggerFactory.getLogger(ClimbingSiteService.class);

	@Autowired
	ClimbingSiteRepository climbingSiteRepository;

	public List<ClimbingSite> getAllClimbingSites() {
		logger.info("in ClimbingSiteService in getClimbingSites");
		List<ClimbingSite> climbingSiteItems = climbingSiteRepository.findAll();
		return climbingSiteItems;
	}

	public int getClimbingSiteListSize() {
		logger.info("in ClimbingSiteService in getClimbingSiteListSize");
		return getAllClimbingSites().size();
	}

	public ClimbingSite getOneClimbingSiteById(Integer id) {
		logger.info("in ClimbingSiteService in getOneClimbingSiteById");
		return climbingSiteRepository.getOne(id);
	}

	public ClimbingSite addClimbingSite (ClimbingSite climbingSite) {
		logger.info("in ClimbingSiteService in addClimbingSite");
		return climbingSiteRepository.save(climbingSite);
	}
	
	public void deleteClimbingSite(Integer id) {
		logger.info("in ClimbingSiteService in deleteClimbingSite");
		ClimbingSite climbingSite = getOneClimbingSiteById(id);
		climbingSiteRepository.delete(climbingSite);
	}
	
	



}
