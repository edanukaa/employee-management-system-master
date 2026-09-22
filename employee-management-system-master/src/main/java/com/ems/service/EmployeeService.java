package com.ems.service;

import com.ems.dao.EmployeeDao;
import com.ems.model.Employee;

import java.util.List;

public class EmployeeService {

    private final EmployeeDao dao = new EmployeeDao();

    public void addEmployee(Employee e) {
        if (e.getSalary() <= 0)
            throw new IllegalArgumentException("Salary must be positive");
        dao.addEmployee(e);
    }

    public List<Employee> getAllEmployees() {
        return dao.getAllEmployees();
    }

    public Employee getEmployeeById(int id) {
        return dao.getEmployeeById(id);
    }

    public void updateEmployee(Employee e, int roleId) {
        if (roleId != 1) {
            throw new SecurityException("Only admin can edit employees");
        }
        dao.updateEmployee(e);
    }


    public void deleteEmployee(int id, int roleId) {
        if (roleId != 1)
            throw new SecurityException("Only admin can delete employees");
        dao.deleteEmployee(id);
    }
}
