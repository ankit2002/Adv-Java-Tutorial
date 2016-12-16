package de.fh_kiel.person.worklog;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ankit on 11/27/2016.
 */
@Entity
public class WorklogDayEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long workLogId;

    @Column(name = "WORKLOG_DAY")
    LocalDate day;

    @ElementCollection
    @JoinTable(name = "PERSON_WORKLOG_TIME_ENTRY")
    List<WorklogTimeEntry> entries = new ArrayList<>();


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
    public Long getWorkLogId() {
        return workLogId;
    }

    public void setWorkLogId(Long workLogId) {
        this.workLogId = workLogId;
    }

}
