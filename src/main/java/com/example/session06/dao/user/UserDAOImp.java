package com.example.session06.dao.user;

import com.example.session06.model.User;
import com.example.session06.utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImp implements UserDAO {

    @Override
    public boolean register(User user) {
        Connection conn = null;
        CallableStatement callSt = null;
        try{
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call registerUser(?,?,?,?)}");
            callSt.setString(1, user.getUsername());
            callSt.setString(2, user.getPassword());
            callSt.setString(3, user.getEmail());
            callSt.setString(4, user.getPhone());
            callSt.execute();
            return true;
        }catch (SQLException e){
            System.out.println("Có lỗi trong quá trình đăng ký: "+e.getMessage());
        }catch (Exception e){
            System.out.println("Có lỗi không xác định trong quá trình đăng ký: "+e.getMessage());
        }finally{
            ConnectionDB.closeConnection(conn,callSt);
        }
        return false;
    }

    @Override
    public User login(String username, String password) {
        Connection conn = null;
        CallableStatement callSt = null;
        User user = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call loginUser(?,?)}");
            callSt.setString(1, username);
            callSt.setString(2, password);
            callSt.execute();
            ResultSet rs = callSt.getResultSet();
            if(rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
            }
            return user;
        }catch (SQLException e){
            System.out.println("Có lỗi trong quá trình đăng ký: "+e.getMessage());
        }catch (Exception e){
            System.out.println("Có lỗi không xác định trong quá trình đăng ký: "+e.getMessage());
        }finally{
            ConnectionDB.closeConnection(conn,callSt);
        }
        return user;
    }
}
