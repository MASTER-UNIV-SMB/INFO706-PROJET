<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Progression du colis</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="css/getmdl.min.css">
    <script defer src="js/getmdl.min.js"></script>
</head>
<body>
    <div class="mdl-layout mdl-js-layout mdl-layout--fixed-header
                mdl-layout--fixed-tabs">
        <header class="mdl-layout__header">
            <div class="mdl-layout__header-row">
                <span class="mdl-layout-title">Progressions du colis</span>
            </div>
        </header>
        <main class="mdl-layout__content">
            <div class="mdl-card__title mdl-card--expand">
                <h2 class="mdl-card__title-text">Colis n°${colis.id }</h2>
            </div>
            <div class="mdl-card__supporting-text">
                <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
                    <thead>
                        <tr>
                            <th class="mdl-data-table__cell--non-numeric">Emplacement</th>
                            <th class="mdl-data-table__cell--non-numeric">Etat</th>
                            <th>Latitude</th>
                            <th>Longitude</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${progressions}" var="progression">
                        <tr>
                            <td class="mdl-data-table__cell--non-numeric">${progression.emplacement}</td>
                            <td class="mdl-data-table__cell--non-numeric">${progression.etat}</td>
                            <td>${progression.latitude}</td>
                            <td>${progression.longitude}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="mdl-card__actions">
                <a class="mdl-button mdl-js-button mdl-button--raised mdl-button--accent" href="index.html">Revenir à la page principale</a>
            </div>
        </main>
    </div>
</body>
</html>