package de.fh_kiel.person.initializeTables;

import de.fh_kiel.person.repositories.DeveloperRepository;
import de.fh_kiel.person.stubclass.Developer;
import de.fh_kiel.person.stubclass.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * Created by amit on 16.12.16.
 */
@Component
@Order(2)
public class DeveloperInitializeData implements CommandLineRunner {


    @Autowired
    private DeveloperRepository developerRepository;

    @Override
    public void run(String... args) throws Exception {

        Developer d1 = new Developer();
        Developer d2 = new Developer();
        d1.setWorkExp(3);
        d1.setMin_Salary(1000.00);
        d2.setWorkExp(3);
        d2.setMin_Salary(1000.00);

        d1.setFirst_Name("Amit");
        d1.setLast_Name("Nagar");
        d1.setD_o_b(LocalDate.of(1900,10,10));
        d1.setGender(Gender.Male);

        d2.setFirst_Name("Riki");
        d2.setLast_Name("Hey");
        d2.setD_o_b(LocalDate.of(1900,11,10));
        d2.setGender(Gender.Female);

        developerRepository.save(d1);
        developerRepository.save(d2);

    }
}

