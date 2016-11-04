package de.fh_kiel.person.datamodel;



import de.fh_kiel.person.exception.CompanyNotFound;
import de.fh_kiel.person.stubclass.Company;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Created by Ankit on 10/25/2016.
 */
@Component
public interface CompanyDAO {

    /**
     * Create Company
     * @param company
     */
    public boolean createCompany(Company company);

    /**
     * Get list of All Companies
     * @return ArrayList
     */
    public Collection<Company> getAllCompanies();

    /**
     * Get Company by ID
     * @param id
     * @return company
     */
    public Company getCompanyById(long id) throws CompanyNotFound;

    /**
     * update Company
     * @param company
     */
    public void updateCompanyInfo(Company company) throws Exception;

    /**
     * delete Company
     * @param id
     */
    public void deleteCompany(Long id);

}
