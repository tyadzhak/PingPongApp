package com.tiad.mentorship.reentrantlock;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class App {

    public static final ReentrantLock locker = new ReentrantLock();

    public static void main(String[] args) {
        App app = new App();
        app.play();
    }

    private AtomicBoolean wakeUp = new AtomicBoolean(false);

    private void play() {
        Thread ping = new Thread(new Ping(this));
        ping.setName("pingThread");

        Thread pong = new Thread(new Pong(this));
        pong.setName("pongThread");

        ping.start();
        pong.start();
    }

    public boolean getWakeUp() {
        return wakeUp.get();
    }

    public void setWakeUp(boolean wakeUp) {
        this.wakeUp.set(wakeUp);
    }
}
