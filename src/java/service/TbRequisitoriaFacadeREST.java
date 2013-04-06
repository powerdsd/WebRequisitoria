/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.TbRequisitoria;
//import domain.TbRequisitoria_;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author u05521
 */
@Stateless
@Path("domain.tbrequisitoria")
public class TbRequisitoriaFacadeREST extends AbstractFacade<TbRequisitoria> {
    @PersistenceContext(unitName = "WebRequisitoriaPU")
    private EntityManager em;

    public TbRequisitoriaFacadeREST() {
        super(TbRequisitoria.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(TbRequisitoria entity) {
        super.create(entity);
    }

    @PUT
    @Override
    @Consumes({"application/xml", "application/json"})
    public void edit(TbRequisitoria entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public TbRequisitoria find(@PathParam("id") Integer id) {
        return super.find(id);
    }
    
    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<TbRequisitoria> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<TbRequisitoria> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }
    

    @GET
    @Path("{dni}") 
//  @Produces({"application/json"})  solo permite text/xml
    public List<TbRequisitoria> findByDni(@PathParam("dni") String dni) {
    CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
    CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
    Root<TbRequisitoria> c = criteriaQuery.from(TbRequisitoria.class);
    criteriaQuery.select(c);
    criteriaQuery.where(criteriaBuilder.equal(c.get("dniPersona"), dni));
                       
        return getEntityManager().createQuery(criteriaQuery).getResultList();
    }  
/*
CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
CriteriaQuery cq = cb.createQuery();
Root<T> c = cq.from(entityClass);
cq.select(c);
cq.where(cb.gt(c.get("status"), 1));
return getEntityManager().createQuery(cq).getResultList();
*/
 
    
    
    
@GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
/*prueba
    @GET
    @Path("{dniPersona}")
    @Override 
    @Produces({"application/xml", "application/json"})
    public List<TbRequisitoria> getRequisitoriasPorDni(
           @PathParam("dni") String dniPersona ) {
        return super.findByDniPersona(dniPersona);
    }
    */ 
    
}
