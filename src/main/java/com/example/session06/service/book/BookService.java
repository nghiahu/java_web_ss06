package com.example.session06.service.book;

import com.example.session06.model.Book;

import java.util.ArrayList;

public interface BookService {
    ArrayList<Book> findAllBooks();
    boolean addBook(Book book);
    Book findBook(int id);
    boolean updateBook(Book book);
    boolean deleteBook(int id);
}
