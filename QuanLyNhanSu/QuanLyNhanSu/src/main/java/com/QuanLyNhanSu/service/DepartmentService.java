package com.QuanLyNhanSu.service;
import java.util.List;
import com.QuanLyNhanSu.model.Department;

public interface DepartmentService {

	Iterable<Department> findAll();

    List<Department> search(String q);

    Department findById(int id);

    void save(Department contact);

    void delete(int id);
}
