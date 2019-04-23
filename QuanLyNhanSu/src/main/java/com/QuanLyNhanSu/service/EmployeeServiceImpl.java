package com.QuanLyNhanSu.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.QuanLyNhanSu.model.Employee;
import com.QuanLyNhanSu.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> search(String q) {
        return employeeRepository.findByNameContaining(q);
    }

    @Override
    public Employee findById(int id) {
    	return employeeRepository.findById(id).get();
    }

    @Override
    public void save(Employee contact) {
    	employeeRepository.save(contact);
    }

    @Override
    public void delete(int id) {
    	employeeRepository.deleteById(id);
    }
}