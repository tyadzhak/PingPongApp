package com.tiad.mentorship.waitnotify;

public class Pong implements Runnable {
    private static final String PONG_STRING = "pong";

    private App app;

    public Pong(App app) {
        this.app = app;
    }

    @Override
    public void run() {
        synchronized (Lock.pongLock) {
            while (true) {
                try {
                    Lock.pongLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(PONG_STRING);
                synchronized (Lock.pingLock) {
                    Lock.pingLock.notifyAll();
                }
            }
        }
    }
}
