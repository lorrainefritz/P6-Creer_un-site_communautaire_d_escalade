<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<link rel="stylesheet" href="style.css">
</head>
<body>

	<nav class="navigation">
		<div class="navigation_menu">
			<div class="logo">
				<p>
					<img alt="logo de l'association les amis de l'escalade"
						src="/imagesAndLogos/logos/logo.png">
				</p>
			</div>

			<div class=menu_header>
				<div id=menu_element>
					<a href="/">Home</a>
				</div>
				<div id=menu_element>
					<a href="/aProposDeLAssociation">A Propos de l'Association</a>
				</div>
				<div class="dropdown" id=menu_element>
					<a class=droping> Les Sites d'escalade : </a>
					<div class="dropdown_content">
						<a href="/listeDesSitesDEscalade">La liste des Sites
							D'escalade</a> <a href="/lesSitesDEscalade">Rechercher des Sites
							D'escalade</a> <a href="/ajouterDesSitesDEscalade">Ajouter des
							Sites D'escalade</a>
					</div>
				</div>
				<div id=menu_element>
					<a href="/listeDesTopos">Liste des Topos</a>
				</div>
				<div id=menu_element>
					<a href="/sInscrire">S'inscrire</a>
				</div>
				<div id=menu_element>
					<a href="/monCompte">Mon Compte</a>
				</div>
			</div>
		</div>
	</nav>
</body>