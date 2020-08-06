
package middleware.library.LibrarySystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import middleware.library.LibrarySystem.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    List<Employee> findByName(String name);
//    Employee findByNic(String nic);
}