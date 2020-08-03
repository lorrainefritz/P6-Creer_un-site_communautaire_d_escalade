package com.openclassrooms.LesAmisDeLEscaladeApplication.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="CLIMBING_SITES")
public class ClimbingSiteItem implements Serializable { 
	
	@Id
	@GeneratedValue 
	@Column(name="ID")
	private Integer id;
	
 

	@Size(max=10)
	@NotBlank
	@Column(name="TITLE")
	private String title;
	
	@NotBlank
	@Column(name="IMAGE")
	private String image;
	
	@Size(max=10)
	@NotBlank
	@Column(name="SECTEUR")
	private String secteur;
	
	@NotNull
	@Column(name="LONGUEUR")
	private int longueur;
	
	@NotBlank
	@Column(name="DIFFICULTY")
	private String difficulty;
	
	@Column(name="TAGGED")
	private boolean tagged;
	
	@NotNull
	@Column(name="NOMBRE_DE_VOIES")
	private int nombreDeVoies;
	
	public ClimbingSiteItem() {
		super();
	}
	
	

	public ClimbingSiteItem(String title, String image, String secteur, int longueur, String difficulty, boolean tagged,
			int nombreDeVoies) {
		super();
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
