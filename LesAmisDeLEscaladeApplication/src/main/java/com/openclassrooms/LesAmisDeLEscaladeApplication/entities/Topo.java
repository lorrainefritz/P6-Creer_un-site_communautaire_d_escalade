package com.openclassrooms.LesAmisDeLEscaladeApplication.entities;

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
	@NotBlank
	private String title;
	
	@Column(name = "CONTENT")
	@NotBlank
	private String content;
	
	
	@Column(name = "LIBRE_POUR_EMPRUNT")
	@NotBlank
	private boolean freeForBorrow;


	public Topo(@NotBlank String title, @NotBlank String content, @NotBlank boolean freeForBorrow) {
		super();
		this.title = title;
		this.content = content;
		this.freeForBorrow = freeForBorrow;
	}
	
	



	

	
}
