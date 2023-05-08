package main.java.com.verkhonina.multythreaddemo;


public class Main {
    public static void main(String[] args) {
        Foo f = new Foo();

        Thread a = new Thread(() -> {
            try {
                f.first(() -> System.out.print("first"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread b = new Thread(() -> {
            try {
                f.second(() -> System.out.print("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread c = new Thread(() -> {
            try {
                f.third(() -> System.out.print("third"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        b.start();
        a.start();
        c.start();
    }
}
