package com.openclassrooms.LesAmisDeLEscaladeApplication.domain;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class ClimbingSiteItem {
	private Integer id;
	
	@Size(max=10)
	@NotBlank
	private String title;
	
	@NotBlank
	private String image;
	
	@Size(max=10)
	@NotBlank
	private String secteur;
	
	@NotNull
	private int longueur;
	
	@NotBlank
	private String difficulty;
	private boolean tagged;
	
	@NotNull
	private int nombreDeVoies;
	
	public ClimbingSiteItem() {
		super();
	}
	
	

	public ClimbingSiteItem(Integer id, String title, String image, String secteur, int longueur, String difficulty,
			boolean tagged, int nombreDeVoies) {
		super();
		this.id = id;
		this.title = title;
		this.image = image;
		this.secteur = secteur;
		this.longueur = longueur;
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

	public int getLongueur() {
		return longueur;
	}

	public void setLongueur(int longueur) {
		this.longueur = longueur;
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
