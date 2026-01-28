## Library Management API (In-Memory)

1. Project Title & Goal
   
This is a robust RESTful API built with Spring Boot to manage a library book inventory using strictly in-memory (H2) storage, designed for efficient book tracking and retrieval.

2. Setup Instructions
      
To run this project locally, follow these steps:

- Clone the repository
git clone https://github.com/Payal0jha888/Zimetrics-Round-2.git

- Navigate to project folder
cd LibraryAPI

- Build the project using Maven
mvn clean install

- Run the application
mvn spring-boot:run

  The API will be available at http://localhost:8080

3. The Logic (How I thought)
- Approach: I chose Spring Boot with Spring Data JPA because it allows for rapid development and clean separation of concerns (Controller-Service-Repository pattern).
- The Hardest Bug: Initially, I faced a HttpMessageNotReadableException (400 Bad Request) where JSON keys weren't mapping to Java primitives. I fixed this by using the @JsonProperty("year") annotation and switching from int to Integer to handle potential null values gracefully during deserialization.
- Storage: Since "strictly in-memory" was required, I configured an H2 Database that clears on every restart, ensuring no persistent junk data.

4. Output Screenshots
   - Connecting the in-memory database: H2
  
     
   - Adding the book details to the database through API: [POST]http://localhost:8080/api/addBooks
  
     
   - Resultant modification shown in h2-console
  
     
   - Fetching all the books through API: [GET]http://localhost:8080/api/showAllBooks
  
     
   - Fetching Books filtered by year through API: [GET]http://localhost:8080/api/books/search?year=2002
  
     
   - Delete the book by id through the API: [DELETE]http://localhost:8080/api/removeBook/{id}


   - Fetching the books from empty dataset giving 204(No Content) in response through API: [GET]http://localhost:8080/api/books/search?year=2002
  
     

6. Future Improvements
If I had 2 more days, I would add:

- Global Exception Handling: To return custom user-friendly error messages instead of standard Spring stack traces.

- Swagger/OpenAPI Documentation: To provide an interactive UI for testing the endpoints without needing Postman.

- Unit Testing: Implement JUnit and Mockito tests for the Service layer logic.


