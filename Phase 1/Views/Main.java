package ch.unil.doplab.gadswebsite.v1.views;

import ch.unil.doplab.gadswebsite.v1.controllers.PhysicalActivityController;
import ch.unil.doplab.gadswebsite.v1.controllers.LoginController;
import ch.unil.doplab.gadswebsite.v1.controllers.UserController;
import ch.unil.doplab.gadswebsite.v1.database.MockDatabase;
import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author EMERY Guillaume, HORNUNG David, KERN Sophie, MUINO Adrian
 */
public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
       
    }

    private static void homePage() {
        String choice, username, password, firstName, lastName, email, age, gender, height, weight, nbSessions, nbHoursPerSession, userPicture, currentSportLevel, gymAccess,goal,targetWeight;
        do {
            System.out.println("Enter:"
                    + "\n[q] to quit the application"
                    + "\n[1] to login"
                    + "\n[2] to create a user account"
                    + "\n[3] to see all types of physical activities and exercises available");
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Enter your username:");
                    username = sc.nextLine();
                    System.out.println("Enter your password:");
                    password = sc.nextLine();
                    LoginController.setUsername(username);
                    LoginController.setPassword(password);
                    LoginController.userLogsIn();
                    if (LoginController.getUserLoggedIn() != null) {
                        userHomePage();
                    }
                    break;
                case "2":
                    username = "";
                    while (username.matches("[A-Z]{1}[a-z]{1,20}")==false)
                    {
                        System.out.println("Enter your username: \n"
                                + "2 to 20 letters"
                                + "\n begin with a capital letter");
                        username = sc.nextLine();
                        if (username.matches("[A-Z]{1}[a-z]{1,20}")==true)
                        {
                            System.out.print("username valid\n");
                        }
                        else
                        {
                            System.out.print("username invalid\n");
                        }
                    }
                    firstName = "";
                    while (firstName.matches("[A-Z]{1}[a-z]{1,20}")==false)
                    {
                        System.out.println("Enter your first name: \n"
                                + "2 to 20 letters"
                                + "\n begin with a capital letter ");
                        firstName = sc.nextLine();
                        if (firstName.matches("[A-Z]{1}[a-z]{1,20}")==true)
                        {
                            System.out.print("first name valid\n");
                        }
                        else
                        {
                            System.out.print("first name invalid\n");
                        }
                    }
                    lastName = "";
                    while (lastName.matches("[A-Z]{1}[a-z]{1,20}")==false)
                    {
                        System.out.println("Enter your last name: \n"
                                + "2 to 20 letters"
                                + "\n begin with a capital letter");
                        lastName = sc.nextLine();
                        if (lastName.matches("[A-Z]{1}[a-z]{1,20}")==true)
                        {
                            System.out.print("last name valid\n");
                        }
                        else
                        {
                            System.out.print("last name invalid\n");
                        }
                    }
                    email = "";
                    while (email.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")==false)
                    {
                        System.out.println("Enter your email: \n");
                        email = sc.nextLine();
                        if (email.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")==true)
                        {
                            System.out.print("email valid\n");
                        }
                        else
                        {
                            System.out.print("email invalid\n");
                        }
                    }
                    password = "";
                    while (password.matches(".{4,12}")==false)
                    {
                        System.out.println("Enter your password: \n"
                                + "4 to 12 caracters");
                        password = sc.nextLine();
                        if (password.matches(".{4,12}")==true)
                        {
                            System.out.print("password valid\n");
                        }
                        else
                        {
                            System.out.print("password invalid\n");
                        }
                    }
                    age = "";
                    while (age.matches("^(?:1[01][0-9]|120|1[0-9]|[2-9][0-9])$")==false)
                    {
                        System.out.println("Enter your age (age must be between 10-120): \n");
                        age = sc.nextLine();
                        if (age.matches("^(?:1[01][0-9]|120|1[0-9]|[2-9][0-9])$")==true)
                        {
                            System.out.print("age valid\n");
                        }
                        else
                        {
                            System.out.print("age invalid\n");
                        }
                    }
                    gender = "";
                    while (gender.matches("([M]{1}|[F]{1})")==false)
                    {
                        System.out.println("Enter your gender M or F: \n");
                        gender = sc.nextLine();
                        if (gender.matches("([M]{1}|[F]{1})")==true)
                        {
                            System.out.print("gender valid\n");
                        }
                        else
                        {
                            System.out.print("gender invalid\n");
                        }
                    }
                    height = "";
                    while (height.matches("([1]{1}|[2]{1})\\.[0-9]{2}")==false)
                    {
                        System.out.println("Enter your height in meters (X.XX): \n");
                        height = sc.nextLine();
                        if (height.matches("([1]{1}|[2]{1})\\.[0-9]{2}")==true)
                        {
                            System.out.print("height valid\n");
                        }
                        else
                        {
                            System.out.print("height invalid\n");
                        }
                    }
                    weight = "";
                    while (weight.matches("([1]{1}|[2]{1}){0,1}[0-9]{2}\\.[0-9]{1}")==false)
                    {
                        System.out.println("Enter your weight in kilograms (XXX.X or XX.X): \n");
                        weight = sc.nextLine();
                        if (weight.matches("([1]{1}|[2]{1}){0,1}[0-9]{2}\\.[0-9]{1}")==true)
                        {
                            System.out.print("weight valid\n");
                        }
                        else
                        {
                            System.out.print("weight invalid\n");
                        }
                    }
                           
                    System.out.println("Enter the url to the picture you want on your account:");
                    userPicture = sc.nextLine();

                    System.out.println("What is your target weight?");
                    targetWeight= sc.nextLine();
               
                    UserController.setUsername(username);
                    UserController.setFirstName(firstName);
                    UserController.setLastName(lastName);
                    UserController.setEmail(email);
                    UserController.setPassword(password);
                    UserController.setAge(Integer.parseInt(age));
                    UserController.setGender(gender);
                    UserController.setHeight(Double.parseDouble(height));
                    UserController.setWeight(Double.parseDouble(weight));
                    UserController.setUserPicture(userPicture);
                    UserController.setTargetWeight(Double.parseDouble(targetWeight));
                    UserController.createAUser();
                    
                    
                    break;
                case "3":
                    System.out.println(PhysicalActivityController.getPhysicalActivities());
                    break;
                case "q":
                    System.out.println("Quitting...");
                    break;
                default:
                    System.out.println("Choice = " + choice + " does not exist.");
                    break;
            }
        } while (!choice.equals("q"));
    }

    public static void userHomePage() {
        String choice, subChoice, physicalActivityName,weight,nbSessions,nbHoursPerSession,gymAccess,targetWeight,legsTraining,armsTraining,absTraining,cardio;
 
        do {
            System.out.println("Enter:"
                    + "\n[q] to log out"
                    + "\n[1] to see all types of physical activities and exercises available"
                    + "\n[2] to create a new training program"
                    + "\n[3] to see your training program"
                    + "\n[4] to show your information"
                    + "\n[5] to update your information(weight and target weight)"
                    + "\n[6] to show your achievements"
                    + "\n[7] to show your recipes");
            
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    System.out.println(PhysicalActivityController.getPhysicalActivities());
                    break;
                case "2":
                    System.out.println("What is your actual weight?");
                        weight = sc.nextLine();
                        UserController.updateWeight(Double.parseDouble(weight));

                    System.out.println("Do you have a new target weight? (if no enter your previous target weight)");
                        targetWeight = sc.nextLine(); 
                        UserController.updateTargetWeight(Double.parseDouble(targetWeight));    
                    System.out.println("Your information have been sucessfully updated.");
                    
                    nbHoursPerSession = "";
                    while (nbHoursPerSession.matches("([1]|[2]|[3]){1}")==false)
                    {
                        System.out.println("Enter: \n1 if you want to train 2h \n2 if you want to train 1h20 \n3 if you want to train 40min \n");
                        nbHoursPerSession = sc.nextLine();
                        if (nbHoursPerSession.matches("([1]|[2]|[3]){1}")==true)
                        {
                            System.out.print("valid entry\n");
                        }
                        else
                        {
                            System.out.print("invalid entry\n");
                        }
                    }
                    UserController.updatenbHoursPerSession(Integer.parseInt(nbHoursPerSession));
                    legsTraining = "";
                    while (legsTraining.matches("([N][o]|[Y][e][s]){1}")==false)
                    {
                        System.out.println("Do you want to do legs training Yes or No ?");
                        legsTraining = sc.nextLine();
                        if (legsTraining.matches("([N][o]|[Y][e][s]){1}")==true)
                        {
                            System.out.print("valid entry\n");
                        }
                        else
                        {
                            System.out.print("invalid entry\n");
                        }
                    }
                    UserController.setLegsTraining(legsTraining);
                    armsTraining = "";
                    while (armsTraining.matches("([N][o]|[Y][e][s]){1}")==false)
                    {
                        System.out.println("Do you want to do arms training Yes or No ?");
                        armsTraining = sc.nextLine();
                        if (armsTraining.matches("([N][o]|[Y][e][s]){1}")==true)
                        {
                            System.out.print("valid entry\n");
                        }
                        else
                        {
                            System.out.print("invalid entry\n");
                        }
                    }                   
                    UserController.setArmsTraining(armsTraining);
                    absTraining = "";
                    while (absTraining.matches("([N][o]|[Y][e][s]){1}")==false)
                    {
                        System.out.println("Do you want to do abs training Yes or No ?");
                        absTraining = sc.nextLine();
                        if (absTraining.matches("([N][o]|[Y][e][s]){1}")==true)
                        {
                            System.out.print("valid entry\n");
                        }
                        else
                        {
                            System.out.print("invalid entry\n");
                        }
                    }       
                    UserController.setAbsTraining(absTraining);
                    cardio = "";
                    while (cardio.matches("([N][o]|[Y][e][s]){1}")==false)
                    {
                        System.out.println("Do you want to do cardio Yes or No ?");
                        cardio = sc.nextLine();
                        if (cardio.matches("([N][o]|[Y][e][s]){1}")==true)
                        {
                            System.out.print("valid entry\n");
                        }
                        else
                        {
                            System.out.print("invalid entry\n");
                        }
                    }       
                    UserController.setCardio(cardio);
                    System.out.println("This is your new training program:");
                    System.out.println(UserController.getTrainingprogram());                    
                    break;
                case "3":
                    System.out.println("This is your new training program:");
                    System.out.println(UserController.getTrainingprogram());
                    break;
                case "4":
                    System.out.println(LoginController.getUserLoggedIn().toString());
                    break;
                case "5":
                    System.out.println("What is your actual weight?");
                        weight = sc.nextLine();
                        UserController.updateWeight(Double.parseDouble(weight));

                    System.out.println("Do you have a new target weight? (if no enter your previous target weight)");
                        targetWeight = sc.nextLine(); 
                        UserController.updateTargetWeight(Double.parseDouble(targetWeight));    
                    System.out.println("Your information have been sucessfully updated.");
                    break;
                case "6":
                    System.out.println("The Dictionary is: " + LoginController.getUserLoggedIn().getAchievements());
                    System.out.println(LoginController.getUserLoggedIn().printAchievement());
                    break;
                case "7":
                    System.out.println(UserController.getRecipe());
                    break;
                case "q":
                    System.out.println("Homepage...");
                    break;
                default:
                    System.out.println("Choice = " + choice + " does not exist.");
                    break;
            }
        } while (!choice.equals("q"));
        LoginController.userLogsout();
    }

}
