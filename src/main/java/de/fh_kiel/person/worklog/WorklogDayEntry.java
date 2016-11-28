package de.fh_kiel.person.worklog;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Ankit on 11/27/2016.
 */
public class WorklogDayEntry {
    LocalDate day;
    List<WorklogTimeEntry> entries;


    public List<WorklogTimeEntry> getEntries() {
        return entries;
    }

    public void setEntries(List<WorklogTimeEntry> entries) {
        this.entries = entries;
    }

    public LocalDate getDay() {

        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }
}
