/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.pi4.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;
//import javax.persistence.PersistenceContext;
import sp.senac.pi4.ejb.Entities.Cliente;

/**
 *
 * @author vsantos
 */
@Stateless

public class ClienteEJB implements ClienteEJBLocal {
    //@PersistenceContext()
    private EntityManager em;
    
    @Override
    public void cadastrarCliente(Cliente cliente){
        em.persist(cliente);
    }

    @Override
    public void alterarCliente(Cliente cliente) {
        em.merge(cliente);
    }

    @Override
    public void inativarCliente(Cliente cliente) {
        em.detach(cliente);
    }

    @Override
    public Cliente listarByName(String nome) {
        Query q = em.createNamedQuery("Cliente.findByName", Cliente.class);
        q.setParameter(1, nome);
        
        return (Cliente) q.getSingleResult();
    }
}
