package main.java.com.verkhonina.multythreaddemo;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Foo f = new Foo();

        Thread a = new Thread(() -> f.first(() -> System.out.print("first")));

        Thread b = new Thread(() -> f.second(() -> System.out.print("second")));

        Thread c = new Thread(() -> f.third(() -> System.out.print("third")));

        a.start();
        a.join();

        b.start();
        b.join();

        c.start();
        c.join();

    }
}
