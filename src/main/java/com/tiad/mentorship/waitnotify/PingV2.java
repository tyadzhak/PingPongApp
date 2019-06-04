package com.tiad.mentorship.waitnotify;

import java.util.Scanner;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class PingV2 implements Runnable {
    private static final String PING_STRING = "ping";
    private static final String EXIT_STRING = "exit";
    private final Exchanger<String> exchanger;

    public PingV2(Exchanger<String> exchanger) {

        this.exchanger = exchanger;
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

            try {
                exchanger.exchange(PING_STRING, 100, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }
    }
}
