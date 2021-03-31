package com.openclassrooms.LesAmisDeLEscaladeApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.openclassrooms.LesAmisDeLEscaladeApplication.entities.ClimbingSite;

public interface ClimbingSiteRepository extends JpaRepository<ClimbingSite, Integer> {

}
