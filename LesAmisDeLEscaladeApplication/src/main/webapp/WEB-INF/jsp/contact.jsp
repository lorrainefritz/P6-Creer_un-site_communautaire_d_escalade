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
				<h1>NOUS CONTACTER</h1>
			</div>
		</header>
		<div class=contact_page>
			<div class=contact_element>
				<h2>Où nous trouver</h2>
				<p>
					6 rue Beauregard 57970 KATZENHEIM.<br>
					<i>Email de contact</i> : nous-contacter@lesAmisDeLEscalade.com <br>
					<i>Téléphone</i> : 03 82 88 88 88
				</p>
			</div>
		</div>
		<footer><%@ include file="footer.jsp"%></footer>
	</div>
</body>
</html>