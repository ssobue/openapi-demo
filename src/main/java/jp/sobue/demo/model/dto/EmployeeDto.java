package jp.sobue.demo.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * Employee DTO.
 *
 * @author Sho SOBUE
 */
@Data
@Builder
@ToString
@Schema(title = "Employee")
public class EmployeeDto {

  /**
   * Employee ID
   */
  @Schema(
      description = "Employee ID",
      example = "1",
      accessMode = AccessMode.READ_ONLY)
  @Min(1)
  @Max(Integer.MAX_VALUE)
  private Integer id;

  @NotNull
  @Schema(
      description = "Name",
      example = "John Smith",
      requiredMode = RequiredMode.REQUIRED,
      accessMode = AccessMode.READ_WRITE)
  @Min(3)
  @Min(100)
  private String name;

  /**
   * E-Mail
   */
  @Email
  @Schema(
      description = "E-Mail",
      example = "john@example.com",
      requiredMode = RequiredMode.REQUIRED,
      accessMode = AccessMode.READ_WRITE)
  @Min(6)
  @Max(300)
  private String email;

  /**
   * Department ID
   */
  @NotNull
  @Schema(
      description = "Department ID. Requires registered department id",
      example = "1",
      requiredMode = RequiredMode.REQUIRED,
      accessMode = AccessMode.READ_WRITE)
  private Integer departmentId;
}
