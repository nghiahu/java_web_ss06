package com.example.session06.dao.user;

import com.example.session06.model.User;

public interface UserDAO {
    boolean register(User user);
    User login(String username, String password);
}
