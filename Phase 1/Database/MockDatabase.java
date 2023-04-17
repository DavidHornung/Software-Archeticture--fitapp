package ch.unil.doplab.gadswebsite.v1.database;

import ch.unil.doplab.gadswebsite.v1.models.PhysicalActivity;
import ch.unil.doplab.gadswebsite.v1.models.User;
import java.util.ArrayList;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author EMERY Guillaume, HORNUNG David, KERN Sophie, MUINO Adrian
 */
public class MockDatabase {

    private static MockDatabase instance;

    private ArrayList<User> users;
    private ArrayList<PhysicalActivity> physicalActivities;
    
    

    private MockDatabase() {
        users = new ArrayList<User>();
       users.add(new User("Adrian", "Adrian", "Muino", "adrian@muino.com", "1234",27,"male",1.75,83.0,2,"url here or smth","",0.0,100.00,100.00,1,0,0,0));


        physicalActivities = new ArrayList<PhysicalActivity>();
        
        ArrayList<String> act1 = new ArrayList<String>();
        act1.add("legs training;gain;10;Exercise_1;Description_1");
        act1.add("legs training;gain;10;Exercise_2;Description_2");
        act1.add("legs training;gain;10;Exercise_3;Description_3");
        act1.add("legs training;gain;10;Exercise_4;Description_4");
        act1.add("legs training;gain;10;Exercise_5;Description_5");
        act1.add("legs training;lose;10;Exercise_6;Description_6");
        act1.add("legs training;lose;10;Exercise_7;Description_7");
        act1.add("legs training;lose;10;Exercise_8;Description_8");
        act1.add("legs training;lose;10;Exercise_9;Description_9");
        act1.add("legs training;lose;10;Exercise_10;Description_10");
        physicalActivities.add(new PhysicalActivity("Legs Training", "gain weight: ex.[1-5] & lose weight: ex.[6-10]", act1));

        ArrayList<String> act2 = new ArrayList<String>();
        act2.add("arms training;gain;10;Exercise_1;Description_1");
        act2.add("arms training;gain;10;Exercise_2;Description_2");
        act2.add("arms training;gain;10;Exercise_3;Description_3");
        act2.add("arms training;gain;10;Exercise_4;Description_4");
        act2.add("arms training;gain;10;Exercise_5;Description_5");
        act2.add("arms training;lose;10;Exercise_6;Description_6");
        act2.add("arms training;lose;10;Exercise_7;Description_7");
        act2.add("arms training;lose;10;Exercise_8;Description_8");
        act2.add("arms training;lose;10;Exercise_9;Description_9");
        act2.add("arms training;lose;10;Exercise_10;Description_10");
        physicalActivities.add(new PhysicalActivity("Arms Training", "gain weight: ex.[1-5] & lose weight: ex.[6-10]", act2));

        
        ArrayList<String> act3 = new ArrayList<String>();
        act3.add("abs training;gain;10;Exercise_1;Description_1");
        act3.add("abs training;gain;10;Exercise_2;Description_2");
        act3.add("abs training;gain;10;Exercise_3;Description_3");
        act3.add("abs training;gain;10;Exercise_4;Description_4");
        act3.add("abs training;gain;10;Exercise_5;Description_5");
        act3.add("abs training;lose;10;Exercise_6;Description_6");
        act3.add("abs training;lose;10;Exercise_7;Description_7");
        act3.add("abs training;lose;10;Exercise_8;Description_8");
        act3.add("abs training;lose;10;Exercise_9;Description_9");
        act3.add("abs training;lose;10;Exercise_10;Description_10");
        physicalActivities.add(new PhysicalActivity("Abs Training", "gain weight: ex.[1-5] & lose weight: ex.[6-10]", act3));
        
        
        ArrayList<String> act4 = new ArrayList<String>();
        act4.add("cardio training;gain;10;Exercise_1;Description_1");
        act4.add("cardio training;gain;10;Exercise_2;Description_2");
        act4.add("cardio training;gain;10;Exercise_3;Description_3");
        act4.add("cardio training;gain;10;Exercise_4;Description_4");
        act4.add("cardio training;gain;10;Exercise_5;Description_5");
        act4.add("cardio training;lose;10;Exercise_6;Description_6");
        act4.add("cardio training;lose;10;Exercise_7;Description_7");
        act4.add("cardio training;lose;10;Exercise_8;Description_8");
        act4.add("cardio training;lose;10;Exercise_9;Description_9");
        act4.add("cardio training;lose;10;Exercise_10;Description_10");
        physicalActivities.add(new PhysicalActivity("Cardio", "gain weight: ex.[1-5] & lose weight: ex.[6-10]", act4));        
        
    }

    public static MockDatabase getInstance() {
        if (instance == null) {
            instance = new MockDatabase();
        }
        return instance;
    }
    
    public void addAUser(User user) {
        users.add(user);
    }

    public void addPhysicalActivity(PhysicalActivity physicalActivity) {
        physicalActivities.add(physicalActivity);
    }

    public void removeAUser(User user) {
        users.remove(user);
    }

    public static void removePhysicalActivity(PhysicalActivity phisicalActivity) {

    }

    public ArrayList<PhysicalActivity> getPhysicalActivities() {
        return physicalActivities;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

}
