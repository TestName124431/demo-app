package com.ticketpay.demoapp.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ticketpay.demoapp.service.BidStatus;
import lombok.*;
import org.hibernate.validator.constraints.Range;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "bid")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bid_id")
    private int id;

    @NotNull(message = "Date and Time  can not be null")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Range(min = 1, message = "Route number must be equal or larger 1")
    @Column(name = "route_number")
    private int routeNumber;

    @Enumerated(EnumType.STRING)
    private BidStatus status;

}
