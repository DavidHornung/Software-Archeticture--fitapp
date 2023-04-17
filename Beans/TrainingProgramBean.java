/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unil.doplab.gadsweb.Beans;


import ch.unil.doplab.gadswebsite.exceptions.DoesNotExistException;
import ch.unil.doplab.gadswebsite.models.Trainingprogram;
import ch.unil.doplab.gadswebsite.models.User;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

//*
// * Software Architectures | DOPLab | UniL
// *
// * @author EMERY Guillaume, HORNUNG David, KERN Sophie, MUINO Adrian
// */
@Named(value = "trainingProgramBean")
@SessionScoped
public class TrainingProgramBean implements Serializable {
@PersistenceContext(unitName = "gads_PU")
private EntityManager em;


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
    //Function to remove
    private Trainingprogram findExercicesbylegsinTrainingProgram(User user, String legs,String goal) throws DoesNotExistException {
        for (Trainingprogram ex : user.getTrainingList()) {
            if (ex.getLegs().equals(legs)&& ex.getGoal().equals(goal)) {
                return ex;
            }
        }
        throw new DoesNotExistException("Not working");
    }
    
    private Trainingprogram findExercicesbyabsinTrainingProgram(User user, String abs,String goal) throws DoesNotExistException {
        for (Trainingprogram ex : user.getTrainingList()) {
            if (ex.getAbs().equals(abs)&& ex.getGoal().equals(goal)) {
                return ex;
            }
        }
        throw new DoesNotExistException("Not working");
    }
    
    private Trainingprogram findExercicesbyarmsinTrainingProgram(User user, String arms,String goal) throws DoesNotExistException {
        for (Trainingprogram ex : user.getTrainingList()) {
            if (ex.getArms().equals(arms)&& ex.getGoal().equals(goal)) {
                return ex;
            }
        }
        throw new DoesNotExistException("Not working");
    }
    
    private Trainingprogram findExercicesbycardioinTrainingProgram(User user, String cardio,String goal) throws DoesNotExistException {
        for (Trainingprogram ex : user.getTrainingList()) {
            if (ex.getCardio().equals(cardio)&& ex.getGoal().equals(goal)) {
                return ex;
            }
        }
        throw new DoesNotExistException("Not working");
    }
    
    
    // Function to add
    @Transactional
    public Trainingprogram findExercicesbylegs(String legs, String goal) throws DoesNotExistException {
        Query query = em.createNamedQuery("Trainingprogram.findByLegs");
        List<Trainingprogram> exercice=query.setParameter("legs",legs).setParameter("goal",goal).getResultList();
        if (exercice.size() > 0) {
            return exercice.get(0);
        }
        throw new DoesNotExistException(""+query);
    }
    
    @Transactional
    public Trainingprogram findExercicesbyarms(String arms, String goal) throws DoesNotExistException {
        Query query = em.createNamedQuery("Trainingprogram.findByArms");
        List<Trainingprogram> exercice = query.setParameter("arms",arms).setParameter("goal",goal).getResultList();
        if (exercice.size() > 0) {
            return exercice.get(0);
        }
        throw new DoesNotExistException(""+query);
    }    
    @Transactional
    public Trainingprogram findExercicesbycardio(String cardio, String goal) throws DoesNotExistException {
        Query query = em.createNamedQuery("Trainingprogram.findByCardio");
        List<Trainingprogram> exercice = query.setParameter("cardio",cardio).setParameter("goal",goal).getResultList();
        if (exercice.size() > 0) {
            return exercice.get(0);
        }
        throw new DoesNotExistException(""+query);
    }    
    @Transactional
    public Trainingprogram findExercicesbyabs(String abs, String goal) throws DoesNotExistException {
        Query query = em.createNamedQuery("Trainingprogram.findByAbs");
        List<Trainingprogram> exercice = query.setParameter("abs",abs).setParameter("goal",goal).getResultList();
        if (exercice.size() > 0) {
            return exercice.get(0);
        }
        throw new DoesNotExistException(""+query);
    }    
    
        @Transactional
    public void generateTrainingProgram() throws DoesNotExistException {
        User user = LoginBean.getUserLoggedIn();
        try { 
            //Legs
            if(doesExerciceslegsExistInTraingProgram(user, legs,"Gain weight")) {
                Trainingprogram ex = findExercicesbylegsinTrainingProgram(user, legs,"Gain weight");
                List uList = user.getTrainingList();
                uList.remove(ex);
                em.merge(user);
            }
            if(doesExerciceslegsExistInTraingProgram(user, legs,"Lose weight")) {
            Trainingprogram ex = findExercicesbylegsinTrainingProgram(user, legs,"Lose weight");
                List uList = user.getTrainingList();
                uList.remove(ex);
                em.merge(user);       
            }
            //Arms
            if(doesExercicesarmsExistInTraingProgram(user, arms,"Gain weight")) {
                Trainingprogram ex = findExercicesbyarmsinTrainingProgram(user, arms,"Gain weight");
                List uList = user.getTrainingList();
                uList.remove(ex);
                em.merge(user);
            }
            if (doesExercicesarmsExistInTraingProgram(user, arms,"Lose weight")) {
                Trainingprogram ex = findExercicesbyarmsinTrainingProgram(user, arms,"Lose weight");
                List uList = user.getTrainingList();
                uList.remove(ex);
                em.merge(user);
            }
            //Cardio
            if (doesExercicescardioExistInTraingProgram(user, cardio,"Gain weight")) {
                Trainingprogram ex = findExercicesbycardioinTrainingProgram(user, cardio,"Gain weight");
                List uList = user.getTrainingList();
                uList.remove(ex);
                em.merge(user);
            }
            if(doesExercicescardioExistInTraingProgram(user, cardio,"Lose weight")){
                Trainingprogram ex = findExercicesbycardioinTrainingProgram(user, cardio,"Lose weight");
                List uList = user.getTrainingList();
                uList.remove(ex);
                em.merge(user);
            }
            //ABS
            if(doesExercicesabsExistInTraingProgram(user, abs,"Gain weight")) {
                Trainingprogram ex = findExercicesbyabsinTrainingProgram(user, abs,"Gain weight");
                List uList = user.getTrainingList();
                uList.remove(ex);
                em.merge(user);
            } 
            if(doesExercicesabsExistInTraingProgram(user, abs,"Lose weight")) {
                Trainingprogram ex = findExercicesbyabsinTrainingProgram(user, abs,"Lose weight");
                List uList = user.getTrainingList();
                uList.remove(ex);
                em.merge(user);
            }
        }
        catch (DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
        
        try { 
            if ("Yes".equals(legs)){
            Trainingprogram ex = findExercicesbylegs(legs,user.getGoal());
                List uList = user.getTrainingList();
                uList.add(ex);
            }
            if ("Yes".equals(arms)){
            Trainingprogram ex = findExercicesbyarms(arms,user.getGoal());
                List uList = user.getTrainingList();
                uList.add(ex);
                em.merge(user);
            }               
            if ("Yes".equals(cardio)){
            Trainingprogram ex = findExercicesbycardio(cardio,user.getGoal());
                List uList = user.getTrainingList();
                uList.add(ex);
                em.merge(user);
            }
            if ("Yes".equals(abs)){
            Trainingprogram ex = findExercicesbyabs(abs,user.getGoal());
                List uList = user.getTrainingList();
                uList.add(ex);
                em.merge(user);
            }
        }
        catch (DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
        
        // empty values
        this.legs = "";
        this.abs="";
        this.arms="";
        this.cardio="";
    }

        
 private boolean doesExerciceslegsExistInTraingProgram(User user, String legs,String goal) {
        try {
            return findExercicesbylegsinTrainingProgram(user, legs,goal) != null;
        } catch (DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
  private boolean doesExercicesabsExistInTraingProgram(User user, String abs,String goal) {
        try {
            return findExercicesbyabsinTrainingProgram(user, abs,goal) != null;
        } catch (DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
   private boolean doesExercicesarmsExistInTraingProgram(User user, String arms,String goal) {
        try {
            return findExercicesbyarmsinTrainingProgram(user, arms,goal) != null;
        } catch (DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    private boolean doesExercicescardioExistInTraingProgram(User user, String cardio,String goal) {
        try {
            return findExercicesbycardioinTrainingProgram(user, cardio,goal) != null;
        } catch (DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
}