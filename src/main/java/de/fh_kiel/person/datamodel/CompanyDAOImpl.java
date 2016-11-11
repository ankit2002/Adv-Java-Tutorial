package de.fh_kiel.person.datamodel;

//import de.fh_kiel.person.Company;

import de.fh_kiel.person.exception.CompanyNotFound;
import de.fh_kiel.person.stubclass.Company;
import de.fh_kiel.person.stubclass.Gender;
import de.fh_kiel.person.stubclass.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

/**
 * Created by Ankit on 10/25/2016.
 */
@Repository
public class CompanyDAOImpl implements CompanyDAO {

    /**
     * HashSet to store Companies
     */
    private static final Set<Company> companiesList = new HashSet<>();

    static {
        Person person = new Person();
        person.setId(1L);
        person.setFirst_Name("Free");
        person.setLast_Name("Falling");
        person.setD_o_b(LocalDate.of(1983, 10, 10));
        person.setGender(Gender.Male);
        Person person1 = new Person();
        person1.setId(2L);
        person1.setFirst_Name("Amit");
        person1.setLast_Name("nagar");
        person1.setD_o_b(LocalDate.of(1983, 10, 10));
        person1.setGender(Gender.Male);
        Person person3 = new Person();
        person3.setId(3L);
        person3.setFirst_Name("hello");
        person3.setLast_Name("guys");
        person3.setD_o_b(LocalDate.of(1983, 10, 10));
        person3.setGender(Gender.Male);
        companiesList.add(new Company(1, "Company1", new ArrayList<Person>(Arrays.asList(person))));
        companiesList.add(new Company(2, "Company2", new ArrayList<Person>(Arrays.asList(person1))));
        companiesList.add(new Company(3, "Company3", new ArrayList<Person>(Arrays.asList(person3))));
    }

    /**
     * Logger Variable
     */
    Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);

    @Override
    public long createCompany(Company company) {

        if(company.getCompanyid() != 0L && company != null) {
            companiesList.add(company);
            return company.getCompanyid();
        }
        logger.error("Company is null cannot be created");
        return 0L;
    }

    @Override
    public Collection<Company> getAllCompanies() {
        return new ArrayList<>(companiesList);
    }

    @Override
    public Company getCompanyById(long id) throws CompanyNotFound{
        for (Company company:companiesList) {
            if(company.getCompanyid()==id){
                return company;
            }
        }
        throw new CompanyNotFound("Company Not Found");
    }

    @Override
    public void updateCompanyInfo(Company company, long id) throws Exception {

        Company newComp = null;
        try{
            newComp = getCompanyById(id);
        }catch (CompanyNotFound companyNotFound){
            throw new CompanyNotFound(companyNotFound.toString());
        }

        if( newComp != null )
        {
            // Updated
            newComp.setCompanyName(company.getCompanyName());
            newComp.setCompanyEmpList(company.getCompanyEmpList());
        }

    }

    @Override
    public void deleteCompany(Long id) {

        Company newComp = null;
        try{
            newComp = getCompanyById(id);
        }catch (CompanyNotFound companyNotFound){
            logger.warn("Company not Found");
        }
        if(newComp != null)
            companiesList.remove(newComp);
    }
}
