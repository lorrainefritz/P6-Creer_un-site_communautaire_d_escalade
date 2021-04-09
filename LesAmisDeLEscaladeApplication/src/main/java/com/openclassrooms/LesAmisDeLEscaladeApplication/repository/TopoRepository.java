package com.openclassrooms.LesAmisDeLEscaladeApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.LesAmisDeLEscaladeApplication.entities.Topo;

@Repository
public interface TopoRepository extends JpaRepository<Topo,Integer> {

}
