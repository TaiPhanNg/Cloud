package com.QuanLyNhanSu.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.QuanLyNhanSu.model.Department;
import com.QuanLyNhanSu.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;
	 @Override
	    public Iterable<Department> findAll() {
	        return departmentRepository.findAll();
	    }

	    @Override
	    public List<Department> search(String q) {
	        return departmentRepository.findByNameContaining(q);
	    }

	    @Override
	    public Department findById(int id) {
	    	return departmentRepository.findById(id).get();
	    }

	    @Override
	    public void save(Department contact) {
	    	departmentRepository.save(contact);
	    }

	    @Override
	    public void delete(int id) {
	    	departmentRepository.deleteById(id);
	    }
}
