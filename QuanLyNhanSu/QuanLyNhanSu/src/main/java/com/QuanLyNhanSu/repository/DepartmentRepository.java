package com.QuanLyNhanSu.repository;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.QuanLyNhanSu.model.Department;

public interface  DepartmentRepository extends CrudRepository<Department, Integer> {

    List<Department> findByNameContaining(String q);

}