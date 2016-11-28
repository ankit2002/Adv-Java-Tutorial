package de.fh_kiel.person.datamodel;

//import de.fh_kiel.person.Company;

import de.fh_kiel.person.stubclass.Company;
import de.fh_kiel.person.stubclass.Gender;
import de.fh_kiel.person.stubclass.Person;
import de.fh_kiel.person.worklog.WorklogTimeEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

/**
 * Created by Ankit on 10/25/2016.
 */
@Repository
public class CompanyDAOImpl implements CompanyDAO {

    /**
     * HashMap to store Companies
     */
    private static final Map<Long, Company> companiesList = new HashMap<>();

    static {
        Person person = new Person();
        person.setId(1L);
        person.setFirst_Name("Free");
        person.setLast_Name("Falling");
        person.setD_o_b(LocalDate.of(1983, 10, 10));
        person.setGender(Gender.Male);
        List<WorklogTimeEntry> tempList = new ArrayList<>();
        WorklogTimeEntry worklogTimeEntry = new WorklogTimeEntry();
        worklogTimeEntry.setBegin(LocalTime.of(8,0,0));
        worklogTimeEntry.setEnd(LocalTime.of(16,00,0));
        tempList.add(worklogTimeEntry);
        person.addWorkLog(LocalDate.of(2016,28,11),tempList);

        Person person1 = new Person();
        person1.setId(2L);
        person1.setFirst_Name("Amit");
        person1.setLast_Name("nagar");
        person1.setD_o_b(LocalDate.of(1983, 10, 10));
        List<WorklogTimeEntry> tempList1 = new ArrayList<>();
        WorklogTimeEntry worklogTimeEntry1 = new WorklogTimeEntry();
        worklogTimeEntry1.setBegin(LocalTime.of(8,0,0));
        worklogTimeEntry1.setEnd(LocalTime.of(16,00,0));
        tempList1.add(worklogTimeEntry);
        person.addWorkLog(LocalDate.of(2016,28,11),tempList1);
        person.addWorkLog(LocalDate.of(2016,29,11),tempList1);
        person.addWorkLog(LocalDate.of(2016,30,11),tempList1);

        person1.setGender(Gender.Male);

        Person person3 = new Person();
        person3.setId(3L);
        person3.setFirst_Name("hello");
        person3.setLast_Name("guys");
        person3.setD_o_b(LocalDate.of(1983, 10, 10));
        person3.setGender(Gender.Male);

        companiesList.put(1L,new Company(1, "Company1", new ArrayList<Person>(Arrays.asList(person))));
        companiesList.put(2L,new Company(2, "Company2", new ArrayList<Person>(Arrays.asList(person1))));
        companiesList.put(3L,new Company(3, "Company3", new ArrayList<Person>(Arrays.asList(person3))));
    }

    /**
     * Logger Variable
     */
    Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);

    /**
     * createCompany
     * @param company
     * @return
     */
    @Override
    public long createCompany(Company company) {

        if(company.getCompanyid() != 0L && company != null) {
            companiesList.put(1L,company);
            return company.getCompanyid();
        }
        logger.error("Company is null cannot be created");
        return 0L;
    }

    /**
     * getAllCompanies
     * @return
     */
    @Override
    public Collection<Company> getAllCompanies() {
        return new ArrayList<>(companiesList.values());
    }

    /**
     * getCompanyById
     * @param id
     * @return
     */
    @Override
    public Optional<Company> getCompanyById(long id){

        Company company = companiesList.get(id);
        return Optional.ofNullable(company); // can be null; used for debugging

    }

    /**
     * updateCompanyInfo
     * @param company
     * @param id
     * @throws Exception
     */
    @Override
    public void updateCompanyInfo(Company company, long id) throws Exception {

        Optional<Company> newComp;
        newComp = getCompanyById(id);

        if( newComp.isPresent() )
        {
            this.deleteCompany(id);
            companiesList.put(id,company);
        }
    }

    /**
     * deleteCompany
     * @param id
     */
    @Override
    public void deleteCompany(Long id) {

        Optional<Company> newComp;
        newComp = getCompanyById(id);
        if(newComp.isPresent()) {
            companiesList.remove(newComp);
        }
    }
}
