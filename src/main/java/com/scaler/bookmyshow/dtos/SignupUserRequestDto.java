package com.scaler.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupUserRequestDto {

  private String email;
  private String password;
  private String name;
  private int age;
}
