# Getting Started with Spring boot tests

### Reference Documentation
Examples of how to test Spring boot Application:


  Using MockMvc \
    http://localhost:8080/hello \
    http://localhost:8080/input?name=joe \
    http://localhost:8080/input?name=joe&id=10 \
  Use @ExceptionHandler or @ControllerAdvice to handle exceptions globally. \
  @ControllerAdvice. This class will be responsible for handling exceptions globally. \
  @ExceptionHandler. These methods will handle exceptions just as they did in the controller, but now they apply across all controllers in the application.

### Test scenarios :
* Endpoint Validation: Verify that all API endpoints are accessible and return the expected results based on different inputs. \
* CRUD Operations: Test all CRUD (Create, Read, Update, Delete) operations to ensure they work as expected. \
* Input Validation: Ensure that the API correctly handles valid and invalid inputs. This includes checking for required fields, data types, and value constraints.\
* Response Formats: Validate that the API returns responses in the correct format (e.g., JSON, XML) and with the correct content type. \
* Status Codes: Ensure the API returns appropriate HTTP status codes (e.g., 200 OK, 201 Created, 400 Bad Request, 404 Not Found, 500 Internal Server Error) for different scenarios.\






* CONTRACT / PACT Testing https://github.com/mkris8/spring-boot-contract-testing-pact.git 
* Unit testing (jUnit)
* TODO Integration Testing
* TODO TestContainers
* TODO API Testing

