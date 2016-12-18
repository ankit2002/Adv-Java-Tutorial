package de.fh_kiel.person.worklog;

import javax.persistence.Column;
import javax.persistence.Embeddable;
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
