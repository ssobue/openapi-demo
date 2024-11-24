package jp.sobue.demo.model.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Builder
@ToString
@EqualsAndHashCode(callSuper = true)
public class Employee extends BaseEntity {

  private Integer id;
  private String name;
  private String email;
  private Integer departmentId;
}
