package com.openclassrooms.LesAmisDeLEscaladeApplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.openclassrooms.LesAmisDeLEscaladeApplication.domain.ClimbingSiteItem;
import com.openclassrooms.LesAmisDeLEscaladeApplication.exception.DuplicateTitleException;
import com.openclassrooms.LesAmisDeLEscaladeApplication.repository.ClimbingSiteRepository;

@Service
public class ClimbingSiteService {
	ClimbingSiteRepository climbingSiteRepository;

	public ClimbingSiteService(ClimbingSiteRepository climbingSiterepository) {
		super();
		this.climbingSiteRepository = climbingSiterepository;
	}
	
	public List<ClimbingSiteItem> getClimbingSiteItems(){
		List<ClimbingSiteItem> climbingSiteItem = climbingSiteRepository.getListOfSite();
		return climbingSiteItem;
	}
	
	public int getClimbinSiteListSize() {
		return climbingSiteRepository.getListOfSite().size();
	}
	
	public ClimbingSiteItem findClimbingSiteById(Integer id) {
		return climbingSiteRepository.findClimbingSiteById(id);
		
	}
	
	public void addOrUpdateClimbingSiteItem(ClimbingSiteItem climbingSiteItem) throws DuplicateTitleException {
		ClimbingSiteItem existingSiteItem = findClimbingSiteById(climbingSiteItem.getId());
		if (existingSiteItem == null) {
			if (climbingSiteRepository.findClimbingSiteByTitle(climbingSiteItem.getTitle())!=null) {
				throw new DuplicateTitleException();
			}
			climbingSiteRepository.addClimbingSiteItem(climbingSiteItem);
			
		}else {
			existingSiteItem.setTitle(climbingSiteItem.getTitle());
			existingSiteItem.setSecteur(climbingSiteItem.getSecteur());
			existingSiteItem.setImage(climbingSiteItem.getImage());
			existingSiteItem.setLongeur(climbingSiteItem.getLongeur());
			existingSiteItem.setNombreDeVoies(climbingSiteItem.getNombreDeVoies());
			existingSiteItem.setDifficulty(climbingSiteItem.getDifficulty());
		}
	}

}
