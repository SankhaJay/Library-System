package middleware.library.LibrarySystem.repository;

import middleware.library.LibrarySystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByName(String name);
}
