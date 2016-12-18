package de.fh_kiel.person.worklog;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalTime;

/**
 * Created by Ankit on 11/27/2016.
 */
@Embeddable
public class WorklogTimeEntry {
    @Column(name = "WORKLOG_TIME_ENTRY_BEGIN")
    LocalTime begin;
    @Column(name = "WORKLOG_TIME_ENTRY_END")
    LocalTime end;

    @ManyToOne
    @JoinColumn(name = "WORKLOG_ID")
    private WorklogDayEntry worklogDayEntry;


    public WorklogDayEntry getWorklogDayEntry() {
        return worklogDayEntry;
    }

    public void setWorklogDayEntry(WorklogDayEntry worklogDayEntry) {
        this.worklogDayEntry = worklogDayEntry;
    }


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
