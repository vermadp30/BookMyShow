package com.scaler.bookmyshow.models;

import com.scaler.bookmyshow.enums.State;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
  private String address;
  private City city;
  private String pinCode;
  private State state;
}
