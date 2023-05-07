package main.java.com.verkhonina.multythreaddemo;


public class Foo {

    public void first(Runnable r) {
        r.run();
    }

    public void second(Runnable r) {
        r.run();
    }

    public void third(Runnable r) {
        r.run();
    }
}
