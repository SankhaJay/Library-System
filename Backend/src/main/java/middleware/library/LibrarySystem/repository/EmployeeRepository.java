
package middleware.library.LibrarySystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import middleware.library.LibrarySystem.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    Employee findByName(String name);
}