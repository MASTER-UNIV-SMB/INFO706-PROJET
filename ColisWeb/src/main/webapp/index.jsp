<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Gestion des colis</title>
	<link rel="stylesheet" type="text/css" href="css/base.css" >
    <link rel="stylesheet" type="text/css" href="css/getmdl-select.min.css" >
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="css/getmdl.min.css">
    <script defer src="js/getmdl-select.min.js"></script>
    <script defer src="js/getmdl.min.js"></script>
</head>
<body>
    <div class="mdl-layout mdl-js-layout mdl-layout--fixed-header
                mdl-layout--fixed-tabs">
        <header class="mdl-layout__header">
            <div class="mdl-layout__header-row">
                <span class="mdl-layout-title">Gestion des colis</span>
            </div>
            <div class="mdl-layout__tab-bar mdl-js-ripple-effect">
                <a href="#fixed-tab-1" class="mdl-layout__tab is-active">Enregistrer un colis</a>
                <a href="#fixed-tab-2" class="mdl-layout__tab">Ajouter une étape à un colis</a>
                <a href="#fixed-tab-3" class="mdl-layout__tab">Suivre la progression d'un colis</a>
            </div>
        </header>
        <main class="mdl-layout__content">
            <section class="mdl-layout__tab-panel is-active" id="fixed-tab-1">
                <div class="page-content">
                    <form action="EnregistrerColisServlet" method="post" class="form">
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label field">
                            <input class="mdl-textfield__input" type="number" pattern="-?[0-9]*(\.[0-9]+)?" id="poids" name="poids">
                            <label class="mdl-textfield__label" for="poids">Poids</label>
                            <span class="mdl-textfield__error">Ce n'est pas un nombre !</span>
                        </div>
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label field">
                            <input class="mdl-textfield__input" type="number" pattern="-?[0-9]*(\.[0-9]+)?" id="prix" name="prix">
                            <label class="mdl-textfield__label" for="prix">Valeur</label>
                            <span class="mdl-textfield__error">Ce n'est pas un nombre !</span>
                        </div>
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label field">
                            <input class="mdl-textfield__input" type="text" id="origine" name="origine">
                            <label class="mdl-textfield__label" for="origine">Origine</label>
                        </div>
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label field">
                            <input class="mdl-textfield__input" type="text" id="destination" name="destination">
                            <label class="mdl-textfield__label" for="destination">Destination</label>
                        </div>
                        <input type="submit" value="Enregistrer" class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored">
                    </form>
                </div>
            </section>
            <section class="mdl-layout__tab-panel" id="fixed-tab-2">
                <div class="page-content">
                    <form action="AjouterEtapeColisServlet" method="post" class="form" >
                        <div class="mdl-textfield mdl-js-textfield getmdl-select">
                            <input type="text" value="" class="mdl-textfield__input" name="id_colis" id="id_colis" readonly>
                            <input type="hidden" value="" name="id_colis">
                            <label for="sample1" class="mdl-textfield__label">Identifiant colis</label>
                            <ul for="sample1" class="mdl-menu mdl-menu--bottom-left mdl-js-menu">
                                <c:forEach items="${listeColis}"  var="colis">
                                    <li class="mdl-menu__item" data-val="${colis.id}">${colis.id}</li>
                                </c:forEach>
                            </ul>
                        </div>
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label field">
                            <input class="mdl-textfield__input" type="text" id="latitude" name="latitude">
                            <label class="mdl-textfield__label" for="latitude">Latitude</label>
                        </div>
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label field">
                            <input class="mdl-textfield__input" type="text" id="longitude" name="longitude">
                            <label class="mdl-textfield__label" for="longitude">Longitude</label>
                        </div>
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label field">
                            <input class="mdl-textfield__input" type="text" id="emplacement" name="emplacement">
                            <label class="mdl-textfield__label" for="emplacement">Emplacement</label>
                        </div>
                        <div class="mdl-textfield mdl-js-textfield getmdl-select field">
                            <input type="text" value="" class="mdl-textfield__input" name="etat" id="etat" readonly>
                            <input type="hidden" value="" name="etat">
                            <label for="sample1" class="mdl-textfield__label">Etat</label>
                            <ul for="sample1" class="mdl-menu mdl-menu--bottom-left mdl-js-menu">
                                <li class="mdl-menu__item" data-val="ENREGISTREMENT">ENREGISTREMENT</li>
                                <li class="mdl-menu__item" data-val="EN_ATTENTE">EN_ATTENTE</li>
                                <li class="mdl-menu__item" data-val="ACHEMINEMENT">ACHEMINEMENT</li>
                                <li class="mdl-menu__item" data-val="BLOQUE">BLOQUE</li>
                                <li class="mdl-menu__item" data-val="LIVRE">LIVRE</li>
                            </ul>
                        </div>
                        <input type="submit" value="Modifier" class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored">
                    </form>
                </div>
            </section>

            <section class="mdl-layout__tab-panel" id="fixed-tab-3">
                <div class="page-content">
                    <form action="SuivreProgressionColisServlet" method="post" class="form">
                        <div class="mdl-textfield mdl-js-textfield getmdl-select field">
                            <input type="text" value="" class="mdl-textfield__input" name="id" id="id" readonly>
                            <input type="hidden" value="" name="id">
                            <label for="sample1" class="mdl-textfield__label">Identifiant colis</label>
                            <ul for="sample1" class="mdl-menu mdl-menu--bottom-left mdl-js-menu">
                                <c:forEach items="${listeColis}"  var="colis">
                                    <li class="mdl-menu__item" data-val="${colis.id}">${colis.id}</li>
                                </c:forEach>
                            </ul>
                        </div>
                        <input type="submit" value="chercher" class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored">
                    </form>
                </div>
            </section>
        </main>
    </div>
</body>
</html>