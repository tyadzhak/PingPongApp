package com.tiad.mentorship.waitnotify;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Pong implements Runnable {
    private static final String PONG_STRING = "pong";
    private final ArrayBlockingQueue queue;

    public Pong(ArrayBlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                if(queue.poll(15, TimeUnit.SECONDS) == null)
                    System.out.println("timeout");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(PONG_STRING);

        }
    }
}

