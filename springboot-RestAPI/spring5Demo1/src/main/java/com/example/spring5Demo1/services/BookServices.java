package com.example.spring5Demo1.services;

import com.example.spring5Demo1.model.Book;

import java.util.List;

public interface BookServices {

        public void addBook (Book b);
        public List<Book> getBooks ();
        public void deleteBook (String bid);
}

