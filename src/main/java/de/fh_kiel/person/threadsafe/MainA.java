package de.fh_kiel.person.threadsafe;

/**
 * Created by amit on 01.12.16.
 */
import java.util.function.Function;

public class MainA {
    public static void main(String[] args) {
        A a = new A();
        //a.x = 10;

        Thread t1 = new Thread(() -> {
            System.out.println("Inside Thread 1");
           // a.x = 5;
            System.out.println("inside thread 1 a.x:" + a.x);
            a.applyIf(x -> x > 4, Function.identity());
            System.out.println("Inside Thread 1 after apply:" + a.x);
        });
        Thread t2 = new Thread(() -> {
            System.out.println("Inside Thread 2");
           // a.x = 4;
            System.out.println("inside thread 2 a.x:" + a.x);
            a.applyIf(x -> x < 5, x -> x + x);
            System.out.println("Inside Thread 2 after apply:" + a.x);

        });

        t1.start();
        t2.start();
    }
}