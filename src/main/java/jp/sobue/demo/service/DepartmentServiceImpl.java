package jp.sobue.demo.service;

import java.util.List;
import jp.sobue.demo.model.entity.Department;
import jp.sobue.demo.repository.DepartmentRepository;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implement of Logic layer for department.
 *
 * @author Sho SOBUE
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

  /**
   * Application Name.
   */
  private final String myAppName;

  /**
   * Repository layer for department
   */
  private final DepartmentRepository repository;

  /**
   * Constructor.
   *
   * @param environment environment
   * @param repository repository
   */
  public DepartmentServiceImpl(Environment environment, DepartmentRepository repository) {
    this.myAppName = environment.getProperty("spring.application.name");
    this.repository = repository;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @Transactional(readOnly = true)
  public List<Department> getAll() {
    return repository.findAll();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @Transactional(readOnly = true)
  public Department getById(Integer id) {
    return repository.findById(id);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @Transactional
  public void create(Department department) {
    department.setUpdatedBy(myAppName); // AOPにしたい
    repository.insert(department);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @Transactional
  public void update(Department department) {
    department.setUpdatedBy(myAppName); // AOPにしたい
    repository.update(department);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @Transactional
  public void delete(Department department) {
    department.setUpdatedBy(myAppName); // AOPにしたい
    department.setDeleted(Boolean.TRUE);
    repository.update(department);
  }
}
