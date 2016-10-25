package de.fh_kiel.person;

import java.util.Collection;

/**
 * Created by Ankit on 10/25/2016.
 */
public interface CompanyDAO {

    /**
     *
     * @param company
     */
    public void createCompany(Company company);

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
    public void updateCompanyInfo(Company company) throws Exception;

    /**
     * deletePerson
     * @param company
     * @return
     */
    public void deleteCompany(Company company);

}
