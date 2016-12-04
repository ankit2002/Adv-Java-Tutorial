package de.fh_kiel.person.threadsafe;

/**
 * Created by amit on 01.12.16.
 */
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainB {

    public static void main(String[] args) {
        final B b = new B();
        IntStream ints = new Random().ints(50000, 1, 10);

        List<CompletableFuture<Void>> collect = ints.mapToObj(i -> doSth(b, i)).collect(Collectors.toList());

        CompletableFuture<Void> allDoneFuture = CompletableFuture.allOf((CompletableFuture[])collect.toArray(new CompletableFuture[0]));
        try{
            allDoneFuture.get();
            System.out.println(b.getInts());
        }
        catch (ExecutionException | InterruptedException e){
            System.out.println("Exception"+ e);
        }
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