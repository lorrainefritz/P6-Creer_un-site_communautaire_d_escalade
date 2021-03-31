/**
 * 
 */


function validate() {
	if (emptyTitle()) {
		document.getElementById("error_title").innerHTML = "Le champs du titre est vide signé JS";
		event.preventDefault();
	} 
}
	

	
function emptyTitle() {
	var name = document.getElementById("title").value;
	if (name == "") {
		return true;
			}
}
		
		
		
// if (emptyTitle()) {
// document.getElementById("title_text_danger").innerHTML = "Le champs titre est
// vide(signé JS)";
// event.preventDefault();
// }
//	if(emptyImage()){
//		document.getElementById("image_text_danger").innerHTML = "Le champs image est vide";
//		event.preventDefault();
//	}
//	if(imageInvalidFormat()){
//		document.getElementById("image_text_danger").innerHTML = "merci de mettre un image jpeg ou png";
//		event.preventDefault();
//	}
//	if (emptySecteur()){
//		document.getElementById("secteur_text_danger").innerHTML = "Le champs secteur est vide";
//		event.preventDefault();
//	}
//	if(emptyLongueur()){
//		document.getElementById("longueur_text_danger").innerHTML = "Le champs longueur est vide";
//		event.preventDefault();
//	}
//	if(emptyNombreDeVoies()){
//		document.getElementById("nombreDeVoies_text_danger").innerHTML = "Le champs du nombre de voies est vide";
//		event.preventDefault();
//	}
//	if(longueurLenghtIsNotValid()){
//		document.getElementById("longueur_text_danger").innerHTML = "la longueur n'est pas valide, merci de rentrer un chiffre entre 1 et 100";
//		event.preventDefault();
//	}
//	if(nombreDeVoiesLenghtIsNotValid()){
//		document.getElementById("nombreDeVoies_text_danger").innerHTML = "le nombre de voies n'est pas valide, merci de rentrer un chiffre entre 1 et 10";
//		event.preventDefault();
//	}
//}
//
//
//function emptyTitle() {
//	var title = document.forms["formulaire"]["title"].value;
//	if (title == "") {
//		return true;
//	}
//}
//function emptyImage() {
//	var image = document.forms["formulaire"]["image"].value;
//	if (image == "") {
//		return true;
//	}
//}
//function emptySecteur() {
//	var secteur = document.forms["formulaire"]["secteur"].value;
//	if (secteur == "") {
//		return true;
//	}
//}
//function emptyLongueur() {
//	var longueur = document.forms["formulaire"]["longueur"].value;
//	if (longueur == "") {
//		return true;
//	}
//}
//function emptyNombreDeVoies() {
//	var nombreDeVoies = document.forms["formulaire"]["nombreDeVoies"].value;
//	if (nombreDeVoies == "") {
//		return true;
//	}
//}
//
//function imageInvalidFormat() {
//	var image = document.forms["formulaire"]["image"].value;
//	var png = "^[a-zA-Z0-9]+\.png$";
//	var jpeg = "^[a-zA-Z0-9]+\.jpeg$";
//	if (!image.match(png)&&!image.match(jpeg)) {
//		
//		return true;
//	}
//}
//
//function longueurLenghtIsNotValid() {
//	var longueur = document.forms["formulaire"]["longueur"].value;
//	if (isNaN(longueur) || longueur < 1 || longueur > 100) {		
//		return true;
//	}
//}
//function nombreDeVoiesLenghtIsNotValid() {
//	var nombreDeVoies = document.forms["formulaire"]["nombreDeVoies"].value;
//	if (isNaN(nombreDeVoies) || nombreDeVoies < 1 || nombreDeVoies > 10) {
//		return true;
//	}
//}