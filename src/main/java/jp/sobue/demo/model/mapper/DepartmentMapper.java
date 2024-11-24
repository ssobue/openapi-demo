package jp.sobue.demo.model.mapper;

import jp.sobue.demo.model.dto.DepartmentDto;
import jp.sobue.demo.model.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentMapper {

  DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);

  DepartmentDto toDto(Department entity);

  Department toEntity(DepartmentDto dto);
}
