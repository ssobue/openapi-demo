package jp.sobue.demo.repository;

import java.util.List;
import jp.sobue.demo.model.entity.Department;
import jp.sobue.demo.model.entity.Employee;
import jp.sobue.demo.repository.mapper.DepartmentMapper;
import jp.sobue.demo.repository.mapper.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DepartmentRepositoryImpl implements DepartmentRepository {

  private final SqlSession sqlSession;

  @Override
  public List<Department> findAll() {
    return sqlSession.getMapper(DepartmentMapper.class).findAll();
  }

  @Override
  public Department findById(Integer id) {
    return sqlSession.getMapper(DepartmentMapper.class).findById(id);
  }

  @Override
  public void insert(Department department) {
    sqlSession.getMapper(DepartmentMapper.class).insert(department);
  }

  @Override
  public void update(Department department) {
    sqlSession.getMapper(DepartmentMapper.class).update(department);
  }
}
