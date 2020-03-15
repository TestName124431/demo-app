package com.ticketpay.demoapp.service;

import com.ticketpay.demoapp.model.Bid;


public interface BidService {
    Bid getbyId(int id);

    int saveBid(Bid bid);

    void processing();
}
