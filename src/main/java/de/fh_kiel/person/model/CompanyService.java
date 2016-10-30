package de.fh_kiel.person.model;

//import de.fh_kiel.person.Company;
//import de.fh_kiel.person.Person;

import de.fh_kiel.person.checkmethod.CheckNull;
import de.fh_kiel.person.datamodel.CompanyDAO;
import de.fh_kiel.person.stubclass.Company;
import de.fh_kiel.person.stubclass.Person;

import java.util.Collection;

/**
 * Created by Ankit on 10/25/2016.
 */
@CheckNull
public class CompanyService {

    private final CompanyDAO companyDAO;

    // Constructor
    public CompanyService( CompanyDAO companyDAO )
    {
        this.companyDAO = companyDAO;
    }

    /**
     * Create company
     * @param company
     */
    public void createCompany(Company company){
        companyDAO.createCompany(company);
    }

    /**
     * Get All companies
     * @return
     */
    public Collection<Company> getAllCompanies(){
        return companyDAO.getAllCompanies();
    }

    /**
     * get company by ID
     * @param id
     * @return
     */
    public Person getPCompanyById(long id){
        return null;
    }

    // Get Person Size
    public int getAllCompaniesSize(){
        return companyDAO.getAllCompanies().size();
    }


    /**
     * Update company
     * @param company
     * @return
     */
    public void updateCompany(Company company) {
        try{
            companyDAO.updateCompanyInfo(company);
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    /**
     * Delete company
     * @param company
     * @return
     */
    public void deleteCompany(Company company){
        companyDAO.deleteCompany(company);
    }

}
