package ch.unil.doplab.gadswebsite.v1.controllers;


import ch.unil.doplab.gadswebsite.v1.models.PhysicalActivity;
import ch.unil.doplab.gadswebsite.v1.database.MockDatabase;

import java.util.ArrayList;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author EMERY Guillaume, HORNUNG David, KERN Sophie, MUINO Adrian
 */
 
public class PhysicalActivityController {
    private static String physicalActivityName = "";
    
    public static ArrayList<PhysicalActivity> getPhysicalActivities() {
        return MockDatabase.getInstance().getPhysicalActivities();
    }
}
