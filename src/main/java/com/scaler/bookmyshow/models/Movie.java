package com.scaler.bookmyshow.models;

import com.scaler.bookmyshow.enums.Language;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Movie extends BaseModel {
    private String name;

  @Enumerated(EnumType.STRING)
  @ElementCollection
  private List<Language> languages;
}
