package main.java.com.verkhonina.multythreaddemo;

import java.util.concurrent.Semaphore;

public class Foo {

    private final Semaphore smp1 = new Semaphore(1);
    private final Semaphore smp2 = new Semaphore(1);

    Foo() {
        try {
            smp1.acquire();
            smp2.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void first(Runnable r) throws InterruptedException {
        r.run();
        smp1.release();
    }

    public void second(Runnable r) throws InterruptedException {
        smp1.acquire();
        r.run();
        smp2.release();
    }

    public void third(Runnable r) throws InterruptedException {
        smp2.acquire();
        r.run();
    }
}
