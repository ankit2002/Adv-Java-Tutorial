package de.fh_kiel.person.model;

//import de.fh_kiel.person.Company;
//import de.fh_kiel.person.Person;

import de.fh_kiel.person.checkmethod.CheckNull;
import de.fh_kiel.person.datamodel.CompanyDAO;
import de.fh_kiel.person.exception.CompanyNotFound;
import de.fh_kiel.person.stubclass.Company;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Ankit on 10/25/2016.
 */
@Service
public class CompanyService {

    @Autowired
    private final CompanyDAO companyDAO;

    /**
     * Logger Variable
     */
    Logger logger = LoggerFactory.getLogger(PersonService.class);

    // Constructor
    public CompanyService( CompanyDAO companyDAO )
    {
        this.companyDAO = companyDAO;
    }

    /**
     * Create company
     * @param company
     */
    @CheckNull
    public long createCompany(Company company){
        return companyDAO.createCompany(company);
    }

    /**
     * Get All companies
     * @return
     */
    @CheckNull
    public Collection<Company> getAllCompanies(){
        return companyDAO.getAllCompanies();
    }

    /**
     * get company by ID
     * @param id
     * @return
     */
    @CheckNull
    public Company getCompanyById(long id){

        try{
            return companyDAO.getCompanyById(id);
        }catch (CompanyNotFound e){
            logger.warn(e.toString());
            return null;
        }
    }

    // Get Person Size
    @CheckNull
    public int getAllCompaniesSize(){
        return companyDAO.getAllCompanies().size();
    }


    /**
     * Update company
     * @param company
     * @return
     */
    @CheckNull
    public void updateCompany(Company company, long id) {
        try{
            companyDAO.updateCompanyInfo(company, id);
        }catch (Exception e){
            logger.warn(e.toString());
        }
    }

    /**
     * Delete company
     * @param id
     * @return
     */
    @CheckNull
    public void deleteCompany(Long id){
        companyDAO.deleteCompany(id);
    }

}
