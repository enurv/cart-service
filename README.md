# Cart Service

Welcome to the Cart Service, a straightforward application designed for adding items to a cart, applying discounts, and
calculating the total price. This service has been developed using Tactical Domain-Driven Design principles to enhance
its architecture and maintainability.

## Architecture Overview

The application is structured into distinct layers, each serving a specific purpose:

- **Controller**: This layer handles incoming requests and provides responses to clients.

- **Application Service**: Responsible for orchestrating interactions between domain services and factories,
  facilitating command flows.

- **Factory**: This layer is responsible for creating domain objects and providing support for dynamically managed
  instances using Dependency Injection.

- **Domain Entities**: This layer comprises domain objects that encapsulate the core business logic closely related to
  specific
  classes.

- **Domain Services**: These services handle business logic that isn't directly tied to specific classes but is crucial
  for the overall functionality.

Please note that the application does not include a database; instead, it employs a simple in-memory database to store
cart items. As a result, there is no repository layer.

## Endpoints

You can utilize the provided [Postman collection](cart-service.postman_collection.json) to test the various endpoints
offered by the Cart Service.

## Running the Application

To get the Cart Service up and running, follow these steps:

1. Clone the repository to your local machine.

2. Navigate to the project directory:

```
cd cart-service
mvn package
docker build -t cart-service-container .
docker run -p 8080:8080 cart-service-container
```

If you don't have Docker installed, you can start the application using the following command:

```
cd cart-service
mvn spring-boot:run
```

## Testing the application

To run the tests, run the following command:

```
mvn test
```
