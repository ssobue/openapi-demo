package jp.sobue.demo.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public abstract class BaseEntity implements Serializable {

  private String updatedBy;
  private LocalDateTime updatedAt;
  private Boolean deleted;
}
