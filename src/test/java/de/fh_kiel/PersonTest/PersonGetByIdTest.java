package de.fh_kiel.PersonTest;

/**
 * Created by amit on 18.12.16.
 */

import de.fh_kiel.person.ApplicationConfig;
import de.fh_kiel.person.datamodel.PersonDAO;
import de.fh_kiel.person.stubclass.Person;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.Assert.assertThat;

//import org.springframework.test.context.transaction.TransactionConfiguration;

@ContextConfiguration(classes=ApplicationConfig.class)
@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonGetByIdTest {

    @Autowired
    private PersonDAO personDAO;

    @Autowired
    private TestEntityManager entityManager;

    //public void setup

    @Test
    public void testPersonFindById() {

        Person p1 = new Person();
        p1.setLast_Name("Nagar");
        p1.setFirst_Name("Amit");
        p1.setD_o_b(LocalDate.of(1900,10,10));

        Person p2 = new Person();
        p2.setLast_Name("Martin");
        p2.setFirst_Name("Rick");
        p2.setD_o_b(LocalDate.of(1900,05,05));

        this.entityManager.persist(p1);
        this.entityManager.persist(p2);

        Person assert1 = personDAO.findOne(1L);

        assertThat(assert1.getId(), Matchers.equalTo(1L));
        assertThat(assert1.getFirst_Name(), Matchers.equalTo("Amit"));
        assertThat(assert1.getLast_Name(), Matchers.equalTo("Nagar"));
        assertThat(assert1.getD_o_b().toString(), Matchers.equalTo("1900-10-10"));

        Person assert2 = personDAO.findOne(2L);
        assertThat(assert2.getId(), Matchers.equalTo(2L));
        assertThat(assert2.getFirst_Name(), Matchers.equalTo("Rick"));
        assertThat(assert2.getLast_Name(), Matchers.equalTo("Martin"));
        assertThat(assert2.getD_o_b().toString(), Matchers.equalTo("1900-05-05"));

    }
}
