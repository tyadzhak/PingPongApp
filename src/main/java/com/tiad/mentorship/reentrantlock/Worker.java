package com.tiad.mentorship.reentrantlock;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;

public class Worker implements Runnable {
    private static final String PING_STRING = "ping";
    private static final String PONG_STRING = "pong";
    private static final String EXIT_STRING = "exit";


    private static String turn = PING_STRING;

    @Override
    public void run() {
        //App.locker.lock();
        runImpl();
        //App.locker.unlock();
    }

    private void runImpl() {
/*
        Condition condition = App.locker.newCondition();

        while (true) {
            if (!PING_STRING.equalsIgnoreCase(turn)) {
                App.locker.lock();
                turn = PING_STRING;
                System.out.println(Thread.currentThread().getName());
                System.out.println(PONG_STRING);

                condition.signalAll();
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                App.locker.unlock();
            } else {
                App.locker.lock();
                System.out.println(Thread.currentThread().getName());
                Scanner sc = new Scanner(System.in);
                while (sc.hasNext()) {
                    String next = sc.next();
                    if (next.equalsIgnoreCase(EXIT_STRING))
                        System.exit(0);

                    if (next.equalsIgnoreCase(PING_STRING))
                        break;
                }
                turn = PONG_STRING;
                condition.signalAll();
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                App.locker.unlock();
            }
        }
*/
    }

}
