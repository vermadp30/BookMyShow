package com.scaler.bookmyshow.models;

import com.scaler.bookmyshow.enums.TicketStatus;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel {
    private int amount;
    private Date timeOfBooking;
  @ManyToMany private List<Chair> chairs;
  @ManyToOne private User bookedBy;
  @ManyToOne private Event event;
  @OneToMany private List<Payment> payments;

  @Enumerated(EnumType.ORDINAL)
  private TicketStatus status;
}
