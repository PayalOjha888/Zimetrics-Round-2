package com.Task.LibraryAPI.Controller;

import com.Task.LibraryAPI.Model.Books;
import com.Task.LibraryAPI.Service.InventoryService;
import org.hibernate.type.descriptor.java.YearJavaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class InventoryController {

    @Autowired
    private InventoryService service;

    @GetMapping("/showAllBooks")
    public List<Books> showBooks(){
        return service.getBooks();
    }

    @PostMapping("/addBooks")
    public Books addBooks(@RequestBody Books books){
        return service.addBooks(books);
    }

    @DeleteMapping("/removeBook/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable int id){
        service.deleteItem(id);
        return new ResponseEntity<>("Item with id "+id+" has been deleted successfully!", HttpStatus.OK);
    }

    //Get the books by year
    // URL: localhost:8080/api/books/search?year=2024
    @GetMapping("/books/search")
    public ResponseEntity<List<Books>> searchByYear(@RequestParam("year") int year) {
        List<Books> books = service.getBookByYear(year);
        if (books.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
}
