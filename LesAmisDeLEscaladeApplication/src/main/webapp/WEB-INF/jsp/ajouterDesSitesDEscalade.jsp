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
				<h1>AJOUTER UN SITE D'ESCALADE</h1>
			</div>
		</header>
		<div class="page_formulaire">
			<form class="formulaire" method="post">
				<div class="form_element">
					<label for="title">TITRE</label> <input type="text"
						class="form_label" id="title" name="title"
						placeholder="Obligatoire" value="${param.title}">
					<div class="element">
						<span class="text-danger">${title}</span>
					</div>
				</div>
				<div class="form_element">
					<label for="image">IMAGE</label> <input type="text"
						class="form_label" id="image" name="image"
						placeholder="Obligatoire" value="${param.image}">
					<div class="element">
						<span class="text-danger">${image} </span>
					</div>
				</div>

				<div class="form_element">
					<label for="secteur">SECTEUR</label> <input type="text"
						class="form_label" id="secteur" name="secteur"
						placeholder="Obligatoire" value="${param.secteur}">

					<div class="element">
						<span class="text-danger">${secteur} </span>
					</div>
				</div>

				<div class="form_element">
					<label for="longueur">LONGUEUR</label> <input type="text"
						class="form_label" id="longueur" name="longueur" placeholder=">0"
						value="${param.longueur}">
					<div class="element">
						<span class="text-danger">${longueur} </span>
					</div>
				</div>

				<div class="form_element">
					<label for="nombreDeVoies">NOMBRE DE VOIES</label> <input
						type="text" class="form_label" id="nombreDeVoies"
						name="nombreDeVoies" placeholder="1-1000"
						value="${param.nombreDeVoies}">

					<div class="element">
						<span class="text-danger">${nombreDeVoies} </span>
					</div>
				</div>


				<div class="form_element">
					DIFFICULTE <select name="difficulty">
						<option value="3a">3a</option>
						<option value="3b">3b</option>
						<option value="3c">3c</option>
						<option value="4a">4a</option>
						<option value="4b">4b</option>
						<option value="4c">4c</option>
						<option value="5a">5a</option>
						<option value="5b">5b</option>
						<option value="5c">5c</option>
						<option value="6a">6a</option>
						<option value="6b">6b</option>
						<option value="6c">6c</option>
						<option value="7a">7a</option>
						<option value="7b">7b</option>
						<option value="7c">7c</option>
						<option value="8a">8a</option>
						<option value="8b">8b</option>
						<option value="8c">8c</option>
						<option value="9a">9a</option>
						<option value="9b">9b</option>
						<option value="9c">9c</option>

					</select>
				</div>
				<div class="form_element">
					<div class="tag">
						OFFICIEL DE L'ASSOCIATION :
						<p>
							<input type="radio" name="tagged" value="true" checked="checked">Oui
							<input type="radio" name="tagged" value="false">Non
						</p>
					</div>
				</div>


				<div class="form_element">
					<div class="element">
						<input type="hidden" class="form_label" id="id" name="id">
						<button type="submit" class="btn_form_submit">Soumettre</button>
					</div>
				</div>
			</form>
		</div>
		<footer><%@ include file="footer.jsp"%></footer>
	</div>
</body>
</html>