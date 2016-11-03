package de.fh_kiel.person.controller;

import de.fh_kiel.person.model.CompanyService;
import de.fh_kiel.person.stubclass.Company;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by amit on 03.11.16.
 */
@RestController
@RequestMapping("/company")

public class CompanyController implements ErrorController {

    Logger logger = LoggerFactory.getLogger(CompanyController.class);;


    @Autowired
    private CompanyService companyService;


    @Autowired
    public void createPerson(){;
    }

    //@RequestMapping("/persons")
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Company> companyCollection(){
        logger.info("Testing for returning wmpty object");
        return companyService.getAllCompanies();
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