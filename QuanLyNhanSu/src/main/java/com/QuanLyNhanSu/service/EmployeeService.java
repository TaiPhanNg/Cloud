package com.QuanLyNhanSu.service;
import java.util.List;
import com.QuanLyNhanSu.model.Employee;

public interface EmployeeService {
	Iterable<Employee> findAll();

    List<Employee> search(String q);

    Employee findById(int id);

    void save(Employee contact);

    void delete(int id);
}