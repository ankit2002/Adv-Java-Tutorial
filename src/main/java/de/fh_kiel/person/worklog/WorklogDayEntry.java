package de.fh_kiel.person.worklog;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Ankit on 11/27/2016.
 */
public class WorklogDayEntry {
    LocalDate day;
    List<WorklogTimeEntry> entries;
}
