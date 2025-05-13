package com.example.session06.dao.book;

import com.example.session06.model.Book;
import com.example.session06.utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDAOImp implements BookDAO {
    @Override
    public ArrayList<Book> findAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        ArrayList<Book> books = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call fildAllBook()}");
            callSt.execute();
            ResultSet rs = callSt.getResultSet();
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setCategory(rs.getString("category"));
                book.setQuantity(rs.getInt("quantity"));
                books.add(book);
            }
            return books;
        }catch (SQLException e) {
            System.out.println("Có lỗi trong quá trình duyệt: "+e.getMessage());
        }catch (Exception e){
            System.out.println("Có lỗi không xác định trong quá trình duyệt: "+e.getMessage());
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return books;
    }

    @Override
    public boolean addBook(Book book) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call addNewBook(?,?,?,?)}");
            callSt.setString(1, book.getTitle());
            callSt.setString(2, book.getAuthor());
            callSt.setString(3, book.getCategory());
            callSt.setInt(4, book.getQuantity());
            callSt.execute();
            return true;
        }catch (SQLException e) {
            System.out.println("Có lỗi trong quá trình thêm: "+e.getMessage());
        }catch (Exception e){
            System.out.println("Có lỗi không xác định trong quá trình thêm: "+e.getMessage());
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    @Override
    public Book findBook(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        Book book = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call findById(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                book = new Book();
                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setCategory(rs.getString("category"));
                book.setQuantity(rs.getInt("quantity"));
            }
            return book;
        }catch (SQLException e) {
            System.out.println("Có lỗi trong quá trình tìm kiếm: "+e.getMessage());
        }catch (Exception e){
            System.out.println("Có lỗi không xác định trong quá trình tìm kiếm: "+e.getMessage());
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return book;
    }

    @Override
    public boolean updateBook(Book book) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call updateBook(?,?,?,?,?)}");
            callSt.setInt(1, book.getId());
            callSt.setString(2, book.getTitle());
            callSt.setString(3, book.getAuthor());
            callSt.setString(4, book.getCategory());
            callSt.setInt(5, book.getQuantity());
            callSt.execute();
            return true;
        }catch (SQLException e) {
            System.out.println("Có lỗi trong quá trình cập nhật: "+e.getMessage());
        }catch (Exception e){
            System.out.println("Có lỗi không xác định trong quá trình cập nhật: "+e.getMessage());
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    @Override
    public boolean deleteBook(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call deleteBook(?)}");
            callSt.setInt(1, id);
            callSt.execute();
            return true;
        }catch (SQLException e) {
            System.out.println("Có lỗi trong quá trình xóa: "+e.getMessage());
        }catch (Exception e){
            System.out.println("Có lỗi không xác định trong quá trình xóa: "+e.getMessage());
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }
}
