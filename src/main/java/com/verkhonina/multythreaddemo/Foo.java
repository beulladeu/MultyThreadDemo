package main.java.com.verkhonina.multythreaddemo;

import java.util.concurrent.Semaphore;

public class Foo {

    private final Semaphore semaphoreBetweenFirstAndSecond = new Semaphore(0);
    private final Semaphore semaphoreBetweenSecondAndThird = new Semaphore(0);

    public void first(Runnable r) {
        r.run();
        semaphoreBetweenFirstAndSecond.release();
    }

    public void second(Runnable r) {
        try {
            semaphoreBetweenFirstAndSecond.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        r.run();
        semaphoreBetweenSecondAndThird.release();
    }

    public void third(Runnable r) {
        try {
            semaphoreBetweenSecondAndThird.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        r.run();
    }
}
