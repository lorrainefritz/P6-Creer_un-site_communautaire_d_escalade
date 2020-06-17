<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
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
			<div class="header_midle_part">
				<div class="image_holder">
					<img
						alt="un chat sur une colline regardant au loin sur fond de montagne"
						src="\imagesAndLogos\images\CatOnAHill.jpg">
				</div>
			</div>
			<div class="header_bottom_part">
				<h1>NEWS</h1>
			</div>
		</header>

		<div class=home_articles_setion>
			<article>
				<div>
					<img src="\imagesAndLogos\images\kid.jpg" alt="kid.jpg">
				</div>
				<div class=text_article>
					<h2>Ré-organisation de l'association, certains parcours enfant réouvrent pour les vacances</h2>
					<p>Pendant la crise sanitaire qui nous a touchée, les activités de l'association ont été mises en pause. Avec la fin du confinement nous nous réorganisons pour permettre aux plus jeunes de refaire de l'escalade, dans le strict respect des recommandations d'hygiène.</p>
				</div>
			</article>
			<article>
				<div>
					<img src="\imagesAndLogos\images\lockdown.jpg" alt="lockdown.jpg">
				</div>
				<div class=text_article>
					<h2>Crise sanitaire, certains trouvent la parade</h2>
					<p>Du fait de la crise sanitaire actuelle, il n'est plus possible de pratiquer dans des conditions normales. Certains créatifs ont néamoins trouvé des manières de pratiquer sans enfreindre les recommendations gouvernementales.</p>
				</div>
			</article>
			<article>
				<div>
					<img src="\imagesAndLogos\images\knot.jpg" alt="knot.jpg">
				</div>
				<div class=text_article>
					<h2>Comment s'occuper pendant le confinement</h2>
					<p>Suite à la crise sanitaire qui nous frappe, nous sommes tous contraint de rester enfermé chez nous. Nous pouvons mettre ce temps à profit pour travailler nos capacités à faire les différents noeuds existants.</p>
				</div>
			</article>
			<article>
				<div>
					<img src="\imagesAndLogos\images\climbingBear.jpg"
						alt="climbingBear.jpg">
				</div>
				<div class=text_article>
					<h2>Les animaux aiment aussi l'escalade</h2>
					<p>Lors d'une de ses expeditions sur un parcours aux Etats Unis, un de nos membre a été très surpris par l'identité d'un autre participant du parcours...</p>
				</div>
			</article>

		</div>


	</div>
	<footer><%@ include file="footer.jsp"%></footer>
</body>
</html>