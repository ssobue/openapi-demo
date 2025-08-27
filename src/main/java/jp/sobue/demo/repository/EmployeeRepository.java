package jp.sobue.demo.repository;

import java.util.List;
import jp.sobue.demo.model.entity.Employee;

/**
 * Employee Repository.
 *
 * @author Sho SOBUE
 */
public interface EmployeeRepository {

  /**
   * Find all employees.
   *
   * @return List of employees
   */
  List<Employee> findAll();

  /**
   * Find an employee by ID.
   *
   * @param id ID
   * @return Employee
   */
  Employee findById(Integer id);

  /**
   * Insert an employee.
   *
   * @param employee Employee
   */
  void insert(Employee employee);

  /**
   * Update an employee.
   *
   * @param employee Employee
   */
  void update(Employee employee);
}
