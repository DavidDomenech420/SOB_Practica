/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import model.entities.Prompt;
import service.dto.PromptDetailDTO;
import service.dto.PromptSummaryDTO;

/**
 *
 * @author Kei
 */
@Stateless
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("prompt")
public class PromptFacadeREST extends AbstractFacade<Prompt>{
    @PersistenceContext(unitName = "Homework1PU") private EntityManager em;

    public PromptFacadeREST() {
        super(Prompt.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @GET
    public Response getPrompt(@QueryParam("author") String author, @QueryParam("tag") String tag){
        StringBuilder jpql = new StringBuilder("SELECT DISTINCT p FROM Prompt p WHERE 1=1");
        
        if( author != null && !author.trim().isEmpty()){
            jpql.append(" AND p.author.username = :author");
        }
        
        if( tag != null && !tag.trim().isEmpty()){
            jpql.append(" AND :tag MEMBER OF p.tags");
        }
        
        jpql.append(" ORDER BY p.title ASC");
        
        TypedQuery<Prompt> query = em.createQuery(jpql.toString(), Prompt.class);
        if( author != null && !author.trim().isEmpty()){
            query.setParameter("author", author);
        }
        
        if( tag != null && !tag.trim().isEmpty()){
            query.setParameter("tag", tag);
        }
        
        List<Prompt> resultQuery = query.getResultList();
        List<Object> result = new ArrayList<>();
        
        for (Prompt prompt: resultQuery){
            if (prompt.isIsPrivate()) {
                result.add(new PromptSummaryDTO(prompt));
            }
            else {
                result.add(new PromptDetailDTO(prompt));
            }
        }
        
        return Response.ok(result).build();
    }
    
    
}
