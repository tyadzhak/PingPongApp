package com.tiad.mentorship.waitnotify.v2;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class PongV2 implements Runnable {
    private static final String PONG_STRING = "pong";
    final private Exchanger<String> exchanger;

    public PongV2(Exchanger<String> exchanger) {

        this.exchanger = exchanger;
    }

    @Override
    public void run() {
            while (true) {
                try {
                    exchanger.exchange("ping", 100, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
                System.out.println(PONG_STRING);
        }

    }
}
