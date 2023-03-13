package com.example.spring5Demo1.repository;

import com.example.spring5Demo1.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

    @Repository
    public class BookRepositoryImpl implements BookRepository {
        List<Book> bookList;

        public BookRepositoryImpl() {
            bookList = new ArrayList<>();
        }


        @Override
        public void addBook(Book book) {
            bookList.add(book);
        }
        @Override
        public List<Book> getBooks() {
            return bookList;
        }

        @Override
        public void deleteBook(String b_id) {
            Book temp=null;
            for(Book b:bookList)
            {
                if(b.getB_id().equals(b_id))
                {
                    temp=b;
                    break;
                }
            }
            if(temp!=null)
            {
                bookList.remove(temp);
            }

        }
    }

