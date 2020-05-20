<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Les Amis de L'escalade</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div id="bloc_page">
		<header><%@ include file="menu.jsp"%></header>
		<form action="#" method="post" th:action=@{/climbingSiteItemForm}
			th:object="">

			<div class="form element">
				<span class="text danger" th:errors="*{global}"></span>
			</div>

			<div class="form element">
				<label for="title" class="form label">Titre</label>
				<div class="element">
					<input th:field="*{title}" type="text" class="form-control"
						placeholder="Obligatoire">
				</div>
				<div class="element">
					<span class="text-danger" th:errors="*{title}"> </span>
				</div>
			</div>

			<div class="form element">
				<label for="image" class="form label">Image</label>
				<div class="element">
					<input th:field="*{image}" type="text" class="form-control"
						placeholder="HOP">
				</div>
				<div class="element">
					<span class="text-danger" th:errors="*{image}"> </span>
				</div>
			</div>

			<div class="form element">
				<label for="secteur" class="form label">Secteur</label>
				<div class="element">
					<input th:field="*{secteur}" type="text" class="form-control"
						placeholder="Obligatoire">
				</div>
				<div class="element">
					<span class="text-danger" th:errors="*{secteur}"> </span>
				</div>

			</div>
			<div class="form element">
				<label for="longueur" class="form label">Longueur</label>
				<div class="element">
					<input th:field="*{longueur}" type="text" class="form-control"
						placeholder="Obligatoire">
				</div>
				<div class="element">
					<span class="text-danger" th:errors="*{longueur}"> </span>
				</div>

			</div>
			<div class="form element">
				<label for="nombre_de_voies" class="form label">Nombre de
					voies</label>
				<div class="element">
					<input th:field="*{nombre_de_voies}" type="text"
						class="form-control" placeholder="1-100">
				</div>
				<div class="element">
					<span class="text-danger" th:errors="*{nombre_de_voies}"> </span>
				</div>

			</div>

			<div class="form element">
				<label for="difficulte" class="form label">Difficulté</label>
				<div class="element">
					<input th:field="*{difficulte}" type="text" class="form-control"
						placeholder="3-9c">
				</div>
				<div class="element">
					<span class="text-danger" th:errors="*{difficulte}"> </span>
				</div>
			</div>

			<div class="form element">
				<div class="element">
					<input type="hidden" th:field="*{id}">
					<button type="submit" class="btn btn-primary">Submit</button>
				</div>
			</div>

		</form>
		<footer><%@ include file="footer.jsp"%></footer>
	</div>



</body>
</html>