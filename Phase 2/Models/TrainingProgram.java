package ch.unil.doplab.gadswebsite.models;

import java.util.ArrayList;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author EMERY Guillaume, HORNUNG David, KERN Sophie, MUINO Adrian
 */
public class TrainingProgram {

    private ArrayList<PhysicalActivity> physicalActivities;

    public TrainingProgram() {
        this.physicalActivities = new ArrayList<>();
    }
    
    public ArrayList getPhysicalActivities() {
        return this.physicalActivities;
    }
}
