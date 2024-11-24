package jp.sobue.demo.repository;

import java.util.List;
import jp.sobue.demo.model.entity.Employee;
import jp.sobue.demo.repository.mapper.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository {

  private final SqlSession sqlSession;

  @Override
  public List<Employee> findAll() {
    return sqlSession.getMapper(EmployeeMapper.class).findAll();
  }

  @Override
  public Employee findById(Integer id) {
    return sqlSession.getMapper(EmployeeMapper.class).findById(id);
  }

  @Override
  public void insert(Employee employee) {
    sqlSession.getMapper(EmployeeMapper.class).insert(employee);
  }

  @Override
  public void update(Employee employee) {
    sqlSession.getMapper(EmployeeMapper.class).update(employee);
  }
}
