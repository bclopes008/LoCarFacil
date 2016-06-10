/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.pi4.DAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import sp.senac.pi4.ejb.Entities.Usuario;
/**
 *
 * @author helenob
 */
public class UsuarioDAO {
    
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("LoCarFacil-ejbPU");
    
    public List isThereUser(String user, String password){        
        EntityManager em = factory.createEntityManager();
        //em.getTransaction().begin();
        List<String> users = new ArrayList<String>();
        //users = em.createQuery("SELECT c.loginuser, c.idpessoa FROM Usuario AS c WHERE c.loginuser = :user").setParameter("user", user).getResultList();
        users.add(user);
        users.add(password);
        //em.getTransaction().commit();        
        return users;
    }
}
