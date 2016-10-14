package de.fh_kiel.Person;

/**
 * Created by amit on 07.10.16.
 */
public class ProjectManager extends Developer {

    public float pmExp;

    /*ProjectManager(float exp){
        pmExp = exp;
    }*/

    // Getter and Setter of the variables
    public void setPmExp(float exp){
        pmExp = exp;
    }

    public float getPmExp(){
        return pmExp;
    }

    // Method to check EXP
    public boolean checkExp(){
       return this.getPmExp()<=super.getWorkExp();
    }
}
