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
        System.out.println("inside main");

        IntStream ints = new Random().ints(8, 1, 10);

        List<CompletableFuture<Void>> collect = ints.mapToObj(i -> doSth(b, i)).collect(Collectors.toList());
        System.out.println("collect:" + collect.size());

        CompletableFuture.allOf((CompletableFuture[])collect.toArray(new CompletableFuture[0]));

        System.out.println("Size of "+ b.getInts().size());
    }

    private static CompletableFuture<Void> doSth(final B b, final int i) {

        System.out.println("inside doSth "+ i);

        return CompletableFuture.runAsync(() -> {
            if (!b.getInts().contains(i)) {
                b.addInt(i);
            }
        });
    }
}