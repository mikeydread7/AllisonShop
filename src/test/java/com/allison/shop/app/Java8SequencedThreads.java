package com.allison.shop.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class SequenceRun {
    private static Logger LOGGER = LoggerFactory.getLogger(SequenceRun.class);

    public static void main(String bar[]) {
        int threadCount = 5;
        List<Thread> threads = new ArrayList<>();
        IntStream.rangeClosed(1, threadCount).forEach(i -> {
            threads.add(new Thread(() -> {
                logIt();
            }));
        });
        threadsJoiner(threads);
    }

    private static void threadsJoiner(List<Thread> threads) {

        threads.forEach(thread -> {
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    private static void logIt() {
        LOGGER.info("{} .........", Thread.currentThread().getName());
    }
}
