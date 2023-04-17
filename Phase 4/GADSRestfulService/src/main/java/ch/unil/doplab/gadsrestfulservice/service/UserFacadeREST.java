/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unil.doplab.gadsrestfulservice.service;

import ch.unil.doplab.gadswebsite.models.Achievement;
import ch.unil.doplab.gadswebsite.models.Recipe;
import ch.unil.doplab.gadswebsite.models.Trainingprogram;
import ch.unil.doplab.gadswebsite.models.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author EMERY Guillaume, HORNUNG David, KERN Sophie, MUINO Adrian
 */
@Stateless
@Path("ch.unil.doplab.gadsrestfulservice.user")
public class UserFacadeREST extends AbstractFacade<User> {

    @PersistenceContext(unitName = "gads_PU")
    private EntityManager em;

    public UserFacadeREST() {
        super(User.class);
    }

    @POST
    @Path("/create")
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(User entity) {
        super.create(entity);
    }

    @PUT
    @Path("/edit/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, User entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("/remove/{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("/find/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public User find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    

    @GET
    @Path("/findByName/{name}")
    public User findByName(@PathParam("name") String userName) {
        return super.findByName("User.findByUsername", "username", userName);
    }
    
    @GET
    @Path("/emailExists/{email}")
    public boolean emailExists(@PathParam("email") String email) {
        Query query = em.createNamedQuery("User.findByEmail");
        List<User> results = query.setParameter("email", email).getResultList();
        return results.size() == 1;
    }
    
//  Jointables Recipe
    
    @GET
    @Path("/getRecipe/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Recipe> getRecipe(@PathParam("id") Integer id) {
        return find(id).getRecipeList();
    }
    
    @GET
    @Path("/addToRecipe/{uId}/{fId}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void addToRecipe(@PathParam("uId") Integer uId, @PathParam("fId") Integer fId) {
        Recipe f = getEntityManager().find(Recipe.class, fId);
        User u = find(uId);
        u.getRecipeList().add(f);
        getEntityManager().merge(u);
    }
    
    @GET
    @Path("/removeFromRecipe/{uId}/{fId}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void removeFromRecipe(@PathParam("uId") Integer uId, @PathParam("fId") Integer fId) {
        Recipe f = getEntityManager().find(Recipe.class, fId);
        User u = find(uId);
        u.getRecipeList().remove(f);
        getEntityManager().merge(u);
    }
    
    //  Jointables Achievement
    
    @GET
    @Path("/getAchievement/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Achievement> getAchievement(@PathParam("id") Integer id) {
        return find(id).getAchievementLists();
    }

    @GET
    @Path("/addToAchievement/{uId}/{fId}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void addToAchievement(@PathParam("uId") Integer uId, @PathParam("fId") Integer fId) {
        Achievement f = getEntityManager().find(Achievement.class, fId);
        User u = find(uId);
        u.getAchievementLists().add(f);
        getEntityManager().merge(u);
    }
    
    @GET
    @Path("/removeFromAchievement/{uId}/{fId}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void removeFromAchievement(@PathParam("uId") Integer uId, @PathParam("fId") Integer fId) {
        Achievement f = getEntityManager().find(Achievement.class, fId);
        User u = find(uId);
        u.getAchievementLists().remove(f);
        getEntityManager().merge(u);
    }
    
    //  Jointables Trainingprogram
    
    @GET
    @Path("/getTrainingprogram/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Trainingprogram> getTrainingprogram(@PathParam("id") Integer id) {
        return find(id).getTrainingList();
    }
    
    @GET
    @Path("/getTrainingprogrambylegs/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Trainingprogram> getTrainingprogrambylegs(@PathParam("id") Integer id) {
        return find(id).getTrainingList();
    }
    
    @GET
    @Path("/addToTrainingprogram/{uId}/{fId}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void addToTrainingprogram(@PathParam("uId") Integer uId, @PathParam("fId") Integer fId) {
        Trainingprogram f = getEntityManager().find(Trainingprogram.class, fId);
        User u = find(uId);
        u.getTrainingList().add(f);
        getEntityManager().merge(u);
    }
    
    @GET
    @Path("/removeFromTrainingprogram/{uId}/{fId}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void removeFromTrainingprogram(@PathParam("uId") Integer uId, @PathParam("fId") Integer fId) {
        Trainingprogram f = getEntityManager().find(Trainingprogram.class, fId);
        User u = find(uId);
        u.getTrainingList().remove(f);
        getEntityManager().merge(u);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<User> findAll() {
        return super.findAll();
    }
}
