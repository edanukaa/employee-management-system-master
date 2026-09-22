package com.ems.dao;

import com.ems.helper.DatabaseConnection;
import com.ems.model.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDao {

    public List<Department> getAllDepartments() {
        List<Department> list = new ArrayList<>();
        String sql = "{call sp_GetAllDepartments}";

        try (Connection conn = DatabaseConnection.connect();
             CallableStatement cs = conn.prepareCall(sql);
             ResultSet rs = cs.executeQuery()) {

            while (rs.next()) {
                list.add(new Department(
                        rs.getInt("department_id"),
                        rs.getString("department_name")
                ));
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return list;
    }
}
