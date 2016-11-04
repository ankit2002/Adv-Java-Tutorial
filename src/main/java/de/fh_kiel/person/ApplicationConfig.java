package de.fh_kiel.person;

import de.fh_kiel.person.datamodel.PersonDAO;
import de.fh_kiel.person.datamodel.PersonDAOImpl;
import de.fh_kiel.person.model.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
        Logger logger = LoggerFactory.getLogger(ApplicationConfig.class);
        logger.debug("Application Started");
        /*LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        StatusPrinter.print(lc);*/
        SpringApplication.run(ApplicationConfig.class, args);
    }
}
