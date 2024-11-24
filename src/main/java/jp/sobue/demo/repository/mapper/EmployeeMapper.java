package jp.sobue.demo.repository.mapper;

import java.util.List;
import jp.sobue.demo.model.entity.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface EmployeeMapper {

  @Select("""
          SELECT
              e.id,
              e.name,
              e.email,
              e.department_id,
              e.updated_by,
              e.updated_on,
              e.deleted
          FROM employee e
          WHERE e.deleted = '0'
      """)
  @ResultMap("employeeMap")
  List<Employee> findAll();

  @Select("""
          SELECT
              e.id,
              e.name,
              e.email,
              e.department_id,
              e.updated_by,
              e.updated_on,
              e.deleted
          FROM employee e
          WHERE e.id = #{id}
      """)
  @ResultMap("employeeMap")
  Employee findById(Integer id);

  @Insert("""
          INSERT INTO employee
              (name, email, department_id, updated_by, updated_on)
          VALUES
              (#{name}, #{email}, #{departmentId}, #{updatedBy}, #{updatedOn})
      """)
  int insert(Employee employee);

  @Update("""
        UPDATE employee
        SET
            name = #{name},
            email = #{email},
            department_id = #{departmentId},
            updated_by = #{updatedBy},
            updated_on = #{updatedOn},
            deleted = #{deleted}
        WHERE id = #{id}
      """)
  int update(Employee employee);
}
