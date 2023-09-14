package com.scaler.bookmyshow.models;

import com.scaler.bookmyshow.enums.EventChairStatus;
import jakarta.persistence.*;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class EventChair extends BaseModel {
    @ManyToOne
    private Event event;
    @ManyToOne
    private Chair chair;
    @Enumerated(EnumType.ORDINAL)
    private EventChairStatus status;
    private Date lockedAt;
}
