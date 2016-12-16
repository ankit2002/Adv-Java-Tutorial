package de.fh_kiel.person.initializeTables;

import de.fh_kiel.person.repositories.PersonRepository;
import de.fh_kiel.person.stubclass.Gender;
import de.fh_kiel.person.stubclass.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * Created by amit on 15.12.16.
 */
@Component
@Order(1)
public class PersonInitializeData implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public void run(String... args) throws Exception {

        Person p1 = new Person();
        Person p2 = new Person();

        p1.setFirst_Name("Amit");
        p1.setLast_Name("Nagar");
        p1.setD_o_b(LocalDate.of(1900,10,10));
        p1.setGender(Gender.Male);

        p2.setFirst_Name("Riki");
        p2.setLast_Name("Hey");
        p2.setD_o_b(LocalDate.of(1900,11,10));
        p2.setGender(Gender.Female);

        personRepository.save(p1);
        personRepository.save(p2);


    }
}
