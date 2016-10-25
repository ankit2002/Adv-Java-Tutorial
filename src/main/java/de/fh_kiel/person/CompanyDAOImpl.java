package de.fh_kiel.person;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Ankit on 10/25/2016.
 */
public class CompanyDAOImpl implements CompanyDAO {

    /**
     * HashSet to store Companies
     */
    private final HashSet<Company> companiesList = new HashSet<>();

    @Override
    public void createCompany(Company company) {
        companiesList.add(company);
    }

    @Override
    public Collection<Company> getAllCompanies() {
        return companiesList;
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
            newComp = getCompanyById(newComp.getCompanyid());
        }catch (CompanyNotFound companyNotFound){
            throw new Exception(companyNotFound.toString());
        }

        if( newComp != null )
        {
            // Updated
            newComp.setCompanyName(company.getCompanyName());
            newComp.setCompanyEmpList(company.getCompanyEmpList());
        }
        else
        {
            throw new Exception("Company cannot be updated");
        }

    }

    @Override
    public void deleteCompany(Company company) {

        Company newComp = null;
        try{
            newComp = getCompanyById(company.getCompanyid());
        }catch (CompanyNotFound companyNotFound){
            System.out.println("Company not Found");
        }
        if(newComp != null) {
            companiesList.remove(newComp);
        }
    }
}