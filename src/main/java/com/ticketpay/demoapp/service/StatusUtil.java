package com.ticketpay.demoapp.service;

import java.util.Random;

public class StatusUtil {

    public static final Random RANDOM = new Random();

    public static BidStatus getRandomStatus() {
        BidStatus[] values = BidStatus.values();

        return values[RANDOM.nextInt(values.length)];
    }

}
