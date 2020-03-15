package com.ticketpay.demoapp.repository;

import com.ticketpay.demoapp.model.Bid;
import com.ticketpay.demoapp.service.BidStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BidRepository extends JpaRepository<Bid, Long> {

    @Query("SELECT b FROM Bid b WHERE b.status = :bstatus")
    List<Bid> findAllByStatus(@Param("bstatus") BidStatus status);
}
