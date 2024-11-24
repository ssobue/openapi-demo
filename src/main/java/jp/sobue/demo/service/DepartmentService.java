package jp.sobue.demo.service;

import java.util.List;
import jp.sobue.demo.model.entity.Department;

/**
 * Logic layer for department.
 *
 * @author Sho SOBUE
 */
public interface DepartmentService {

  /**
   * Get all departments.
   *
   * @return a List of departments.
   */
  List<Department> getAll();

  /**
   * Get a department by ID.
   *
   * @param id department id
   * @return a departments
   */
  Department getById(Integer id);

  /**
   * Create a department.
   *
   * @param department a department
   */
  void create(Department department);

  /**
   * Update a department.
   *
   * @param department a department
   */
  void update(Department department);

  /**
   * Delete a department.
   *
   * @param department a department
   */
  void delete(Department department);
}
