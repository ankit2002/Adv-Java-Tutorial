package de.fh_kiel.person.initializeTables;

import de.fh_kiel.person.repositories.PersonRepository;
import de.fh_kiel.person.stubclass.Gender;
import de.fh_kiel.person.stubclass.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * Created by amit on 15.12.16.
 */
@Component
public class PersonInitializeData implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public void run(String... args) throws Exception {
        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();
        Person p4 = new Person();
        Person p5 = new Person();

        p1.setFirst_Name("Amit");
        p1.setLast_Name("Nagar");
        p1.setD_o_b(LocalDate.of(1900,10,10));
        p1.setGender(Gender.Male);

        p2.setFirst_Name("Riki");
        p2.setLast_Name("Hey");
        p2.setD_o_b(LocalDate.of(1900,11,10));
        p2.setGender(Gender.Female);

        p3.setFirst_Name("Rock");
        p3.setLast_Name("hello");
        p3.setD_o_b(LocalDate.of(1900,02,02));
        p3.setGender(Gender.Male);

        p4.setFirst_Name("Silvy");
        p4.setLast_Name("Hi");
        p4.setD_o_b(LocalDate.of(1900,04,05));
        p4.setGender(Gender.Female);

        p5.setFirst_Name("Martin");
        p5.setLast_Name("Say");
        p5.setD_o_b(LocalDate.of(1900,03,06));
        p5.setGender(Gender.Male);

        personRepository.save(p1);
        personRepository.save(p2);
        personRepository.save(p3);
        personRepository.save(p4);
        personRepository.save(p5);
    }
}
