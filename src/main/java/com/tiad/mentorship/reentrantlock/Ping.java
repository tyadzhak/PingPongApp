package com.tiad.mentorship.reentrantlock;

import java.util.Scanner;

public class Ping implements Runnable {
    private static final String PING_STRING = "ping";
    private static final String EXIT_STRING = "exit";

    @Override
    public void run() {
        while (true) {
            App.lock.lock();
            try {
                Scanner sc = new Scanner(System.in);
                while (sc.hasNext()) {
                    String next = sc.next();
                    if (next.equalsIgnoreCase(EXIT_STRING)) {
                        System.exit(0);
                    }

                    if (next.equalsIgnoreCase(PING_STRING)) {
                        break;
                    }
                }
                App.pongCondition.signalAll();
                App.pingCondition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                App.lock.unlock();
            }
        }
    }
}
