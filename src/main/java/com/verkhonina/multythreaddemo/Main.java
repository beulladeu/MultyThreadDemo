package main.java.com.verkhonina.multythreaddemo;


public class Main {
    public static void main(String[] args) {
        Foo f = new Foo();

        Thread a = new Thread(() -> f.first(() -> System.out.print("first")));
        Thread b = new Thread(() -> f.second(() -> System.out.print("second")));
        Thread c = new Thread(() -> f.third(() -> System.out.print("third")));

        b.start();
        a.start();
        c.start();
    }
}
