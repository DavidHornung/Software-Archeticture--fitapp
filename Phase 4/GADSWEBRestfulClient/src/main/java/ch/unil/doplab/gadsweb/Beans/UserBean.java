/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unil.doplab.gadsweb.Beans;

import ch.unil.doplab.gadsweb.Client.PersistenceClient;
import ch.unil.doplab.gadswebsite.exceptions.AlreadyExistsException;
import ch.unil.doplab.gadswebsite.exceptions.DoesNotExistException;
import ch.unil.doplab.gadswebsite.models.User;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 *
 * @author EMERY Guillaume, HORNUNG David, KERN Sophie, MUINO Adrian
 */
@Named(value = "userBean")
@SessionScoped
public class UserBean implements Serializable {
    
    private String username = "";
    private String firstName = "";
    private String lastName = "";
    private String email = "";
    private String password = "";
    private Integer age = 0;
    private String gender = "";
    private double height = 0.0;
    private double weight = 0.0;
    private String goal = "";
    private double bmi = 0.0;
    private double targetWeight = 0.0;
    private String inputcardio="";
    private String inputarms="";
    private String inputabs="";
    private String inputlegs="";
    private String imagegoal="";
    private String passwordmessage="";
    
      
    public String createAUser() {
        try {
            boolean a = !PersistenceClient.getInstance().emailExists(email);
            boolean b = PersistenceClient.getInstance().getUserByName(username) == null;
            if (a && b) {
                User newUser = new User();
                newUser.setUsername(username);
                newUser.setFirstname(firstName);
                newUser.setLastName(lastName);
                newUser.setEmail(email);
                newUser.setPassword(password.hashCode());
                newUser.setGender(gender);
                newUser.setHeight(height);
                newUser.setWeight(weight);
                newUser.setAge(age);
                PersistenceClient.getInstance().createUser(newUser);
            }
        } catch (AlreadyExistsException ex) {
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
        this.inputcardio="";
        this.inputarms="";
        this.inputabs="";
        this.inputlegs="";
        return "/MainPage/MainPage.xhtml?faces-redirect=true";
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
    
    
    public String getGoal() {
        return goal;
    }
    
    public double getTargetWeight() {
        return targetWeight;
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
    
    public double getBmi() {
        return bmi;
    }

    public String getPasswordmessage() {
        return passwordmessage;
    }
  
    
    //Setter Methods
    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    
    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    public void setBmi(double weight) {
        this.bmi = calculBmi(this.getWeight(), this.getHeight()) ;
    }
    
    public void setGoals(double gweight,double gtargetWeight) {
        User user = LoginBean.getUserLoggedIn();
        if (gweight < gtargetWeight){
            this.imagegoal="https://upload.wikimedia.org/wikipedia/en/3/3f/Pok%C3%A9mon_Snorlax_art.png";
            user.setGoal("Gain weight");
        }else{
            this.imagegoal="https://www.pokepedia.fr/images/2/24/Machopeur-EdC.png";
            user.setGoal("Lose weight");
                    }
    }
    
    public void setTargetWeight(double targetWeight) {
        this.targetWeight = targetWeight;
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

    public void setPasswordmessage(String passwordmessage) {
        this.passwordmessage = passwordmessage;
    }
    

    //Functions
    public void updateWeight(Double weight) {
        User user = LoginBean.getUserLoggedIn();
        user.setWeight(weight);
        }
    public void updateBmi(){
        User user = LoginBean.getUserLoggedIn();
        user.setBmi(calculBmi(user.getWeight(),user.getHeight()));
        
    }
    
    public double calculBmi(double lweight,double lheight){
        return this.bmi= lweight/Math.pow(lheight,2.0);
    }
    public void updateTargetWeight(double targetWeight,double weight) throws DoesNotExistException {
        setGoals(this.weight, this.targetWeight);
        User user = LoginBean.getUserLoggedIn();
        user.setWeight(this.getWeight());
        user.setTargetweight(this.getTargetWeight());
        user.setBmi(calculBmi(user.getWeight(),user.getHeight()));
        PersistenceClient.getInstance().updateUser(user);
        }
    
    public void Displaypasswordmessage(){
        if ( password.isEmpty()){
        this.passwordmessage= "Sorry a problem occured try again";
        }else{
        this.passwordmessage= "Congratulation your password has changed";
        }
        }

     public void updateUserInformation(){ 
        User user = LoginBean.getUserLoggedIn();
        user.setUsername(username);
        user.setPassword(password.hashCode());
        user.setAge(age);
        user.setEmail(email);
        user.setFirstname(firstName);
        user.setLastName(lastName);
        user.setHeight(height);
        PersistenceClient.getInstance().updateUser(user);
        Displaypasswordmessage();
        }
}
