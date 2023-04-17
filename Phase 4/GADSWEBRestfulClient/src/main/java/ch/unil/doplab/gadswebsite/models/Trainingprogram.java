/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unil.doplab.gadswebsite.models;


import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author EMERY Guillaume, HORNUNG David, KERN Sophie, MUINO Adrian
 */
@XmlRootElement
public class Trainingprogram {

    private Integer idTrainingProgram;
    private String goal;
    private String cardio;
    private String legs;
     private String arms;
    private String abs;
    private String trainingProgramTitel;
    private String trainingProgramGoal;
    private String trainingProgramExercicesImage;
    private String trainingProgramGIF1;
    private String trainingProgramGIF2;
    private String trainingProgramGIF3;
    private String trainingProgramGIF4;
    private String trainingProgramGIF5;
    private List<User> userList;

    public Trainingprogram() {
    }

    public Trainingprogram(Integer idTrainingProgram) {
        this.idTrainingProgram = idTrainingProgram;
    }

    public Integer getIdTrainingProgram() {
        return idTrainingProgram;
    }

    public void setIdTrainingProgram(Integer idTrainingProgram) {
        this.idTrainingProgram = idTrainingProgram;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getCardio() {
        return cardio;
    }

    public void setCardio(String cardio) {
        this.cardio = cardio;
    }

    public String getLegs() {
        return legs;
    }

    public void setLegs(String legs) {
        this.legs = legs;
    }

    public String getArms() {
        return arms;
    }

    public void setArms(String arms) {
        this.arms = arms;
    }

    public String getAbs() {
        return abs;
    }

    public void setAbs(String abs) {
        this.abs = abs;
    }

    public String getTrainingProgramTitel() {
        return trainingProgramTitel;
    }

    public void setTrainingProgramTitel(String trainingProgramTitel) {
        this.trainingProgramTitel = trainingProgramTitel;
    }

    public String getTrainingProgramGoal() {
        return trainingProgramGoal;
    }

    public void setTrainingProgramGoal(String trainingProgramGoal) {
        this.trainingProgramGoal = trainingProgramGoal;
    }

    public String getTrainingProgramExercicesImage() {
        return trainingProgramExercicesImage;
    }

    public void setTrainingProgramExercicesImage(String trainingProgramExercicesImage) {
        this.trainingProgramExercicesImage = trainingProgramExercicesImage;
    }

    public String getTrainingProgramGIF1() {
        return trainingProgramGIF1;
    }

    public void setTrainingProgramGIF1(String trainingProgramGIF1) {
        this.trainingProgramGIF1 = trainingProgramGIF1;
    }

    public String getTrainingProgramGIF2() {
        return trainingProgramGIF2;
    }

    public void setTrainingProgramGIF2(String trainingProgramGIF2) {
        this.trainingProgramGIF2 = trainingProgramGIF2;
    }

    public String getTrainingProgramGIF3() {
        return trainingProgramGIF3;
    }

    public void setTrainingProgramGIF3(String trainingProgramGIF3) {
        this.trainingProgramGIF3 = trainingProgramGIF3;
    }

    public String getTrainingProgramGIF4() {
        return trainingProgramGIF4;
    }

    public void setTrainingProgramGIF4(String trainingProgramGIF4) {
        this.trainingProgramGIF4 = trainingProgramGIF4;
    }

    public String getTrainingProgramGIF5() {
        return trainingProgramGIF5;
    }

    public void setTrainingProgramGIF5(String trainingProgramGIF5) {
        this.trainingProgramGIF5 = trainingProgramGIF5;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
    
}
