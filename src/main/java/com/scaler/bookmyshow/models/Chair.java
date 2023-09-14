package com.scaler.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Chair extends BaseModel {
  private String seatNumber;
  private int rowz;
  private int colz;
  @ManyToOne private ChairType chairType;
}
