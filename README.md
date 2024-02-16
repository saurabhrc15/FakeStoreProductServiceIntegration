# Third-Party Product Service Integration

This Java Spring Boot application serves as a middleware for interacting with a third-party product service, specifically designed to manage product information by communicating with the Fake Store API. It abstracts the complexities involved in directly interacting with the third-party API and provides a simplified, RESTful interface to fetch, add, and update product details.

## Features

- **List Products**: Fetch a list of products with optional filtering parameters.
- **Get Product Details**: Retrieve detailed information about a specific product by ID.
- **Add New Product**: Add a new product to the third-party service.
- **Update Product**: Update details of an existing product.

## How It Works

The application defines a `ProductController` that handles incoming HTTP requests for various product-related operations. It utilizes a `ProductService` to process these requests, which in turn, communicates with the Fake Store API to perform the necessary actions.

### Endpoints

- `GET /products`: List all products or filter them based on query parameters.
- `GET /product/{id}`: Get details of a specific product by its ID.
- `POST /product`: Add a new product with the details provided in the request body.
- `PUT /product/{id}`: Update an existing product identified by its ID with the new details provided in the request body.

## Getting Started

To run this application:

1. Ensure you have Java and Maven installed on your system.
2. Clone the repository to your local machine.
3. Navigate to the project directory and run `mvn spring-boot:run` to start the application.
4. The application will be accessible at `http://localhost:8080`.

## Dependencies

- Spring Boot
- Spring Web MVC
- Any other necessary libraries are managed through Maven.

## Contribution

Feel free to fork the repository and submit pull requests to contribute to the development of this application. For major changes, please open an issue first to discuss what you would like to change.
