package com.tiad.mentorship.waitnotify;

import java.util.concurrent.atomic.AtomicBoolean;

public class App {

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
