package com.openclassrooms.LesAmisDeLEscaladeApplication.entities;


import java.util.Collection;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
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
    Date creationDateTime;

	@Column(name = "TITLE")
	@NotBlank
	private String title;

	@Column(name = "CONTENT")
	@NotBlank
	private String content;

	public Commentaire(Date creationDateTime, @NotBlank String title, @NotBlank String content) {
		super();
		this.creationDateTime = creationDateTime;
		this.title = title;
		this.content = content;
	}

	


}
