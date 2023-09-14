package com.scaler.bookmyshow.models;

import com.scaler.bookmyshow.enums.PaymentProvider;
import com.scaler.bookmyshow.enums.PaymentStatus;
import com.scaler.bookmyshow.enums.PaymentType;
import java.util.Date;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel {
    private int amount;

  @Enumerated(EnumType.STRING)
  private PaymentProvider paymentProvider;

    private Date time;
  private String refId;

  @Enumerated(EnumType.ORDINAL)
  private PaymentStatus paymentStatus;

  @Enumerated(EnumType.ORDINAL)
  private PaymentType paymentType;
}
