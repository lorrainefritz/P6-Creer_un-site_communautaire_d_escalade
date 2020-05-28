<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
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
				<h1>TOUS LES SITES D'ESCALADE</h1>
			</div>
		</header>
		<table class="table">
			<thead class="table top">
				<tr>
					<th>ID</th>
					<th>IMAGE</th>
					<th>TITRE</th>
					<th>SECTEUR</th>
					<th>LONGUEUR</th>
					<th>NOMBRE DE VOIES</th>
					<th>DIFFICULTE</th>
					<th>TAG</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="cS" items="${climbingSiteItems}">
					<tr>
						<td>${cS.id}</td>
						<td>${cS.image}</td>
						<td>${cS.title}</td>
						<td>${cS.secteur}</td>
						<td>${cS.longueur}</td>
						<td>${cS.nombreDeVoies}</td>
						<td>${cS.difficulty}</td>
						<td>${cS.tagged}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>




		<footer><%@ include file="footer.jsp"%></footer>
	</div>
</body>
</html>