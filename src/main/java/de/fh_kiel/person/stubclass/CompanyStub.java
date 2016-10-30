package de.fh_kiel.person.stubclass;

import de.fh_kiel.annotation.BoilerPlate;
import de.fh_kiel.person.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amit on 25.10.16.
 */
@BoilerPlate
public class CompanyStub {
    private long companyid;
    private String companyName;
    private List<Person> companyEmpList = new ArrayList<>();
}
