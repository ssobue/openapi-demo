package jp.sobue.demo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import jp.sobue.demo.model.dto.EmployeeDto;
import jp.sobue.demo.model.mapper.EmployeeMapper;
import jp.sobue.demo.service.EmployeeService;
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
 * Employee management APIs.
 *
 * @author Sho SOBUE
 */
@Validated
@RestController
@RequiredArgsConstructor
@Tag(name = "Employees", description = "Employee management APIs")
@RequestMapping("/api/v1/employees")
public class EmployeeController {

  /**
   * Employee Model Mapper
   */
  private static final EmployeeMapper MAPPER = EmployeeMapper.INSTANCE;

  /**
   * Logic layer for employee
   */
  private final EmployeeService employeeService;

  @Operation(summary = "Get all employees")
  @GetMapping
  public List<EmployeeDto> getAllEmployees() {
    return employeeService
        .getAll()
        .stream()
        .map(MAPPER::toDto)
        .toList();
  }

  @Operation(summary = "Get an employee by ID")
  @GetMapping("/{id}")
  public EmployeeDto getEmployeeById(@PathVariable Integer id) {
    return MAPPER.toDto(employeeService.getById(id));
  }

  @Operation(summary = "Create an employee")
  @PostMapping
  public void createEmployee(
      @RequestBody @Valid EmployeeDto employeeDto) {
    employeeService.create(MAPPER.toEntity(employeeDto));
  }

  @Operation(summary = "Update an employee by ID")
  @PutMapping("/{id}")
  public void updateEmployee(
      @PathVariable Integer id,
      @RequestBody @Valid EmployeeDto employeeDto) {
    employeeDto.setId(id);
    employeeService.update(MAPPER.toEntity(employeeDto));
  }

  @Operation(summary = "Delete an employee by ID")
  @DeleteMapping("/{id}")
  public void deleteEmployee(@PathVariable Integer id) {
    employeeService.delete(MAPPER.toEntity(EmployeeDto.builder().id(id).build()));
  }
}
