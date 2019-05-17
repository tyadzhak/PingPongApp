package com.tiad.mentorship.waitnotify;

public class Pong implements Runnable {
    private static final String PONG_STRING = "pong";

    private App app;

    public Pong(App app) {
        this.app = app;
    }

    @Override
    public void run() {
        synchronized (Lock.lock) {
            while (true) {
                if (!app.getWakeUp()) {
                    try {
                        Lock.lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(PONG_STRING);
                app.setWakeUp(false);
                Lock.lock.notifyAll();
            }
        }
    }
}
