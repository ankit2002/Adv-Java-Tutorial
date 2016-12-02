package de.fh_kiel.person.threadsafe;

/**
 * Created by amit on 01.12.16.
 */
import java.util.function.Function;
import java.util.function.Predicate;

public class A {
    public int x;


    /**
     * Added Synchronized for the setter method to make the code Thread safe: TASK 1a
     * @param p
     * @param f
     */
     public synchronized void applyIf(Predicate<Integer> p, Function<Integer, Integer> f){
        if (p.test(x)){
            x = f.apply(x);
            System.out.println("Threading value x:" + x);
        }
        System.out.println("Threading value after if x:" + x);
    }
}
