package com.scaler.bookmyshow;

import com.scaler.bookmyshow.controller.UserController;
import com.scaler.bookmyshow.dtos.SignupUserRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookMyShowApplication implements CommandLineRunner {

  private UserController userController;

  @Autowired
  public BookMyShowApplication(UserController userController) {
    this.userController = userController;
  }

  public static void main(String[] args) {
    SpringApplication.run(BookMyShowApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("hello.....");

    SignupUserRequestDto request = new SignupUserRequestDto();
    request.setEmail("email");
    request.setPassword("password");
    request.setName("name");
    request.setAge(18);
    userController.signUpUser(request);
  }
}
