package jp.sobue.demo.service;

import java.util.List;
import jp.sobue.demo.model.entity.Employee;

/**
 * Logic layer for employee.
 *
 * @author Sho SOBUE
 */
public interface EmployeeService {

  /**
   * Get all employees.
   *
   * @return a List of departments.
   */
  List<Employee> getAll();

  /**
   * Get an employee by ID.
   *
   * @param id employee id
   * @return an employee
   */
  Employee getById(Integer id);

  /**
   * Create an employee.
   *
   * @param employee an employee
   */
  void create(Employee employee);

  /**
   * Update an employee.
   *
   * @param employee an employee
   */
  void update(Employee employee);

  /**
   * Delete an employee.
   *
   * @param employee an employee
   */
  void delete(Employee employee);
}
