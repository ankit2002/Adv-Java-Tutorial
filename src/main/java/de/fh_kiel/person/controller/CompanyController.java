package de.fh_kiel.person.controller;

import de.fh_kiel.person.model.CompanyService;
import de.fh_kiel.person.stubclass.Company;
import de.fh_kiel.person.stubclass.Developer;
import de.fh_kiel.person.stubclass.Gender;
import de.fh_kiel.person.stubclass.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

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
    public Collection<Company> companies(){
        return companyService.getAllCompanies();
    }


    /**
     * Ger Company id
     * @return company
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Company getCompanyById(@PathVariable("id") long id){
        return companyService.getCompanyById(id);
    }

    /**
     * Create Company
     * @return
     */
    @RequestMapping(value ="/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean createCompany(@RequestBody Company company){
        return companyService.createCompany(company);
    }


    /**
     * Update Company
     * @param id
     * @param company
     */
    @RequestMapping(value ="/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateCompany(@PathVariable("id") long id,@RequestBody Company company){
        if(company.getCompanyid() == id){
            companyService.updateCompany(company);
        }else {
            logger.error("Companies ID is not same for updation");
        }

    }

    /**
     * Delete Company
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteCompany(@PathVariable("id") long id){
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