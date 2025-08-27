package jp.sobue.demo.repository;

import java.util.List;
import jp.sobue.demo.model.entity.Employee;
import jp.sobue.demo.repository.mapper.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

/**
 * Employee Repository Implementation.
 *
 * @author Sho SOBUE
 */
@Repository
@RequiredArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository {

  /**
   * SqlSession.
   */
  private final SqlSession sqlSession;

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Employee> findAll() {
    return sqlSession.getMapper(EmployeeMapper.class).findAll();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Employee findById(Integer id) {
    return sqlSession.getMapper(EmployeeMapper.class).findById(id);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void insert(Employee employee) {
    sqlSession.getMapper(EmployeeMapper.class).insert(employee);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void update(Employee employee) {
    sqlSession.getMapper(EmployeeMapper.class).update(employee);
  }
}
