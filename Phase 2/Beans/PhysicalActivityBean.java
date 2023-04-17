/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unil.doplab.gadsweb.Beans;

import ch.unil.doplab.gadswebsite.database.MockDatabase;
import ch.unil.doplab.gadswebsite.models.PhysicalActivity;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author EMERY Guillaume, HORNUNG David, KERN Sophie, MUINO Adrian
 */
@Named(value = "physicalActivityBean")
@SessionScoped
public class PhysicalActivityBean implements Serializable {

    private static String physicalActivityName = "";
    
   public static ArrayList<PhysicalActivity> getPhysicalActivities() {
        return MockDatabase.getInstance().getPhysicalActivities();
    }
    
}
