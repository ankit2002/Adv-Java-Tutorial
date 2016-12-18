package de.fh_kiel.PersonTest;

/**
 * Created by amit on 18.12.16.
 */

import de.fh_kiel.person.ApplicationConfig;
import de.fh_kiel.person.datamodel.CompanyDAO;
import de.fh_kiel.person.stubclass.Company;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

//import org.springframework.test.context.transaction.TransactionConfiguration;

@ContextConfiguration(classes=ApplicationConfig.class)
@RunWith(SpringRunner.class)
@DataJpaTest
public class CompanyGetAllTest {

    @Autowired
    private CompanyDAO companyDAO;

    @Autowired
    private TestEntityManager entityManager;

    //public void setup

    @Test
    public void testFindAll() {
       // List<Company> listCompany = companyDAO.findAll();
        Company cm1 = new Company();
        cm1.setCompanyName("Bosch");
        Company cm2 = new Company();
        cm2.setCompanyName("Google");
        this.entityManager.persist(cm1);
        this.entityManager.persist(cm2);
        Company assert1 = companyDAO.findOne(1L);
        assertThat(assert1.getCompanyid(),equalTo(1L));
        assertThat(assert1.getCompanyName(),equalTo("Bosch"));

        Company assert2 = companyDAO.findOne(2L);
        assertThat(assert2.getCompanyid(),equalTo(2L));
        assertThat(assert2.getCompanyName(),equalTo("Google"));
        assertThat(companyDAO.findAll(), hasSize(2));
        assertThat(companyDAO.count(), equalTo(2L));




    }
}
