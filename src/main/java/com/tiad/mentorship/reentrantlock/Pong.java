package com.tiad.mentorship.reentrantlock;

public class Pong implements Runnable {
    private static final String PONG_STRING = "pong";

    private App app;

    public Pong(App app) {
        this.app = app;
    }

    @Override
    public void run() {

            while (true) {
                boolean tryLock = App.locker.tryLock();
                if (tryLock) {
                    if (app.getWakeUp())
                        App.locker.lock();

                    System.out.println(PONG_STRING);


                    if (app.getWakeUp()) {
                        app.setWakeUp(false);
                        App.locker.unlock();
                    }
                }
            }

        //                Lock.lock.notifyAll();
    }


}