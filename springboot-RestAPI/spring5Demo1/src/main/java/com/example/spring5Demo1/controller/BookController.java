package com.example.spring5Demo1.controller;


import com.example.spring5Demo1.model.Book;
import com.example.spring5Demo1.services.BookServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController
{
    //private BookServices bookServices=new BookServicesImpl();

    private BookServices bookServices;

    public BookController(BookServices bookServices) {
        this.bookServices = bookServices;
    }



    //http://localhost:65500/add-book   [post]  json{}
    @PostMapping("/add-book")
    public ResponseEntity<?> addBook(@RequestBody Book book)
    {
        bookServices.addBook(book);
        return new ResponseEntity<>("Data Added", HttpStatus.CREATED);
    }

    //http://localhost:65500/get-books   [get] --
    @GetMapping("/get-books")
    public ResponseEntity<?> getBooks()
    {
        return new ResponseEntity<>(bookServices.getBooks(),HttpStatus.OK);
    }



    //http://localhost:65500/delete-book/xxx   [delete]
    @DeleteMapping("/delete-book/{bid}")
    public ResponseEntity<?> deleteBook(@PathVariable String bid)
    {
        bookServices.deleteBook(bid);
        return new ResponseEntity<>("Deleted.........", HttpStatus.OK);
    }
}
