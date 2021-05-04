package com.openclassrooms.LesAmisDeLEscaladeApplication.service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;

import com.openclassrooms.LesAmisDeLEscaladeApplication.entities.ClimbingSite;
import com.openclassrooms.LesAmisDeLEscaladeApplication.entities.Commentaire;
import com.openclassrooms.LesAmisDeLEscaladeApplication.repository.ClimbingSiteRepository;

@Service
public class ClimbingSiteService {
	private final Logger logger = LoggerFactory.getLogger(ClimbingSiteService.class);

	@Autowired
	ClimbingSiteRepository climbingSiteRepository;
	@Autowired
	private CommentaireService commentaireService;

	public List<ClimbingSite> getAllClimbingSites() {
		logger.info("in ClimbingSiteService in getAllClimbingSites");
		List<ClimbingSite> climbingSiteItems = climbingSiteRepository.findAll();
		return climbingSiteItems;
	}
	
	public List<ClimbingSite> getClimbingSitesSearchingByKeyword(String keyword) {
		logger.info("in ClimbingSiteService in getClimbingSitesSearchingByKeyword");
		List<ClimbingSite> climbingSiteItems = climbingSiteRepository.findByKeyword(keyword);
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
	
	
	public ClimbingSite addImageToClimbingSite (ClimbingSite climbingSite,MultipartFile image) {
		logger.info("in ClimbingSiteService in addImageToClimbingSite");
		
		try {
			logger.info("in ClimbingSiteService in addImageToClimbingSite try ");
			climbingSite.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
		}catch (IOException e) {
			e.printStackTrace();
		}
		return climbingSiteRepository.save(climbingSite);
	}
	
	
	
	public void deleteClimbingSite(Integer id) {
		logger.info("in ClimbingSiteService in deleteClimbingSite");
		ClimbingSite climbingSite = getOneClimbingSiteById(id);
		climbingSiteRepository.delete(climbingSite);
	}

	public ClimbingSite addClimbingSiteCommentaire(ClimbingSite climbingSite, Commentaire commentaire) {
		List<Commentaire> commentaires = (List<Commentaire>) climbingSite.getCommentaires();
		commentaires.add(commentaire);
		return climbingSiteRepository.save(climbingSite);
	}

	public ClimbingSite deleteCommentaireWithId(ClimbingSite climbingSite, Integer custStat) {
		logger.info("in deleteUserCommentaireWithCustat = " + custStat);
		List<Commentaire> commentaires = (List<Commentaire>) climbingSite.getCommentaires();
		int positionOfCommentInTheList = custStat;
		commentaires.remove(positionOfCommentInTheList);
		climbingSite.setCommentaires(commentaires);
		return climbingSiteRepository.save(climbingSite);
	}
	

	

}
