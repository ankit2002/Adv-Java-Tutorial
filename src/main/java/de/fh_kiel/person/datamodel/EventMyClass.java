package de.fh_kiel.person.datamodel;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by amit on 04.12.16.
 */
public class EventMyClass {
      String eventName;
     static Set<Integer> seatList = new TreeSet<>();
    static {
        seatList.add(1);
        seatList.add(2);
        seatList.add(3);
        seatList.add(4);
        seatList.add(5);
        for(Integer i:seatList){
            System.out.println("list:" + i);
        }
    }


    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Set<Integer> getSeatList() {
        return seatList;
    }

    public void setSeatList(Set<Integer> seatList) {
        this.seatList = seatList;
    }
}
