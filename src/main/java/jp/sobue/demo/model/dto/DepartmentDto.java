package jp.sobue.demo.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * Department DTO.
 *
 * @author Sho SOBUE
 */
@Data
@Builder
@ToString
@Schema(title = "Department")
public class DepartmentDto {

  /**
   * Department ID
   */
  @Schema(
      description = "Department ID",
      example = "1",
      accessMode = AccessMode.READ_ONLY)
  @Min(1)
  @Max(Integer.MAX_VALUE)
  private Integer id;

  /**
   * Department Name
   */
  @NotNull
  @Schema(
      description = "Department Name",
      example = "Marketing & Sales",
      requiredMode = RequiredMode.REQUIRED,
      accessMode = AccessMode.READ_WRITE)
  @Min(1)
  @Max(100)
  private String name;
}
