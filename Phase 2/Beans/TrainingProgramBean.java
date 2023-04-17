/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unil.doplab.gadsweb.Beans;

import static ch.unil.doplab.gadsweb.Beans.FoodBean.generateBetween;
import ch.unil.doplab.gadswebsite.database.MockDatabase;
import ch.unil.doplab.gadswebsite.models.User;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//*
// * Software Architectures | DOPLab | UniL
// *
// * @author EMERY Guillaume, HORNUNG David, KERN Sophie, MUINO Adrian
// */
@Named(value = "trainingProgramBean")
@SessionScoped
public class TrainingProgramBean implements Serializable {
private String imagedescription_1;
private String imagedescription_2;
private String imagedescription_3;
private String imagedescription_4;
private String imagedescription_5;
private String imagedescription_6;
private String imagedescription_7;
private String imagedescription_8;
private String imagedescription_9;
private String imagedescription_10;
private String imagedescription_11;
private String imagedescription_12;
private String imagedescription_13;
private String imagedescription_14;
private String imagedescription_15;
private String imagedescription_16;
private String imagedescription_17;
private String imagedescription_18;
private String imagedescription_19;
private String imagedescription_20;
private int  test;
private ArrayList<String> testtext;
private String exercices_1;
private String exercices_2;
private String exercices_3;
private String exercices_4;
private String goal_1;
private String goal_2;
private String goal_3;
private String goal_4;
private String titre_1;
private String titre_2;
private String titre_3;
private String titre_4;
private ArrayList<String> Listofexercices;

    public String getImagedescription_1() {
        return imagedescription_1;
    }

    public String getImagedescription_2() {
        return imagedescription_2;
    }

    public String getImagedescription_3() {
        return imagedescription_3;
    }

    public String getImagedescription_4() {
        return imagedescription_4;
    }

    public String getImagedescription_5() {
        return imagedescription_5;
    }

    public String getImagedescription_6() {
        return imagedescription_6;
    }

    public String getImagedescription_7() {
        return imagedescription_7;
    }

    public String getImagedescription_8() {
        return imagedescription_8;
    }
    

    public String getImagedescription_9() {
        return imagedescription_9;
    }

    public String getImagedescription_10() {
        return imagedescription_10;
    }

    public String getImagedescription_11() {
        return imagedescription_11;
    }

    public String getImagedescription_12() {
        return imagedescription_12;
    }

    public String getImagedescription_13() {
        return imagedescription_13;
    }

    public String getImagedescription_14() {
        return imagedescription_14;
    }

    public String getImagedescription_15() {
        return imagedescription_15;
    }

    public String getImagedescription_16() {
        return imagedescription_16;
    }

    public String getImagedescription_17() {
        return imagedescription_17;
    }

    public String getImagedescription_18() {
        return imagedescription_18;
    }

    public String getImagedescription_19() {
        return imagedescription_19;
    }

    public String getImagedescription_20() {
        return imagedescription_20;
    }
    
    
   
    public String getExercices_1() {
        return exercices_1;
    }

    public String getExercices_2() {
        return exercices_2;
    }

    public String getExercices_3() {
        return exercices_3;
    }

    public String getExercices_4() {
        return exercices_4;
    }
    

    public String getGoal_1() {
        return goal_1;
    }

    public String getGoal_2() {
        return goal_2;
    }

    public String getGoal_3() {
        return goal_3;
    }

    public String getGoal_4() {
        return goal_4;
    }
    

    public String getTitre_1() {
        return titre_1;
    }

    public String getTitre_2() {
        return titre_2;
    }

    public String getTitre_3() {
        return titre_3;
    }

    public String getTitre_4() {
        return titre_4;
    }
    

    public ArrayList<String> getListofexercices() {
        return Listofexercices;
    }

    public int  getTest() {
        return test;
    }

    public ArrayList<String> getTesttext() {
        return testtext;
    }
    
    
    
    public void setExercices_1(String exercices_1) {
        this.exercices_1 = exercices_1;
    }

    public void setExercices_2(String exercices_2) {
        this.exercices_2 = exercices_2;
    }

    public void setExercices_3(String exercices_3) {
        this.exercices_3 = exercices_3;
    }

    public void setExercices_4(String exercices_4) {
        this.exercices_4 = exercices_4;
    }
    

    public void setGoal_1(String goal_1) {
        this.goal_1 = goal_1;
    }

    public void setGoal_2(String goal_2) {
        this.goal_2 = goal_2;
    }

    public void setGoal_3(String goal_3) {
        this.goal_3 = goal_3;
    }

    public void setGoal_4(String goal_4) {
        this.goal_4 = goal_4;
    }
    

    public void setImagedescription_1(String imagedescription_1) {
        this.imagedescription_1 = imagedescription_1;
    }

    public void setTitre_1(String titre_1) {
        this.titre_1 = titre_1;
    }

    public void setTitre_2(String titre_2) {
        this.titre_2 = titre_2;
    }

    public void setTitre_3(String titre_3) {
        this.titre_3 = titre_3;
    }

    public void setTitre_4(String titre_4) {
        this.titre_4 = titre_4;
    }

    public void setListofexercices(ArrayList<String> Listofexercices) {
        this.Listofexercices = Listofexercices;
    }

    public void setTest(int test) {
        this.test = test;
    }

    public void setTesttext(ArrayList<String> testtext) {
        this.testtext = testtext;
    }

    public void setImagedescription_2(String imagedescription_2) {
        this.imagedescription_2 = imagedescription_2;
    }

    public void setImagedescription_3(String imagedescription_3) {
        this.imagedescription_3 = imagedescription_3;
    }

    public void setImagedescription_4(String imagedescription_4) {
        this.imagedescription_4 = imagedescription_4;
    }

    public void setImagedescription_5(String imagedescription_5) {
        this.imagedescription_5 = imagedescription_5;
    }

    public void setImagedescription_6(String imagedescription_6) {
        this.imagedescription_6 = imagedescription_6;
    }

    public void setImagedescription_7(String imagedescription_7) {
        this.imagedescription_7 = imagedescription_7;
    }

    public void setImagedescription_8(String imagedescription_8) {
        this.imagedescription_8 = imagedescription_8;
    }

    public void setImagedescription_9(String imagedescription_9) {
        this.imagedescription_9 = imagedescription_9;
    }

    public void setImagedescription_10(String imagedescription_10) {
        this.imagedescription_10 = imagedescription_10;
    }

    public void setImagedescription_11(String imagedescription_11) {
        this.imagedescription_11 = imagedescription_11;
    }

    public void setImagedescription_12(String imagedescription_12) {
        this.imagedescription_12 = imagedescription_12;
    }

    public void setImagedescription_13(String imagedescription_13) {
        this.imagedescription_13 = imagedescription_13;
    }

    public void setImagedescription_14(String imagedescription_14) {
        this.imagedescription_14 = imagedescription_14;
    }

    public void setImagedescription_15(String imagedescription_15) {
        this.imagedescription_15 = imagedescription_15;
    }

    public void setImagedescription_16(String imagedescription_16) {
        this.imagedescription_16 = imagedescription_16;
    }

    public void setImagedescription_17(String imagedescription_17) {
        this.imagedescription_17 = imagedescription_17;
    }

    public void setImagedescription_18(String imagedescription_18) {
        this.imagedescription_18 = imagedescription_18;
    }

    public void setImagedescription_19(String imagedescription_19) {
        this.imagedescription_19 = imagedescription_19;
    }

    public void setImagedescription_20(String imagedescription_20) {
        this.imagedescription_20 = imagedescription_20;
    }
    
    
    public static List generateTrainingProgram(String goal, int hours, int cardio, int legsTraining, int absTraining, int armsTraining) {
        List a=MockDatabase.getInstance().getPhysicalActivities();
        List b= new ArrayList<String>();
        List p= new ArrayList<String>();
        String c= "";
        List e= new ArrayList<String>();
        List newTrainingProgram = new ArrayList<String>();
        if (legsTraining==1 && "Gain weight".equals(goal)){
            b= a.subList(0,1);
            c= b.toString();
            String[] d = c.split(",");
            List y =new ArrayList<String>();
            int i=-1;
            while ( i < 2) {
                i=i+1;
            y.add(d[i]);
        }
           
            newTrainingProgram.add(y);
        }
        if(legsTraining==1 && "Lose weight".equals(goal)){
            b= a.subList(0,1);
            c= b.toString();
            String[] d = c.split(",");
            List y =new ArrayList<String>();
            int i=2;
            while ( i < 5) {
                i=i+1;
            y.add(d[i]);
        }
           
            newTrainingProgram.add(y);
        }
        
        if(armsTraining==1 && "Gain weight".equals(goal)){
            b= a.subList(1,2);
            c= b.toString();
            String[] d = c.split(",");
            List y =new ArrayList<String>();
            int i=-1;
            while ( i < 2) {
                i=i+1;
            y.add(d[i]);
        }
           
            newTrainingProgram.add(y);
        }
        if(armsTraining==1 && "Lose weight".equals(goal)){
            b= a.subList(1,2);
            c= b.toString();
            String[] d = c.split(",");
            List y =new ArrayList<String>();
            int i=2;
            while ( i < 5) {
                i=i+1;
            y.add(d[i]);
        }
           
            newTrainingProgram.add(y);
        }
        if(absTraining==1 && "Gain weight".equals(goal)){
            b= a.subList(2,3);
            c= b.toString();
            String[] d = c.split(",");
            List y =new ArrayList<String>();
            int i=-1;
            while ( i < 2) {
                i=i+1;
            y.add(d[i]);
        }
           
            newTrainingProgram.add(y);
        }
        if(absTraining==1 && "Lose weight".equals(goal)){
            b= a.subList(2,3);
            c= b.toString();
            String[] d = c.split(",");
            List y =new ArrayList<String>();
            int i=2;
            while ( i < 5) {
                i=i+1;
            y.add(d[i]);
        }
           
            newTrainingProgram.add(y);
        }
        if(cardio==1 && "Gain weight".equals(goal)){
            b= a.subList(3,4);
            c= b.toString();
            String[] d = c.split(",");
            List y =new ArrayList<String>();
            int i=-1;
            while ( i < 2) {
                i=i+1;
            y.add(d[i]);
        }
           
            newTrainingProgram.add(y);
        }
        if(cardio==1 && "Lose weight".equals(goal)){
            b= a.subList(3,4);
            c= b.toString();
            String[] d = c.split(",");
            List y =new ArrayList<String>();
            int i=2;
            while ( i < 5) {
                i=i+1;
            y.add(d[i]);
        }
           
            newTrainingProgram.add(y);
        }
        return newTrainingProgram;
                
                
    
    }
    public void securesetGraphics() {
        User user = LoginBean.getUserLoggedIn();
    if (!user.getTrainingProgram().isEmpty()){ 
        setGraphics();
    }else{
    this.titre_1="";
      this.goal_1= "";
      this.exercices_1= "";
      this.imagedescription_1= "";
      this.imagedescription_2= "";
      this.imagedescription_3="";
      this.imagedescription_4="";
      this.imagedescription_5="";
      this.titre_2="";
      this.goal_2= "";
      this.exercices_2= "";
      this.imagedescription_6= "";
      this.imagedescription_7= "";
      this.imagedescription_8="";
      this.imagedescription_9="";
      this.imagedescription_10="";
      this.titre_3="";
      this.goal_3= "";
      this.exercices_3= "";
      this.imagedescription_11= "";
      this.imagedescription_12= "";
      this.imagedescription_13="";
      this.imagedescription_14="";
      this.imagedescription_15="";
      this.titre_4="";
      this.goal_4= "";
      this.exercices_4= "";
      this.imagedescription_16= "";
      this.imagedescription_17= "";
      this.imagedescription_18="";
      this.imagedescription_19="";
      this.imagedescription_20="";
      
    }
    }
    
    public void setGraphics() {   
      User user = LoginBean.getUserLoggedIn();        
      ArrayList<String> A= user.getTrainingProgram();
      String b= A.toString();
      String[] c = b.split(";");
      List y =new ArrayList<String>();
      int f=0;
            while ( f < 11) {
                f=f+1;
            y.add(c[f]);
        }
      int r = c.length; 
      this.test= r;
     
      this.titre_1=(String) y.get(0);
      this.goal_1= (String) y.get(2);
      this.exercices_1= (String) y.get(3);
      this.imagedescription_1= (String) y.get(4);
      this.imagedescription_2= (String) y.get(6);
      this.imagedescription_3=(String) y.get(7);
      this.imagedescription_4=(String) y.get(8);
      this.imagedescription_5=(String) y.get(9);
      this.titre_2="";
      this.goal_2= "";
      this.exercices_2= "";
      this.imagedescription_6= "";
      this.imagedescription_7= "";
      this.imagedescription_8="";
      this.imagedescription_9="";
      this.imagedescription_10="";
      this.titre_3="";
      this.goal_3= "";
      this.exercices_3= "";
      this.imagedescription_11= "";
      this.imagedescription_12= "";
      this.imagedescription_13="";
      this.imagedescription_14="";
      this.imagedescription_15="";
      this.titre_4="";
      this.goal_4= "";
      this.exercices_4= "";
      this.imagedescription_16= "";
      this.imagedescription_17= "";
      this.imagedescription_18="";
      this.imagedescription_19="";
      this.imagedescription_20="";
      
      
      if(r>20){
      int s=11;
       while ( s < 21) {
            s=s+1;
       y.add(c[s]);
       }
       
      this.titre_2=(String) y.get(11);
      this.goal_2= (String) y.get(2);
      this.exercices_2= (String) y.get(3);
      this.imagedescription_6= (String) y.get(15);
      this.imagedescription_7= (String) y.get(17);
      this.imagedescription_8=(String) y.get(18);
      this.imagedescription_9=(String) y.get(19);
      this.imagedescription_10=(String) y.get(20);
      this.titre_3="";
      this.goal_3= "";
      this.exercices_3= "";
      this.imagedescription_11= "";
      this.imagedescription_12= "";
      this.imagedescription_13="";
      this.imagedescription_14="";
      this.imagedescription_15="";
      this.titre_4="";
      this.goal_4= "";
      this.exercices_4= "";
      this.imagedescription_16= "";
      this.imagedescription_17= "";
      this.imagedescription_18="";
      this.imagedescription_19="";
      this.imagedescription_20="";

      }
      if(r>30){
      int e=20;
       while ( e < 33) {
            e=e+1;
       y.add(c[e]);
       }
       
      this.titre_3=(String) y.get(23);
      this.goal_3= (String) y.get(2);
      this.exercices_3= (String) y.get(3);
      this.imagedescription_11= (String) y.get(27);
      this.imagedescription_12= (String) y.get(29);
      this.imagedescription_13=(String) y.get(30);
      this.imagedescription_14=(String) y.get(31);
      this.imagedescription_15=(String) y.get(32);
      this.titre_4="";
      this.goal_4= "";
      this.exercices_4= "";
      this.imagedescription_16= "";
      this.imagedescription_17= "";
      this.imagedescription_18="";
      this.imagedescription_19="";
      this.imagedescription_20="";

      }
      if(r>40){
      int p=33;
       while ( p < 44) {
            p=p+1;
       y.add(c[p]);
       }
       
      this.titre_4=(String) y.get(34);
      this.goal_4= (String) y.get(2);
      this.exercices_4= (String) y.get(3);
      this.imagedescription_16= (String) y.get(38);
      this.imagedescription_17= (String) y.get(40);
      this.imagedescription_18=(String) y.get(41);
      this.imagedescription_19=(String) y.get(42);
      this.imagedescription_20=(String) y.get(43);
      this.testtext=(ArrayList<String>) y;

      }
      
     }

}

