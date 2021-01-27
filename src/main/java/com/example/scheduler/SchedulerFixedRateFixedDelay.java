package com.example.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class SchedulerFixedRateFixedDelay {
    public static final Logger log = LoggerFactory.getLogger(SchedulerFixedRateFixedDelay.class);

    @Scheduled(fixedRate = 5000) //fixedRate = "${fixedRate.in.milliseconds}"
    public void every5seconds() throws InterruptedException {
        log.info("Logging every (fixed rate)5 seconds, then sleeps for 3 sec", Level.INFO);
        Thread.sleep(3000);
    }

    @Scheduled(fixedDelay = 10000)
    public void every10seconds() throws InterruptedException {
        log.info("Runs Continously with (fixed delay)10 sec delay before next run with sleep time of 3 sec",Level.INFO);
        Thread.sleep(3000);
    }

    @Scheduled(fixedRate = 600000)
    @CacheEvict(value = {"employee"}, allEntries = true)
    public void clearEmpCache() {
        log.info("Clearing employee caches in every 10 minutes");
    }
}
