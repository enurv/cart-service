# cart-service

This is a simple cart service that allows you to add items to a cart, apply discounts and calculate the total price.

Tactical domain driven design was used to design the application.

The building blocks of application are as follows:

- Controller: This layer is responsible for handling the requests and returning the responses.
- ApplicationService: This layer is responsible for establishing orchestration between the domain services and factories
  and set command flows.
- Factory: This layer is responsible for creating some domain objects and help dynamically using DI managed instances.
- Domain: This layer consists of domain objects establishing the business logic closely related to classes.
- Domain Services: This layer consists of domain services that are responsible for the business logic that is not
  closely related to classes.

This application doesn't have a database, it uses a simple in memory database to store the cart items. So it doesn't
have a repository layer.

## Endpoints

You can use the [Postman collection](cart-service.postman_collection.json) to test the endpoints.

## Running Application

Clone the repository and run the following commands:

```
cd cart-service
mvn package
docker build -t cart-service-container .
docker run -p 8080:8080 cart-service-container
```

You can also use the following command to run the application if you don't have docker installed:

```
cd cart-service
mvn spring-boot:run
```

## Testing the application

To run the tests, run the following command:

```
mvn test
```
