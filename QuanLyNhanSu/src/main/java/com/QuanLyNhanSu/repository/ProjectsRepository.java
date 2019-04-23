package com.QuanLyNhanSu.repository;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.QuanLyNhanSu.model.Projects;;

public interface  ProjectsRepository  extends CrudRepository<Projects, Integer> {

    List<Projects> findByNameContaining(String q);

}
