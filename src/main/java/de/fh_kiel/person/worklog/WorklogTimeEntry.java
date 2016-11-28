package de.fh_kiel.person.worklog;

import java.time.LocalTime;

/**
 * Created by Ankit on 11/27/2016.
 */
public class WorklogTimeEntry {
    LocalTime begin;
    LocalTime end;

    public LocalTime getBegin() {
        return begin;
    }

    public void setBegin(LocalTime begin) {
        this.begin = begin;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }
}
