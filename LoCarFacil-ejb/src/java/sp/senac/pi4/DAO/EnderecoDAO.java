/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.pi4.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import sp.senac.pi4.ejb.Entities.Endereco;

/**
 *
 * @author BrunoWilliam
 */
public class EnderecoDAO {
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("LoCarFacil-ejbPU");
    EntityManager em = factory.createEntityManager();
    
    public boolean addressRegister(Endereco address){
        em.persist(address);
        System.out.println("444444444");
        return true;
    }
}
