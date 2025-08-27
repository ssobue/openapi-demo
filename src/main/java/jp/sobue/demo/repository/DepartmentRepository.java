package jp.sobue.demo.repository;

import java.util.List;
import jp.sobue.demo.model.entity.Department;

/**
 * Department Repository.
 *
 * @author Sho SOBUE
 */
public interface DepartmentRepository {

  /**
   * Find all departments.
   *
   * @return List of departments
   */
  List<Department> findAll();

  /**
   * Find a department by ID.
   *
   * @param id ID
   * @return Department
   */
  Department findById(Integer id);

  /**
   * Insert a department.
   *
   * @param department Department
   */
  void insert(Department department);

  /**
   * Update a department.
   *
   * @param department Department
   */
  void update(Department department);
}
