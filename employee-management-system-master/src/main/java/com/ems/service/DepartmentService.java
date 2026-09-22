package com.ems.service;

import com.ems.dao.DepartmentDao;
import com.ems.model.Department;

import java.util.List;

public class DepartmentService {

    private final DepartmentDao departmentDao = new DepartmentDao();

    public List<Department> getAllDepartments() {
        return departmentDao.getAllDepartments();
    }
}
