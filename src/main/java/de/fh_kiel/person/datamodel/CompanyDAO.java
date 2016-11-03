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
     *
     * @param company
     */
    public boolean createCompany(Company company);

    /**
     *
     * @return
     */
    public Collection<Company> getAllCompanies();

    /**
     *
     * @param id
     * @return
     */
    public Company getCompanyById(long id) throws CompanyNotFound;

    /**
     * updatedPerson
     * @param company
     * @return
     */
    public boolean updateCompanyInfo(Company company) throws Exception;

    /**
     * deletePerson
     * @param company
     * @return
     */
    public boolean deleteCompany(Company company);

}
