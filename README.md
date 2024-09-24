Product Management RESTful Web Service
  This project provides a RESTful API for managing a list of products. It allows users to create, read, update, and delete (CRUD) product entries through HTTP requests.

Features
  Get all products: Retrieve the list of all products.
  Create a product: Add a new product with all mandatory fields.
  Update a product: Modify existing product details (description, category, price, or isSpecial status).
  Delete a product: Remove a specific product by its ID.

Product Model
  Each product contains the following properties:
    id (integer, unique identifier)
    description (string, product description)
    category (string, must be one of: vegetables, meat, furniture)
    price (decimal, up to 2 decimal places)
    isSpecial (boolean, true or false)
API Endpoints
1. Get All Products
  Endpoint: /products
  Method: GET
  Response: JSON object containing all products.
2. Create a New Product
  Endpoint: /products
  Method: POST
  Request Body: JSON object with all mandatory product fields:
  Response: Newly created product's details in JSON format.
3. Update a Product
  Endpoint: /products/{id}
  Method: PUT
  Request Body: JSON object with fields to update (any of the following: description, category, price, isSpecial):
  Response: Updated product's details in JSON format.
4. Delete a Product
  Endpoint: /products/{id}
  Method: DELETE
  Response: Confirmation message.
