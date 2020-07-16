<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta charset="UTF-8">
<title>Les Amis de L'escalade</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div id="bloc_page">
		<header>
			<div class="header_top_part">
				<%@ include file="menu.jsp"%>
			</div>
			<div class="header_bottom_part">
				<h1>MENTIONS LEGALES</h1>
			</div>
		</header>
		<div class=mention_page>
			<article>
				<div class=mention_leg>
					<h2>Les Amis de L'Escalade</h2>
					<p>
						<i>Forme juridique</i> : Société par Actions au capital social de
						49.564,30 euros <br>
						<i>Immatriculation</i> : RCS sous le numéro 655 777 777 (numéro
						TVA intracommunautaire FR5755555555)<br> <i>Siège social</i>
						: 6 rue Beauregard 57970 KATZENHEIM <br> <i>Email de
							contact</i> : nous-contacter@lesAmisDeLEscalade.com <br> <i>Téléphone</i>
						: 03 82 88 88 88
					</p>
				</div>
				<div class=mention_leg>
					<h2>Propriété intellectuelle</h2>
					<p>Tous les éléments du site lesAmisDeLEscalade.com sont la
						propriété de les Amis de l'Escalade Conformément à l’article L.
						122-4 du Code de la propriété intellectuelle, toute
						représentation, reproduction, traduction, adaptation,
						transformation intégrale ou partielle des textes et/ou des œuvres
						de ce site faite sans le consentement de les Amis de l'Escalade
						est interdite.</p>
				</div>
				<div class=mention_leg>
					<h2>Vie Privée</h2>
					<p>
						Le site les Amis de l'Escalade collecte des informations à
						caractère personnel relatives aux internautes. Il a fait l’objet
						d’une déclaration préalable auprès de la CNIL sous le numéro
						suivant : 1498888. Cette collecte d’informations est uniquement
						destinée à gérer plus facilement les services proposés par le site
						les Amis de l'Escalade.<br> Conformément aux articles 39 et
						suivants de la loi n° 78-17 du 6 janvier 1978 modifiée en 2004
						relative à l’informatique, aux fichiers et aux libertés, toute
						personne peut obtenir communication et, le cas échéant,
						rectification ou suppression des informations la concernant, en
						s’adressant par courrier électronique à l’adresse suivante :
						nous-contacter@lesAmisDeLEscalade.com ou par courrier postal à
						l’adresse suivante : Siège social 6 rue Beauregard 57970
						KATZENHEIM
					</p>
				</div>
			</article>
		</div>
		<footer><%@ include file="footer.jsp"%></footer>
	</div>
</body>
</html>