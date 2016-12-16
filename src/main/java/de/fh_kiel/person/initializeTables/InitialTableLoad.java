package de.fh_kiel.person.initializeTables;

import de.fh_kiel.person.repositories.CompanyRepository;
import de.fh_kiel.person.repositories.PersonRepository;
import de.fh_kiel.person.repositories.ProgLangRepository;
import de.fh_kiel.person.repositories.WorkLogRepository;
import de.fh_kiel.person.stubclass.*;
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
public class InitialTableLoad implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private WorkLogRepository workLogRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private ProgLangRepository progLangRepository;

    @Override
    public void run(String... args) throws Exception {

        /**
         * Project Manager details loaded
         */

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

        /**
         * Project manager Work log loaded
         */
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

        w1.setPerson(p1);
        w2.setPerson(p1);
        w3.setPerson(p2);
        w4.setPerson(p2);

        /**
         * Developer details loaded
         */

        Developer d1 = new Developer();
        Developer d2 = new Developer();


        d1.setFirst_Name("developer1");
        d1.setLast_Name("Nagar");
        d1.setD_o_b(LocalDate.of(1999,10,03));
        d1.setGender(Gender.Male);

        d1.setWorkExp(4);
        d1.setMin_Salary(500.00);

        d2.setFirst_Name("developer2");
        d2.setLast_Name("Nagar");
        d2.setD_o_b(LocalDate.of(2000,10,03));
        d2.setGender(Gender.Female);

        d2.setWorkExp(4);
        d2.setMin_Salary(500.00);

        /**
         * Developer Woke log loaded
         */

        WorklogDayEntry w5 = new WorklogDayEntry();
        WorklogDayEntry w6 = new WorklogDayEntry();
        WorklogDayEntry w7 = new WorklogDayEntry();
        WorklogDayEntry w8 = new WorklogDayEntry();


        WorklogTimeEntry wt5 = new WorklogTimeEntry();
        WorklogTimeEntry wt6 = new WorklogTimeEntry();
        WorklogTimeEntry wt7 = new WorklogTimeEntry();
        WorklogTimeEntry wt8 = new WorklogTimeEntry();


        wt5.setBegin(LocalTime.MIN);
        wt5.setEnd(LocalTime.MAX);
        wt6.setBegin(LocalTime.MIN);
        wt6.setEnd(LocalTime.MAX);
        wt7.setBegin(LocalTime.MIN);
        wt7.setEnd(LocalTime.MAX);
        wt8.setBegin(LocalTime.MIN);
        wt8.setEnd(LocalTime.MAX);

        w5.setDay(LocalDate.now());
        w6.setDay(LocalDate.now());
        w7.setDay(LocalDate.now());
        w8.setDay(LocalDate.now());


        w5.getEntries().add(wt5);
        w6.getEntries().add(wt6);
        w7.getEntries().add(wt7);
        w8.getEntries().add(wt8);

        w5.setPerson(d1);
        w6.setPerson(d1);
        w7.setPerson(d2);
        w8.setPerson(d2);


        /**
         * Programming Languages loaded for the Developer
         */

        ProgLanguage pl1 = new ProgLanguage();
        ProgLanguage pl2 = new ProgLanguage();
        ProgLanguage pl3 = new ProgLanguage();
        ProgLanguage pl4 = new ProgLanguage();
        pl1.setName("JAVA");
        pl2.setName("C++");
        pl3.setName("COBOL");
        pl4.setName("SAS");
        pl1.getDeveloperlist().add(d1);
        pl2.getDeveloperlist().add(d1);
        pl1.getDeveloperlist().add(d2);
        pl2.getDeveloperlist().add(d2);





        d1.getProglanglist().add(pl1);
        d1.getProglanglist().add(pl2);
        d2.getProglanglist().add(pl1);
        d2.getProglanglist().add(pl2);

        /**
         * Company details loaded for both developer and project managed
         */

        Company cm1 = new Company();
        cm1.setCompanyName("Bosch");
        Company cm2 = new Company();
        cm2.setCompanyName("Google");
        cm1.getCompanyEmpList().add(p1);
        cm1.getCompanyEmpList().add(p2);
        cm2.getCompanyEmpList().add(d1);
        cm2.getCompanyEmpList().add(d2);

        companyRepository.save(cm1);
        companyRepository.save(cm2);


        p1.setCompany(cm1);
        p2.setCompany(cm1);
        d1.setCompany(cm2);
        d2.setCompany(cm2);

        p1.getWorklogs().add(w1);
        p1.getWorklogs().add(w2);
        p2.getWorklogs().add(w3);
        p2.getWorklogs().add(w4);

        d1.getWorklogs().add(w5);
        d1.getWorklogs().add(w6);
        d2.getWorklogs().add(w7);
        d2.getWorklogs().add(w8);

        personRepository.save(p1);
        personRepository.save(p2);
        personRepository.save(d1);
        personRepository.save(d2);

        workLogRepository.save(w1);
        workLogRepository.save(w2);
        workLogRepository.save(w3);
        workLogRepository.save(w4);
        workLogRepository.save(w5);
        workLogRepository.save(w6);
        workLogRepository.save(w7);
        workLogRepository.save(w8);


        progLangRepository.save(pl1);
        progLangRepository.save(pl2);
        progLangRepository.save(pl3);
        progLangRepository.save(pl4);


    }
}
