package com.openclassrooms.LesAmisDeLEscaladeApplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.openclassrooms.LesAmisDeLEscaladeApplication.entity.ClimbingSiteItem;

public interface ClimbingSiteRepositoryInterface extends JpaRepository<ClimbingSiteItem, Integer> {

}
