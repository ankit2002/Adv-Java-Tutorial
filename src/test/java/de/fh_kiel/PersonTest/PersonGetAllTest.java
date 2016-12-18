package de.fh_kiel.PersonTest;

/**
 * Created by amit on 18.12.16.
 */

import de.fh_kiel.person.ApplicationConfig;
import de.fh_kiel.person.datamodel.PersonDAO;
import de.fh_kiel.person.stubclass.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

//import org.springframework.test.context.transaction.TransactionConfiguration;

@ContextConfiguration(classes=ApplicationConfig.class)
@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonGetAllTest {

    @Autowired
    private PersonDAO personDAO;

    @Autowired
    private TestEntityManager entityManager;

    //public void setup

    @Test
    public void testPersonFindAll() {

        Person p1 = new Person();
        p1.setLast_Name("Nagar");
        p1.setFirst_Name("Amit");
        p1.setD_o_b(LocalDate.of(1900,10,10));

        Person p2 = new Person();
        p2.setLast_Name("MArtin");
        p2.setFirst_Name("Rick");
        p2.setD_o_b(LocalDate.of(1900,05,05));

        this.entityManager.persist(p1);
        this.entityManager.persist(p2);

        assertThat(personDAO.findAll(), hasSize(2));
        assertThat(personDAO.count(), equalTo(2L));



    }
}