package com.example.session06.service.user;

import com.example.session06.dao.user.UserDAO;
import com.example.session06.dao.user.UserDAOImp;
import com.example.session06.model.User;

public class UserServiceImp implements UserService{
    private final UserDAOImp userDAO;

    public UserServiceImp(){
        this.userDAO = new UserDAOImp();
    }
    @Override
    public boolean register(User user) {
        return userDAO.register(user);
    }

    @Override
    public User login(String username, String password) {
        return userDAO.login(username, password);
    }
}
