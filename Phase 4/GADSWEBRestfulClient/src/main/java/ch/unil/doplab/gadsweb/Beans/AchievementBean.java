/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unil.doplab.gadsweb.Beans;

import ch.unil.doplab.gadsweb.Client.PersistenceClient;
import ch.unil.doplab.gadswebsite.exceptions.DoesNotExistException;
import ch.unil.doplab.gadswebsite.models.Achievement;
import ch.unil.doplab.gadswebsite.models.User;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import static java.lang.Math.abs;
import java.util.List;

/**
 *
 * @author EMERY Guillaume, HORNUNG David, KERN Sophie, MUINO Adrian
 */
@Named(value = "achievementBean")
@SessionScoped
public class AchievementBean implements Serializable {

private Double actualWeight = 0.0;// valeur input de user XHTML
private Integer ratioWeight = 0; // 
private Integer progressionTotal = 0; // goal début moins poids début
private Integer progressionActual = 0;// Elle évolue en kilogram
private Integer progressionRatio = 0;// clé pour pokemon


public Double getActualWeight() {
    return actualWeight;
    }

public void setActualWeight(Double actualWeight) {
    this.actualWeight = actualWeight;
    }

public Integer getProgressionTotal() {
    return progressionTotal;
    }

    public void setProgressionTotal(Integer progressionTotal) {
        this.progressionTotal = progressionTotal;
    }

public Integer getProgressionActual() {
    return progressionActual;
    }

    public void setProgressionActual(Integer progressionActual) {
        this.progressionActual = progressionActual;
    }
    
public Integer getProgressionRatio() {
    return progressionRatio;
    }

    public void setProgressionRatio(Integer progressionRatio) {
        this.progressionRatio = progressionRatio;
    }

public int getRatioWeight() {
    return ratioWeight;
    }

    public void setRatioWeight(Integer ratioWeight) {
        this.ratioWeight = ratioWeight;
    }
    
    public List<Achievement> getAchievementUser() {
        User user = LoginBean.getUserLoggedIn();
        return PersistenceClient.getInstance().getAllAchievement(user.getIdUser());
    }


//FUNCTION
public void generateAchievement() throws DoesNotExistException {//Fonction appeler depuis XHTML
    if(progressionActual==0){
    calculRatio();
    }else{
    User user = LoginBean.getUserLoggedIn();
         List<Achievement>  pokemonlist = PersistenceClient.getInstance().getAllAchievement(user.getIdUser());
         for (Achievement pokemon : pokemonlist ) {
         if (pokemon.getIdachievement().equals(progressionActual)) {
                PersistenceClient.getInstance().removeFromAchievement(user.getIdUser(), pokemon.getIdachievement());
         }
                }
         
         Achievement Digimon = PersistenceClient.getInstance().getAchievementById(progressionActual);
         PersistenceClient.getInstance().addToAchievement(user.getIdUser(), Digimon.getIdachievement());
         getAchievementUser();
    // empty values
    this.actualWeight = 0.0;
    }
}

    
    public double calculRatio(){
        
    User user = LoginBean.getUserLoggedIn();
    int TotalPro=0;
    int ActualPro=0;
    Integer RatioPro=0;
    int PremiumPro=0;
    TotalPro=(int) abs(user.getWeight()-user.getTargetweight());
    ActualPro=(int)abs(actualWeight-user.getTargetweight());
    PremiumPro=(int)abs(ActualPro-TotalPro);
    RatioPro= (PremiumPro*100)/TotalPro;
    user.setAge(RatioPro);
    return this.progressionActual= RatioPro;
    }

}

