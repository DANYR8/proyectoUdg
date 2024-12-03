package com.example.biblioteca.Services;

import com.example.biblioteca.Models.BookModel;
import com.example.biblioteca.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    //GET
    public ArrayList<BookModel> findAllBooks(){
        return (ArrayList<BookModel>) bookRepository.findAll();
    }
    //SAVE
    public BookModel saveBook(BookModel book){
        return bookRepository.save(book);
    }

    //FindByCode
    public Optional<BookModel> findByCode(String code){
        return bookRepository.findByCode(code);
    }
    //FindByTitle
    public Optional<BookModel> findByName(String title){
        return bookRepository.findByTitle(title);
    }

    //Delete
    public String deleteBook(String code){
        String response = "";
        Optional<BookModel> bookFound = bookRepository.findByCode(code);
        if(bookFound.isPresent()){
            bookRepository.delete(bookFound.get());
            response = "Book deleted successfully";
        }else{
            response = "Book not found";
        }
        return response;
    }
}
