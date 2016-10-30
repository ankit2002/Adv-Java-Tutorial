package de.fh_kiel.person;

import de.fh_kiel.person.datamodel.*;
import de.fh_kiel.person.model.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by Ankit on 10/28/2016.
 */
@SpringBootApplication
public class ApplicationConfig {


    @Bean
    public PersonService personService() {
        return new PersonService(personDAO());
    }

    @Bean
    public PersonDAO personDAO() {
        return new PersonDAOImpl();
    }


    public static void main(String[] args) throws Exception {
        SpringApplication.run(ApplicationConfig.class, args);
    }
}
