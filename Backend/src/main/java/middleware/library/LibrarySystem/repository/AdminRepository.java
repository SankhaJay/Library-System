package middleware.library.LibrarySystem.repository;

import java.util.List;
import middleware.library.LibrarySystem.entity.Administrator;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AdminRepository extends JpaRepository<Administrator, Integer>{
    List<Administrator> findByName(String name);


}

