package ch.unil.doplab.gadswebsite.models;

import ch.unil.doplab.gadsweb.Beans.FoodBean;
import ch.unil.doplab.gadsweb.Beans.UserBean;
import ch.unil.doplab.gadsweb.Beans.TrainingProgramBean;
import java.util.*;
import java.text.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.primefaces.model.charts.line.LineChartModel;
import scala.collection.mutable.HashTable;

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
    
    private int age;
    private String gender; 
    private double height;
    private double weight;
    private int nbHoursPerSession; 
    private String userPicture;
    private String goal;
    private double bmi ;
    private double targetWeight;
    private String strDate;
    private double foodWeight;
    
    private int legsTraining; 
    private int armsTraining; 
    private int absTraining; 
    private int cardio;
    private String inputcardio;
    private String inputarms;
    private String inputabs;
    private String inputlegs;
    private String imagegoal;

    private ArrayList<String> trainingProgram;
    private ArrayList<String> recipe;
    private ArrayList<String> recordofkey;
    private LineChartModel lineModel;
    private String twentyfivePercent;
    private String fiftyPercent;
    private String seventyfivePercent;
    private String onehundredPercent;
    private String urlAchievements;
    
    
    Hashtable<String,Double> bmiRecord= new Hashtable<String,Double>();
    Dictionary<String,Double> weightRecord= new Hashtable<String,Double>();
    Dictionary<String,String> achievements = new Hashtable<String,String>();
    Dictionary<String,Double> initialWeight= new Hashtable<String,Double>();

    public User(String username, String firstName, String lastName, String email, String password,
            int age, String gender, double height, double weight, int nbHoursPerSession,
            String userPicture, String goal,double bmi,
            double targetWeight, double foodWeight, int legsTraining, int absTraining, int armsTraining, int cardio) {
      
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
        this.inputcardio="";
        this.inputarms="";
        this.inputabs="";
        this.inputlegs="";
        this.imagegoal="";
        this.bmiRecord= new Hashtable<String, Double>() {{ put("1", 1.0); put("2", 2.0); }};
        this.recordofkey= new ArrayList();
        this.twentyfivePercent="Not obtained";
        this.fiftyPercent="Not obtained";
        this.seventyfivePercent="Not obtained";
        this.onehundredPercent="Not obtained";
        this.urlAchievements="https://fontmeme.com/permalink/221124/217033c69c3f801a2f777fb51c46aed8.png";
        
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
    
    public double getHeight() {
        return height;
    }

    public double getWeight() {
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
    
    public ArrayList<String> getTrainingProgram() {
        return trainingProgram;
    }    
    
    
    public double getTargetWeight() {
        return targetWeight;
    }    
    
    public ArrayList<String> getRecipe() {
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

    public String getInputcardio() {
        return inputcardio;
    }

    public String getInputabs() {
        return inputabs;
    }

    public String getInputarms() {
        return inputarms;
    }

    public String getInputlegs() {
        return inputlegs;
    }

    public String getImagegoal() {
        return imagegoal;
    }

    public LineChartModel getLineModel() {
        return lineModel;
    }

    public Dictionary<String, Double> getBmiRecord() {
        if (bmiRecord==null)
            bmiRecord.put("0", 0.0);
     
        return bmiRecord;
    }

    public ArrayList<String> getRecordofkey() {
        return recordofkey;
    }
    
     
    public String getTwentyfivePercent() {
    return twentyfivePercent;
    }
    
    public String getFiftyPercent() {
    return fiftyPercent;
    }
        
    public String getSeventyfivePercent() {
    return seventyfivePercent;
    }
    
    public String getOnehundredPercent() {
    return onehundredPercent;
    }
    
    public String getUrlAchievements() {
        return urlAchievements;
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

    public void setBmi() {
        this.bmi = calculBmi(weight, height);
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
    
    public void setHeight(double height) {
        this.height = height;
    }    
    
    public void setWeight(double weight) {
        this.weight = weight;
        
        this.bmiRecord.put(dictionnaryDate(new Date()),this.getBmi());
        this.weightRecord.put(dictionnaryDate(new Date()),weight);
        this.recordofkey.add(dictionnaryDate(new Date()));
 
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

   public String setGoal(double gweight,double gtargetWeight) {
        if (gweight < gtargetWeight){
            this.imagegoal="https://upload.wikimedia.org/wikipedia/en/3/3f/Pok%C3%A9mon_Snorlax_art.png";
            return goal = "Gain weight";
        }else{
            this.imagegoal="https://www.pokepedia.fr/images/2/24/Machopeur-EdC.png";
            return goal = "Lose weight";
                    }
    }

     
    public void setTargetWeight(double targetWeight) {
        this.targetWeight = targetWeight;
    }
    
    public void setRecipe() {
        this.recipe = FoodBean.generateRecipes(this.goal);
    }

    public void setFoodweight(double foodweight) {
        this.foodWeight = calculFoodWeight();
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
        this.trainingProgram = (ArrayList<String>) TrainingProgramBean.generateTrainingProgram(goal, age, cardio, legsTraining, absTraining, armsTraining);
     }

    public void setInputcardio(String inputcardio) {
        this.inputcardio = inputcardio;
    }

    public void setInputabs(String inputabs) {
        this.inputabs = inputabs;
    }

    public void setInputarms(String inputarms) {
        this.inputarms = inputarms;
    }

    public void setInputlegs(String inputlegs) {
        this.inputlegs = inputlegs;
    }

    public void setImagegoal(String imagegoal) {
        this.imagegoal = imagegoal;
    }

    public void setLineModel(LineChartModel lineModel) {
        this.lineModel = lineModel;
    }

    public void setBmiRecord(Hashtable<String,Double> bmiRecord) {
        this.bmiRecord = bmiRecord;
    }

    public void setRecordofkey(ArrayList<String> recordofkey) {
        this.recordofkey = recordofkey;
    }
        
    public void setTwentyfivePercent(String twentyfivePercent) {
        this.twentyfivePercent = twentyfivePercent;
    }
    
    public void setFiftyPercent(String fiftyPercent) {
        this.fiftyPercent = fiftyPercent;
    }
    
    public void setSeventyfivePercent(String seventyfivePercent) {
        this.seventyfivePercent = seventyfivePercent;
    }
    
    public void setOnehundredPercent(String onehundredPercent) {
        this.onehundredPercent = onehundredPercent;
    }
    
    public void setUrlAchievements(String urlAchievements) {
        this.urlAchievements = urlAchievements;
    }
    

    /// Functions
    
    public void updateAchievements(){

    if ("Lose weight".equals(getGoal())){

        if ((weight-getTargetWeight())/(initialWeight.get("1")-getTargetWeight())<=0.75
            &&(weight-getTargetWeight())/(initialWeight.get("1")-getTargetWeight())>0.5) {
            setTwentyfivePercent("Obtained");
            setFiftyPercent("Not obtained");
            setSeventyfivePercent("Not obtained");
            setOnehundredPercent("Not obtained");
        }
        if ((weight-getTargetWeight())/(initialWeight.get("1")-getTargetWeight())<=0.5
            &&(weight-getTargetWeight())/(initialWeight.get("1")-getTargetWeight())>0.25) {
            setTwentyfivePercent("Not obtained");
            setFiftyPercent("Obtained");
            setSeventyfivePercent("Not obtained");
            setOnehundredPercent("Not obtained");
        }    
        if ((weight-getTargetWeight())/(initialWeight.get("1")-getTargetWeight())<=0.25
            &&(weight-getTargetWeight())/(initialWeight.get("1")-getTargetWeight())>0) {
            setTwentyfivePercent("Not obtained");
            setFiftyPercent("Not obtained");
            setSeventyfivePercent("Obtained");
            setOnehundredPercent("Not obtained");
        }

        if ((weight-getTargetWeight())/(initialWeight.get("1")-getTargetWeight())<=0) {
            setTwentyfivePercent("Not obtained");
            setFiftyPercent("Not obtained");
            setSeventyfivePercent("Not obtained");
            setOnehundredPercent("Obtained");
        }

    } 
    else if ("Gain weight".equals(getGoal())){
        if ((weight-initialWeight.get("1"))/(getTargetWeight()-initialWeight.get("1"))>=0.25
                &&(weight-initialWeight.get("1"))/(getTargetWeight()-initialWeight.get("1"))<0.5) {
            setTwentyfivePercent("Obtained");
            setFiftyPercent("Not obtained");
            setSeventyfivePercent("Not obtained");
            setOnehundredPercent("Not obtained");
        }
        if ((weight-initialWeight.get("1"))/(getTargetWeight()-initialWeight.get("1"))>=0.5
                &&(weight-initialWeight.get("1"))/(getTargetWeight()-initialWeight.get("1"))<0.75) {
            setTwentyfivePercent("Not obtained");
            setFiftyPercent("Obtained");
            setSeventyfivePercent("Not obtained");
            setOnehundredPercent("Not obtained");
        }    
        if ((weight-initialWeight.get("1"))/(getTargetWeight()-initialWeight.get("1"))>=0.75
                &&(weight-initialWeight.get("1"))/(getTargetWeight()-initialWeight.get("1"))<1){
            setTwentyfivePercent("Not obtained");
            setFiftyPercent("Not obtained");
            setSeventyfivePercent("Obtained");
            setOnehundredPercent("Not obtained");
        }

        if ((weight-initialWeight.get("1"))/(getTargetWeight()-initialWeight.get("1"))>=1) {
            setTwentyfivePercent("Not obtained");
            setFiftyPercent("Not obtained");
            setSeventyfivePercent("Not obtained");
            setOnehundredPercent("Obtained");
        }

    }
}    
    
    public void updateUrlAchievements(){
        if ("Obtained".equals(getTwentyfivePercent())){
            setUrlAchievements("https://images.vexels.com/media/users/3/126940/isolated/preview/c38299eea63490fce4823870ca59fc77-25-percent-circular-progress-tag.png");
        }
        else if ("Obtained".equals(getFiftyPercent())){
            setUrlAchievements("https://images.vexels.com/media/users/3/126968/isolated/lists/466f926f271713ebfb783f1214405f5d-50-percent-progress-circle.png");
        }
        else if ("Obtained".equals(getSeventyfivePercent())){
            setUrlAchievements("https://images.vexels.com/media/users/3/126974/isolated/lists/562291c8a657a8e1f01134b0c88b6a34-75-percent-round-tag.png");
        }
        
        else if ("Obtained".equals(getOnehundredPercent())){
            setUrlAchievements("https://images.vexels.com/media/users/3/126914/isolated/lists/a52d4248ee1559908b63f3c2c7f73239-100-percent-circle-graph.png");
        }
        
        
        
    }
    
    public double calculBmi(double lweight,double lheight){
        return this.bmi= lweight/Math.pow(lheight,2.0);
    }
    public String dictionnaryDate(Date gdate){
        DateFormat dateFormat = new SimpleDateFormat("dd hh:mm:ss");  
        return this.strDate=dateFormat.format(gdate);
    }
    public double calculFoodWeight(){
    if ("Gain weight".equals(goal)){
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
