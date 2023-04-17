package ch.unil.doplab.gadswebsite.v1.controllers;

import ch.unil.doplab.gadswebsite.v1.exceptions.AlreadyExistsException;
import ch.unil.doplab.gadswebsite.v1.exceptions.DoesNotExistException;
import ch.unil.doplab.gadswebsite.v1.models.User;
import ch.unil.doplab.gadswebsite.v1.database.MockDatabase;
import ch.unil.doplab.gadswebsite.v1.models.Food;
import java.util.List;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author EMERY Guillaume, HORNUNG David, KERN Sophie, MUINO Adrian
 */

public class UserController {

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
    public static String recipe =Food.generateRecipes(foodWeight);
    private static int legsTraining = 0;
    private static int armsTraining = 0;
    private static int absTraining = 0;
    private static int cardio = 0;

    public static List trainingProgram =TrainingProgramController.generateTrainingProgram(goal, nbHoursPerSession, legsTraining, armsTraining, absTraining, cardio);

    public static void createAUser() {
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
    }

    public static User findByUsername(String username) throws DoesNotExistException {
        for (User user : MockDatabase.getInstance().getUsers()) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        throw new DoesNotExistException("The user " + username + " does not exist.");
    }

    protected static boolean emailExists() throws AlreadyExistsException {
        for (User user : MockDatabase.getInstance().getUsers()) {
            if (user.getEmail().equals(email)) {
                throw new AlreadyExistsException("The email " + email + " already exists.");
            }
        }
        return false;
    }

    protected static boolean usernameExists() throws DoesNotExistException {
        for (User user : MockDatabase.getInstance().getUsers()) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    
    //Getter Methods
    public static String getEmail() {
        return email;
    }

    public static String getFirstName() {
        return firstName;
    }

    public static String getLastName() {
        return lastName;
    }

    public static String getPassword() {
        return password;
    }

    public static String getUsername() {
        return username;
    }
    
    public static int getAge() {
        return age;
    }

    public static String getGender() {
        return gender;
    }
    
    public static Double getHeight() {
        return height;
    }
    
    public static Double getWeight() {
        return weight;
    }
    
    public static int getNbHoursPerSession() {
        return nbHoursPerSession;
    }
    
    public static String getUserPicture() {
        return userPicture;
    }
    
    public static String getGoal() {
        return goal;
    }
    
    public double getTargetWeight() {
        return targetWeight;
    }    
    public static double getFoodWeight() {
        return foodWeight;
    }

    public static String getRecipe() {
    User user = LoginController.getUserLoggedIn();
        return Food.generateRecipes(user.calculFoodWeight());
    }
    
    public static int getLegsTraining() {
        return legsTraining;
    }  
    
    public static int getArmsTraining() {
        return armsTraining;
    }  
    
    public static int getAbsTraining() {
        return absTraining;
    }  
    public static int getCardio() {
        return cardio;
    }  
    
    public static List getTrainingprogram() {
    User user = LoginController.getUserLoggedIn();
    return TrainingProgramController.generateTrainingProgram(user.getGoal(),user.getNbHoursPerSession(),user.getCardio(),user.getLegsTraining(),user.getAbsTraining(),user.getArmsTraining());
    }
    
    //Setter Methods
    public static void setEmail(String email) {
        UserController.email = email;
    }

    public static void setFirstName(String firstName) {
        UserController.firstName = firstName;
    }

    public static void setLastName(String lastName) {
        UserController.lastName = lastName;
    }

    public static void setPassword(String password) {
        UserController.password = password;
    }

    public static void setUsername(String username) {
        UserController.username = username;
    }
    
    public static void setAge(int age) {
        UserController.age = age;
    }
    
    public static void setGender(String gender) {
        UserController.gender = gender;
    }

    public static void setHeight(double height) {
        UserController.height = height;
    }
    
    public static void setWeight(double weight) {
        UserController.weight = weight;
    }
    
    public static void setBmi(double weight) {
        UserController.weight = weight;
    }
    
    public static void setNbHoursPerSession(int nbHoursPerSession) {
        UserController.nbHoursPerSession = nbHoursPerSession;
    }
    
    public static void setUserPicture(String userPicture) {
        UserController.userPicture = userPicture;
    }
    
    public String setGoal(double gweight,double gtargetWeight) {
        if (gweight < gtargetWeight){
            return goal = "Gain weight";
        }else{
            return goal = "Lose weight";
                    }
    }
    
    public static void setTargetWeight(double targetWeight) {
        UserController.targetWeight = targetWeight;
    }
    public static void setFoodweight(double foodWeight) {
        UserController.foodWeight = foodWeight;
    }

    public static void setRecipe(String recipe) {
        UserController.recipe = recipe;
    }
    
   public static void setAbsTraining(String absTraining) {
       User user = LoginController.getUserLoggedIn();
       user.setAbsTraining(absTraining);
    }

    public static void setArmsTraining(String armsTraining) {
        User user = LoginController.getUserLoggedIn();
        user.setArmsTraining(armsTraining);
    }

    public static void setCardio(String cardio) {
        User user = LoginController.getUserLoggedIn();
        user.setCardio(cardio);
    }

    public static void setLegsTraining(String legsTraining) {
        User user = LoginController.getUserLoggedIn();
        user.setLegsTraining(legsTraining);
    }
   
    //Functions
    public static void updateWeight(Double weight) {
        User user = LoginController.getUserLoggedIn();
        user.setWeight(weight);
        }
    public static void updateBmi(){
        User user = LoginController.getUserLoggedIn();
        user.calculBmi(user.getWeight(),user.getHeight());                       
    }
   
    public static void updatenbHoursPerSession(Integer nbHoursPerSession) {
        User user = LoginController.getUserLoggedIn();
        user.setNbHoursPerSession(nbHoursPerSession);
        user.setTrainingprogram();
        }

    public static void updateTargetWeight(Double targetWeight) {
        User user = LoginController.getUserLoggedIn();
        user.setTargetWeight(targetWeight);
        user.setGoal(user.getWeight(),targetWeight);
        user.calculFoodWeight();  
        user.setTrainingprogram();
        }
}