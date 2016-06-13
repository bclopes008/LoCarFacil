/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.pi4.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import sp.senac.pi4.ejb.Entities.Pessoa;

/**
 *
 * @author BrunoWilliam
 */
public class PessoaDAO {
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("LoCarFacil-ejbPU");
    
    EntityManager em = factory.createEntityManager();
    
    public Pessoa personData(int idPerson){
        return em.createNamedQuery("Pessoa.findByIdpessoa", Pessoa.class).setParameter("idpessoa", idPerson).getSingleResult();                
    }
    
    public boolean personRegister(Pessoa person){
        em.persist(person);
        person = em.merge(person);
        System.out.println(person.getIdpessoa() + "IDIIIIIIIIIIIIIIIIIIII!!!!!!!!!!");
        return true;
    }
}
