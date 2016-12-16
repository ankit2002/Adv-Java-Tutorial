package de.fh_kiel.person.initializeTables;

import de.fh_kiel.person.repositories.CompanyRepository;
import de.fh_kiel.person.repositories.PersonRepository;
import de.fh_kiel.person.repositories.WorkLogRepository;
import de.fh_kiel.person.stubclass.Company;
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
public class InitialTableLoad implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private WorkLogRepository workLogRepository;

    @Autowired
    private CompanyRepository companyRepository;

    /*@Autowired
    private ProgLangRepository progLangRepository;
*/

    @Override
    public void run(String... args) throws Exception {

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

        w1.setPerson(p1);
        w2.setPerson(p1);
        w3.setPerson(p2);
        w4.setPerson(p2);

       /* ProgLanguage pl1 = new ProgLanguage();
        ProgLanguage pl2 = new ProgLanguage();
        ProgLanguage pl3 = new ProgLanguage();
        ProgLanguage pl4 = new ProgLanguage();
        pl1.setName("JAVA");
        pl2.setName("C++");
        pl3.setName("COBOL");
        pl4.setName("SAS");

        p1.getProglanglist().add(pl1);
        p1.getProglanglist().add(pl2);
        p1.getProglanglist().add(pl3);
        p1.getProglanglist().add(pl4);*/



        Company cm1 = new Company();
        cm1.setCompanyName("Bosch");
        Company cm2 = new Company();
        cm2.setCompanyName("Google");
        cm1.getCompanyEmpList().add(p1);
        cm1.getCompanyEmpList().add(p2);

        companyRepository.save(cm1);
        companyRepository.save(cm2);

        p1.setCompany(cm1);
        p2.setCompany(cm1);

        p1.getWorklogs().add(w1);
        p1.getWorklogs().add(w2);
        p2.getWorklogs().add(w3);
        p2.getWorklogs().add(w4);

        personRepository.save(p1);
        personRepository.save(p2);

        workLogRepository.save(w1);
        workLogRepository.save(w2);
        workLogRepository.save(w3);
        workLogRepository.save(w4);


       /* progLangRepository.save(pl1);
        progLangRepository.save(pl2);
        progLangRepository.save(pl3);
        progLangRepository.save(pl4);*/



    }
}
