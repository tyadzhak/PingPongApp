package com.tiad.mentorship.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class App {

    public static final Lock lock = new ReentrantLock();
    public static final Condition pingCondition = lock.newCondition();
    public static final Condition pongCondition = lock.newCondition();

    public static void main(String[] args) {
        App app = new App();
        app.play();
    }

    private void play() {
        Thread ping = new Thread(new Ping());
        ping.setName("pingThread");

        Thread pong = new Thread(new Pong());
        pong.setName("pongThread");

        ping.start();
        pong.start();
    }
}
