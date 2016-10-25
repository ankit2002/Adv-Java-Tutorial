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
    public Collection<Company> getAllCompanys();

    /**
     *
     * @param id
     * @return
     * @throws PersonNotFound
     */
    public Person getCompany(long id);

    /**
     * updatedPerson
     * @param company
     * @return
     */
    public void updateCompanynfo(Company company) throws Exception;

    /**
     * deletePerson
     * @param company
     * @return
     */
    public boolean deleteCompany(Company company);

}
