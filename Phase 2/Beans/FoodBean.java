/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unil.doplab.gadsweb.Beans;

import static ch.unil.doplab.gadswebsite.models.Food.getRecipe;
import ch.unil.doplab.gadswebsite.models.User;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author david
 */
@Named(value = "foodBean")
@SessionScoped
public class FoodBean implements Serializable {
    /**
     * Creates a new instance of FoodBean
     */
    
private String image;
private String description;
private String goal;
private String titre;
private String ingredient;
private ArrayList<String> test;

    public String getImage() {
        return image;
    }

    public String getGoal() {
        return goal;
    }

    public String getDescription() {
        return description;
    }

    public String getTitre() {
        return titre;
    }

    public String getIngredient() {
        return ingredient;
    }

    public ArrayList<String> getTest() {
        return test;
    }
    
    
    

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public void setTest(ArrayList<String> test) {
        this.test = test;
    }
    


    public static ArrayList<String> generateRecipes(String goal) {
     List b= new ArrayList<String>();
     List y =new ArrayList<String>();
     String c= "";
     b=getRecipe();
     c= b.toString();
     String[] d = c.split(";");
     int i=-1;
            while ( i < 18) {
                i=i+1;
            y.add(d[i]);
            
        }
        return (ArrayList<String>) y;
}
    public static int generateBetween(int number, int max) {
    Random random = new Random();
    int generated = random.nextInt(max - number);
    return generated;
}
    public void securesetGraphics() {
        User user = LoginBean.getUserLoggedIn();
    if (!user.getRecipe().isEmpty()){ 
        setGraphics();
    }else{
    this.titre="";
    this.image= "";
    this.ingredient="";
    this.description=""; 
    }
    }
    
      public void setGraphics() {
      User user = LoginBean.getUserLoggedIn();
      ArrayList<String> A= user.getRecipe();
      int d = generateBetween(1,5);
      int t=parseInt(A.get(1));
      int z=parseInt(A.get(7));
      int y=parseInt(A.get(13));
       if (d==t){
      this.titre=A.get(t+1);
      this.image= A.get(t+2);
      this.ingredient=A.get(t+3);
      this.description=A.get(t+4);
      this.test=A;
       }
       if (d==z){
      this.titre=A.get(z+6);
      this.image= A.get(z+7);
      this.ingredient=A.get(z+8);
      this.description=A.get(z+9);
       this.test=A;
       }
       if (d==y){     
      this.titre=A.get(y+11);
      this.image= A.get(y+12);
      this.ingredient=A.get(y+13);
      this.description=A.get(y+14);
       this.test=A;
       }
     }
}


