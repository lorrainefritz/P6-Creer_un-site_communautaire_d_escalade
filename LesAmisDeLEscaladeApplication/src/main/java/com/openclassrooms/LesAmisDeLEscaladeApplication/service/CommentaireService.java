package com.openclassrooms.LesAmisDeLEscaladeApplication.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.LesAmisDeLEscaladeApplication.entities.Commentaire;
import com.openclassrooms.LesAmisDeLEscaladeApplication.repository.CommentaireRepository;

@Service
public class CommentaireService {
	private final Logger logger = LoggerFactory.getLogger(CommentaireService.class);

	@Autowired
	CommentaireRepository commentaireRepository;

	public List<Commentaire> getAllCommentaires() {
		List<Commentaire> listOfCommentaires = commentaireRepository.findAll();
		return listOfCommentaires;
	}

	public Commentaire addCommentaire(Commentaire commentaire) {
		logger.info("in CommentaireService addCommentaire");
		return commentaireRepository.save(commentaire);
	}

	public void deleteCommentaire(Integer id) {
		logger.info("in CommentaireService deleteCommentaire" + id);
		commentaireRepository.deleteById(id);
	}

	public Commentaire getOneCommentaireById(Integer id) {
		logger.info("in CommentaireService getOneCommentaireById");
		return commentaireRepository.getOne(id);

	}

	public Commentaire saveCommentaire(Commentaire commentaire) {
		logger.info("in CommentaireService addCommentaire");
		return commentaireRepository.save(commentaire);

	}
}
