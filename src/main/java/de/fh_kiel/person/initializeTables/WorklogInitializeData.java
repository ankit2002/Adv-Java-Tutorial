package de.fh_kiel.person.initializeTables;

import de.fh_kiel.person.repositories.WorkLogRepository;
import de.fh_kiel.person.worklog.WorklogDayEntry;
import de.fh_kiel.person.worklog.WorklogTimeEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by amit on 15.12.16.
 */
@Component
public class WorklogInitializeData implements CommandLineRunner {

    @Autowired
    private WorkLogRepository workLogRepository;


    @Override
    public void run(String... args) throws Exception {

        WorklogDayEntry w1 = new WorklogDayEntry();
        WorklogDayEntry w2 = new WorklogDayEntry();
        WorklogDayEntry w3 = new WorklogDayEntry();
        WorklogDayEntry w4 = new WorklogDayEntry();
        WorklogDayEntry w5 = new WorklogDayEntry();

        WorklogTimeEntry wt1 = new WorklogTimeEntry();
        WorklogTimeEntry wt2 = new WorklogTimeEntry();
        WorklogTimeEntry wt3 = new WorklogTimeEntry();
        WorklogTimeEntry wt4 = new WorklogTimeEntry();
        WorklogTimeEntry wt5 = new WorklogTimeEntry();

        wt1.setBegin(LocalTime.MIN);
        wt1.setEnd(LocalTime.MAX);
        wt2.setBegin(LocalTime.MIN);
        wt2.setEnd(LocalTime.MAX);
        wt3.setBegin(LocalTime.MIN);
        wt3.setEnd(LocalTime.MAX);
        wt4.setBegin(LocalTime.MIN);
        wt4.setEnd(LocalTime.MAX);
        wt5.setBegin(LocalTime.MIN);
        wt5.setEnd(LocalTime.MAX);

        w1.setDay(LocalDate.now());
        w2.setDay(LocalDate.now());
        w3.setDay(LocalDate.now());
        w4.setDay(LocalDate.now());
        w5.setDay(LocalDate.now());

        w1.getEntries().add(wt1);
        w2.getEntries().add(wt2);
        w3.getEntries().add(wt3);
        w4.getEntries().add(wt4);
        w5.getEntries().add(wt5);

        workLogRepository.save(w1);
        workLogRepository.save(w2);
        workLogRepository.save(w3);
        workLogRepository.save(w4);
        workLogRepository.save(w5);
    }
}
