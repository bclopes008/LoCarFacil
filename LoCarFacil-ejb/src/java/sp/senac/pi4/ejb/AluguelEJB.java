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
import sp.senac.pi4.ejb.Entities.Aluguel;

/**
 *
 * @author vsantos
 */
@Stateless
public class AluguelEJB implements AluguelEJBLocal {
    private EntityManagerFactory emf;

    @Override
    public List<Aluguel> listar() {
        EntityManager em = emf.createEntityManager();
        try{
            Query q = em.createNamedQuery("Aluguel.findAll");
            
            return q.getResultList();
        }finally {
            em.close();
        }
    }

    @Override
    public void cadastrarAluguel(Aluguel aluguel) {
        EntityManager em = emf.createEntityManager();
        try{
            em.persist(aluguel);
        } finally {
            em.close();
        }
    }

    @Override
    public void devolucaoAluguel(Aluguel aluguel) {
        EntityManager em = emf.createEntityManager();
        try{
            em.merge(aluguel);
        } finally{
            em.close();
        }
    }

    @Override
    public void alterarAluguel(Aluguel aluguel) {
        EntityManager em = emf.createEntityManager();
        em.merge(aluguel);
    }

}
