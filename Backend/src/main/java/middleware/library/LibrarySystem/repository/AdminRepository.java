package middleware.library.LibrarySystem.repository;

import java.util.List;
import middleware.library.LibrarySystem.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AdminRepository extends JpaRepository<Admin, Integer>{
    List<Admin> findByName(String name);


}

