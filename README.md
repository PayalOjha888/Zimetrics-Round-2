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
     


   <img width="1919" height="619" alt="Screenshot 2026-01-27 190126" src="https://github.com/user-attachments/assets/1f1d6360-a011-4097-ac8b-941a8e5f32b0" />



   - Adding the book details to the database through API: [POST]http://localhost:8080/api/addBooks
     
     

   <img width="1357" height="779" alt="Screenshot 2026-01-27 213457" src="https://github.com/user-attachments/assets/5d112249-271d-4902-88f5-31d89f7466f6" />
   


   - Resultant modification shown in h2-console
     
     
     
   <img width="1919" height="1020" alt="Screenshot 2026-01-27 222054" src="https://github.com/user-attachments/assets/b2dde80c-d6c4-4536-86d3-175b1dda6bea" />



   - Fetching all the books through API: [GET]http://localhost:8080/api/showAllBooks
     
     

   <img width="1378" height="922" alt="Screenshot 2026-01-27 222132" src="https://github.com/user-attachments/assets/30b0c4ff-9c9c-48d0-bb6c-a01e86eb959a" />



   - Fetching Books filtered by year through API: [GET]http://localhost:8080/api/books/search?year=2002
     
     

   <img width="1397" height="895" alt="Screenshot 2026-01-27 223722" src="https://github.com/user-attachments/assets/c7b8b46b-f95d-4b94-b30f-faac4ddc0886" />



   - Delete the book by id through the API: [DELETE]http://localhost:8080/api/removeBook/{id}
     

     
   <img width="1400" height="772" alt="Screenshot 2026-01-27 222230" src="https://github.com/user-attachments/assets/b3bc7dda-d95a-4a20-ae99-17dc66bef231" />




   - Fetching the books from empty dataset giving 204(No Content) in response through API: [GET]http://localhost:8080/api/books/search?year=2002
     

  
   <img width="1388" height="894" alt="Screenshot 2026-01-27 223908" src="https://github.com/user-attachments/assets/93d8fb38-d44c-44d3-95e1-652d1f5384c4" />




   - Hibernate Query Generation on performing each operation through RestAPI shown in terminal:
     
  
  <img width="1885" height="645" alt="Screenshot 2026-01-27 223930" src="https://github.com/user-attachments/assets/3c7673da-c3f8-43da-83be-44149ce4cfd6" />

  

5. Future Improvements

- Frontend Integration (React.js)
Logic: I plan to build a full-featured Dashboard using React.js and Tailwind CSS. This will include a responsive table to display the library inventory, intuitive forms for adding new books, and a real-time search bar for instant filtering.

   Why: This will eliminate the dependency on API clients like Postman for end-users and provide a seamless, user-friendly experience.

- Global Exception Handling
Logic: Currently, the API returns default Spring Boot error stack traces. I intend to implement a @ControllerAdvice class to intercept exceptions and return standardized, clean JSON error responses (e.g., specific messages for 404 Not Found or 400 Bad Request).

  Why: Professional error handling makes the API more secure, predictable, and easier for frontend developers to integrate with.

- Pagination and Sorting
Logic: As the library inventory grows to thousands of records, fetching all data at once will impact performance. I plan to implement the Pageable interface in the Service layer to allow for paginated results and alphabetical sorting of book titles.

  Why: This will significantly improve the API's scalability and reduce memory consumption on both the server and client sides.


