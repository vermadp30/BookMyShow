package com.scaler.bookmyshow.models;

import jakarta.persistence.*;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@EntityListeners({AuditingEntityListener.class})
@MappedSuperclass
public class BaseModel {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @CreatedDate
  @Temporal(TemporalType.TIME)
  private Date createdOn;

  @LastModifiedDate
  @Temporal(TemporalType.TIMESTAMP)
  private Date updatedOn;
}
