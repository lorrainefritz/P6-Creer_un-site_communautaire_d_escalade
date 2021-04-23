package com.openclassrooms.LesAmisDeLEscaladeApplication.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name="TOPOS")
@Getter 
@Setter 
@NoArgsConstructor
public class Topo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name="ID")
	private Integer id;
	
	@Column(name = "TITLE")
	@Size(max=65, message="65 charactères maximum")
	@NotBlank(message="Ce champ ne doit pas être vide")
	private String title;
	
	@Column(name = "CONTENT")
	@Size(max=65, message="65 charactères maximum")
	@NotBlank(message="Ce champ ne doit pas être vide")
	private String content;
	
	@Column(name = "OWNERMAIL")
	private String ownerMail;
	
	
	@Column(name = "LIBRE_POUR_EMPRUNT")
	private boolean freeForBorrow;


	public Topo(
			@Size(max = 65, message = "65 charactères maximum") @NotBlank(message = "Ce champ ne doit pas être vide") String title,
			@Size(max = 65, message = "65 charactères maximum") @NotBlank(message = "Ce champ ne doit pas être vide") String content,
			String ownerMail, boolean freeForBorrow) {
		super();
		this.title = title;
		this.content = content;
		this.ownerMail = ownerMail;
		this.freeForBorrow = freeForBorrow;
	}









	
}
