package de.fh_kiel.person.threadsafe;

/**
 * Created by amit on 01.12.16.
 */
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainB {

    public static void main(String[] args) {
        final B b = new B();
        IntStream ints = new Random().ints(50000, 1, 10);
        List<CompletableFuture<Void>> collect = ints.mapToObj(i -> doSth(b, i)).collect(Collectors.toList());
        CompletableFuture.allOf((CompletableFuture[])collect.toArray(new CompletableFuture[0]));
        System.out.println(b.getInts().size());
        System.out.println("Collect:" + collect.size());
    }

    private static CompletableFuture<Void> doSth(final B b, final int i) {

        return CompletableFuture.runAsync(() -> {
            synchronized (b) {
                if (!b.getInts().contains(i)) {

                    b.addInt(i);
                }
            }
        });
    }
}