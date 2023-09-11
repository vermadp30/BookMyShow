package com.scaler.bookmyshow.models;

import com.scaler.bookmyshow.enums.Feature;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Auditorium extends BaseModel {
  private String name;
  private List<Seat> seat;
  private List<Feature> features;
}
