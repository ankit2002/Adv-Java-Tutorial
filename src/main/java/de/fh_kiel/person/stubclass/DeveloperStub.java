package de.fh_kiel.person.stubclass;
import de.fh_kiel.annotation.BoilerPlate;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ankit on 10/7/2016.
 */
@BoilerPlate
public class DeveloperStub extends PersonStub {

    private float workExp;
    private double min_Salary;
    private Set<String> prog_lang = new HashSet<>();

/*
    public void removeProgrammingLanguage(String programmingLanguage) {
        prog_lang.remove(programmingLanguage);
    }

    public void addProgrammingLanguage(final String programmingLanguage) {
        this.prog_lang.add(programmingLanguage);
    }*/

}