package com.scaler.bookmyshow.controller;

import com.scaler.bookmyshow.dtos.BookTicketRequestDto;
import com.scaler.bookmyshow.dtos.BookTicketResponseDto;
import com.scaler.bookmyshow.enums.BookTicketResponseStatus;
import com.scaler.bookmyshow.exceptions.ChairNotAvailableException;
import com.scaler.bookmyshow.exceptions.InvalidArgumentException;
import com.scaler.bookmyshow.models.Ticket;
import com.scaler.bookmyshow.services.TicketService;
import java.util.List;
import java.util.concurrent.TimeoutException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TicketController {
    TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    public BookTicketResponseDto bookTicket(BookTicketRequestDto request) {

        List<Long> seatIds = request.getSeatIds();
        Long userId = request.getUserId();
        Long showId = request.getShowId();

        BookTicketResponseDto response = new BookTicketResponseDto();
        Ticket ticket;

        try{
        ticket = ticketService.bookTicket(
                seatIds, userId, showId
        );
        } catch (TimeoutException exception) {
            response.setMessage("Something went wrong");
            response.setStatus(BookTicketResponseStatus.FAILURE);
            return response;
        }catch (InvalidArgumentException exception){
            response.setStatus(BookTicketResponseStatus.FAILURE);
            response.setMessage("Invalid arguments passed in the request.");
            return response;
        } catch (ChairNotAvailableException exception){
            response.setStatus(BookTicketResponseStatus.FAILURE);
            response.setMessage("All seats are not available. Can't book.");
            return response;
        }
        response.setTicketId(ticket.getId());
        response.setAmount(ticket.getAmount());
        response.setAuditoriumName(ticket.getEvent().getAuditorium().getName());
        response.setStatus(BookTicketResponseStatus.SUCCESS);
        response.setMessage("Ticket created successfully");
        return response;
    }
}
