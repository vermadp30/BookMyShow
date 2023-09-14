package com.scaler.bookmyshow.services;

import static com.scaler.bookmyshow.enums.EventChairStatus.*;

import com.scaler.bookmyshow.enums.EventChairStatus;
import com.scaler.bookmyshow.enums.TicketStatus;
import com.scaler.bookmyshow.exceptions.ChairNotAvailableException;
import com.scaler.bookmyshow.exceptions.InvalidArgumentException;
import com.scaler.bookmyshow.models.*;
import com.scaler.bookmyshow.repositories.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeoutException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TicketService {
    private ChairRepository chairRepository;
    private EventChairRepository eventChairRepository;
    private EventRepository eventRepository;
    private UserRepository userRepository;
    private TicketRepository ticketRepository;

    @Autowired
    public TicketService(ChairRepository chairRepository,
                         EventChairRepository eventChairRepository,
                         EventRepository eventRepository,
                         UserRepository userRepository,
                         TicketRepository ticketRepository) {
        this.chairRepository = chairRepository;
        this.eventChairRepository=eventChairRepository;
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository;
    }

  public Ticket bookTicket(List<Long> chairIds, Long userId, Long eventId)
      throws InvalidArgumentException, ChairNotAvailableException, TimeoutException {

        List<Chair> chairs = chairRepository.findAllById(chairIds);
        Optional<Event> eventOptional= eventRepository.findById(eventId);

        if(eventOptional.isEmpty()){
            throw new InvalidArgumentException(
                    "Event by: "+ eventId + " doesn't exist."
            );
        }

        List<EventChair> savedEventChairs = getAndLockEventChair(chairs, eventOptional);



        Optional<User> userOptional= userRepository.findById(userId);

        if(userOptional.isEmpty()){
            throw new InvalidArgumentException("User with Id: " + userId + " doesn't exist");
        }

        Ticket ticket = new Ticket();
        ticket.setBookedBy(userOptional.get());
        ticket.setChairs(chairs);
        ticket.setEvent(eventOptional.get());
        ticket.setTimeOfBooking(new Date());
        ticket.setStatus(TicketStatus.PROCESSING);
        ticket.setAmount(0);

        return ticketRepository.save(ticket);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE, timeout = 2)
    public List<EventChair> getAndLockEventChair(List<Chair> chairs, Optional<Event> eventOptional) throws ChairNotAvailableException {
        List<EventChair> eventChairs = eventChairRepository.findAllByChairInAndEvent(chairs, eventOptional.get());

        for(EventChair eventChair: eventChairs){
            if(!(eventChair.getStatus().equals(AVAILABLE))){
                throw new ChairNotAvailableException();
            }
        }
        List<EventChair> savedEventChairs = new ArrayList<>();

        for(EventChair eventChair: eventChairs){
            eventChair.setStatus(EventChairStatus.LOCKED);
            eventChair.setLockedAt(new Date());
            savedEventChairs.add(eventChairRepository.save(eventChair));
        }
        return savedEventChairs;
    }
}
