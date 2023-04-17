package ch.unil.doplab.gadswebsite.models;

import java.util.ArrayList;
import java.util.Arrays;
import ch.unil.doplab.gadswebsite.database.MockDatabase;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author EMERY Guillaume, HORNUNG David, KERN Sophie, MUINO Adrian
 */
public class PhysicalActivity {

    private String name;
    private String description;
    private ArrayList<String> exercises;

    public PhysicalActivity(ArrayList<String> exercisesList) {
        this.name = name;
        this.description = description;
        exercises = new ArrayList<>(); 
        exercises.addAll(exercisesList); 
    }

    //GETTERS Methods
    
    public ArrayList<String> getExercises() {
        return exercises;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public static ArrayList<PhysicalActivity> getPhysicalActivities() {
        return MockDatabase.getInstance().getPhysicalActivities();
    }
    
    //SETTERS Methods

    public void setName(String name) {
        this.name = name;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PhysicalActivity) {
            PhysicalActivity f = (PhysicalActivity) obj;
            return f.toString().equals(this.toString());
        }
        return false;
    }

    @Override
    public String toString() {
        return Arrays.toString(exercises.toArray());
    }
}
