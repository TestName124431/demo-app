package com.ticketpay.demoapp.service;

import com.ticketpay.demoapp.model.Bid;
import com.ticketpay.demoapp.repository.BidRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Slf4j
@Service
@Transactional
public class BidServiceImpl implements BidService {



    @Autowired
    private final BidRepository bidRepository;

    public BidServiceImpl(BidRepository bidRepository) {
        this.bidRepository = bidRepository;
    }

    @Override
    public Bid getbyId(int id) {

        return bidRepository.findById((long) id).get();
    }

    @Override
    public int saveBid(Bid bid) {

        bidRepository.save(bid).getId();
        bid.setStatus(BidStatus.COMPLETE);
        log.info("Bid succesfully saved. Details"+ bid);
        return bid.getId();


    }


    @Override
    @Scheduled(cron = "0 0/1 * * * ?")
    public void processing() {
        List<Bid> bids = bidRepository.findAllByStatus(BidStatus.PENDING);
        if (bids.size() > 0) {
            Bid bid = bids.get(0);
            bid.setStatus(StatusUtil.getRandomStatus());

            bidRepository.save(bid);
            log.info("Bid status succesfully processing "+ bid);
        }

    }

}
