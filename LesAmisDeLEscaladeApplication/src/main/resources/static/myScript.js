
function test () {
	window.alert("test");
}
//_______________________Validation Site d'escalade____________________________________

function validateClimbingSite(){
	document.getElementById("errorTitleSiteEscalade").innerHTML = "";
	document.getElementById("errorLieuSiteEscalade").innerHTML = "";
	document.getElementById("errorSecteurSiteEscalade").innerHTML = "";
	document.getElementById("errorLongueurSiteEscalade").innerHTML = "";
	document.getElementById("errorNombreDeVoiesSiteEscalade").innerHTML = "";
	emptyTitleSiteEscalade();
	emptyLieuSiteEscalade();
	emptySecteurSiteEscalade();
	emptyLongueurSiteEscalade();
	emptyNombreDeVoiesSiteEscalade();
	titleLenghtSiteEscaladeIsNotValid()
	lieuLenghtSiteEscaladeIsNotValid()
	secteurLenghtSiteEscaladeIsNotValid()
	longueurLenghtSiteEscaladeIsNotValid();
	nombreDeVoiesLenghtSiteEscaladeIsNotValid();
}

function emptyTitleSiteEscalade() {
	var titleSiteEscalade = document.getElementById("titleSiteEscalade").value;
	if (titleSiteEscalade == "") {
		document.getElementById("errorTitleSiteEscalade").innerHTML = "Le champs titre est vide";
// 		event.preventDefault();
	}	
}
function emptyLieuSiteEscalade() {
	var lieuSiteEscalade = document.getElementById("lieuSiteEscalade").value;
	if (lieuSiteEscalade == "") {
		document.getElementById("errorLieuSiteEscalade").innerHTML = "Le champs lieu est vide";
//		event.preventDefault();
	}
}
function emptySecteurSiteEscalade() {
	var secteurSiteEscalade = document.getElementById("secteurSiteEscalade").value;
	if (secteurSiteEscalade == "") {
		document.getElementById("errorSecteurSiteEscalade").innerHTML = "Le champs secteur est vide";
//		event.preventDefault();
	}
}
function emptyLongueurSiteEscalade() {
	var longueurSiteEscalade = document.getElementById("longueurSiteEscalade").value;
	if (longueurSiteEscalade == 0) {
		document.getElementById("errorLongueurSiteEscalade").innerHTML = "Le champs longueur est vide";
//		event.preventDefault();
	}	
}	
function emptyNombreDeVoiesSiteEscalade() {
	var nombreDeVoiesSiteEscalade = document.getElementById("nombreDeVoiesSiteEscalade").value;
	if (nombreDeVoiesSiteEscalade == 0) {
		document.getElementById("errorNombreDeVoiesSiteEscalade").innerHTML = "Le champs nombre de Voies est vide";
//		event.preventDefault();
	}		
}

function titleLenghtSiteEscaladeIsNotValid() {
	var title = document.getElementById("titleSiteEscalade").value;
	if (title < 0 || title.length > 65) {		
		document.getElementById("errorTitleSiteEscalade").innerHTML = "La valeur du champs titre doit être compris entre 1 et 65 caractères";
//		event.preventDefault();
	}
}
function lieuLenghtSiteEscaladeIsNotValid() {
	var lieu = document.getElementById("lieuSiteEscalade").value;
	if (lieu < 0 || lieu.length > 65) {		
		document.getElementById("errorLieuSiteEscalade").innerHTML = "La valeur du champs lieu doit être compris entre 1 et 65 caractères";
//		event.preventDefault();
	}
}

function secteurLenghtSiteEscaladeIsNotValid() {
	var secteur = document.getElementById("secteurSiteEscalade").value;
	if (secteur < 0 || secteur.length > 65) {		
		document.getElementById("errorSecteurSiteEscalade").innerHTML = "La valeur du champs secteur doit être compris entre 1 et 65 caractères";
//		event.preventDefault();
	}
}

function longueurLenghtSiteEscaladeIsNotValid() {
	var longueur = document.getElementById("longueurSiteEscalade").value;
	if (isNaN(longueur) || longueur < 0 || longueur > 100) {		
		document.getElementById("errorLongueurSiteEscalade").innerHTML = "La valeur du champs longueur doit être compris entre 1 et 100";
//		event.preventDefault();
	}
}
function nombreDeVoiesLenghtSiteEscaladeIsNotValid() {
	var nombreDeVoies = document.getElementById("nombreDeVoiesSiteEscalade").value;
	if (isNaN(nombreDeVoies) || nombreDeVoies < 0 || nombreDeVoies > 10) {
		document.getElementById("errorNombreDeVoiesSiteEscalade").innerHTML = "La valeur du champs nombre de voies doit être compris entre 1 et 10";
//		event.preventDefault();
	}
}

function imageInvalidFormat() {
	var image = document.getElementById("imageSiteEscalade").value;
	var png = "^[a-zA-Z0-9]+\.png$";
	var jpeg = "^[a-zA-Z0-9]+\.jpeg$";
	if (!image.match(png)&&!image.match(jpeg)) {
		document.getElementById("errorImageSiteEscalade").innerHTML = "Merci de rentrer un nom d'image en .jpeg ou .png";
//		event.preventDefault();
	}
}
//_______________________Validation ajout d'un nouveau type de role général____________________________________

function validateAddRole(){
	window.alert("test Ajout role");
	document.getElementById("errorNameRole").innerHTML = "";
	emptyNameRole();
	nameRoleLenghtIsNotValid();
}

function emptyNameRole() {
	var nameRole = document.getElementById("nameRole").value;
	if (nameRole == "") {
		document.getElementById("errorNameRole").innerHTML = "Le champs nom du role est vide";
// 		event.preventDefault();
	}	
}
function nameRoleLenghtIsNotValid() {
	var nameRole = document.getElementById("nameRole").value;
	if (nameRole < 0 || nameRole.length > 65) {		
		document.getElementById("errorNameRole").innerHTML = "La valeur du champs nom du role doit être compris entre 1 et 65 caractères";
//		event.preventDefault();
	}
}

//_______________________Validation ajout d'un Commentaire____________________________________

function validateAjouterUnCommentaire(){
	window.alert("test Commentaire");
	document.getElementById("errorTitleCommentaire").innerHTML = "";
	document.getElementById("errorContentCommentaire").innerHTML = "";
	document.getElementById("errorSignatureCommentaire").innerHTML = "";
	emptyTitleCommentaire();
	emptyContentCommentaire();
	emptySignatureCommentaire();
	titleCommentaireLenghtIsNotValid();
	contentCommentaireLenghtIsNotValid();
	contentSignatureLenghtIsNotValid();
}

function emptyTitleCommentaire() {
	var titleCommentaire = document.getElementById("titleCommentaire").value;
	if (titleCommentaire == "") {
		document.getElementById("errorTitleCommentaire").innerHTML = "Le champs titre est vide";
// 		event.preventDefault();
	}	
}
function titleCommentaireLenghtIsNotValid() {
	var titleCommentaire = document.getElementById("titleCommentaire").value;
	if (titleCommentaire < 0 || titleCommentaire.length > 65) {		
		document.getElementById("errorTitleCommentaire").innerHTML = "La valeur du champs titre doit être compris entre 1 et 65 caractères";
//		event.preventDefault();
	}
}

function emptyContentCommentaire() {
	var contentCommentaire = document.getElementById("contentCommentaire").value;
	if (contentCommentaire == "") {
		document.getElementById("errorContentCommentaire").innerHTML = "Le champs contenu est vide";
// 		event.preventDefault();
	}	
}
function contentCommentaireLenghtIsNotValid() {
	var contentCommentaire = document.getElementById("contentCommentaire").value;
	if (contentCommentaire < 0 || contentCommentaire.length > 65) {		
		document.getElementById("errorContentCommentaire").innerHTML = "La valeur du champs contenu doit être compris entre 1 et 65 caractères";
//		event.preventDefault();
	}
}

function emptySignatureCommentaire() {
	var signatureCommentaire = document.getElementById("signatureCommentaire").value;
	if (signatureCommentaire == "") {
		document.getElementById("errorSignatureCommentaire").innerHTML = "Le champs signature est vide";
// 		event.preventDefault();
	}	
}
function contentSignatureLenghtIsNotValid() {
	var signatureCommentaire = document.getElementById("signatureCommentaire").value;
	if (signatureCommentaire < 0 || signatureCommentaire.length > 65) {		
		document.getElementById("errorSignatureCommentaire").innerHTML = "La valeur du champs signature doit être compris entre 1 et 65 caractères";
//		event.preventDefault();
	}
}


//_______________________Validation ajout d'un Topo____________________________________

function validateAjouterUnTopo(){
	window.alert("test Topo");
	document.getElementById("errorTitleTopo").innerHTML = "";
	document.getElementById("errorContentTopo").innerHTML = "";
	emptyTitleTopo();
	emptyContentTopo();
	titleTopoLenghtIsNotValid();
	contentTopoLenghtIsNotValid();
}

function emptyTitleTopo(){
	var titleTopo = document.getElementById("titleTopo").value;
	if (titleTopo == "") {
		document.getElementById("errorTitleTopo").innerHTML = "Le champs titre est vide";
// 		event.preventDefault();
	}	
}
function titleTopoLenghtIsNotValid() {
	var titleTopo = document.getElementById("titleTopo").value;
	if (titleTopo < 0 || titleTopo.length > 65) {		
		document.getElementById("errorTitleTopo").innerHTML = "La valeur du champs titre doit être compris entre 1 et 65 caractères";
//		event.preventDefault();
	}
}

function emptyContentTopo(){
	var contentTopo = document.getElementById("contentTopo").value;
	if (contentTopo == "") {
		document.getElementById("errorContentTopo").innerHTML = "Le champs contenu est vide";
// 		event.preventDefault();
	}	
}
function contentTopoLenghtIsNotValid() {
	var contentTopo = document.getElementById("contentTopo").value;
	if (contentTopo < 0 || contentTopo.length > 65) {		
		document.getElementById("errorContentTopo").innerHTML = "La valeur du champs contenu doit être compris entre 1 et 65 caractères";
//		event.preventDefault();
	}
}

//_______________________Validation ajout d'un utilisateur =>registration____________________________________

function validateRegistration(){
	window.alert("test registration");
	document.getElementById("errorNomRegistration").innerHTML = "";
	document.getElementById("errorPrenomRegistration").innerHTML = "";
	document.getElementById("errorAdresseRegistration").innerHTML = "";
	document.getElementById("errorTelephoneRegistration").innerHTML = "";
	document.getElementById("errorPasswordRegistration").innerHTML = "";
	document.getElementById("errorEmailRegistration").innerHTML = "";
	emptyNomRegistration();
	emptyPrenomRegistration();
	emptyAdresseRegistration();
	emptyTelephoneRegistration();
	emptyPasswordRegistration();
	emptyEmailRegistration();
	nomRegistrationLenghtIsNotValid();
	prenomRegistrationLenghtIsNotValid();
	adresseRegistrationLenghtIsNotValid();
	telephoneRegistrationLenghtIsNotValid();
	passwordRegistrationLenghtIsNotValid();
	emailRegistrationLenghtIsNotValid();
}

function emptyNomRegistration() {
	var nomRegistration = document.getElementById("nomRegistration").value;
	if (nomRegistration == "") {
		document.getElementById("errorNomRegistration").innerHTML = "Le champs nom est vide";
// 		event.preventDefault();
	}	
}
function nomRegistrationLenghtIsNotValid() {
	var nomRegistration = document.getElementById("nomRegistration").value;
	if (nomRegistration < 0 || nomRegistration.length > 65) {		
		document.getElementById("errorNomRegistration").innerHTML = "La valeur du champs nom doit être compris entre 1 et 65 caractères";
//		event.preventDefault();
	}
}

function emptyPrenomRegistration() {
	var prenomRegistration = document.getElementById("prenomRegistration").value;
	if (prenomRegistration == "") {
		document.getElementById("errorPrenomRegistration").innerHTML = "Le champs prenom est vide";
// 		event.preventDefault();
	}	
}
function prenomRegistrationLenghtIsNotValid() {
	var prenomRegistration = document.getElementById("prenomRegistration").value;
	if (prenomRegistration < 0 || prenomRegistration.length > 65) {		
		document.getElementById("errorPrenomRegistration").innerHTML = "La valeur du champs prenom doit être compris entre 1 et 65 caractères";
//		event.preventDefault();
	}
}

function emptyAdresseRegistration() {
	var adresseRegistration = document.getElementById("adresseRegistration").value;
	if (adresseRegistration == "") {
		document.getElementById("errorAdresseRegistration").innerHTML = "Le champs adresse est vide";
// 		event.preventDefault();
	}	
}
function adresseRegistrationLenghtIsNotValid() {
	var adresseRegistration = document.getElementById("adresseRegistration").value;
	if (adresseRegistration < 0 || adresseRegistration.length > 65) {		
		document.getElementById("errorAdresseRegistration").innerHTML = "La valeur du champs adresse doit être compris entre 1 et 65 caractères";
//		event.preventDefault();
	}
}

function emptyTelephoneRegistration() {
	var telephoneRegistration = document.getElementById("telephoneRegistration").value;
	if (telephoneRegistration == "") {
		document.getElementById("errorTelephoneRegistration").innerHTML = "Le champs telephone est vide";
// 		event.preventDefault();
	}	
}
function telephoneRegistrationLenghtIsNotValid() {
	var telephoneRegistration = document.getElementById("telephoneRegistration").value;
	if (telephoneRegistration < 0 || telephoneRegistration.length > 65) {		
		document.getElementById("errorTelephoneRegistration").innerHTML = "La valeur du champs Telephone doit être compris entre 1 et 65 caractères";
//		event.preventDefault();
	}
}

function emptyPasswordRegistration() {
	var passwordRegistration = document.getElementById("passwordRegistration").value;
	if (passwordRegistration == "") {
		document.getElementById("errorPasswordRegistration").innerHTML = "Le champs mot de passe est vide";
// 		event.preventDefault();
	}	
}
function passwordRegistrationLenghtIsNotValid() {
	var passwordRegistration = document.getElementById("passwordRegistration").value;
	if (passwordRegistration < 0 || passwordRegistration.length > 65) {		
		document.getElementById("errorPasswordRegistration").innerHTML = "La valeur du champs mot de passe doit être compris entre 1 et 65 caractères";
//		event.preventDefault();
	}
}

function emptyEmailRegistration() {
	var emailRegistration = document.getElementById("emailRegistration").value;
	if (emailRegistration == "") {
		document.getElementById("errorEmailRegistration").innerHTML = "Le champs email est vide";
// 		event.preventDefault();
	}	
}
function emailRegistrationLenghtIsNotValid() {
	var emailRegistration = document.getElementById("emailRegistration").value;
	if (emailRegistration < 0 || emailRegistration.length > 65) {		
		document.getElementById("errorEmailRegistration").innerHTML = "La valeur du champs email doit être compris entre 1 et 65 caractères";
//		event.preventDefault();
	}
}