package com.openclassrooms.LesAmisDeLEscaladeApplication.domain;

import java.util.ArrayList;
import java.util.List;

public class ClimbingSiteItem {
	private Integer id;
	private String title;
	private String image;
	private String secteur;
	private int longeur;
	private String difficulty;
	private boolean tagged;
	private int nombreDeVoies;
	
	public ClimbingSiteItem() {
		super();
	}
	
	

	public ClimbingSiteItem(Integer id, String title, String image, String secteur, int longeur, String difficulty,
			boolean tagged, int nombreDeVoies) {
		super();
		this.id = id;
		this.title = title;
		this.image = image;
		this.secteur = secteur;
		this.longeur = longeur;
		this.difficulty = difficulty;
		this.tagged = tagged;
		this.nombreDeVoies = nombreDeVoies;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getSecteur() {
		return secteur;
	}

	public void setSecteur(String secteur) {
		this.secteur = secteur;
	}

	public int getLongeur() {
		return longeur;
	}

	public void setLongeur(int longeur) {
		this.longeur = longeur;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public boolean isTagged() {
		return tagged;
	}

	public void setTagged(boolean tagged) {
		this.tagged = tagged;
	}

	public int getNombreDeVoies() {
		return nombreDeVoies;
	}

	public void setNombreDeVoies(int nombreDeVoies) {
		this.nombreDeVoies = nombreDeVoies;
	}




		
	
	
	
	
	
}
