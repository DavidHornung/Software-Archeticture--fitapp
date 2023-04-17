/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unil.doplab.gadsrestfulservice.service;


import ch.unil.doplab.gadswebsite.models.Trainingprogram;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
 * @author david
 */
@Stateless
@Path("ch.unil.doplab.gadsrestfulservice.trainingprogram")
public class TrainingprogramFacadeREST extends AbstractFacade<Trainingprogram> {

    @PersistenceContext(unitName = "gads_PU")
    private EntityManager em;

    public TrainingprogramFacadeREST() {
        super(Trainingprogram.class);
    }

    @POST
    @Path("/create")
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Trainingprogram entity) {
        super.create(entity);
    }

    @PUT
    @Path("/edit/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Trainingprogram entity) {
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
    public Trainingprogram find(@PathParam("id") Integer id) {
        return super.find(id);
    }
    
    @GET
    @Path("/findByLegs/{legs}/{goal}")
    public Trainingprogram findByLegs(@PathParam("legs") String legs, 
            @PathParam("goal") String goal) {
        return super.findByNames("Trainingprogram.findByLegs", "legs",legs,"goal",goal);
    }
    
    @GET
    @Path("/findByArms/{arms}/{goal}")
    public Trainingprogram findByArms(@PathParam("arms") String arms, 
            @PathParam("goal") String goal) {
        return super.findByNames("Trainingprogram.findByArms", "arms",arms,"goal",goal);
    }
    
    @GET
    @Path("/findByAbs/{abs}/{goal}")
    public Trainingprogram findByAbs(@PathParam("abs") String abs, 
            @PathParam("goal") String goal) {
        return super.findByNames("Trainingprogram.findByAbs", "abs",abs,"goal",goal);
    }
    
    @GET
    @Path("/findByCardio/{cardio}/{goal}")
    public Trainingprogram findByCardio(@PathParam("cardio") String cardio, 
            @PathParam("goal") String goal) {
        return super.findByNames("Trainingprogram.findByCardio", "cardio",cardio,"goal",goal);
    }
    
    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Trainingprogram> findAll() {
        return super.findAll();
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
