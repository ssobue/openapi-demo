package jp.sobue.demo.service;

import java.util.List;
import jp.sobue.demo.model.entity.Employee;
import jp.sobue.demo.repository.EmployeeRepository;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implement of Logic layer for employee.
 *
 * @author Sho SOBUE
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

  /**
   * Application Name.
   */
  private final String myAppName;

  /**
   * Repository layer for employee
   */
  private final EmployeeRepository repository;

  /**
   * Constructor.
   *
   * @param environment environment
   * @param repository repository
   */
  public EmployeeServiceImpl(Environment environment, EmployeeRepository repository) {
    this.myAppName = environment.getProperty("spring.application.name");
    this.repository = repository;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @Transactional(readOnly = true)
  public List<Employee> getAll() {
    return repository.findAll();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @Transactional(readOnly = true)
  public Employee getById(Integer id) {
    return repository.findById(id);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @Transactional
  public void create(Employee employee) {
    employee.setUpdatedBy(myAppName); // AOPにしたい
    repository.insert(employee);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @Transactional
  public void update(Employee employee) {
    employee.setUpdatedBy(myAppName); // AOPにしたい
    repository.update(employee);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @Transactional
  public void delete(Employee employee) {
    employee.setUpdatedBy(myAppName); // AOPにしたい
    employee.setDeleted(Boolean.TRUE);
    repository.update(employee);
  }
}
