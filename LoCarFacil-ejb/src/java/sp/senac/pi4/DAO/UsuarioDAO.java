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
/**
 *
 * @author helenob
 */
public class UsuarioDAO {
    
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("user");
    
    public int isThereUser(){
        EntityManager em = factory.createEntityManager();
        //em.f
        //Person person = em.find(Person.class, 1);
        return 0;
    }
}
