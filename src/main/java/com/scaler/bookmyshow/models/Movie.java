package com.scaler.bookmyshow.models;

import com.scaler.bookmyshow.enums.Language;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Movie extends BaseModel {
    private String name;
    private List<Language> languages;
}
