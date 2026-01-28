package com.Task.LibraryAPI.Service;

import com.Task.LibraryAPI.Model.Books;
import com.Task.LibraryAPI.Repository.BooksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private BooksRepo repo;

    public List<Books> getBooks() {
        return repo.findAll();
    }

    public Books addBooks(Books books) {
       return repo.save(books);
    }

    public void deleteItem(int id) {
        repo.deleteById(id);
    }

    public List<Books> getBookByYear(int year) {
        return repo.findAllByYear(year);
    }
}
