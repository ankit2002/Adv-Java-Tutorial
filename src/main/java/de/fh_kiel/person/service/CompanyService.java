package de.fh_kiel.person.service;

//import de.fh_kiel.person.Company;
//import de.fh_kiel.person.Person;

import de.fh_kiel.person.checkmethod.CheckNull;
import de.fh_kiel.person.datamodel.CompanyDAO;
import de.fh_kiel.person.stubclass.Company;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * Created by Ankit on 10/25/2016.
 */
@Service
public class CompanyService {

    @Autowired
    private CompanyDAO companyDAO;

    /**
     * Logger Variable
     */
    Logger logger = LoggerFactory.getLogger(CompanyService.class);

    // Constructor
    public CompanyService( CompanyDAO companyDAO)
    {
        this.companyDAO = companyDAO;
    }

    /**
     * Create company
     * @param company
     */
    @CheckNull
    public List<Company> createCompany(Company company){
         companyDAO.save(company);
        return companyDAO.findAll();
    }

    /**
     * Get All companies
     * @return
     */
    @CheckNull
    public Collection<Company> getAllCompanies(){
        return companyDAO.findAll();
    }

    /**
     * get company by ID
     * @param id
     * @return
     */
    @CheckNull
    public Company getCompanyById(long id){
            return companyDAO.findOne(id);
    }

     /**
     * Update company
     * @param company
     * @return
     */
    @CheckNull
    public void updateCompany(Company company) {
        if(companyDAO.findOne(company.getCompanyid()).getCompanyid() == company.getCompanyid()){
            System.out.print("amitcompanyupdate: + " + company);
            companyDAO.save(company);
        }
    }


    /**
     * Delete company
     * @param id
     * @return
     */
    @CheckNull
    public void deleteCompany(Long id) throws Exception{
        if(companyDAO.findOne(id).getCompanyid()==id) {
            System.out.print("amitcompanydelete: + " + id + "hellodi: " + companyDAO.findOne(id));
            companyDAO.delete(id);
        }
    }

}
