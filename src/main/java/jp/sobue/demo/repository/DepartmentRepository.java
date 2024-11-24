package jp.sobue.demo.repository;

import java.util.List;
import jp.sobue.demo.model.entity.Department;

public interface DepartmentRepository {

  List<Department> findAll();

  Department findById(Integer id);

  void insert(Department department);

  void update(Department department);
}
