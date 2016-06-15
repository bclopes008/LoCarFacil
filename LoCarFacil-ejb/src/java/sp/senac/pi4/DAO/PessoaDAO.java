/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.pi4.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import sp.senac.pi4.ejb.Entities.Pessoa;
import sp.senac.pi4.ejb.Entities.Usuario;

/**
 *
 * @author BrunoWilliam
 */
public class PessoaDAO {
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("LoCarFacil-ejbPU");
    
    EntityManager em = factory.createEntityManager();
    
//    public Pessoa personData(int idPerson){
//        return em.createNamedQuery("Pessoa.findByIdpessoa", Pessoa.class).setParameter("idpessoa", idPerson).getSingleResult();                
//    }
    
    public int personRegister(Pessoa person){        
        em.persist(person);
        person = returnPersonByCpf(person);
        return person.getIdpessoa();
    }
    public Pessoa returnPersonByCpf(Pessoa person){
        Query query;
        query = em.createNamedQuery("Pessoa.findByCpf", Pessoa.class);
        query.setParameter("cpf", person.getCpf());
        person = (Pessoa) query.getSingleResult();
        return person;
    }
    
        public Pessoa returnPersonById(Usuario user){
        Query query;
        query = em.createNamedQuery("Pessoa.findByIdpessoa", Pessoa.class);
        query.setParameter("idpessoa", user.getIdpessoa());
        return (Pessoa) query.getSingleResult();
    }
}
