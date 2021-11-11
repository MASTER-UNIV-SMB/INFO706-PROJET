<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Information colis</title>
    <link rel="stylesheet" type="text/css" href="css/base.css" >
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="css/getmdl.min.css">
    <script defer src="js/getmdl.min.js"></script>
</head>
<body>
    <div class="mdl-layout mdl-js-layout mdl-layout--fixed-header
            mdl-layout--fixed-tabs">
        <header class="mdl-layout__header">
            <div class="mdl-layout__header-row">
                <span class="mdl-layout-title">Information colis</span>
            </div>
        </header>
        <main class="mdl-layout__content">
            <div class="demo-card-square mdl-card mdl-shadow--2dp">
                <div class="mdl-card__title mdl-card--expand">
                    <h2 class="mdl-card__title-text">Colis n°${colis.id }</h2>
                </div>
                <div class="mdl-card__supporting-text">
                    <p>Poids : ${colis.poids }</p>
                    <p>Prix : ${colis.prix }</p>
                    <p>Origine : ${colis.origine }</p>
                    <p>Destination : ${colis.destination }</p>
                </div>
                <div class="mdl-card__actions mdl-card--border">
                    <a class="mdl-button mdl-js-button mdl-button--raised mdl-button--accent" href="index.html">Revenir à la page principale</a>
                </div>
            </div>
        </main>
    </div>
</body>
</html>
