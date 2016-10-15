package de.fh_kiel.Person;

import java.time.LocalDate;

/**
 * Created by amit on 07.10.16.
 */
public class ProjectManager extends Developer {

    public float pmExp;

    // Constructor
    public ProjectManager(){

    }

    // param Const
    public ProjectManager(final String firstName, final String lastName, final LocalDate dayOfBirth, final String gender, final long id,final int experienceInYears, final int minimumSalary,
                          final int experienceInYearsAsPM) {
        super(firstName, lastName, dayOfBirth, gender, id,experienceInYears, minimumSalary);
        this.setExperienceInYearsAsPM(experienceInYearsAsPM);
    }

    public ProjectManager(float exp){
        this.pmExp = exp;
    }

    // Getter and Setter of the variables
    public void setPmExp(float exp){
        pmExp = exp;
    }

    public float getPmExp(){
        return pmExp;
    }


    // Method to check EXP
    public void setExperienceInYearsAsPM(final int experienceInYearsAsPM) {
        if (experienceInYearsAsPM > super.getWorkExp()) {
            throw new IllegalArgumentException(
                    "experienceInYearsAsPM (" + this.pmExp + ") is bigger than the overall experienceInYears (" + super.getWorkExp() + ")");
        }
        this.pmExp = experienceInYearsAsPM;
    }


   /* public boolean checkExp(){
       return this.getPmExp()<=super.getWorkExp();
    }*/
}
