package com.ems.dao;

import com.ems.helper.DatabaseConnection;
import com.ems.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    public void addEmployee(Employee e) {
        String sql = "{call sp_AddEmployee(?,?,?,?,?)}";

        try (Connection conn = DatabaseConnection.connect();
             CallableStatement cs = conn.prepareCall(sql)) {

            cs.setString(1, e.getFirstName());
            cs.setString(2, e.getLastName());
            cs.setString(3, e.getEmail());
            cs.setDouble(4, e.getSalary());
            cs.setInt(5, e.getDepartmentId());
            cs.execute();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        String sql = "{call sp_GetAllEmployees}";

        try (Connection conn = DatabaseConnection.connect();
             CallableStatement cs = conn.prepareCall(sql);
             ResultSet rs = cs.executeQuery()) {

            while (rs.next()) {
                list.add(new Employee(
                        rs.getInt("employee_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getDouble("salary"),
                        0
                ));
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return list;
    }

    public Employee getEmployeeById(int id) {
        String sql = "{call sp_GetEmployeeById(?)}";

        try (Connection conn = DatabaseConnection.connect();
             CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, id);
            ResultSet rs = cs.executeQuery();

            if (rs.next()) {
                return new Employee(
                        rs.getInt("employee_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getDouble("salary"),
                        rs.getInt("department_id")
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }


    public void updateEmployee(Employee e) {
        String sql = "{call sp_UpdateEmployee(?,?,?,?,?,?)}";

        try (Connection conn = DatabaseConnection.connect();
             CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, e.getEmployeeId());
            cs.setString(2, e.getFirstName());
            cs.setString(3, e.getLastName());
            cs.setString(4, e.getEmail());
            cs.setDouble(5, e.getSalary());
            cs.setInt(6, e.getDepartmentId());

            cs.execute();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }


    public void deleteEmployee(int id) {
        String sql = "{call sp_DeleteEmployee(?)}";

        try (Connection conn = DatabaseConnection.connect();
             CallableStatement cs = conn.prepareCall(sql)) {

            cs.setInt(1, id);
            cs.execute();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
