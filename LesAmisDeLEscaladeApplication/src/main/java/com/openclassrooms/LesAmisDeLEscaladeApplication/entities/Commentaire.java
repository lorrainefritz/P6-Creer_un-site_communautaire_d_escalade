package com.openclassrooms.LesAmisDeLEscaladeApplication.entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="COMMENTAIRES")
@Getter 
@Setter 
@NoArgsConstructor
@RequiredArgsConstructor 
public class Commentaire {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name="ID")
	private Integer id;
	
	@NonNull
	@Column(name = "TITLE")
	@NotBlank
	private String title;
	
	@NonNull
	@Column(name = "CONTENT")
	@NotBlank
	private String content;
	
	
}
