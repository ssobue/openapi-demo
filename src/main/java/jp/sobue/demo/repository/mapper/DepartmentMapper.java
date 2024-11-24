package jp.sobue.demo.repository.mapper;

import java.util.List;
import jp.sobue.demo.model.entity.Department;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface DepartmentMapper {

  @Select("""
          SELECT
              d.id,
              d.name,
              d.updated_by,
              d.updated_on,
              d.deleted
          FROM department d
          WHERE d.deleted = '0'
      """)
  @ResultMap("departmentMap")
  List<Department> findAll();

  @Select("""
          SELECT
              d.id,
              d.name,
              d.updated_by,
              d.updated_on,
              d.deleted
          FROM department d
          WHERE d.id = #{id}
      """)
  @ResultMap("departmentMap")
  Department findById(Integer id);

  @Insert("""
           INSERT INTO department (name, updated_by, updated_on)
              VALUES (#{name}, #{updatedBy}, #{updatedOn})
      """)
  int insert(Department department);

  @Update("""
              UPDATE department
              SET
                  name = #{name},
                  updated_by = #{updatedBy},
                  updated_on = #{updatedOn},
                  deleted = #{deleted}
              WHERE id = #{id}
      """)
  int update(Department department);
}
