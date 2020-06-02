<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
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
		<form method="post">
		

			<div class="form element">
				<label for="title">Titre</label> <input type="text"
					class="form label" id="title" name="title"
					placeholder="Obligatoire" value="${param.title}">
				<div class="element">
					<span class="text-danger">${InputError.get("title")} </span>
				</div>
			</div>
			<div class="form element">
				<label for="image">Image</label> <input type="text"
					class="form label" id="image" name="image"
					placeholder="Obligatoire" value="${param.image}">

				<div class="element">
					<span class="text-danger">${InputError.get("image")} </span>
				</div>
			</div>

			<div class="form element">
				<label for="secteur">Secteur</label> <input type="text"
					class="form label" id="secteur" name="secteur"
					placeholder="Obligatoire" value="${param.secteur}">

				<div class="element">
					<span class="text-danger">${InputError.get("secteur")} </span>
				</div>
			</div>

			<div class="form element">
				<label for="longueur">Longueur</label> <input type="text"
					class="form label" id="longueur" name="longueur" placeholder=">0"
					value="${param.longueur}">

				<div class="element">
					<span class="text-danger">${InputError.get("longueur")} </span>
				</div>
			</div>

			<div class="form element">
				<label for="nombreDeVoies">Nombre de Voies</label> <input
					type="text" class="form label" id="nombreDeVoies"
					name="nombreDeVoies" placeholder="1-100"
					value="${param.nombreDeVoies}">

				<div class="element">
					<span class="text-danger">${InputError.get("nombreDeVoies")}
					</span>
				</div>
			</div>


			<div class="form element">Difficulté
			
			<select name="difficulty"> 
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
				<div class="element">
					<span class="text-danger">${InputError.get("difficulty")} </span>
				</div>
			</div>


			<div class="form element">
				<div id ="tag">
				<p> Officiel des Amis de L'escalade</p>
					<input type="radio" name="tagged" value="true">Oui
					<input type="radio" name="tagged" value="false">Non

					<div class="element">
						<span class="text-danger"> </span>
					</div>
				</div>
			</div>


			<div class="form element">
				<div class="element">
					<input type="hidden" class="form label" id="id" name="id">
					<button type="submit" class="btn btn-primary">Submit</button>
				</div>
			</div>
		</form>
		<footer><%@ include file="footer.jsp"%></footer>
	</div>
</body>
</html>