package com.openclassrooms.LesAmisDeLEscaladeApplication.entities;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;

import lombok.Setter;

@Entity
@Table(name = "COMMENTAIRES")
@Getter
@Setter
@NoArgsConstructor
public class Commentaire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
    Date creationDateTime ;

	
	@Column(name = "TITLE")
	@Size(max=65, message="65 charactères maximum")
	@NotBlank(message="Ce champ ne doit pas être vide")
	private String title;

	@Column(name = "CONTENT")
	@Size(max=65, message="65 charactères maximum")
	@NotBlank(message="Ce champ ne doit pas être vide")
	private String content;
	
	@Column(name = "SIGNATURE")
	@Size(max=65, message="65 charactères maximum")
	@NotBlank(message="Ce champ ne doit pas être vide")
	private String signature;
	
	@Column(name = "AUTHOR_EMAIL")
	private String authorEmail;

	public Commentaire(Date creationDateTime,
			@Size(max = 65, message = "65 charactères maximum") @NotBlank(message = "Ce champ ne doit pas être vide") String title,
			@Size(max = 65, message = "65 charactères maximum") @NotBlank(message = "Ce champ ne doit pas être vide") String content,
			@Size(max = 65, message = "65 charactères maximum") @NotBlank(message = "Ce champ ne doit pas être vide") String signature,
			String authorEmail) {
		super();
		this.creationDateTime = creationDateTime;
		this.title = title;
		this.content = content;
		this.signature = signature;
		this.authorEmail = authorEmail;
	}

}
