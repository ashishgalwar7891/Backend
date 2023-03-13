package com.example.spring5Demo1.repository;

import com.example.spring5Demo1.model.Book;

import java.util.List;

public interface BookRepository {
    public void addBook(Book book);
    public List<Book> getBooks();
    public void deleteBook(String b_id);
}
