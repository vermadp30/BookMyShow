package com.scaler.bookmyshow.dtos;

import com.scaler.bookmyshow.enums.BookTicketResponseStatus;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookTicketResponseDto {

    private int amount;
    private Long ticketId;
    private List<String> seatNumber;
    private String auditoriumName;
    private String message;
    private BookTicketResponseStatus status;
}
