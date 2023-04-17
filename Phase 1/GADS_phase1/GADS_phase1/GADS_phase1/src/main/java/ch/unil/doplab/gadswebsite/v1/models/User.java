package ch.unil.doplab.gadswebsite.v1.models;

import java.util.*;
import java.text.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import ch.unil.doplab.gadswebsite.v1.controllers.TrainingProgramController;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author EMERY Guillaume, HORNUNG David, KERN Sophie, MUINO Adrian
 */

public class User {

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private int password;
    
    private TrainingProgram Trainingprogram;
    private int age;
    private String gender; 
    private double height;
    private double weight;
    private int nbHoursPerSession; 
    private String userPicture;
    private String goal;
    private double bmi ;
    private double targetWeight;
    public String strDate;
    private double foodWeight;
    
    private int legsTraining; 
    private int armsTraining; 
    private int absTraining; 
    private int cardio;

    private ArrayList<TrainingProgramController> trainingProgram;
    private ArrayList<Food> recipe;
    
    
    Dictionary<String,Double> bmiRecord= new Hashtable<String,Double>();
    Dictionary<String,Double> weightRecord= new Hashtable<String,Double>();
    Dictionary<String,String> achievements = new Hashtable<String,String>();
    Dictionary<String,Double> initialWeight= new Hashtable<String,Double>();

    public User(String username, String firstName, String lastName, String email, String password,
            int age, String gender, Double height, Double weight, int nbHoursPerSession,
            String userPicture, String goal,Double bmi,
            Double targetWeight, Double foodWeight, int legsTraining, int absTraining, int armsTraining, int cardio) {
      
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password.hashCode();
        
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.nbHoursPerSession = nbHoursPerSession;
        this.userPicture = userPicture;
        this.goal = goal;
        this.bmi=bmi;
        this.targetWeight= targetWeight; 
        this.foodWeight = foodWeight;
        this.recipe= new ArrayList();
        this.bmiRecord.put(dictionnaryDate(new Date()),calculBmi(weight,getHeight()));
        this.weightRecord.put(dictionnaryDate(new Date()),weight);
        this.achievements.put("you have achieved 25% of your goal","not obtained yet");
        this.achievements.put("you have achieved 50% of your goal","not obtained yet");
        this.achievements.put("you have achieved 75% of your goal","not obtained yet");
        this.achievements.put("congratulations!!! you have achieved your goal","not obtained yet");
        this.initialWeight.put("1", weight);
        this.legsTraining = legsTraining;
        this.armsTraining = armsTraining;
        this.absTraining = absTraining; 
        this.cardio = cardio;
        this.trainingProgram= new ArrayList();
    }

    //GETTERS methods
    
    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
    
    public int getAge() {
        return age;
    }   
    
    public String getGender() {
        return gender;
    }
    
    public Double getHeight() {
        return height;
    }

    public Double getWeight() {
        return weight;
    }
    
    public double getBmi(){
        return bmi;
    }

    public int getNbHoursPerSession() {
        return nbHoursPerSession;
    }

    public String getUserPicture() {    
        return userPicture;
    }

    public String getGoal() {
        return goal;
    }    
    
    public ArrayList<TrainingProgramController> getTrainingProgram() {
        return trainingProgram;
    }    
    
    public TrainingProgram getTrainingprogram(){
        return Trainingprogram;
    }
    
    public double getTargetWeight() {
        return targetWeight;
    }    
    
    public ArrayList<Food> getRecipe() {
        return recipe;
    }

    public double getFoodweight() {
        return foodWeight;
    }
    

    public Dictionary getAchievements() {
        return achievements;
    }  
    
    public int getLegsTraining() {
        return legsTraining;
    }  
    
    public int getArmsTraining() {
        return armsTraining;
    }  
    
    public int getAbsTraining() {
        return absTraining;
    }  
    public int getCardio() {
        return cardio;
    }  

 


//SETTERS methods
    
    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password.hashCode();
    }

    public boolean isPasswordCorrect(String password) {
        return password.hashCode() == this.password;
    }

    public void setAge(int age) {
        this.age = age;
    }    
    
    public void setHeight(Double height) {
        this.height = height;
    }    
    
    public void setWeight(Double weight) {
        this.weight = weight;
        
        this.bmiRecord.put(dictionnaryDate(new Date()),calculBmi(weight,getHeight()));
        this.weightRecord.put(dictionnaryDate(new Date()),weight);
        
        if ("Lose weight".equals(getGoal())){

            if ((weight-getTargetWeight())/(initialWeight.get("1")-getTargetWeight())<0.75) {
                this.achievements.remove("you have achieved 25% of your goal");
                this.achievements.put("you have achieved 25% of your goal","obtained");
            }
            if ((weight-getTargetWeight())/(initialWeight.get("1")-getTargetWeight())<0.50) {
                this.achievements.remove("you have achieved 50% of your goal");
                this.achievements.put("you have achieved 50% of your goal","obtained");
                this.achievements.remove("you have achieved 25% of your goal");
                this.achievements.put("you have achieved 25% of your goal","obtained");
            }    
            if ((weight-getTargetWeight())/(initialWeight.get("1")-getTargetWeight())<0.25) {
                this.achievements.remove("you have achieved 75% of your goal");
                this.achievements.put("you have achieved 75% of your goal","obtained");
                this.achievements.remove("you have achieved 50% of your goal");
                this.achievements.put("you have achieved 50% of your goal","obtained"); 
                this.achievements.remove("you have achieved 25% of your goal");
                this.achievements.put("you have achieved 25% of your goal","obtained"); 
            }

            if ((weight-getTargetWeight())/(initialWeight.get("1")-getTargetWeight())<=0) {
                this.achievements.remove("you have achieved 75% of your goal");
                this.achievements.put("you have achieved 75% of your goal","obtained");
                this.achievements.remove("you have achieved 50% of your goal");
                this.achievements.put("you have achieved 50% of your goal","obtained"); 
                this.achievements.remove("you have achieved 25% of your goal");
                this.achievements.put("you have achieved 25% of your goal","obtained"); 
                this.achievements.remove("congratulations!!! you have achieved your goal");
                this.achievements.put("congratulations!!! you have achieved your goal","obtained");
            }
            
        } 
        else if ("Gain weight".equals(getGoal())){
            if ((weight-initialWeight.get("1"))/(getTargetWeight()-initialWeight.get("1"))>=0.25
                    &&(weight-initialWeight.get("1"))/(getTargetWeight()-initialWeight.get("1"))<0.5) {
                this.achievements.remove("you have achieved 25% of your goal");
                this.achievements.put("you have achieved 25% of your goal","obtained");
            }
            if ((weight-initialWeight.get("1"))/(getTargetWeight()-initialWeight.get("1"))>=0.5
                    &&(weight-initialWeight.get("1"))/(getTargetWeight()-initialWeight.get("1"))<0.75) {
                this.achievements.remove("you have achieved 50% of your goal");
                this.achievements.put("you have achieved 50% of your goal","obtained");
                this.achievements.remove("you have achieved 25% of your goal");
                this.achievements.put("you have achieved 25% of your goal","obtained");
            }    
            if ((weight-initialWeight.get("1"))/(getTargetWeight()-initialWeight.get("1"))>=0.75
                    &&(weight-initialWeight.get("1"))/(getTargetWeight()-initialWeight.get("1"))<1){
                this.achievements.remove("you have achieved 75% of your goal");
                this.achievements.put("you have achieved 75% of your goal","obtained");
                this.achievements.remove("you have achieved 50% of your goal");
                this.achievements.put("you have achieved 50% of your goal","obtained"); 
                this.achievements.remove("you have achieved 25% of your goal");
                this.achievements.put("you have achieved 25% of your goal","obtained"); 
            }

            if ((weight-initialWeight.get("1"))/(getTargetWeight()-initialWeight.get("1"))>=1) {
                this.achievements.remove("you have achieved 75% of your goal");
                this.achievements.put("you have achieved 75% of your goal","obtained");
                this.achievements.remove("you have achieved 50% of your goal");
                this.achievements.put("you have achieved 50% of your goal","obtained"); 
                this.achievements.remove("you have achieved 25% of your goal");
                this.achievements.put("you have achieved 25% of your goal","obtained"); 
                this.achievements.remove("congratulations!!! you have achieved your goal");
                this.achievements.put("congratulations!!! you have achieved your goal","obtained"); 
            }
    
        }
    }
    
    public void setNbHoursPerSession(int nb_hours_per_session) {
        this.nbHoursPerSession = nb_hours_per_session;
    }
    
    public void setUserPicture(String user_picture) {
        this.userPicture = user_picture;
    }    

    public String setGoal(Double gweight,Double gtargetweight) {
        if (gweight < gtargetweight){
            return goal = "Gain weight";
        }else{
            return goal = "Lose weight";
                    }
    }

     
    public void setTargetWeight(Double targetWeight) {
        this.targetWeight = targetWeight;
    }
    
    public void setRecipe(ArrayList<Food> recipe) {
        this.recipe = recipe;
    }

    public void setFoodweight(double foodweight) {
        this.foodWeight = foodweight;
    }

 public int setAbsTraining(String absTraining) {
        if ("Yes".equals(absTraining)){
            return this.absTraining= 1;
        }else{
            return this.absTraining= 0;
                    }
    }

    public int setCardio(String cardio) {
        if ("Yes".equals(cardio)){
            return this.cardio= 1;
        }else{
            return this.cardio= 0;
                    }
    }

    public int setArmsTraining(String armsTraining) {
        if ("Yes".equals(armsTraining)){
            return this.armsTraining= 1;
        }else{
            return this.armsTraining= 0;
                    }
    }

    public int setLegsTraining(String legsTraining) {
        if ("Yes".equals(legsTraining)){
            return this.legsTraining= 1;
        }else{
            return this.legsTraining= 0;
                    }
    }

    public void setTrainingprogram() {
        this.trainingProgram = (ArrayList<TrainingProgramController>) TrainingProgramController.generateTrainingProgram(getGoal(), getNbHoursPerSession(), getCardio(), getLegsTraining(), getAbsTraining(), getArmsTraining());
    }
    
   
    
    /// Functions
    
    public double calculBmi(double lweight,double lheight){
        return this.bmi= lweight/Math.pow(lheight,2.0);
    }
    public String dictionnaryDate(Date gdate){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        return this.strDate=dateFormat.format(gdate);
    }
    public double calculFoodWeight(){
    if (this.getGoal()=="Gain weight"){
            return this.foodWeight= this.getWeight()+1.0;
        }else{
            return this.foodWeight= this.getWeight()-1.0;
                    }    
    }
    
    public String printAchievement(){
    if (getAchievements().get("you have achieved 25% of your goal")=="obtained"
            &&getAchievements().get("you have achieved 75% of your goal")=="obtained"
            &&getAchievements().get("you have achieved 50% of your goal")=="obtained"
            &&getAchievements().get("congratulations!!! you have achieved your goal")=="obtained"){
        return "you have achieved 25% of your goal\n"
                + "you have achieved 50% of your goal\n"
                + "you have achieved 75% of your goal\n"
                + "congratulations!!! you have achieved your goal";
       
    }
    if (getAchievements().get("you have achieved 25% of your goal")=="obtained"
            &&getAchievements().get("you have achieved 75% of your goal")=="obtained"
            &&getAchievements().get("you have achieved 50% of your goal")=="obtained"
            &&getAchievements().get("congratulations!!! you have achieved your goal")=="not obtained yet"){
        return "you have achieved 25% of your goal\n"
                + "you have achieved 50% of your goal\n"
                + "you have achieved 75% of your goal\n";
    }
    if (getAchievements().get("you have achieved 25% of your goal")=="obtained"
            &&getAchievements().get("you have achieved 75% of your goal")=="not obtained yet"
            &&getAchievements().get("you have achieved 50% of your goal")=="obtained"
            &&getAchievements().get("congratulations!!! you have achieved your goal")=="not obtained yet"){
        return "you have achieved 25% of your goal\n"
                + "you have achieved 50% of your goal\n";
    }
    if (getAchievements().get("you have achieved 25% of your goal")=="obtained"
            &&getAchievements().get("you have achieved 75% of your goal")=="not obtained yet"
            &&getAchievements().get("you have achieved 50% of your goal")=="not obtained yet"
            &&getAchievements().get("congratulations!!! you have achieved your goal")=="not obtained yet"){
        return "you have achieved 25% of your goal\n";
    }
    if (getAchievements().get("congratulations!!! you have achieved your goal")=="not obtained yet"
            &&getAchievements().get("you have achieved 75% of your goal")=="not obtained yet"
            &&getAchievements().get("you have achieved 50% of your goal")=="not obtained yet"
            &&getAchievements().get("you have achieved 25% of your goal")=="not obtained yet"){
        return "you haven't obtained any achievement yet";
    }
    else{    
    return null;
    }
    }
    
    
    
    @Override
    public boolean equals(Object obj) {
        return ((User) obj).getUsername().equals(this.username);
    }

    @Override
    public String toString() {
        return "Username: " + this.username
                + "\nFirst name: " + this.firstName
                + "\nLast name: " + this.lastName
                + "\nEmail: " + this.email
                + "\nAge: " + this.age
                + "\nGender: " + this.gender
                + "\nHeight: " + this.height
                + "\nWeight: " + this.weight
                + "\nNb hours per session: " + this.nbHoursPerSession
                + "\nUser picture: " + this.userPicture
                + "\nGoal: " + this.goal
                + "\nTarget weight: " + this.targetWeight
                + "\nYour Training Program" + this.trainingProgram.toString()
                + "\nYour actual BMI is " + String.format("%.2f", this.calculBmi(this.weight,this.height))
                + "\nYour record BMI are " + this.bmiRecord
                + "\nYour record weight are " + this.weightRecord
                + "\nYour record weight are " + this.weightRecord
                + "\nArms" + this.armsTraining
                + "\nLegs " + this.legsTraining
                + "\nAbs " + this.absTraining
                + "\nCardio " + this.cardio;
    }

}
