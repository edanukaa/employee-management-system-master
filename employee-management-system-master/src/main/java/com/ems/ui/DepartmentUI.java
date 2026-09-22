package com.ems.ui;

import com.ems.service.DepartmentService;

public class DepartmentUI {

    private final DepartmentService departmentService = new DepartmentService();

    public void start() {
        departmentService.getAllDepartments()
                .forEach(d ->
                        System.out.println(
                                d.getDepartmentId() + " - " +
                                        d.getDepartmentName()
                        )
                );
    }
}
