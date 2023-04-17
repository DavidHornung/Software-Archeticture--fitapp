/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unil.doplab.gadsweb.Beans;

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
    
    @PersistenceContext(unitName = "gads_PU")
    private EntityManager em;
    
    private static String username = "";
    private static String firstName = "";
    private static String lastName = "";
    private static String email = "";
    private static String password = "";
    private static Integer age = 0;
    private static String gender = "";
    private static double height = 0.0;
    private static double weight = 0.0;
    private static String goal = "";
    private static double bmi = 0.0;
    private static double targetWeight = 0.0;
    private static String inputcardio="";
    private static String inputarms="";
    private static String inputabs="";
    private static String inputlegs="";
    private static String imagegoal="";
    private static String passwordmessage="";
    
    @Transactional        
    public void createAUser() {
        try {
            if (!emailExists() && !usernameExists()) {
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
                em.persist(newUser);
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
        this.inputcardio="";
        this.inputarms="";
        this.inputabs="";
        this.inputlegs="";
        
    }

    private boolean emailExists() throws AlreadyExistsException {
        Query query = em.createNamedQuery("User.findByEmail");
        List<User> user = query.setParameter("email", email).getResultList();
        return user.size() > 0;
    }

    private boolean usernameExists() throws DoesNotExistException {
        Query query = em.createNamedQuery("User.findByUsername");
        List<User> user = query.setParameter("username", username).getResultList();
        return user.size() > 0;
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
        UserBean.email = email;
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
        UserBean.targetWeight = targetWeight;
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

    public void setPasswordmessage(String passwordmessage) {
        UserBean.passwordmessage = passwordmessage;
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

    public void updateTargetWeight(double targetWeight,double weight) throws DoesNotExistException {
        setGoals(this.weight, this.targetWeight);
        User user = LoginBean.getUserLoggedIn();
        user.setWeight(this.getWeight());
        user.setTargetweight(this.getTargetWeight());
        user.setBmi();
        }
    
    public void Displaypasswordmessage(){
        if ( password.isEmpty()){
        this.passwordmessage= "Sorry a problem occured try again";
        }else{
        this.passwordmessage= "Congratulation your password has changed";
        }
        }
    
    
    
    

    @Transactional
     public void updateUserInformation(){ 
        User user = LoginBean.getUserLoggedIn();
        user.setUsername(username);
        user.setPassword(password.hashCode());
        user.setAge(age);
        user.setEmail(email);
        user.setFirstname(firstName);
        user.setLastName(lastName);
        user.setHeight(height);
        em.merge(user);
        Displaypasswordmessage();
        }
}
