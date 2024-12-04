## Pour demarrer ce projet vous avez besoin :
- Un JDK 21
- Créer une base de données en utilisant le SGBD MySQL, nommer 'bd-banque' ou si vous voulez renommer la base de données vous pouvez changer le nom depuis le fichier application.properties  
- Démarrer votre votre serveur de base de données
- Exécuter les commande suivante l'une après l'autre dans un terminal en vous positionnant à la racine du projet:
`mvn clean`
`mvn install`
`mvn spring-boot:run`
- Après avoir suivit les instructions précédentes vous pouvez consommer l'api en utilisant swagger (http://localhost:8082/swagger-ui/index.html) ou postman
- C'est mieux d'explorer la documentation de l'API depuis swagger et ensuite utiliser postman pour consommer certaines ressources qui demandent l'authentification qui se passe à l'aide de token Bearer 
