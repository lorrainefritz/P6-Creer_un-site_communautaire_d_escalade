<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Les Amis de L'escalade</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div id="bloc_page">
		<header><%@ include file="menu.jsp"%></header>

		<div id=image>
			<img
				alt="un chat sur une colline regardant au loin sur fond de montagne"
				src="\imagesAndLogos\images\CatOnAHill.jpg">
			<p>
				Test
				<c:out value="${1/2}"></c:out>
			</p>

		</div>
	</div>
	<footer><%@ include file="footer.jsp"%></footer>
</body>
</html>