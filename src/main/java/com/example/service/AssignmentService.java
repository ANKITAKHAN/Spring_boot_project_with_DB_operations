package com.example.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service
public class AssignmentService {

    @Async
    public void async_method() {
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
