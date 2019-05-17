package com.tiad.mentorship.waitnotify;

import java.util.Scanner;

public class Worker implements Runnable {
    private static final String PING_STRING = "ping";
    private static final String PONG_STRING = "pong";
    private static final String EXIT_STRING = "exit";


    private static String turn = PING_STRING;

    public Worker() {
    }

    @Override
    public void run() {
        synchronized (Lock.lock) {
            while (true) {
                if (!PING_STRING.equalsIgnoreCase(turn)) {
                    turn = PING_STRING;
                    System.out.println(Thread.currentThread().getName());
                    System.out.println(PONG_STRING);
                    Lock.lock.notifyAll();
                    try {
                        Lock.lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName());
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
                    turn = PONG_STRING;
                    Lock.lock.notifyAll();
                    try {
                        Lock.lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
