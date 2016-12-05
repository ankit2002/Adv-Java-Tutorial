package de.fh_kiel.person.service;

import de.fh_kiel.person.datamodel.EventMyClass;

import java.util.Set;

/**
 * Created by amit on 04.12.16.
 */
public class EventBookingService implements Runnable{
   // private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
    private String name;
    public String reserve(Set<Integer> seatNumbers, String eventName){
        return "hi";
    }
    public Boolean cancel(String reservationId){
        return false;
    }

    @Override
    public void run(){
        EventMyClass eventMyClass = new EventMyClass();
        MyThreadLocal.set(eventMyClass);
        name= Thread.currentThread().getName() + Thread.currentThread().getId();
        System.out.println(Thread.currentThread().getName() + Thread.currentThread().getId());
        System.out.println("Name:" + name);
        //threadLocal.set( (int) (Math.random() * 100D) );
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }

        System.out.println();
    }

}

class MyThreadLocal {
    public static final ThreadLocal userThreadLocal = new ThreadLocal();

    public static void set(EventMyClass user) {
        userThreadLocal.set(user);
        System.out.println("user:" + user);

    }

    public static void unset() {
        userThreadLocal.remove();
    }

}

