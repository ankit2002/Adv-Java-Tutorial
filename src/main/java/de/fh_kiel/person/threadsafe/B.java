package de.fh_kiel.person.threadsafe;

/**
 * Created by amit on 01.12.16.
 */
import java.util.ArrayList;
import java.util.List;

public class B {
    private final List<Integer> ints = new ArrayList<>();

    public List<Integer> getInts() {
        return ints;
    }

    public void addInt(final Integer intt) {
        try {
            Thread.sleep(intt);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ints.add(intt);
    }
}