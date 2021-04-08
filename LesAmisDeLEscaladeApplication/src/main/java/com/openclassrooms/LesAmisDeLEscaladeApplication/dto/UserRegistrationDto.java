package com.openclassrooms.LesAmisDeLEscaladeApplication.dto;

import java.util.Collection;

import com.openclassrooms.LesAmisDeLEscaladeApplication.entities.Commentaire;
import com.openclassrooms.LesAmisDeLEscaladeApplication.entities.Topo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @Getter @Setter @NoArgsConstructor
public class UserRegistrationDto {
private String nom;
private String prenom;
private String adresse;
private String telephone;
private String password;
private String email;
private Collection<Topo> topos;	
private Collection<Commentaire> commentaires;
}
