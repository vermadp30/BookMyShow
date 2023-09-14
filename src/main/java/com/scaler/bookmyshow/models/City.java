package com.scaler.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class City extends BaseModel {
  @OneToMany (mappedBy = "city") //name of attribute in other class
  private List<Theatre> theatres;
  private String name;
}
