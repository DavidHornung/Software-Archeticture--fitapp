/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unil.doplab.gadswebsite.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author david
 */
@Entity
@Table(name = "recipe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recipe.findAll", query = "SELECT r FROM Recipe r"),
    @NamedQuery(name = "Recipe.findByIdrecipe", query = "SELECT r FROM Recipe r WHERE r.idrecipe = :idrecipe")})
public class Recipe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDRECIPE")
    private Integer idrecipe;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "RECIPETITEL")
    private String recipetitel;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "RECIPEIMAGE")
    private String recipeimage;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "RECIPEINGREDIENT")
    private String recipeingredient;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "RECIPEDESCRIPTION")
    private String recipedescription;
    @ManyToMany(mappedBy = "RecipeList")
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
    
    @XmlTransient
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrecipe != null ? idrecipe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recipe)) {
            return false;
        }
        Recipe other = (Recipe) object;
        if ((this.idrecipe == null && other.idrecipe != null) || (this.idrecipe != null && !this.idrecipe.equals(other.idrecipe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ch.unil.doplab.gadswebsite.models.Recipe[ idrecipe=" + idrecipe + " ]";
    }
    // Function
    
    
    
    
    
}
