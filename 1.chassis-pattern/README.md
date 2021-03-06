# Chassis Design Pattern

**What is Chassis Design Pattern?**

In general, a chassis is the base frame of a car or it can be thought of as a skeleton. Similarly, in a microservices context, it can be the base framework or even another service which can be reused across different services. This pattern cuts down on the redundancy factor and complexity across services by abstracting the common logic to a separate layer. [1]

**Why we need it?**

When you start writing a new service by identifying a domain (DDD) or by identifying the functionality, you might end up writing lots of common code. As you progress and create more and more services, it could result in code duplication, or even chaos, to manage such common concerns and redundant functionalities. Moving such logic to a common place and reusing it across different services would improve the overall lifecycle of your service. You might spend some initial effort in creating this component but it will make your life easier later on. [1]

**How Do You Implement It in Your Microservices?**

It can be used in the following notable concerns:[1] [2]
- Logging
- Exception handling
- Health check
- Interception logic
- Metrics
- Authentication/security
- **Some common backend services you connect across services (databases, external calls, MQ, etc.)**
- Distributed tracing
- etc

More details like pros-cons, dos-dont's are mentioned here:

- [1] https://dzone.com/articles/ms-chassis-pattern
- [2] https://microservices.io/patterns/microservice-chassis.html
- [3] https://medium.com/@linjith/micro-service-chassis-9709ad8044ff



**Important Point to consider**

- There are different ways and sceanarios by which one can implement Chassis pattern. But here, in this repository, I have implemented one of the way by which one can implement such Framework. 

- There are so many cross-concerns availbale for which one can implement Chassis. But I choose Database service. (In this repository, I have implemented Chassis for different DB connection, configuration and connection pool mechanism.)

- The project has used the following technologies: Spring Boot(2.5.8), Java-8, MariaDB(10.3) and MongoDB(4.0)


**About the Project Structure...**

Let say, we have an an e-commerce application. In which, we have used 2 RDBMS(Maria DB) databases and 2 NoSQL(Mongo) databases. Also, it is a micro-service architecture and has the following microservices.

1.) Customer Microservice
- Name: microservice-customer
- Databse: database1 ( Hree, I have used mariadb )
- Port: 8081

2.) Purchase Microservice
- Name: microservice-purchase
- Databse: database2 ( I have used mariadb )
- Port: 8082

3.) Product Microservice
- Name: microservice-product
- Databse: database3 ( I have used mongodb )
- Port: 8083

4.) Feedback Microservice
- Name: microservice-feedback
- Databse: database1 ( I have used mongodb )
- Port: 8084


**How to Run**

1.) Prepare the Database(s). ( Execute the scripts under "database-scripts" module )

2.) Build the "module-common-entities" project by executing this command: 
- cd module-common-entities/
- ./gradlew build

3.) Build the "module-chassis" project by executing this command: 
- cd ../module-chassis/
- ./gradlew build

4.) Build and Run every microservice one by one.
- cd ../microservice-customer/
- ./gradlew build
- cd ../microservice-purchase/
- ./gradlew build
- cd ../microservice-product/
- ./gradlew build
- cd ../microservice-feedback/
- ./gradlew build

5.) Call the following end points:
- http://localhost:8081/customer
- http://localhost:8082/purchase
- http://localhost:8083/product
- http://localhost:8084/feedback



**Advantage of Chassis**

If we do not implement the Chassis then 
- we have to configure DB connection, connection-pool and other common(duplicate) configuration in every microservice.
- We have to duplicate the same thing in every microservice. (Reduandant code)
- We have to test everything, everytime in every microservice. (More testing)
- Some change(Let say change in IP, version, driver etc...) need to change in every microservice. (More maintaince)

While here you can see every thing is configured in "module-chassis" module.
- So no reduandant code, less testing and no maintaince
