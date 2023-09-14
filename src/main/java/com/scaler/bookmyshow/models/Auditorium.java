package com.scaler.bookmyshow.models;

import com.scaler.bookmyshow.enums.Feature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Auditorium extends BaseModel {
  private String name;

  @OneToMany private List<Chair> chair;

  @Enumerated(EnumType.STRING)
  @ElementCollection
  private List<Feature> features;
}
