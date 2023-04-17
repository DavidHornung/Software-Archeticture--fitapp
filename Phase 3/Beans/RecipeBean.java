/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unil.doplab.gadsweb.Beans;

import ch.unil.doplab.gadswebsite.exceptions.DoesNotExistException;
import ch.unil.doplab.gadswebsite.models.Recipe;
import ch.unil.doplab.gadswebsite.models.User;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
@PersistenceContext(unitName = "gads_PU")
private EntityManager em;
private Integer recipenumber;


    public Integer getRecipenumber() {
        return recipenumber;
    }
    

    public void setRecipenumber(int min,int max) {
        this.recipenumber = generateBetween(min,max);
    }
    
    
//FUNCTION
    public int generateBetween(int number, int max) {
    Random random = new Random();
    int generated = random.nextInt(max - number);
    return generated;
}
    @Transactional
    public Recipe findRecipebyID(Integer idrecipe) throws DoesNotExistException {
        Query query = em.createNamedQuery("Recipe.findByIdrecipe");
        List<Recipe> recipe = query.setParameter("idrecipe",idrecipe).getResultList();
        if (recipe.size() > 0) {
            return recipe.get(0);
        }
        throw new DoesNotExistException(""+query);
    }    
    @Transactional
     public void generateRecipe() throws DoesNotExistException {
         User user = LoginBean.getUserLoggedIn();
         if(doesRecipeExistInTheCloud(recipenumber)) {
                Recipe recipe1 = findRecipebyID(recipenumber);
                List uList = user.getRecipeList();
                uList.remove(recipe1);
                em.merge(user);}
        try {
            setRecipenumber(1,102);
            Recipe recipes = findRecipebyID(recipenumber);
            user.getRecipeList().add(recipes);
            em.merge(user);
            }
        catch (DoesNotExistException recipes) {
            System.out.println(recipes.getMessage());
        }
}
     
     private boolean doesRecipeExistInTheCloud(Integer number) {
        try {
            return findRecipebyID(number) != null;
        } catch (DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
        }


