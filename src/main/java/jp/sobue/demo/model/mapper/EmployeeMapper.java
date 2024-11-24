package jp.sobue.demo.model.mapper;

import jp.sobue.demo.model.dto.EmployeeDto;
import jp.sobue.demo.model.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {

  EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

  EmployeeDto toDto(Employee entity);

  Employee toEntity(EmployeeDto dto);
}
