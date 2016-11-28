package de.fh_kiel.PersonTest;

import de.fh_kiel.person.datamodel.CompanyDAO;
import de.fh_kiel.person.service.CompanyService;
import de.fh_kiel.person.stubclass.Company;
import de.fh_kiel.person.stubclass.Developer;
import de.fh_kiel.person.stubclass.Gender;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.*;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * Created by Ankit on 10/25/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class CompanyServiceTest {


    @InjectMocks
    private CompanyService companyService;

    @Mock
    private CompanyDAO mockCompanyDAO;

    private Company company1,company2;
    Developer developer1,developer2;

    @Before
    public void setup() {



        developer1 = new Developer(1, 100000, new HashSet<>(Collections.singleton("Java")));
        developer1.setId(1L);
        developer1.setFirst_Name("Free");
        developer1.setLast_Name("Farah");
        developer1.setD_o_b(LocalDate.of(1983, 10, 10));
        developer1.setGender(Gender.Male);

        developer2 = new Developer(1, 100000, new HashSet<>(Collections.singleton("Java")));
        developer2.setId(1L);
        developer2.setFirst_Name("Free");
        developer2.setLast_Name("Farah");
        developer2.setD_o_b(LocalDate.of(1983, 10, 10));
        developer2.setGender(Gender.Male);

        /**
         * Company Object
         */
        company1 = new Company(1L,"Test Comp",new ArrayList<>(Arrays.asList(developer1,developer2)));
        company2 = new Company(2L,"Ag Comp",new ArrayList<>(Arrays.asList(developer1,developer2)));
    }


    @Test
    public void listCompanies() {
        when(mockCompanyDAO.getAllCompanies()).thenReturn(Arrays.asList(company1, company2));
        final List<Company> list = new ArrayList<>(companyService.getAllCompanies());
        assertThat("list shouldn't be null", list, notNullValue());
        assertThat("list should have 4 entries", list, hasSize(2));
        verify(mockCompanyDAO, times(1)).getAllCompanies();
    }



}
