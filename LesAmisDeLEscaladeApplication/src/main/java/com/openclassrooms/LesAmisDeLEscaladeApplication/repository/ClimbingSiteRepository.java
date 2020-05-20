package com.openclassrooms.LesAmisDeLEscaladeApplication.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.openclassrooms.LesAmisDeLEscaladeApplication.domain.ClimbingSiteItem;

@Service
public class ClimbingSiteRepository {
	private List<ClimbingSiteItem> climbingSiteItems= new ArrayList<ClimbingSiteItem>();
	private static int index=1;
	
	
	public List<ClimbingSiteItem> getListOfSite(){
		return climbingSiteItems;
	}
	
	public void addClimbingSiteItem(ClimbingSiteItem climbingSiteItem ) {
		climbingSiteItem.setId(index++);
		climbingSiteItems.add(climbingSiteItem);
	}
	
	public ClimbingSiteItem findClimbingSiteById(Integer id) {
		for (ClimbingSiteItem climbingSiteItem : climbingSiteItems) {
			if(climbingSiteItem.getId().equals(id)) {
				return climbingSiteItem;
			}
		}
		return null;
	}
	
	public ClimbingSiteItem findClimbingSiteByTitle(String title) {
		for (ClimbingSiteItem climbingSiteItem : climbingSiteItems) {
			if(climbingSiteItem.getTitle().equals(title)) {
				return climbingSiteItem;
			}
		}
		return null;
	}
	
	public ClimbingSiteItem findClimbingSiteBySecteur(String secteur) {
		for (ClimbingSiteItem climbingSiteItem : climbingSiteItems) {
			if(climbingSiteItem.getSecteur().equals(secteur)) {
				return climbingSiteItem;
			}
		}
		return null;
	}
	public ClimbingSiteItem findClimbingSiteByDifficulty(String difficulty) {
		for (ClimbingSiteItem climbingSiteItem : climbingSiteItems) {
			if(climbingSiteItem.getDifficulty().equals(difficulty)) {
				return climbingSiteItem;
			}
		}
		return null;
	}
	public ClimbingSiteItem findClimbingSiteByNombreDeVoies(int nombreDeVoies) {
		for (ClimbingSiteItem climbingSiteItem : climbingSiteItems) {
			if(climbingSiteItem.getNombreDeVoies()==nombreDeVoies) {
				return climbingSiteItem;
			}
		}
		return null;
	}
	
}
