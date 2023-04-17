/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unil.doplab.gadswebsite.models;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author EMERY Guillaume, HORNUNG David, KERN Sophie, MUINO Adrian
 */

@XmlRootElement
public class User {

    
    private Integer idUser;
    private String username;
    private String firstname;
    private String lastName;
    private String email;
    private Integer password;
    private int age;
    private String gender;
    private double height;
    private double weight;
    private String goal;
    private Double targetweight;
    private Double bmi;
    private String strDate;
    private String inputcardio;
    private String inputarms;
    private String inputabs;
    private String inputlegs;
    private List<Trainingprogram> trainingList;
    private List<Recipe> RecipeList;
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

    public void setBmi(Double bmi) {
        this.bmi = bmi;
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

    public List<Achievement> getAchievementList() {
        return achievementList;
    }

    public void setAchievementList(List<Achievement> achievementList) {
        this.achievementList = achievementList;
    }

    public List<Recipe> getRecipeList() {
        return RecipeList;
    }

    public void setRecipeList(List<Recipe> RecipeList) {
        this.RecipeList = RecipeList;
    }

    public List<Trainingprogram> getTrainingList() {
        return trainingList;
    }

    public void setTrainingList(List<Trainingprogram> trainingList) {
        this.trainingList = trainingList;
    }
    
     //Function
     
    public String dictionnaryDate(Date gdate){
        DateFormat dateFormat = new SimpleDateFormat("dd hh:mm:ss");  
        return this.strDate=dateFormat.format(gdate);
    }
    
    
}
