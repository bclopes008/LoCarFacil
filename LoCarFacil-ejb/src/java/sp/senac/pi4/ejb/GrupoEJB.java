/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.pi4.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import sp.senac.pi4.ejb.Entities.Carro;
import sp.senac.pi4.ejb.Entities.Grupo;

/**
 *
 * @author b_c_l
 */
@Stateless
public class GrupoEJB implements GrupoEJBLocal {
    
    EntityManagerFactory emf;
    
    @Override
    public List<Grupo> listar() {
        EntityManager em = emf.createEntityManager();
        
        Query q = em.createNamedQuery("Grupo.findAll");
        
        return q.getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public Carro getIdCarro() {
        EntityManager em = emf.createEntityManager();
        
        Query q = em.createNativeQuery("SELECT Carro.* FROM Grupo "
                + "INNER JOIN Carro ON Carro.IDCARRO = GRUPO.IDGRUPO", Carro.class);
        
        return (Carro) q.getSingleResult();
    }
}
