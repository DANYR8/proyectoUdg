package com.example.biblioteca.Controlles;

import com.example.biblioteca.Models.BookModel;
import com.example.biblioteca.Repositories.BookRepository;
import com.example.biblioteca.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/book")
@CrossOrigin
public class BookController {
    @Autowired
    BookService bookService;
    @Autowired
    private BookRepository bookRepository;

    //Get
    @GetMapping
    public ArrayList<BookModel> findAllBooks(){
        return bookService.findAllBooks();
    }

    //Post
    @PostMapping
    public BookModel saveBook(@RequestBody BookModel book){
        return bookService.saveBook(book);
    }

    //Edit
    @CrossOrigin
    @PutMapping()
    public BookModel updateBook(@RequestBody BookModel book){
        return bookService.saveBook(book);
    }

    //FindByTittle
    @GetMapping("/find-by-title")//localhost:8080/book/find-by-title
    public Optional<BookModel> findBookByTitle(@RequestParam("code") String title){
        return bookService.findByName(title);
    }

    //FindByCode
    @GetMapping("/find-by-code")//localhost:8080/book/find-by-code
    public Optional<BookModel> findBookByCode(@RequestParam("code") String code){
        return bookService.findByCode(code);
    }

    @CrossOrigin
    @DeleteMapping("/deleteByCode/{code}")
    public String deleteBookByCode(@PathVariable("code") String code) {
        return bookService.deleteBook(code);
    }


}
