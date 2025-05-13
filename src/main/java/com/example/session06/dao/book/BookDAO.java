package com.example.session06.dao.book;

import com.example.session06.model.Book;

import java.util.ArrayList;

public interface BookDAO {
    ArrayList<Book> findAll();
    boolean addBook(Book book);
    Book findBook(int id);
    boolean updateBook(Book book);
    boolean deleteBook(int id);
}
