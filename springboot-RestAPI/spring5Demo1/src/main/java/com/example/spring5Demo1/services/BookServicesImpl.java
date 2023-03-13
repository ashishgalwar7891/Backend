package com.example.spring5Demo1.services;

import com.example.spring5Demo1.model.Book;
import com.example.spring5Demo1.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServicesImpl implements BookServices
{
    //private BookRepository bookRepository=new BookRepositoryImpl();

    @Autowired
    private BookRepository bookRepository;


    @Override
    public void addBook(Book b) {
        bookRepository.addBook(b);
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.getBooks();
    }

    @Override
    public void deleteBook(String bid) {
        bookRepository.deleteBook(bid);
    }
}
