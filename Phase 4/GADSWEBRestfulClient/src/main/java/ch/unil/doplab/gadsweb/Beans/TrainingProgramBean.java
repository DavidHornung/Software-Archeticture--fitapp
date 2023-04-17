/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unil.doplab.gadsweb.Beans;


import ch.unil.doplab.gadsweb.Client.PersistenceClient;
import ch.unil.doplab.gadswebsite.exceptions.DoesNotExistException;
import ch.unil.doplab.gadswebsite.models.Trainingprogram;
import ch.unil.doplab.gadswebsite.models.User;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;


//*
// * Software Architectures | DOPLab | UniL
// *
// * @author EMERY Guillaume, HORNUNG David, KERN Sophie, MUINO Adrian
// */
@Named(value = "trainingProgramBean")
@SessionScoped
public class TrainingProgramBean implements Serializable {


private String legs;
private String arms;
private String abs;
private String cardio;
private String goal;



    public String getLegs() {
        return legs;
    }

    public String getArms() {
        return arms;
    }

    public String getAbs() {
        return abs;
    }

    public String getCardio() {
        return cardio;
    }

    public String getGoal() {
        User user = LoginBean.getUserLoggedIn();
        return user.getGoal();
    }
    

    public void setGoal() {
        User user = LoginBean.getUserLoggedIn();
        this.goal = user.getGoal();
    }

    public void setLegs(String legs) {
        this.legs = legs;
    }

    public void setArms(String arms) {
        this.arms = arms;
    }

    public void setAbs(String abs) {
        this.abs = abs;
    }

    public void setCardio(String cardio) {
        this.cardio = cardio;
    }
    
    public List<Trainingprogram> getTrainingProgramUser() {
        User user = LoginBean.getUserLoggedIn();
        return PersistenceClient.getInstance().getAllTrainingprogram(user.getIdUser());
    }
    
    public void generateTrainingProgram() throws DoesNotExistException {
        if(this.legs==null || this.arms==null || this.abs==null || this.cardio==null){
        ;
        }else{
            managementLegs();
            managementAbs();
            managementArms();
            managementCardio();
            
        // empty values
        this.legs = "";
        this.abs="";
        this.arms="";
        this.cardio="";
    }
    }
    
    public void managementLegs() throws DoesNotExistException{
        User user = LoginBean.getUserLoggedIn();
    if(legs.equals("No")){
    List<Trainingprogram>  exercicelist1 = PersistenceClient.getInstance().getAllTrainingprogram(user.getIdUser());
         for (Trainingprogram exercices : exercicelist1) {
         if (exercices.getIdTrainingProgram().equals(1)||exercices.getIdTrainingProgram().equals(5)) {
                PersistenceClient.getInstance().removeFromTrainingprogram(user.getIdUser(), exercices.getIdTrainingProgram());
                getTrainingProgramUser();
         }
                }
    }else{
    Trainingprogram exercice1 = PersistenceClient.getInstance().getTrainingprogramByLegs(legs,getGoal());
         PersistenceClient.getInstance().addToTrainingprogram(user.getIdUser(), exercice1.getIdTrainingProgram());
         getTrainingProgramUser();
    }
    }
    
    public void managementAbs() throws DoesNotExistException{
        User user = LoginBean.getUserLoggedIn();
    if(abs.equals("No")){
    List<Trainingprogram>  exercicelist2 = PersistenceClient.getInstance().getAllTrainingprogram(user.getIdUser());
     for (Trainingprogram exercices : exercicelist2) {
         if (exercices.getIdTrainingProgram().equals(4)||exercices.getIdTrainingProgram().equals(8)) {
                PersistenceClient.getInstance().removeFromTrainingprogram(user.getIdUser(), exercices.getIdTrainingProgram());
                getTrainingProgramUser();
         }
                }
    }else{
    Trainingprogram exercice3 = PersistenceClient.getInstance().getTrainingprogramByAbs(abs,getGoal());
         PersistenceClient.getInstance().addToTrainingprogram(user.getIdUser(), exercice3.getIdTrainingProgram());
         getTrainingProgramUser();
    }
    }
    
    public void managementArms() throws DoesNotExistException{
        User user = LoginBean.getUserLoggedIn();
    if(arms.equals("No")){
    List<Trainingprogram>  exercicelist3 = PersistenceClient.getInstance().getAllTrainingprogram(user.getIdUser());
         for (Trainingprogram exercices : exercicelist3) {
         if (exercices.getIdTrainingProgram().equals(2)||exercices.getIdTrainingProgram().equals(6)) {
                PersistenceClient.getInstance().removeFromTrainingprogram(user.getIdUser(), exercices.getIdTrainingProgram());
                getTrainingProgramUser();
         }
                }
    }else{
    Trainingprogram exercice2 = PersistenceClient.getInstance().getTrainingprogramByArms(arms,getGoal());
         PersistenceClient.getInstance().addToTrainingprogram(user.getIdUser(), exercice2.getIdTrainingProgram());
         getTrainingProgramUser();
    }
    }
    
    public void managementCardio() throws DoesNotExistException{
    User user = LoginBean.getUserLoggedIn();
    if(cardio.equals("No")){
    List<Trainingprogram>  exercicelist4 = PersistenceClient.getInstance().getAllTrainingprogram(user.getIdUser());
    for (Trainingprogram exercices : exercicelist4) {
         if (exercices.getIdTrainingProgram().equals(3)||exercices.getIdTrainingProgram().equals(7)) {
                PersistenceClient.getInstance().removeFromTrainingprogram(user.getIdUser(), exercices.getIdTrainingProgram());
                getTrainingProgramUser();
         }
                }
    }else{
        Trainingprogram exercice4 = PersistenceClient.getInstance().getTrainingprogramByCardio(cardio,getGoal());
         PersistenceClient.getInstance().addToTrainingprogram(user.getIdUser(), exercice4.getIdTrainingProgram());
         getTrainingProgramUser();
    }
    }
    
    
    
}