/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unil.doplab.gadsweb.Beans;

import ch.unil.doplab.gadswebsite.database.MockDatabase;
import ch.unil.doplab.gadswebsite.exceptions.AlreadyExistsException;
import ch.unil.doplab.gadswebsite.exceptions.DoesNotExistException;
import ch.unil.doplab.gadswebsite.models.User;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.lang.Integer;
import javax.annotation.PostConstruct;
//import org.primefaces.model.chart.MeterGaugeChartModel;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.line.LineChartDataSet;
import org.primefaces.model.charts.line.LineChartModel;
import scala.collection.mutable.HashTable;

/**
 *
 * @author EMERY Guillaume, HORNUNG David, KERN Sophie, MUINO Adrian
 */
@Named(value = "userBean")
@SessionScoped
public class UserBean implements Serializable {

    private static String username = "";
    private static String firstName = "";
    private static String lastName = "";
    private static String email = "";
    private static String password = "";
    private static Integer age = 0;
    private static String gender = "";
    private static double height = 0.0;
    private static double weight = 0.0;
    private static double newWeight=0.0;
    private static Integer nbHoursPerSession = 0;
    private static String userPicture = "";
    private static String goal = "";
    private static double bmi = 0.0;
    private static double targetWeight = 0.0;
    private static double foodWeight = 0.0;
    public static String recipe = "";
    private static int legsTraining = 0;
    private static int armsTraining = 0;
    private static int absTraining = 0;
    private static int cardio = 0;
    private static String inputcardio="";
    private static String inputarms="";
    private static String inputabs="";
    private static String inputlegs="";
    private static List trainingProgram = new ArrayList<String>();
    private static String imagegoal="";
    private  List recordofkey;
    private LineChartModel lineModel;
//    private MeterGaugeChartModel meterGaugeChartModel;
    Hashtable<String,Double> bmiRecord;
    Dictionary<String,String> achievements = new Hashtable<String,String>();
    Dictionary<String,Double> initialWeight= new Hashtable<String,Double>();
    private String twentyfivePercent;
    private String fiftyPercent;
    private String seventyfivePercent;
    private String onehundredPercent;
    private String urlAchievements;
  
            
    public void createAUser() {
        try {
            if (!emailExists() && !usernameExists()) {
                MockDatabase.getInstance().addAUser(new User(
                        username,
                        firstName,
                        lastName,
                        email,
                        password, 
                        age, 
                        gender, 
                        height, 
                        weight, 
                        nbHoursPerSession, 
                        userPicture, 
                        goal,
                        bmi,
                        targetWeight,
                        foodWeight,
                        legsTraining,
                        absTraining,
                        armsTraining,
                        cardio));
            }
        } catch (AlreadyExistsException | DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
    
//emptys values
        this.email = "";
        this.username = "";
        this.firstName = "";
        this.lastName = "";
        this.password = "";
        this.age=0;
        this.gender="";
        this.height=0.0;
        this.weight=0.0;
        this.goal="";
        this.cardio=0;
        this.legsTraining=0;
        this.absTraining=0;
        this.armsTraining=0;
        this.inputcardio="";
        this.inputarms="";
        this.inputabs="";
        this.inputlegs="";
        this.lineModel = new LineChartModel();
        this.bmiRecord= new Hashtable<String, Double>() {{ put("1", 1.0); put("2", 2.0); }};
        this.recordofkey= new ArrayList<String>();
        this.achievements.put("you have achieved 25% of your goal","not obtained yet");
        this.achievements.put("you have achieved 50% of your goal","not obtained yet");
        this.achievements.put("you have achieved 75% of your goal","not obtained yet");
        this.achievements.put("congratulations!!! you have achieved your goal","not obtained yet");
        this.twentyfivePercent="Not obtained";
        this.fiftyPercent="Not obtained";
        this.seventyfivePercent="Not obtained";
        this.onehundredPercent="Not obtained";
        this.urlAchievements="https://fontmeme.com/permalink/221124/ef5775e0f69890cc57f9d3d4783a177c.png";
        
    }
    protected static User findByUsername(String username) throws DoesNotExistException {
        for (User user : MockDatabase.getInstance().getUsers()) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        throw new DoesNotExistException("The user " + username + " does not exist.");
    }

    private boolean emailExists() throws AlreadyExistsException {
        for (User user : MockDatabase.getInstance().getUsers()) {
            if (user.getEmail().equals(email)) {
                throw new AlreadyExistsException("The email " + email + " already exists.");
            }
        }
        return false;
    }

    private boolean usernameExists() throws DoesNotExistException {
        for (User user : MockDatabase.getInstance().getUsers()) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    
    //Getter Methods
    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
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
    
    public int getNbHoursPerSession() {
        return nbHoursPerSession;
    }
    
    public String getUserPicture() {
        return userPicture;
    }
    
    public String getGoal() {
        return goal;
    }
    
    public double getTargetWeight() {
        return targetWeight;
    }    
    public double getFoodWeight() {
        return foodWeight;
    }

    public String getRecipe() {
    return recipe;
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
    
    public List getTrainingprogram() {
        return trainingProgram;
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
        return bmiRecord;
    }

    public List getRecordofkey() {
        return recordofkey;
    }

//    public MeterGaugeChartModel getMeterGaugeChartModel() {
//        return meterGaugeChartModel;
//    }

    public double getBmi() {
        return bmi;
    }
      
    public Dictionary<String, String> getAchievements() {
        return achievements;
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
    
    public String getOnehundrePercent() {
    return onehundredPercent;
    }

    public String getUrlAchievements() {
    return urlAchievements;
    }
  
    
    //Setter Methods
    public void setEmail(String email) {
        UserBean.email = email;
    }

    public void setTrainingProgram(List trainingProgram) {
        UserBean.trainingProgram = TrainingProgramBean.generateTrainingProgram(this.goal, this.nbHoursPerSession, this.cardio, this.legsTraining,this.absTraining,this.armsTraining );
    }
    

    public void setFirstName(String firstName) {
        UserBean.firstName = firstName;
    }

    public void setLastName(String lastName) {
        UserBean.lastName = lastName;
    }

    public void setPassword(String password) {
        UserBean.password = password;
    }

    public void setUsername(String username) {
        UserBean.username = username;
    }
    
    public void setAge(int age) {
        UserBean.age = age;
    }
    
    public void setGender(String gender) {
        UserBean.gender = gender;
    }

    public void setHeight(double height) {
        UserBean.height = height;
    }
    
    public void setWeight(double weight) {
        UserBean.weight = weight;
    }
    
    public void setBmi(double weight) {
        User user = LoginBean.getUserLoggedIn();
        UserBean.bmi = user.calculBmi(this.getWeight(), this.getHeight()) ;
    }
    
    public void setNbHoursPerSession(int nbHoursPerSession) {
        UserBean.nbHoursPerSession = nbHoursPerSession;
    }
    
    public void setUserPicture(String userPicture) {
        UserBean.userPicture = userPicture;
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
        UserBean.targetWeight = targetWeight;
    }
    public void setFoodweight(double foodWeight) {
        UserBean.foodWeight = foodWeight;
    }
    
public int setAbsTraining(String absTraining) {
        if ("Yes".equals(absTraining)){
            return this.absTraining= 1;
        }else{
            return this.absTraining= 0;
                    }
    }

    public int setCardio(String inputcardio) {
        if ("Yes".equals(this.inputcardio)){
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
    public void setRecipe(String recipe) {
        UserBean.recipe = recipe;
    }

    public void setInputcardio(String inputcardio) {
          UserBean.inputcardio = inputcardio;
    }

    public void setInputabs(String inputabs) {
        UserBean.inputabs = inputabs;
    }

    public void setInputarms(String inputarms) {
        UserBean.inputarms = inputarms;
    }

    public void setInputlegs(String inputlegs) {
        UserBean.inputlegs = inputlegs;
    }

    public void setImagegoal(String imagegoal) {
        UserBean.imagegoal = imagegoal;
    }

    public void setLineModel(LineChartModel lineModel) {
        this.lineModel = lineModel;
    }

    public void setBmiRecord(Hashtable<String, Double> bmiRecord) {
        this.bmiRecord = bmiRecord;
    }

    public void setRecordofkey(List recordofkey) {
        this.recordofkey = recordofkey;
    }

//    public void setMeterGaugeChartModel(MeterGaugeChartModel meterGaugeChartModel) {
//        this.meterGaugeChartModel = meterGaugeChartModel;
//    }
    public void setAchievements(Hashtable<String, String> achievements) {
        this.achievements = achievements;
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
    
    public void setOnehundrePercent(String onehundredPercent) {
        this.onehundredPercent = onehundredPercent;
    }
    
    public void setUrlAchievements(String urlAchievements) {
        this.urlAchievements = urlAchievements;
    }
    
    

    //Functions
    public void updateWeight(Double weight) {
        User user = LoginBean.getUserLoggedIn();
        user.setWeight(weight);
        }
    public void updateBmi(){
        User user = LoginBean.getUserLoggedIn();
        user.calculBmi(user.getWeight(),user.getHeight());                       
    }
   
    public void updatenbHoursPerSession(Integer nbHoursPerSession) {
        User user = LoginBean.getUserLoggedIn();
        user.setNbHoursPerSession(nbHoursPerSession);
        user.setTrainingprogram();
        }

    public void updateTargetWeight(double targetWeight,double weight) {
        User user = LoginBean.getUserLoggedIn();
        user.setWeight(this.getWeight());
        user.setTargetWeight(this.getTargetWeight());
        user.setGoal(this.getWeight(),this.getTargetWeight());
        user.setCardio(this.getInputcardio());
        user.setArmsTraining(this.getInputarms());
        user.setAbsTraining(this.getInputabs());
        user.setLegsTraining(this.getInputlegs());
        user.setBmi();
        user.calculFoodWeight();  
        user.setTrainingprogram();
        user.setRecipe();
        user.updateAchievements();
        user.updateUrlAchievements();
        
        
        }
    
     public void updateUserInformation() {
        User user = LoginBean.getUserLoggedIn();
        user.setUsername(this.username);
        user.setPassword(this.password);
        user.setAge(this.age);
        user.setEmail(this.email);
        user.setFirstName(this.firstName);
        user.setLastName(this.lastName);
        user.setHeight(this.height);
   
        }

//     @PostConstruct
//     public void init() {
////         createLineModel();
//         createMeterGaugeChartModel();
//     }
////     public void createLineModel() {
////       User user = LoginBean.getUserLoggedIn();
//////       Hashtable<String,Double> dicBMI =(Hashtable<String,Double>) user.getBmiRecord();
////       List<Integer> bmi = new ArrayList<Integer>();
////        bmi.add(60);
////        bmi.add(59);
////        bmi.add(80);
////        bmi.add(81);
////        bmi.add(56);
////        bmi.add(55);
////        bmi.add(40);
////       lineModel = new LineChartModel();
////       ChartData data = new ChartData();
////
////        LineChartDataSet dataSet = new LineChartDataSet();
////        List<Object> values = new ArrayList<>();
////        int v=0;
////        while(bmi.size()<values.size()){
////        v=v+1;
////        values.add(bmi.get(v));}
////            
//////        
////        dataSet.setData(values);
////        dataSet.setFill(false);
////        dataSet.setLabel("My First Dataset");
////        dataSet.setBorderColor("rgb(75, 192, 192)");
////        dataSet.setTension(0.1);
////        data.addChartDataSet(dataSet);
////
////        List<String> labels = new ArrayList<>();
////        labels.add("January");
////        labels.add("February");
////        labels.add("March");
////        labels.add("April");
////        labels.add("May");
////        labels.add("June");
////        labels.add("July");
////        data.setLabels(labels);
////        lineModel.setData(data);
////    }
//     public void createLineModel() {
//        lineModel = new LineChartModel();
//        ChartData data = new ChartData();
////        recordofkey.add("1");
////        recordofkey.add("2");
//        Hashtable<String,Double> dicBMI = (Hashtable<String,Double>) this.bmiRecord;
//        LineChartDataSet dataSet = new LineChartDataSet();
//        List<Object> values = new ArrayList<>();
//        values.add(50);
//        values.add(60);
//        values.add(59);
//        values.add(80);
//        values.add(81);
//        values.add(56);
//        values.add(55);
//        values.add(40);
//        dataSet.setData(values);
//        dataSet.setFill(false);
//        dataSet.setLabel("BMI");
//        dataSet.setBorderColor("rgb(75, 192, 192)");
//        dataSet.setTension(0.1);
//        data.addChartDataSet(dataSet);
//
//        List<String> labels = new ArrayList<>();
//        labels.add("January");
//        labels.add("February");
//        labels.add("March");
//        labels.add("April");
//        labels.add("May");
//        labels.add("June");
//        labels.add("July");
//        data.setLabels(labels);
//        lineModel.setData(data);
//}
//     private void createMeterGaugeChartModel() {
//        
//        meterGaugeChartModel = initMeterGaugeChartModel();
//        meterGaugeChartModel.setTitle("Your BMI Chart");
//        meterGaugeChartModel.setShowTickLabels(true);
//        meterGaugeChartModel.setSeriesColors("ff3333,93b75f,E7E658,ff3333,ff3333");
//        meterGaugeChartModel.setGaugeLabel("BMI");
//        meterGaugeChartModel.setGaugeLabelPosition("bottom");
//
//    }
//
//    private MeterGaugeChartModel initMeterGaugeChartModel() {
//        User user = LoginBean.getUserLoggedIn();
//        List<Number> intervals = new ArrayList<Number>() {
//            {
//                add(18);
//                add(25);
//                add(30);
//                add(35);
//                add(40);
//            }
//        };
//        
//        return new MeterGaugeChartModel(user.getBmi(), intervals);
//    }
//    
}
