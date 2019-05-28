package com.tiad.mentorship.reentrantlock;

public class Pong implements Runnable {
    private static final String PONG_STRING = "pong";

    @Override
    public void run() {
        while (true) {
            App.lock.lock();
            try {
                System.out.println(PONG_STRING);
                App.pingCondition.signalAll();
                App.pongCondition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                App.lock.unlock();
            }
        }
    }
}