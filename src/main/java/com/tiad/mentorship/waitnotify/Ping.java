package com.tiad.mentorship.waitnotify;

import java.util.Scanner;

public class Ping implements Runnable {
    private static final String PING_STRING = "ping";
    private static final String EXIT_STRING = "exit";
    private App app;

    public Ping(App app) {
        this.app = app;
    }

    @Override
    public void run() {
        synchronized (Lock.pingLock) {
            Scanner sc = new Scanner(System.in);
            while(sc.hasNext()){
                String next = sc.next();

                if (next.equalsIgnoreCase(EXIT_STRING)) {
                    System.exit(0);
                }

                if (!next.equalsIgnoreCase(PING_STRING)) {
                    continue;
                }

                synchronized (Lock.pongLock) {
                    Lock.pongLock.notifyAll();
                }
                try {
                    Lock.pingLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
