package de.fh_kiel.person.controller;

import de.fh_kiel.person.model.CompanyService;
import de.fh_kiel.person.stubclass.Company;
import de.fh_kiel.person.stubclass.Gender;
import de.fh_kiel.person.stubclass.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

/**
 * Created by amit on 03.11.16.
 */
@RestController
@RequestMapping("/company")
public class CompanyController implements ErrorController {

    Logger logger = LoggerFactory.getLogger(CompanyController.class);;

    /**
     * Injecting dependency for Company Service
     */
    @Autowired
    private CompanyService companyService;


    /**
     * GET METHOD for get companies
     * @return list of companies
     */
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Company> companies(HttpServletRequest request, HttpServletResponse response){
        if (companyService.getAllCompanies() !=null) {
            logger.debug("To get all companies");
            response.setStatus(HttpServletResponse.SC_OK);
        }else {
            response.setStatus( HttpServletResponse.SC_NOT_FOUND);
        }
        return companyService.getAllCompanies();
    }


    /**
     * Ger Company id
     * @return company
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Company getCompanyById(@PathVariable("id") long id, HttpServletRequest request, HttpServletResponse response){

        Optional<Company> company = companyService.getCompanyById(id);
        if (company.isPresent()){
            logger.debug("Object is not Null");
            response.setStatus( HttpServletResponse.SC_OK);
            return company.get();
        }
        else{
            logger.error("Object is NULLABLE, Default object set to : " + (new Company(0L, "Default Company",new ArrayList<Person>())));
            response.setStatus( HttpServletResponse.SC_NOT_FOUND);
            return company.orElse(new Company(0L, "Default Company", new ArrayList<Person>(Arrays.asList(new Person ("Default", "User", LocalDate.of(1900,1,1), Gender.Male, null)))));
        }
    }

    /**
     * Create Company
     * @return
     */
    @RequestMapping(value ="/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public long createCompany(@RequestBody Company company, HttpServletRequest request, HttpServletResponse response){

        long id = companyService.createCompany(company);
        if(id == 0L){
            throw new IllegalArgumentException("Company ID should not be 0");
        }else {
            response.setStatus(HttpServletResponse.SC_OK);
            logger.debug("To create a company");
            return id;
        }
    }


    /**
     * Update Company
     * @param id
     * @param company
     */
    @RequestMapping(value ="/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateCompany(@PathVariable("id") long id,@RequestBody Company company, HttpServletRequest request, HttpServletResponse response){
        if(company.getCompanyid() == id){
            response.setStatus(HttpServletResponse.SC_OK);
            logger.debug("To update a company");
            companyService.updateCompany(company, id);
        }else {
            logger.error("Companies ID is not same for updation");
        }

    }

    /**
     * Delete Company
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteCompany(@PathVariable("id") long id, HttpServletRequest request, HttpServletResponse response){
        response.setStatus(HttpServletResponse.SC_OK);
        logger.debug("To delete a company by id");
        companyService.deleteCompany(id);
    }

    /**
     * Error Handling
     * @return
     */
    @RequestMapping(value = "/error")
    public String error() {
        return "Error handling";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }


}