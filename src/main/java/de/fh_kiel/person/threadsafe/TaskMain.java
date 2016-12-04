/*
package de.fh_kiel.person.threadsafe;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

*/
/**
 * Created by amit on 03.12.16.
 *//*

public class TaskMain {
    public static void main(String ... args) {
        TaskService ts = new TaskService();
        System.out.println("before Thread 1");
                CompletableFuture<Long> createFut = CompletableFuture.supplyAsync(() ->
                {  new TaskService(Thread.currentThread().getId());
                    */
/*try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println(Thread.currentThread().getName() + " interrupted.");
                    }*//*

                    System.out.println(Thread.currentThread().getName() + " exiting.");
                    System.out.println("before create task: " + Thread.currentThread().getName());
                    return ts.createTask(4, "sum");
                });
        CompletableFuture<Integer> getResFut = createFut.thenApply((Long t) -> {
            try {
                        Thread.sleep(1000);

                    } catch (InterruptedException e) {
                        System.out.println(Thread.currentThread().getName() + " interrupted.");
                    }
            return ts.getTaskResult(t);
        });
        CompletableFuture<String> excp = getResFut.handle((result, throwable) -> {
            if (throwable !=null){
                return ("Some Exception here :" + throwable);
            }else{
                System.out.println("else");
                return result.toString();
            }

        });
        if(!getResFut.isDone()){
            try {
                System.out.println("get:" + getResFut.get());

            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted.");
            }catch (ExecutionException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted.");
            }
        }

    }

}
*/
