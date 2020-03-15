package com.ticketpay.demoapp.controller;

import com.ticketpay.demoapp.model.Bid;
import com.ticketpay.demoapp.service.BidService;
import com.ticketpay.demoapp.service.BidServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("bid")
public class BidController {

    @Autowired
    private final BidService bidServiceImpl;

    public BidController(BidServiceImpl bidServiceImpl) {
        this.bidServiceImpl = bidServiceImpl;
    }

    @GetMapping("/status/{id}")
    public String getStatusById(@Valid @PathVariable("id") int id) {
        Bid bid = bidServiceImpl.getbyId(id);
        return bid.getStatus().name();
    }



    @PostMapping("/create")
    public int createBid(@Valid @RequestBody Bid bid) {
        return bidServiceImpl.saveBid(bid);
    }

}
