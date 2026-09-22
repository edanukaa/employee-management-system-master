package com.ems.dao;

import com.ems.helper.DatabaseConnection;
import com.ems.model.User;

import java.sql.*;

public class UserDao {

    public User login(String username, String password) {
        String sql = "{call sp_LoginUser(?,?)}";

        try (Connection conn = DatabaseConnection.connect();
             CallableStatement cs = conn.prepareCall(sql)) {

            cs.setString(1, username);
            cs.setString(2, password);

            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getInt("user_id"),
                        rs.getString("username"),
                        rs.getString("role_name").equals("ADMIN") ? 1 : 2
                );
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return null;
    }
}
