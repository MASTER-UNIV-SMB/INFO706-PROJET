# I706 – TP JEE (JavaEE/JakartaEE)

Ce projet consiste à implanter une application pour gérer les « colis » acheminés par une importante société spécialisée dans le transport.

## Installation

Nous avons utilisé une image Docker pour lancer un serveur Glassfish et ainsi déployer notre application

```docker run -it --rm -p 4848:4848 -p 8080:8080 -p 8181:8181 shinyay/docker-glassfish5```

Ensuite connectez-vous sur :

```http://localhost:4848```

### Identifiant :

**User Name** : _admin_<br/>
**Password** : _glassfish_

Cliquez sur Applications et déployez après compilation du projet ```gradle build``` les fichiers **EAR** et **WAR**

## Utilisation

L'application se découpe en 3 onglets

- Enregistrer un colis (pour ajouter un colis)
- Ajouter une étape à un colis (pour ajouter une étape de suivie au colis)
- Suivre la progression du colis (pour obtenir le suivie du colis avec ces étapes)

