/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unil.doplab.gadswebsite.models;


import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author david
 */
@XmlRootElement
public class Recipe{

    
    private Integer idrecipe;  
    private String recipetitel;
    private String recipeimage;
    private String recipeingredient;
    private String recipedescription;
    private List<User> userList;
    
    public Recipe() {
    }

    public Recipe(Integer idrecipe) {
        this.idrecipe = idrecipe;
    }

    public Integer getIdrecipe() {
        return idrecipe;
    }

    public void setIdrecipe(Integer idrecipe) {
        this.idrecipe = idrecipe;
    }

    public String getRecipetitel() {
        return recipetitel;
    }

    public void setRecipetitel(String recipetitel) {
        this.recipetitel = recipetitel;
    }

    public String getRecipeimage() {
        return recipeimage;
    }

    public void setRecipeimage(String recipeimage) {
        this.recipeimage = recipeimage;
    }

    public String getRecipeingredient() {
        return recipeingredient;
    }

    public void setRecipeingredient(String recipeingredient) {
        this.recipeingredient = recipeingredient;
    }

    public String getRecipedescription() {
        return recipedescription;
    }

    public void setRecipedescription(String recipedescription) {
        this.recipedescription = recipedescription;
    }
    
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
    
}
