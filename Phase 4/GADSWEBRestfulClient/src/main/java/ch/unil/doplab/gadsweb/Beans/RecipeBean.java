/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unil.doplab.gadsweb.Beans;

import ch.unil.doplab.gadsweb.Client.PersistenceClient;
import ch.unil.doplab.gadswebsite.exceptions.DoesNotExistException;
import ch.unil.doplab.gadswebsite.models.Recipe;
import ch.unil.doplab.gadswebsite.models.User;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Random;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 *
 * @author EMERY Guillaume, HORNUNG David, KERN Sophie, MUINO Adrian
 */
@Named(value = "RecipeBean")
@SessionScoped
public class RecipeBean implements Serializable {
    /**
     * Creates a new instance of RecipeBean
     */
private Integer recipenumber;


    public Integer getRecipenumber() {
        return recipenumber;
    }
    

    public void setRecipenumber(int min,int max) {
        this.recipenumber = generateBetween(min,max);
        
    }
    
    public List<Recipe> getRecipeUser() {
        User user = LoginBean.getUserLoggedIn();
        return PersistenceClient.getInstance().getAllRecipe(user.getIdUser());
    }
    
    
//FUNCTION
    public int generateBetween(int number, int max) {
    Random random = new Random();
    int generated = random.nextInt(max - number);
    return generated;
}
    
     public void generateRecipe() throws DoesNotExistException {
         User user = LoginBean.getUserLoggedIn();
         List<Recipe>  recipelist = PersistenceClient.getInstance().getAllRecipe(user.getIdUser());
         for (Recipe recipes : recipelist) {
         if (recipes.getIdrecipe().equals(recipenumber)) {
                PersistenceClient.getInstance().removeFromRecipe(user.getIdUser(), recipes.getIdrecipe());
         }
                }
//                add Recipe
         setRecipenumber(1,102);
         Recipe recipes = PersistenceClient.getInstance().getRecipeById(recipenumber);
         PersistenceClient.getInstance().addToRecipe(user.getIdUser(), recipes.getIdrecipe());
         getRecipeUser();
}
     
     
        }


