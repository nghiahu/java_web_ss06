package com.example.session06.service.user;

import com.example.session06.model.User;

public interface UserService {
    boolean register(User user);
    User login(String username, String password);
}
