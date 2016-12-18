package de.fh_kiel.person.datamodel;



import de.fh_kiel.person.exception.CompanyNotFound;
import de.fh_kiel.person.stubclass.Company;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by Ankit on 10/25/2016.
 */
@Component
public interface CompanyDAO {

    /**
     * Create Company
     * @param company
     */
    public long createCompany(Company company);

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
    public Optional<Company> getCompanyById(long id);

    /**
     * update Company
     * @param company
     */
    public void updateCompanyInfo(Company company, long id) throws Exception;

    /**
     * delete Company
     * @param id
     */
    public void deleteCompany(Long id);

}
