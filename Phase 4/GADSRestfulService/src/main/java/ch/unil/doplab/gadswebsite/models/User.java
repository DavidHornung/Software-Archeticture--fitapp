/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unil.doplab.gadswebsite.models;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "USER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByIdUser", query = "SELECT u FROM User u WHERE u.idUser = :idUser"),
    @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
    @NamedQuery(name = "User.findByFirstname", query = "SELECT u FROM User u WHERE u.firstname = :firstname"),
    @NamedQuery(name = "User.findByLastName", query = "SELECT u FROM User u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findByAge", query = "SELECT u FROM User u WHERE u.age = :age"),
    @NamedQuery(name = "User.findByGender", query = "SELECT u FROM User u WHERE u.gender = :gender"),
    @NamedQuery(name = "User.findByHeight", query = "SELECT u FROM User u WHERE u.height = :height"),
    @NamedQuery(name = "User.findByWeight", query = "SELECT u FROM User u WHERE u.weight = :weight"),
    @NamedQuery(name = "User.findByGoal", query = "SELECT u FROM User u WHERE u.goal = :goal"),
    @NamedQuery(name = "User.findByTargetweight", query = "SELECT u FROM User u WHERE u.targetweight = :targetweight"),
    @NamedQuery(name = "User.findByBmi", query = "SELECT u FROM User u WHERE u.bmi = :bmi"),
    @NamedQuery(name = "User.findByStrDate", query = "SELECT u FROM User u WHERE u.strDate = :strDate"),
    @NamedQuery(name = "User.findByInputcardio", query = "SELECT u FROM User u WHERE u.inputcardio = :inputcardio"),
    @NamedQuery(name = "User.findByInputarms", query = "SELECT u FROM User u WHERE u.inputarms = :inputarms"),
    @NamedQuery(name = "User.findByInputabs", query = "SELECT u FROM User u WHERE u.inputabs = :inputabs"),
    @NamedQuery(name = "User.findByInputlegs", query = "SELECT u FROM User u WHERE u.inputlegs = :inputlegs")})

public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDUSER")
    private Integer idUser;
    @Size(min = 1, max = 45)
    @Column(name = "USERNAME")
    private String username;
    @Size(min = 1, max = 45)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Size(min = 1, max = 45)
    @Column(name = "LASTNAME")
    private String lastName;
    @Size(min = 1, max = 45)
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PASSWORD")
    private Integer password;
    @Column(name = "AGE")
    private int age;
    @Size(min = 1, max = 45)
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "HEIGHT")
    private double height;
    @Column(name = "WEIGHT")
    private double weight;
    @Size(max = 20)
    @Column(name = "GOAL")
    private String goal;
    @Column(name = "TARGETWEIGHT")
    private Double targetweight;
    @Column(name = "BMI")
    private Double bmi;
    @Size(max = 45)
    @Column(name = "STRDATE")
    private String strDate;
    @Size(max = 3)
    @Column(name = "INPUTCARDIO")
    private String inputcardio;
    @Size(max = 3)
    @Column(name = "INPUTARMS")
    private String inputarms;
    @Size(max = 3)
    @Column(name = "INPUTABS")
    private String inputabs;
    @Size(max = 3)
    @Column(name = "INPUTLEGS")
    private String inputlegs;
    @Size(max = 45)
    @JoinTable(name = "USERHASTRAINING", joinColumns = {
        @JoinColumn(name = "IDUSER", referencedColumnName = "IDUSER")}, inverseJoinColumns = {
        @JoinColumn(name = "IDTRAININGPROGRAM", referencedColumnName = "IDTRAININGPROGRAM")})
    @ManyToMany
    private List<Trainingprogram> trainingList;
    @JoinTable(name = "USERHASRECIPE", joinColumns = {
        @JoinColumn(name = "IDUSER", referencedColumnName = "IDUSER")}, inverseJoinColumns = {
        @JoinColumn(name = "IDRECIPE", referencedColumnName = "IDRECIPE")})
    @ManyToMany
    private List<Recipe> RecipeList;
    @JoinTable(name = "USERHASACHIEVEMENT", joinColumns = {
        @JoinColumn(name = "IDUSER", referencedColumnName = "IDUSER")}, inverseJoinColumns = {
        @JoinColumn(name = "IDACHIEVEMENT", referencedColumnName = "IDACHIEVEMENT")})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Achievement> achievementList;
    
    
    public User() {
    }

    public User(Integer idUser) {
        this.idUser = idUser;
    }
    
    public boolean isPasswordCorrect(String password) {
        return password.hashCode() == this.password;
    }
    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public Double getTargetweight() {
        return targetweight;
    }

    public void setTargetweight(Double targetweight) {
        this.targetweight = targetweight;
    }

    public Double getBmi() {
        return bmi;
    }

   public void setBmi() {
        this.bmi = calculBmi(weight, height);
    }

    public String getStrDate() {
        return strDate;
    }

    public void setStrDate(String strDate) {
        this.strDate = strDate;
    }

    public String getInputcardio() {
        return inputcardio;
    }

    public void setInputcardio(String inputcardio) {
        this.inputcardio = inputcardio;
    }

    public String getInputarms() {
        return inputarms;
    }

    public void setInputarms(String inputarms) {
        this.inputarms = inputarms;
    }

    public String getInputabs() {
        return inputabs;
    }

    public void setInputabs(String inputabs) {
        this.inputabs = inputabs;
    }

    public String getInputlegs() {
        return inputlegs;
    }

    public void setInputlegs(String inputlegs) {
        this.inputlegs = inputlegs;
    }
    
    
    //Function
     public double calculBmi(double lweight,double lheight){
        return this.bmi= lweight/Math.pow(lheight,2.0);
    }
    public String dictionnaryDate(Date gdate){
        DateFormat dateFormat = new SimpleDateFormat("dd hh:mm:ss");  
        return this.strDate=dateFormat.format(gdate);
    }
    
    
    
    
    
    @XmlTransient
    public List<Trainingprogram> getTrainingList() {
        return trainingList;
    }

    public void setTrainingList(List<Trainingprogram> trainingList) {
        this.trainingList = trainingList;
    }
    
    @XmlTransient
    public List<Recipe> getRecipeList() {
        return RecipeList;
    }

    public void setRecipeList(List<Recipe> RecipeList) {
        this.RecipeList = RecipeList;
    }
    
    @XmlTransient
    public List<Achievement> getAchievementLists() {
        return achievementList;
    }

    public void setAchievementList(List<Achievement> achievementList) {
        this.achievementList = achievementList;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String s = "Username: " + this.username
                + "\nFirst name: " + this.firstname
                + "\nLast name: " + this.lastName
                + "\nEmail: " + this.email
                + "\n";
        for (Trainingprogram exercices : trainingList) {
            s += exercices.toString() + "\n";
        }
        for (Achievement pokemon : achievementList) {
            s += pokemon.toString() + "\n";
        }
        for (Recipe dish : RecipeList) {
            s += dish.toString() + "\n";
        }
        return s;
    }

    
}
