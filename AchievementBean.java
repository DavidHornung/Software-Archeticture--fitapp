/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unil.doplab.gadsweb.Beans;

import ch.unil.doplab.gadswebsite.exceptions.DoesNotExistException;
import ch.unil.doplab.gadswebsite.models.Achievement;
import ch.unil.doplab.gadswebsite.models.User;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import static java.lang.Math.abs;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 *
 * @author guillaume.emery
 */
@Named(value = "achievementBean")
@SessionScoped
public class AchievementBean implements Serializable {
@PersistenceContext(unitName = "gads_PU")
private EntityManager em;

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

//FUNCTION

@Transactional
public void generateAchievement() throws DoesNotExistException {//Fonction appeler depuis XHTML
    if(progressionActual==0){
    calculRatio();
    }
    User user = LoginBean.getUserLoggedIn();
    if(doesAchievementExistInTheCloud(progressionActual)) {
           Achievement pokemon = findAchievementById(progressionActual);
           List uList = user.getAchievementList();
           uList.remove(pokemon);
           em.merge(user);
    }
    try {
        calculRatio();
        Achievement a = findAchievementById(progressionActual);
        user.getAchievementList().add(a);
        em.merge(user);
    } catch (DoesNotExistException ex) {
        System.out.println(ex.getMessage());
    }
    // empty values
    this.actualWeight = 0.0;
}


@Transactional
    public Achievement findAchievementById(Integer idachievement) throws DoesNotExistException {
        Query query = em.createNamedQuery("Achievement.findByIdachievement");
        List<Achievement> pokemon = query.setParameter("idachievement",idachievement).getResultList();
        if (pokemon.size() > 0) {
            return pokemon.get(0);
        }
        throw new DoesNotExistException(""+query);
    }
    
    private boolean doesAchievementExistInTheCloud(Integer number) {
        try {
            return findAchievementById(number) != null;
        } catch (DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public double calculRatio(){
        
    User user = LoginBean.getUserLoggedIn();
    int TotalPro=0;
    int ActualPro=0;
    int RatioPro=0;
    int PremiumPro=0;
    TotalPro=(int) abs(user.getWeight()-user.getTargetweight());
    ActualPro=(int)abs(actualWeight-user.getTargetweight());
    PremiumPro=(int)abs(ActualPro-TotalPro);
    RatioPro= (PremiumPro*100)/TotalPro;
    return this.progressionActual= RatioPro;
    }

}

