package de.fh_kiel.person;

import java.util.Collection;

/**
 * Created by Ankit on 10/25/2016.
 */
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
