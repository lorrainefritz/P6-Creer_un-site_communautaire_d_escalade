<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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


			<div class="form element">
				<label for="difficulty">Difficulté</label> <input type="text"
					class="form label" id="difficulty" name="difficulty"
					placeholder="3-9c" value="${param.difficulty}">

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