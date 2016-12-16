package de.fh_kiel.person.initializeTables;

import de.fh_kiel.person.repositories.PersonRepository;
import de.fh_kiel.person.repositories.WorkLogRepository;
import de.fh_kiel.person.stubclass.Gender;
import de.fh_kiel.person.stubclass.ProjectManager;
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
@Order(1)
public class PersonInitializeData implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private WorkLogRepository workLogRepository;


    @Override
    public void run(String... args) throws Exception {

       /* Person p1 = new Person();
        Person p2 = new Person();*/

        /*Developer p1 = new Developer();
        Developer p2 = new Developer();*/


        ProjectManager p1 = new ProjectManager();
        ProjectManager p2 = new ProjectManager();

        p1.setFirst_Name("Amit");
        p1.setLast_Name("Nagar");
        p1.setD_o_b(LocalDate.of(1900,10,10));
        p1.setGender(Gender.Male);

        p1.setWorkExp(3);
        p1.setMin_Salary(1000.00);

        p1.setPmExp(8);

        p2.setFirst_Name("Riki");
        p2.setLast_Name("Hey");
        p2.setD_o_b(LocalDate.of(1900,11,10));
        p2.setGender(Gender.Female);

        p2.setWorkExp(3);
        p2.setMin_Salary(1000.00);

        p2.setPmExp(10);

        WorklogDayEntry w1 = new WorklogDayEntry();
        WorklogDayEntry w2 = new WorklogDayEntry();
        WorklogDayEntry w3 = new WorklogDayEntry();
        WorklogDayEntry w4 = new WorklogDayEntry();


        WorklogTimeEntry wt1 = new WorklogTimeEntry();
        WorklogTimeEntry wt2 = new WorklogTimeEntry();
        WorklogTimeEntry wt3 = new WorklogTimeEntry();
        WorklogTimeEntry wt4 = new WorklogTimeEntry();


        wt1.setBegin(LocalTime.MIN);
        wt1.setEnd(LocalTime.MAX);
        wt2.setBegin(LocalTime.MIN);
        wt2.setEnd(LocalTime.MAX);
        wt3.setBegin(LocalTime.MIN);
        wt3.setEnd(LocalTime.MAX);
        wt4.setBegin(LocalTime.MIN);
        wt4.setEnd(LocalTime.MAX);

        w1.setDay(LocalDate.now());
        w2.setDay(LocalDate.now());
        w3.setDay(LocalDate.now());
        w4.setDay(LocalDate.now());


        w1.getEntries().add(wt1);
        w2.getEntries().add(wt2);
        w3.getEntries().add(wt3);
        w4.getEntries().add(wt4);

        p1.getWorklogs().add(w1);
        p1.getWorklogs().add(w2);
        p2.getWorklogs().add(w3);
        p2.getWorklogs().add(w4);


        workLogRepository.save(w1);
        workLogRepository.save(w2);
        workLogRepository.save(w3);
        workLogRepository.save(w4);

        personRepository.save(p1);
        personRepository.save(p2);



    }
}
