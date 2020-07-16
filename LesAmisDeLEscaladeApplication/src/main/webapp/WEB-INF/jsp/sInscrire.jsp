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
				<h1>S'INSCRIRE</h1>
			</div>
		</header>
		<div class="page_formulaire_inscription">
			<form class="formulaire_inscription" method="post"
				name="formulaire_inscription">
				<div class="form_element_inscription">
					<label for="name">NOM</label> <input type="text"
						class="form_label_inscription" id="name" name="name"
						placeholder="Obligatoire" value="${param.name}">
					<div class="element_danger_inscription">
						<div id="name_text_danger">${name}</div>
					</div>
				</div>
				<div class="form_element_inscription">
					<label for="firstName">PRENOM</label> <input type="text"
						class="form_label_inscription" id="firstName" name="firstName"
						placeholder="Obligatoire" value="${param.firstName}">
					<div class="element_danger_inscription">
						<div id="firstName_text_danger">${firstName}</div>
					</div>
				</div>
				<div class="form_element_inscription">
					<label for="adress">ADRESSE</label> <input type="text"
						class="form_label_inscription" id="adress" name="adress"
						placeholder="Obligatoire" value="${param.adress}">
					<div class="element_danger_inscription">
						<div id="adress_text_danger">${adress}</div>
					</div>
				</div>
				<div class="form_element_inscription">
					<label for="telephonNumber">NUMERO DE TELEPHONE</label> <input type="text"
						class="form_label_inscription" id="telephonNumber"
						name="telephonNumber" placeholder="Obligatoire"
						value="${param.telephonNumber}">
					<div class="element_danger_inscription">
						<div id="telephonNumber_text_danger">${telephonNumber}</div>
					</div>
				</div>
				<div class="form_element_inscription">
					<label for="mail">MAIL</label> <input type="text"
						class="form_label_inscription" id="mail" name="mail"
						placeholder="Obligatoire" value="${param.name}">
					<div class="element_danger_inscription">
						<div id="mail_text_danger">${mail}</div>
					</div>
				</div>
				<div class="form_element_inscription">
					<label for="password">MOT DE PASSE</label> <input type="text"
						class="form_label_inscription" id="password" name="password"
						placeholder="Obligatoire" value="${param.password}">
					<div class="element_danger_inscription">
						<div id="password_text_danger">${password}</div>
					</div>
				</div>
				<div class="form_element_inscription">
					<label for="passwordVerif">VERIFICATION DU MOT DE PASSE</label> <input
						type="text" class="form_label_inscription" id="passwordVerif"
						name="passwordVerif" placeholder="Obligatoire"
						value="${param.passwordVerif}">
					<div class="element_danger_inscription">
						<div id="passwordVerif_text_danger">${passwordVerif}</div>
					</div>
				</div>

				<div class="form_element">
					<div class="element">
						<input type="hidden" class="form_label" id="id" name="id">
						<button type="submit" class="btn_form_submit" id="btn_form_submit"
							onclick="">Soumettre</button>
					</div>
				</div>
			</form>
		</div>

		<footer><%@ include file="footer.jsp"%></footer>
	</div>
</body>
</html>