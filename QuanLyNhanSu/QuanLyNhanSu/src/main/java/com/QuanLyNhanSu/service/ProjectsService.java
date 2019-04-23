package com.QuanLyNhanSu.service;
import java.util.List;
import com.QuanLyNhanSu.model.Projects;
public interface ProjectsService {
	Iterable<Projects> findAll();

    List<Projects> search(String q);

   Projects findById(int id);

    void save(Projects contact);

    void delete(int id);
}
