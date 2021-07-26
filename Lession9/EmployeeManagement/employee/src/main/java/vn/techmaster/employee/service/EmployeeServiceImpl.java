package vn.techmaster.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.techmaster.employee.exception.ResourceNotFoundException;
import vn.techmaster.employee.model.Employee;
import vn.techmaster.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
  @Autowired
  private EmployeeRepository employeeRepository;

  @Override
  public List<Employee> findAll() {
    return employeeRepository.findAll();
  }

  @Override
  public Employee findById(Long id) {    
    return employeeRepository.findById(id)
    .orElseThrow(() ->  new ResourceNotFoundException("Employee not found for this id :: " + id));
  }

  @Override
  public Employee update(long id, Employee employeeDetails) {
    Employee employee = this.findById(id);
    employee.setEmailId(employeeDetails.getEmailId());
    employee.setLastName(employeeDetails.getLastName());
    employee.setFirstName(employeeDetails.getFirstName());
    return employeeRepository.save(employee);
  }

  @Override
  public void deleteById(long id) {
    Employee employee = this.findById(id);
    employeeRepository.delete(employee);
  }

  @Override
  public Employee addOrUpdate(Employee employee) {
    return employeeRepository.save(employee);
  }
}
