package ch.unil.doplab.gadswebsite.v1.controllers;

import ch.unil.doplab.gadswebsite.v1.database.MockDatabase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Software Architectures | DOPLab | UniL
 *
 * @author EMERY Guillaume, HORNUNG David, KERN Sophie, MUINO Adrian
 */
public class TrainingProgramController {
    
    
    public static List generateTrainingProgram(String goal, int hours, int cardio,int legsTraining,int absTraining, int armsTraining ) {
     List a=MockDatabase.getInstance().getPhysicalActivities();
     List b= new ArrayList<String>();
     List p= new ArrayList<String>();
     String c= "";
     List e= new ArrayList<String>();
     List newTrainingProgram = new ArrayList<String>();
     // Enlever les return des Ifs et rajouter des add a une liste
     if (legsTraining==1 && "Gain weight".equals(goal)){
                b= a.subList(0,1);
                c= b.toString();
                
                String[] d = c.split(",");
                for (String string : d) {
        }
//                String f = String.join(":", d);
//                String t= f.substring(116,354);
//                String[] z = t.split(",");
 
         List y= new ArrayList<String>(Arrays.asList(d));
                newTrainingProgram.add(y);
    }
      if(legsTraining==1 && "Lose weight".equals(goal)){
                b= a.subList(0,1);
                c= b.toString();
                String[] d = c.split(",");
                String f = String.join(":", d);
                String t= f.substring(356,596);
                String[] z = t.split(",");
                List y= new ArrayList<String>(Arrays.asList(z));
                newTrainingProgram.add(y);
     }
                
     if(armsTraining==1 && "Gain weight".equals(goal)){
                b= a.subList(1,2);
                c= b.toString();
                String[] d = c.split(",");
                String f = String.join(":", d);
                String t= f.substring(116,354);
                String[] z = t.split(",");
                List y= new ArrayList<String>(Arrays.asList(z));
                newTrainingProgram.add(y);
         
                    }
     if(armsTraining==1 && "Lose weight".equals(goal)){
                b= a.subList(1,2);
                c= b.toString();
                String[] d = c.split(",");
                String f = String.join(":", d);
                String t= f.substring(356,596);
                String[] z = t.split(",");
               
         List y= new ArrayList<String>(Arrays.asList(z));
                newTrainingProgram.add(y);
     }
     if(absTraining==1 && "Gain weight".equals(goal)){
                b= a.subList(2,3);
                c= b.toString();
                String[] d = c.split(",");
                String f = String.join(":", d);
                String t= f.substring(115,348);
                String[] z = t.split(",");
               
         List y= new ArrayList<String>(Arrays.asList(z));
                newTrainingProgram.add(y);
                    }
     if(absTraining==1 && "Lose weight".equals(goal)){
                b= a.subList(2,3);
                c= b.toString();
                String[] d = c.split(",");
                String f = String.join(":", d);
                String t= f.substring(350,585);
                String[] z = t.split(",");
               
         List y= new ArrayList<String>(Arrays.asList(z));
                newTrainingProgram.add(y);
     }
     if(cardio==1 && "Gain weight".equals(goal)){
                b= a.subList(3,4);
                c= b.toString();
                String[] d = c.split(",");
                String f = String.join(":", d);
                String t= f.substring(109,357);
                String[] z = t.split(",");
               
         List y= new ArrayList<String>(Arrays.asList(z));
                newTrainingProgram.add(y);
                    }
     if(cardio==1 && "Lose weight".equals(goal)){
                b= a.subList(3,4);
                c= b.toString();
                String[] d = c.split(",");
                String f = String.join(":", d);
                String t= f.substring(359,609);
                String[] z = t.split(",");
               
         List y= new ArrayList<String>(Arrays.asList(z));
                newTrainingProgram.add(y);
     }
        return newTrainingProgram;
     
 }
    
}
