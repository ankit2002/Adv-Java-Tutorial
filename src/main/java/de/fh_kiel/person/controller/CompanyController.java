package de.fh_kiel.person.controller;

import de.fh_kiel.person.service.CompanyService;
import de.fh_kiel.person.stubclass.Company;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.List;

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

        Company company = companyService.getCompanyById(id);
        if (company != null){
            logger.debug("Get company by id");
            response.setStatus( HttpServletResponse.SC_OK);
        }
        else{
            logger.error("No Company found with this id");
            response.setStatus( HttpServletResponse.SC_NOT_FOUND);
        }
        return company;
    }

    /**
     * Create Company
     * @return
     */
    @RequestMapping(value ="/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Company> createCompany(@RequestBody Company company, HttpServletRequest request, HttpServletResponse response){


        if(company !=null){
            logger.debug("Company Created");
            response.setStatus( HttpServletResponse.SC_OK);
        }else {
            logger.error("Company object was null and cant be created");
            response.setStatus( HttpServletResponse.SC_NOT_FOUND);
        }
        return this.companyService.createCompany(company);

    }


    /**
     * Update Company
     * @param id
     * @param company
     */
    @RequestMapping(value ="/update/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateCompany(@PathVariable("id") long id,@RequestBody Company company, HttpServletRequest request, HttpServletResponse response){
        if(company.getCompanyid() == id){
            response.setStatus(HttpServletResponse.SC_OK);
            logger.debug("To update a company");
            companyService.updateCompany(company);
        }else {
            logger.error("Companies ID is not same for updation");
        }

    }
//
//    /**
//     * Delete Company
//     * @param id
//     */
//    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
//    public void deleteCompany(@PathVariable("id") long id, HttpServletRequest request, HttpServletResponse response){
//        logger.debug("To delete a company by id");
//        try{
//            companyService.deleteCompany(id);
//            response.setStatus(HttpServletResponse.SC_OK);
//        }catch (Exception e){
//            logger.error("Exception during delete: " + e);
//        }
//    }

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