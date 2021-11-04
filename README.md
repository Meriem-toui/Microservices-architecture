# Microservices-architecture

Microservices are both an architecture and an approach to software development that consists of breaking down applications into the simplest pieces, independent of each other. Unlike a classic monolithic approach, where all components form an inseparable entity, microservices work synergistically to accomplish the same tasks, while being separate. Each of these components or processes is a microservice.

# Excise
1. Create the Customer-service micro service
  - Create the Customer entity
  - Create the CustomerRepository interface based on Spring Data
  - Deploy the Restful API of the micro-service using Spring Data Rest
  - Test the Micro service
2. Create the Inventory-service micro-service
  - Create the Product entity
  - Create the ProductRepository interface based on Spring Data
  - Deploy the Restful API of the micro-service using Spring Data Rest
  - Test the Micro service
3. Create the Gateway service using Spring Cloud Gateway
   1. Test the Proxy Service using a Static configuration based on the application.yml file
   2. Test the Proxy Service using a Static configuration based on a Java configuration
4. Create the Registry Service directory based on NetFlix Eureka Server
5. Test the proxy using a dynamic configuration of Route management to micro services registered in the Eureka Server directory
6. Create the Billing-Service service using Open Feign to communicate with the Customer-service and Inventory-service services
7. Create an Angular client that allows you to display an invoice
