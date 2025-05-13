package com.example.session06.controller;

import com.example.session06.model.Book;
import com.example.session06.model.User;
import com.example.session06.service.book.BookServiceImp;
import com.example.session06.service.user.UserServiceImp;
import com.example.session06.utils.ConnectionDB;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "bookController", value = "/bookController")
public class bookController extends HttpServlet {
    private final BookServiceImp bookServiceImp;
    private final UserServiceImp userServiceImp;
    private boolean isLogin = false;
    public bookController() {
        bookServiceImp = new BookServiceImp();
        userServiceImp = new UserServiceImp();
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action.equals("add")) {
            String title = request.getParameter("title");
            String author = request.getParameter("author");
            String catalog = request.getParameter("catalog");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            Book book = new Book(0,title, author, catalog, quantity);
            if(bookServiceImp.addBook(book)){
                response.sendRedirect("bookController");
            }
        }else if (action.equals("update")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String title = request.getParameter("title");
            String author = request.getParameter("author");
            String catalog = request.getParameter("catalog");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            Book book = new Book(id,title, author, catalog, quantity);
            bookServiceImp.updateBook(book);
            response.sendRedirect("bookController");
        } else if (action.equals("register")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            User user = new User(username,password,email,phone);
            if(userServiceImp.register(user)){
                response.sendRedirect("bookController");
            }
        }else if (action.equals("login")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            User user = userServiceImp.login(username, password);
            if(user != null){
                isLogin = true;
                response.sendRedirect("bookController");
            }else {
                request.setAttribute("error", "Tài khoản hoặc mật khẩu không đúng");
                request.getRequestDispatcher("view/Bai1,2/login.jsp").forward(request, response);
            }
        }
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        if (!isLogin){
            response.sendRedirect("view/Bai1,2/login.jsp");
        }else {
            if (action == null) {
                request.setAttribute("books", bookServiceImp.findAllBooks());
                request.getRequestDispatcher("view/Bai1,2/listBook.jsp").forward(request,response);
            }else if(action.equals("add")){
                response.sendRedirect("view/Bai1,2/formAdd.jsp");
            }else if(action.equals("update")){
                int id = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("idUpdate", id);
                Book book = bookServiceImp.findBook(id);
                request.setAttribute("idUpdate", book.getId());
                request.setAttribute("titleUpdate", book.getTitle());
                request.setAttribute("authorUpdate", book.getAuthor());
                request.setAttribute("catalogUpdate", book.getCategory());
                request.setAttribute("quantityUpdate", book.getQuantity());
                request.getRequestDispatcher("view/Bai1,2/formEdit.jsp").forward(request,response);
            }else if (action.equals("delete")) {
                int id = Integer.parseInt(request.getParameter("id"));
                if(bookServiceImp.deleteBook(id)){
                    response.sendRedirect("bookController");
                }
            }
        }
    }

    public void destroy() {
    }
}