package vn.techmaster.employee.service;

import java.util.List;

import vn.techmaster.employee.model.Employee;

public interface EmployeeService {
  List<Employee> findAll();

  Employee findById(Long id);

  Employee addOrUpdate(Employee book);

  void deleteById(long id);
}
