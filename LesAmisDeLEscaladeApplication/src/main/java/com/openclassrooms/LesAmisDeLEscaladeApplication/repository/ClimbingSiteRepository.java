package com.openclassrooms.LesAmisDeLEscaladeApplication.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.openclassrooms.LesAmisDeLEscaladeApplication.entities.ClimbingSite;

@Repository
@Transactional
public interface ClimbingSiteRepository extends JpaRepository<ClimbingSite, Integer> {

	@Query(value="SELECT * FROM climbing_sites climbingSites WHERE CONCAT (climbingSites.secteur, climbingSites.lieu, climbingSites.longueur, climbingSites.nombre_de_voies, climbingSites.difficulty) LIKE %?1%", nativeQuery=true)
	List<ClimbingSite> findByKeyword(@Param("keyword")String keyword);
	
}

