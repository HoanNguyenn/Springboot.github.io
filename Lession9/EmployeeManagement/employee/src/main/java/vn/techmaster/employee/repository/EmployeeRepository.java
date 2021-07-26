package vn.techmaster.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.techmaster.employee.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
}
