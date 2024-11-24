package jp.sobue.demo.repository;

import java.util.List;
import jp.sobue.demo.model.entity.Employee;

public interface EmployeeRepository {

  List<Employee> findAll();

  Employee findById(Integer id);

  void insert(Employee employee);

  void update(Employee employee);
}
