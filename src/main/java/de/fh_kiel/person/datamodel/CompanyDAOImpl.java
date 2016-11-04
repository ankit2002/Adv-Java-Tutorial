package de.fh_kiel.person.datamodel;

//import de.fh_kiel.person.Company;

import de.fh_kiel.person.exception.CompanyNotFound;
import de.fh_kiel.person.stubclass.Company;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ankit on 10/25/2016.
 */
@Repository
public class CompanyDAOImpl implements CompanyDAO {

    /**
     * HashSet to store Companies
     */
    private final Set<Company> companiesList = new HashSet<>();

    /**
     * Logger Variable
     */
    Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);

    @Override
    public boolean createCompany(Company company) {
        if(company != null) {
            companiesList.add(company);
            return true;
        }
        return false;
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
    public void updateCompanyInfo(Company company) throws Exception {

        Company newComp = null;
        try{
            newComp = getCompanyById(company.getCompanyid());
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
