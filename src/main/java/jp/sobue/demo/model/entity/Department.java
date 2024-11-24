package jp.sobue.demo.model.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Builder
@ToString
@EqualsAndHashCode(callSuper = true)
public class Department extends BaseEntity {

  private Integer id;
  private String name;
}
