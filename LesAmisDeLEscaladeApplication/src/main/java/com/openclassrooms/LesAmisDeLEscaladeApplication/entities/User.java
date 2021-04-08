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
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.openclassrooms.LesAmisDeLEscaladeApplication.service.UserServiceImplementation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "REGISTERED_USERS", 
	uniqueConstraints = @UniqueConstraint(columnNames = "EMAIL"))
@Getter
@Setter
@NoArgsConstructor
public class User implements Serializable{
	private static final long serialVersionUID = 1L;


	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "NOM")
	@NotBlank
	private String nom;

	@Column(name = "PRENOM")
	@NotBlank
	private String prenom;
	
	@Column(name = "ADRESSE")
	@NotBlank
	private String adresse;
	
	@Column(name = "TELEPHONE")
	@NotBlank
	private String telephone;
	
	
	@Column(name = "PASSWORD")
	@NotBlank
	private String password;

	@Column(name = "EMAIL")
	@NotBlank
	private String email;
	

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "REGISTERED_USERS_ROLES",
			joinColumns = @JoinColumn(
					name = "USER_ID", referencedColumnName = "ID"),
			inverseJoinColumns = @JoinColumn
			(name = "ROLE_ID", referencedColumnName = "ID"))
	private Collection<Role> roles;

		
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(
			name = "REGISTERED_USERS_COMMENTAIRES",
			joinColumns = @JoinColumn(
					name = "USER_ID", referencedColumnName = "ID"),
			inverseJoinColumns = @JoinColumn
			(name="COMMENTAIRES_ID",referencedColumnName="ID"))
	private Collection<Commentaire> commentaires;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(
			name = "REGISTERED_USERS_TOPOS",
			joinColumns = @JoinColumn(
					name = "USER_ID", referencedColumnName = "ID"),
			inverseJoinColumns = @JoinColumn
			(name="TOPOS_ID",referencedColumnName="ID"))
	private Collection<Topo> topos;	
	
	
	
	public Collection<? extends GrantedAuthority> getAuthorities() {
		 Collection<Role> roles = getRoles();
	        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
	         
	        for (Role role : roles) {
	            authorities.add(new SimpleGrantedAuthority(role.getName()));
	        }         
		return authorities;
	}



	public User(@NotBlank String nom, @NotBlank String prenom, @NotBlank String adresse, @NotBlank String telephone,
			@NotBlank String password, @NotBlank String email, Collection<Role> roles,
			Collection<Commentaire> commentaires, Collection<Topo> topos) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.password = password;
		this.email = email;
		this.roles = roles;
		this.commentaires = commentaires;
		this.topos = topos;
	}

}
