package com.openclassrooms.LesAmisDeLEscaladeApplication.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="CLIMBING_SITES")
@Getter 
@Setter 
@NoArgsConstructor
 
public class ClimbingSite implements Serializable { 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Integer id;
	
	
		
	@Size(max=65, message="taille max 65 BACK")
	@NotBlank
	@Column(name="TITLE")
	private String title;
	
	@Size
	@NotBlank
	@Column(name="LIEU")
	private String lieu;
	
	
	@Lob
    @Column(name = "IMAGE", length = Integer.MAX_VALUE, nullable = true)
    private byte[] image;
	
	
	@Size(max=65)
	@NotBlank
	@Column(name="SECTEUR")
	private String secteur;
	
	
	@NotNull
	@Column(name="LONGUEUR")
	private int longueur;
	
	
	@NotNull
	@Column(name="NOMBRE_DE_VOIES")
	private int nombreDeVoies;
	
	
	@NotBlank
	@Column(name="DIFFICULTY")
	private String difficulty;
	
	
	
	@Column(name="TAGGED")
	private boolean tagged;
	
	
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(
			name = "CLIMBING_SITES_COMMENTAIRES",
			joinColumns = @JoinColumn(
					name = "CLIMBING_SITES_ID", referencedColumnName = "ID"),
			inverseJoinColumns=@JoinColumn
			(name="COMMENTAIRES_ID",referencedColumnName="ID")
			)
	private Collection<Commentaire>commentaires;



	public ClimbingSite(@Size(max = 65, message = "taille max 65 BACK") @NotBlank String title,
			@Size @NotBlank String lieu, byte[] image, @Size(max = 65) @NotBlank String secteur, @NotNull int longueur,
			@NotNull int nombreDeVoies, @NotBlank String difficulty, boolean tagged,
			Collection<Commentaire> commentaires) {
		super();
		this.title = title;
		this.lieu = lieu;
		this.image = image;
		this.secteur = secteur;
		this.longueur = longueur;
		this.nombreDeVoies = nombreDeVoies;
		this.difficulty = difficulty;
		this.tagged = tagged;
		this.commentaires = commentaires;
	}




	
	

}
