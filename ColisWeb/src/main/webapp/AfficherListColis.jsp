<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Info comptes</title>
	<link rel="stylesheet" type="text/css" href="css/base.css" >
</head>
<body>
	<h1>Affichage colis</h1>
	<h2>Informations colis :</h2>
	<table>
		<thead>
			<tr>
				<th>Numéro</th>
				<th>Prix</th>
				<th>Poids</th>
				<th>Origine</th>
				<th>Destination</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${colis}"  var="colis">
				<tr>
					<td>${colis.id }</td>
					<td>
						<fmt:formatNumber type="currency"
										  currencySymbol="&euro;"
										  value="${colis.prix }">
						</fmt:formatNumber>
					</td>
					<td>${colis.poids}</td>
					<td>${colis.origine}</td>
					<td>${colis.destination}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p><a href="index.jsp">Revenir à la page principale</a></p>
</body>
</html>