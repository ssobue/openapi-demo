package jp.sobue.demo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import jp.sobue.demo.model.dto.DepartmentDto;
import jp.sobue.demo.model.mapper.DepartmentMapper;
import jp.sobue.demo.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Department management APIs.
 *
 * @author Sho SOBUE
 */
@Validated
@RestController
@RequiredArgsConstructor
@Tag(name = "Departments", description = "Department management APIs")
@RequestMapping("/api/v1/department")
public class DepartmentController {

  /**
   * Department Model Mapper
   */
  private static final DepartmentMapper MAPPER = DepartmentMapper.INSTANCE;

  /**
   * Logic layer for department
   */
  private final DepartmentService departmentService;

  @Operation(summary = "Get all departments")
  @GetMapping
  public List<DepartmentDto> getAllDepartments() {
    return departmentService
        .getAll()
        .stream()
        .map(MAPPER::toDto)
        .toList();
  }

  @Operation(summary = "Get a department by ID")
  @GetMapping("/{id}")
  public DepartmentDto getDepartmentById(@PathVariable Integer id) {
    return MAPPER.toDto(departmentService.getById(id));
  }

  @Operation(summary = "Create a department")
  @PostMapping
  public void createEmployee(
      @RequestBody @Valid DepartmentDto departmentDto) {
    departmentService.create(MAPPER.toEntity(departmentDto));
  }

  @Operation(summary = "Update a department by ID")
  @PutMapping("/{id}")
  public void updateEmployee(
      @PathVariable Integer id,
      @RequestBody @Valid DepartmentDto departmentDto) {
    departmentDto.setId(id);
    departmentService.update(MAPPER.toEntity(departmentDto));
  }

  @Operation(summary = "Delete a department by ID")
  @DeleteMapping("/{id}")
  public void deleteEmployee(@PathVariable Integer id) {
    departmentService.delete(MAPPER.toEntity(DepartmentDto.builder().id(id).build()));
  }
}
