package com.example.biblioteca.Repositories;

import com.example.biblioteca.Models.BookModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<BookModel, Long> {

    public Optional<BookModel> findByCode(String Code);
    public Optional<BookModel> findByTitle(String Title);

}

