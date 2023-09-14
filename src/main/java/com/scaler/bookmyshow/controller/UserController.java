package com.scaler.bookmyshow.controller;

import com.scaler.bookmyshow.dtos.SignupUserRequestDto;
import com.scaler.bookmyshow.dtos.SignupUserResponseDto;
import com.scaler.bookmyshow.models.User;
import com.scaler.bookmyshow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

  private UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  public SignupUserResponseDto signUpUser(SignupUserRequestDto request) {
    User user =
        userService.signupUser(
            request.getEmail(), request.getPassword(), request.getName(), request.getAge());

    SignupUserResponseDto response = new SignupUserResponseDto();
    response.setUserId(user.getId());
    response.setEmail(user.getEmail());
    return response;
  }
}
