package de.fh_kiel.person.service;


import de.fh_kiel.person.datamodel.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by amit on 04.12.16.
 */
public class EventBookingService implements Runnable{


    Logger logger = LoggerFactory.getLogger(EventBookingService.class);
    private String name;

    private static final Map<String, Event> eventList = new HashMap<>();

    final private Map<String, Set<Integer>> storeEventsBooking = new HashMap<>();

    final private Map<String, Event> storeReservationID = new HashMap<>();

    @Autowired
    private final Event event;

    // Constructor
    public EventBookingService( Event event1 )
    {
        this.event = event1;
    }

    public String reserve(Set<Integer> seatNumbers, String eventName)
    {
        Event e = eventList.get(eventName);
        if((e.getSeatList().size() - storeEventsBooking.get(eventName).size()) > seatNumbers.size()){

            if(storeEventsBooking.containsKey(eventName)){
                // not first time
                if((storeEventsBooking.get(eventName).size() + seatNumbers.size()) <= e.getSeatList().size()){

                    String id = UUID.randomUUID().toString();
                    storeReservationID.put(id,new Event(eventName,seatNumbers));

                    seatNumbers.addAll(storeEventsBooking.get(eventName));
                    storeEventsBooking.put(eventName, seatNumbers);

                    return id;
                }
                else{
                    // over booking
                    // throw exception
                    System.out.println("over booking");
                }
            }
            else {

                String id = UUID.randomUUID().toString();
                storeReservationID.put(id,new Event(eventName,seatNumbers));

                // booking for first time
                storeEventsBooking.put(eventName,seatNumbers); // TEDX,3

                return id;
            }
        }
        return null;
    }



    /**
     * create Event first
     * @param seatNumbers
     * @param eventName
     */
    public void createEvent(Set<Integer> seatNumbers, String eventName,Long id){
        event.createEvent(eventName);
        event.setSeatList(seatNumbers);
        eventList.put(eventName,event);
    }

    public Boolean cancel(String reservationId){

        Event e = storeReservationID.get(reservationId);
        storeEventsBooking.remove(e.getSeatList());
        storeReservationID.remove(reservationId);
        return false;
    }






    @Override
    public void run(){

        Event eventMyClass = new Event();
        name= Thread.currentThread().getName() + Thread.currentThread().getId();

        System.out.println(Thread.currentThread().getName() + Thread.currentThread().getId());
        System.out.println("Name:" + name);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            logger.error("Error " + e);
        }
    }

}

