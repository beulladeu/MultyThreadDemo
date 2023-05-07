package main.java.com.verkhonina.multythreaddemo;

import java.util.concurrent.atomic.AtomicBoolean;

public class Foo {

    private final AtomicBoolean bManager = new AtomicBoolean();
    private final AtomicBoolean cManager = new AtomicBoolean();

    public synchronized void first(Runnable r) {
        r.run();
        bManager.set(true);
        notifyAll();
    }

    public synchronized void second(Runnable r) throws InterruptedException {
        while (!bManager.get()) wait();
        r.run();
        cManager.set(true);
        notify();
    }

    public synchronized void third(Runnable r) throws InterruptedException {
        while (!cManager.get()) wait();
        r.run();
    }
}
