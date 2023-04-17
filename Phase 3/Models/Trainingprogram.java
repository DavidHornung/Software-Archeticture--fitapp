/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unil.doplab.gadswebsite.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author EMERY Guillaume, HORNUNG David, KERN Sophie, MUINO Adrian
 */
@Entity
@Table(name = "TRAININGPROGRAM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trainingprogram.findAll", query = "SELECT t FROM Trainingprogram t"),
    @NamedQuery(name = "Trainingprogram.findByIdTrainingProgram", query = "SELECT t FROM Trainingprogram t WHERE t.idTrainingProgram = :idTrainingProgram"),
    @NamedQuery(name = "Trainingprogram.findByGoal", query = "SELECT t FROM Trainingprogram t WHERE t.goal = :goal"),
    @NamedQuery(name = "Trainingprogram.findByCardio", query = "SELECT t FROM Trainingprogram t WHERE t.cardio = :cardio AND t.goal = :goal"),
    @NamedQuery(name = "Trainingprogram.findByLegs", query = "SELECT t FROM Trainingprogram t WHERE t.legs = :legs AND t.goal = :goal"),
    @NamedQuery(name = "Trainingprogram.findByArms", query = "SELECT t FROM Trainingprogram t WHERE t.arms = :arms AND t.goal = :goal"),
    @NamedQuery(name = "Trainingprogram.findByAbs", query = "SELECT t FROM Trainingprogram t WHERE t.abs = :abs AND t.goal = :goal")})
public class Trainingprogram implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDTRAININGPROGRAM")
    private Integer idTrainingProgram;
    @Size(max = 45)
    @Column(name = "GOAL")
    private String goal;
    @Column(name = "CARDIO")
    private String cardio;
    @Column(name = "LEGS")
    private String legs;
    @Column(name = "ARMS")
     private String arms;
    @Column(name = "ABS")
    private String abs;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "TRAININGPROGRAMTITEL")
    private String trainingProgramTitel;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "TRAININGPROGRAMGOAL")
    private String trainingProgramGoal;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "TRAININGPROGRAMEXERCICESIMAGE")
    private String trainingProgramExercicesImage;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "TRAININGPROGRAMGIF1")
    private String trainingProgramGIF1;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "TRAININGPROGRAMGIF2")
    private String trainingProgramGIF2;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "TRAININGPROGRAMGIF3")
    private String trainingProgramGIF3;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "TRAININGPROGRAMGIF4")
    private String trainingProgramGIF4;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "TRAININGPROGRAMGIF5")
    private String trainingProgramGIF5;
    @ManyToMany(mappedBy = "trainingList")
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
    @XmlTransient
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTrainingProgram != null ? idTrainingProgram.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trainingprogram)) {
            return false;
        }
        Trainingprogram other = (Trainingprogram) object;
        if ((this.idTrainingProgram == null && other.idTrainingProgram != null) || (this.idTrainingProgram != null && !this.idTrainingProgram.equals(other.idTrainingProgram))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TrainingProgram{"
                + "\nName=" + trainingProgramTitel
                + "\nPrice=" + trainingProgramGoal
                + "\nIngredients=" + trainingProgramGIF1;
    }
    
}
