package jp.sobue.demo.repository;

import java.util.List;
import jp.sobue.demo.model.entity.Department;
import jp.sobue.demo.repository.mapper.DepartmentMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

/**
 * Department Repository Implementation.
 *
 * @author Sho SOBUE
 */
@Repository
@RequiredArgsConstructor
public class DepartmentRepositoryImpl implements DepartmentRepository {

  /**
   * SqlSession.
   */
  private final SqlSession sqlSession;

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Department> findAll() {
    return sqlSession.getMapper(DepartmentMapper.class).findAll();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Department findById(Integer id) {
    return sqlSession.getMapper(DepartmentMapper.class).findById(id);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void insert(Department department) {
    sqlSession.getMapper(DepartmentMapper.class).insert(department);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void update(Department department) {
    sqlSession.getMapper(DepartmentMapper.class).update(department);
  }
}
