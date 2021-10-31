# Microservices-architecture

Les microservices désignent à la fois une architecture et une approche de développement logiciel qui consiste à décomposer les applications en éléments les plus simples, indépendants les uns des autres. Contrairement à une approche monolithique classique, selon laquelle tous les composants forment une entité indissociable, les microservices fonctionnent en synergie pour accomplir les mêmes tâches, tout en étant séparés. Chacun de ces composants ou processus est un microservice.

#Excise
1. Créer le micro service Customer-service

• Créer l’entité Customer • Créer l’interface CustomerRepository basée sur Spring Data • Déployer l’API Restful du micro-service en utilisant Spring Data Rest • Tester le Micro service
2. Créer le micro service Inventory-service
  • Créer l’entité Product
  • Créer l’interface ProductRepository basée sur Spring Data 
  • Déployer l’API Restful du micro-service en utilisant Spring Data Rest
  •Tester le Micro service
3. Créer la Gateway service en utilisant Spring Cloud Gateway
   1. Tester la Service proxy en utilisant une configuration Statique basée sur le fichier application.yml
   2. Tester la Service proxy en utilisant une configuration Statique basée une configuration Java
4. Créer l’annuaire Registry Service basé sur NetFlix Eureka Server
5. Tester le proxy en utilisant une configuration dynamique de Gestion des routes vers les micro services enregistrés dans l’annuaire Eureka Server
6. Créer Le service Billing-Service en utilisant Open Feign pour communiquer avec les services Customer-service et Inventory-service
7. Créer un client Angular qui permet d’afficher une facture
