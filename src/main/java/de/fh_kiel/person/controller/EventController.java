package de.fh_kiel.person.controller;

import de.fh_kiel.person.service.EventBookingService;

/**
 * Created by amit on 04.12.16.
 */
public class EventController {
    public static void main(String[] args) {
        //EventBookingService RunnableInstance = new EventBookingService();

        Thread thread1 = new Thread(new EventBookingService(),"Booking1-");
        Thread thread2 = new Thread(new EventBookingService(),"Booking2-");

        thread1.start();
        thread2.start();

        try {
            thread1.join(); //wait for thread 1 to terminate
            thread2.join(); //wait for thread 2 to terminate
        }catch (InterruptedException e){

        }
    }

}
