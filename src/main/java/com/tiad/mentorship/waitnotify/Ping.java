package com.tiad.mentorship.waitnotify;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

public class Ping implements Runnable {
    private static final String PING_STRING = "ping";
    private static final String EXIT_STRING = "exit";
    private final ArrayBlockingQueue queue;

    public Ping(ArrayBlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String next = sc.next();

            if (next.equalsIgnoreCase(EXIT_STRING)) {
                System.exit(0);
            }

            if (!next.equalsIgnoreCase(PING_STRING)) {
                continue;
            }
            queue.add(PING_STRING);
        }
    }
}

