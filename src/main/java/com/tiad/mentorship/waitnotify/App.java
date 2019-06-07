package com.tiad.mentorship.waitnotify;

import com.tiad.mentorship.waitnotify.v2.PingV2;
import com.tiad.mentorship.waitnotify.v2.PongV2;

import java.util.concurrent.Exchanger;

public class App {

    public static void main(String[] args) {
        App app = new App();
        app.play();
    }

    private void play() {
/*        ArrayBlockingQueue  queue = new ArrayBlockingQueue(100);
        Thread ping = new Thread(new Ping( queue));
        ping.setName("pingThread");

        Thread pong = new Thread(new Pong(queue));
        pong.setName("pongThread");

        ping.start();
        pong.start();
*/


        Exchanger<String> exchanger = new Exchanger<>();
        Thread pingv2 = new Thread(new PingV2(exchanger));
        pingv2.setName("pingThread");

        Thread pongv2 = new Thread(new PongV2(exchanger));
        pongv2.setName("pongThread");

        pingv2.start();
        pongv2.start();
    }
}
