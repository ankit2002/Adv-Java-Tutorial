package de.fh_kiel.person.initializeTables;

import de.fh_kiel.person.repositories.WorkLogRepository;
import de.fh_kiel.person.worklog.WorklogDayEntry;
import de.fh_kiel.person.worklog.WorklogTimeEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by amit on 15.12.16.
 */
@Component
@Order(3)
public class WorklogInitializeData implements CommandLineRunner {

    @Autowired
    private WorkLogRepository workLogRepository;


    @Override
    public void run(String... args) throws Exception {

        WorklogDayEntry w1 = new WorklogDayEntry();
        WorklogDayEntry w2 = new WorklogDayEntry();


        WorklogTimeEntry wt1 = new WorklogTimeEntry();
        WorklogTimeEntry wt2 = new WorklogTimeEntry();


        wt1.setBegin(LocalTime.MIN);
        wt1.setEnd(LocalTime.MAX);
        wt2.setBegin(LocalTime.MIN);
        wt2.setEnd(LocalTime.MAX);

        w1.setDay(LocalDate.now());
        w2.setDay(LocalDate.now());


        w1.getEntries().add(wt1);
        w2.getEntries().add(wt2);


        workLogRepository.save(w1);
        workLogRepository.save(w2);
    }
}
