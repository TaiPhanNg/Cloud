package com.QuanLyNhanSu.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.QuanLyNhanSu.model.Projects;
import com.QuanLyNhanSu.repository.ProjectsRepository;
@Service
public class ProjectsServiceImpl implements ProjectsService {
	@Autowired
	private ProjectsRepository projectsRepository;
	 @Override
	    public Iterable<Projects> findAll() {
	        return projectsRepository.findAll();
	    }

	    @Override
	    public List<Projects> search(String q) {
	        return projectsRepository.findByNameContaining(q);
	    }

	    @Override
	    public Projects findById(int id) {
	    	return projectsRepository.findById(id).get();
	    }

	    @Override
	    public void save(Projects contact) {
	    	projectsRepository.save(contact);
	    }

	    @Override
	    public void delete(int id) {
	    	projectsRepository.deleteById(id);
	    }
}
