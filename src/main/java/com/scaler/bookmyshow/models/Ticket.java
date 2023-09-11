package com.scaler.bookmyshow.models;

import com.scaler.bookmyshow.enums.TicketStatus;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ticket extends BaseModel {
    private int amount;
    private Date timeOfBooking;
    private List<Seat> seats;
    private User bookedBy;
    private Show show;
    private List<Payment> payments;
    private TicketStatus status;
}
