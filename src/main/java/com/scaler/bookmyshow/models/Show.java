package com.scaler.bookmyshow.models;

import com.scaler.bookmyshow.enums.Language;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Show extends BaseModel {
  private Auditorium auditorium;
  private Date startTime;
  private Date endTime;
  private Movie movie;
  private Language language;
}
