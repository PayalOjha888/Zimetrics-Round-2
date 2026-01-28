package com.Task.LibraryAPI.Repository;

import com.Task.LibraryAPI.Model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepo extends JpaRepository<Books, Integer> {
    List<Books> findAllByYear(int year);
}
