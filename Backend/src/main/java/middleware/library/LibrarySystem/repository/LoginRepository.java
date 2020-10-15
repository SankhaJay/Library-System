package middleware.library.LibrarySystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import middleware.library.LibrarySystem.entity.Login;

public interface LoginRepository extends JpaRepository<Login, String>{

}
