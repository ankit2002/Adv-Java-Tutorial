package de.fh_kiel.person.datamodel;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by amit on 04.12.16.
 */
public class Event {

    private String eventName;
    private Set<Integer> seatList = new TreeSet<>();

    /**
     *
     */
    public Event(){

    }

    public Event(String eventName,Set<Integer> seatList){
        this.eventName = eventName;
        this.seatList = seatList;
    }

    /**
     *
     * @return
     */
    public String getEventName() {
        return eventName;
    }


    /**
     *

     * @param eventName
     */
    public void createEvent(String eventName) {
        this.eventName = eventName;
    }

    /**
     *
     * @return
     */
    public Set<Integer> getSeatList() {
        return seatList;
    }

    /**
     *
     * @param seatList
     */
    public void setSeatList(Set<Integer> seatList) {
        this.seatList = seatList;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (eventName != null ? !eventName.equals(event.eventName) : event.eventName != null) return false;
        return seatList != null ? seatList.equals(event.seatList) : event.seatList == null;

    }

    @Override
    public int hashCode() {
        int result = eventName != null ? eventName.hashCode() : 0;
        result = 31 * result + (seatList != null ? seatList.hashCode() : 0);
        return result;
    }
}
