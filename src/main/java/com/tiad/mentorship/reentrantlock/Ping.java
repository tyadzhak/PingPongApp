package com.tiad.mentorship.reentrantlock;

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

        Scanner sc = new Scanner(System.in);



        try {
        while (sc.hasNext()) {
            App.locker.lock();


                String next = sc.next();

                if (next.equalsIgnoreCase(EXIT_STRING))
                    System.exit(0);

                if (!next.equalsIgnoreCase(PING_STRING))
                    continue;


                //                Lock.lock.notifyAll();
                app.setWakeUp(true);
            App.locker.unlock();
            //Lock.lock.wait();
        }
        } finally {

        }

    }
}
