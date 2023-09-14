package com.scaler.bookmyshow.models;

import com.scaler.bookmyshow.enums.Language;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Event extends BaseModel {
  @ManyToOne private Auditorium auditorium;
  private Date startTime;
  private Date endTime;
  @ManyToOne private Movie movie;

  @Enumerated(EnumType.ORDINAL)
  private Language language;
}
