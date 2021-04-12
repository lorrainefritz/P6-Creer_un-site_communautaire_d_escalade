package com.openclassrooms.LesAmisDeLEscaladeApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.LesAmisDeLEscaladeApplication.entities.Commentaire;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire,Integer> {

}
