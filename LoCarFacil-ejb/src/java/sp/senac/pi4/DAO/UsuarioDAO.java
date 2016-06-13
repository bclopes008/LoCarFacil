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
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import sp.senac.pi4.ejb.Entities.Usuario;
/**
 *
 * @author helenob
 */
public class UsuarioDAO {
    
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("LoCarFacil-ejbPU");
    private EntityManager em = factory.createEntityManager();
    
    public Usuario isThereUser(String user, String password){        
        try {            
            System.out.println("JPA");       
            Query query = em.createNamedQuery("Usuario.findByLoginuserPassword", Usuario.class);
            query.setParameter("loginuser", user);
            query.setParameter("senha", password);
            Usuario usuario = new Usuario();
            usuario = (Usuario)query.getSingleResult();
            return usuario;
        } catch (NoResultException e) {
            System.out.println("Sem resultado!");
            return null;
        }
    }
    
    public boolean userRegister(Usuario user){
        em.persist(user); 
        return true;
    }
}
