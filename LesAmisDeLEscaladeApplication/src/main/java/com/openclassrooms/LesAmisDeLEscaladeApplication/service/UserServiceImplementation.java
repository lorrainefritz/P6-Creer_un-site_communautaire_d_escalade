package com.openclassrooms.LesAmisDeLEscaladeApplication.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.Registration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.openclassrooms.LesAmisDeLEscaladeApplication.dto.UserRegistrationDto;
import com.openclassrooms.LesAmisDeLEscaladeApplication.entities.ClimbingSite;
import com.openclassrooms.LesAmisDeLEscaladeApplication.entities.Commentaire;
import com.openclassrooms.LesAmisDeLEscaladeApplication.entities.Role;
import com.openclassrooms.LesAmisDeLEscaladeApplication.entities.Topo;
import com.openclassrooms.LesAmisDeLEscaladeApplication.entities.User;
import com.openclassrooms.LesAmisDeLEscaladeApplication.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {

	private final Logger logger = LoggerFactory.getLogger(UserServiceImplementation.class);
	private UserRepository userRepository;

	@Autowired
	private RoleService roleService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private ClimbingSiteService climbingSiteService;

	public UserServiceImplementation(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User save(UserRegistrationDto registrationDto) {
		Role roleUserParDefaut = roleService.getOneRoleById(2);
		logger.info("IN SAVE USER and roleUserParDefaut= " + roleUserParDefaut.getName());
		User user = new User(registrationDto.getNom(), registrationDto.getPrenom(), registrationDto.getAdresse(),
				registrationDto.getTelephone(), passwordEncoder.encode(registrationDto.getPassword()),
				registrationDto.getEmail(), Arrays.asList(roleUserParDefaut), registrationDto.getCommentaires(),
				registrationDto.getTopos());
		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("IN LOADUSERBYUSERNAME");
		User user = userRepository.findByEmail(username);
		logger.info("IN LOADUSERBYUSERNAME AFTER USER CREATION VIA FINDBYEMAIL");
		if (user == null) {
			throw new UsernameNotFoundException("Invalid email or Password");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getOneUserById(Integer id) {
		return userRepository.getOne(id);
	}

	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
	}

	public User findUserOnEmail(String email) {
		return userRepository.findByEmail(email);
	}

//methode de modification à la volée utilisable par la perso connectée
	public User emailModification(User user, String email) {
		user.setEmail(email);
		return userRepository.save(user);
	}

	public User userInfosModification(User user, String nom, String prenom, String adresse, String telephone) {
		user.setNom(nom);
		user.setPrenom(prenom);
		user.setAdresse(adresse);
		user.setTelephone(telephone);
		return userRepository.save(user);

	}

	public User passwordModification(User user, String password) {
		logger.info("in passwordModification" + password);
		user.setPassword(passwordEncoder.encode(password));
		return userRepository.save(user);
	}

// méthode d'admin pour admin les roles des user bien changer partout en user
	public User roleUserModification(User user, Collection<Role> roles) {
		logger.info("in roleModification" + roles);
		user.setRoles(roles);
		return userRepository.save(user);
	}

	public User deleteUserRole(User user, Integer id) {
		logger.info("in deleteRole with id = " + id);
		List<Role> useroleColle = (List<Role>) user.getRoles();
		Role role = useroleColle.get(id);
		useroleColle.remove(role);
		user.setRoles(useroleColle);
		return userRepository.save(user);
	}

	public User addUserRole(User user, Role role) {
		logger.info("in addRole" + role);
		Collection<Role> roles = user.getRoles();
		roles.add(role);
		return userRepository.save(user);
	}

	public User addUserTopo(User user, Topo topo) {
		logger.info("in addTopoToUserTopoList" + topo);
		Collection<Topo> topos = user.getTopos();
		topos.add(topo);
		return userRepository.save(user);

	}

	public User deleteUserTopoWithId(User user, Integer id) {
		logger.info("in deleteTopoToUserTopoList Topo with id = " + id);
		List<Topo> topos = (List<Topo>) user.getTopos();
		Topo topo = topos.get(id);
		topos.remove(topo);
		user.setTopos(topos);
		return userRepository.save(user);
	}

	public User addUserCommentaire(User user, Commentaire commentaire) {
		List<Commentaire> commentaires = (List<Commentaire>) user.getCommentaires();
		logger.info("in addUserCommentaire");
		logger.info("User" + user.getNom() +user.getAuthorities());
		logger.info("commentaire" + commentaire.getTitle());
		commentaires.add(commentaire);
		return userRepository.save(user);
	}

	public User deleteUserCommentaireWithId(User user, Integer id) {
		logger.info("in deleteUserCommentaireWithId = " + id);
		List<Commentaire> commentaires = (List<Commentaire>) user.getCommentaires();
		Commentaire commentaire = commentaires.get(id);
		commentaires.remove(commentaire);
		user.setCommentaires(commentaires);
		return userRepository.save(user);
	}

}
