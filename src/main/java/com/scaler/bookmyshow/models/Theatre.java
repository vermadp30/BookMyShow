package com.scaler.bookmyshow.models;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Theatre extends BaseModel {
    private String name;
    private Address address;
    private List<Auditorium> auditoriums;
}
