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
import sp.senac.pi4.ejb.Entities.Filial;

/**
 *
 * @author b_c_l
 */
@Stateless
public class FilialEJB implements FilialEJBLocal {
    
    EntityManagerFactory emf;
    
    @Override
    public List<Filial> listar() {
        EntityManager em = emf.createEntityManager();
        
        Query q = em.createNamedQuery("Filial.findAll");
        
        return q.getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
