package com.example.session06.service.book;

import com.example.session06.dao.book.BookDAOImp;
import com.example.session06.model.Book;

import java.util.ArrayList;

public class BookServiceImp implements BookService {
    private final BookDAOImp bookDAO;

    public BookServiceImp() {
        this.bookDAO = new BookDAOImp();
    }

    @Override
    public ArrayList<Book> findAllBooks() {
        return bookDAO.findAll();
    }

    @Override
    public boolean addBook(Book book) {
        return bookDAO.addBook(book);
    }

    @Override
    public Book findBook(int id) {
        return bookDAO.findBook(id);
    }

    @Override
    public boolean updateBook(Book book) {
        return bookDAO.updateBook(book);
    }

    @Override
    public boolean deleteBook(int id) {
        return bookDAO.deleteBook(id);
    }
}
