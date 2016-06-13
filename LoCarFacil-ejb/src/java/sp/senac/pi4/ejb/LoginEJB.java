/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.pi4.ejb;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import sp.senac.pi4.DAO.PessoaDAO;
import sp.senac.pi4.DAO.UsuarioDAO;
import sp.senac.pi4.ejb.Entities.Pessoa;
import sp.senac.pi4.ejb.Entities.Usuario;

/**
 *
 * @author BrunoWilliam
 */
@Stateless
@Local(LoginEJBLocal.class)
public class LoginEJB implements LoginEJBLocal {
        
    @Override
    public boolean loginValidation(String user, String password){
        System.out.println(user + "CARALHO" + password);
        UsuarioDAO userDAO = new UsuarioDAO();
        PessoaDAO personDAO = new PessoaDAO();
        Usuario userData; 
        Pessoa person = new Pessoa();
        userData = (Usuario) userDAO.isThereUser(user,password);
        if(userData != null){
            if(userData.getIdpessoa() > 0){
                person = personDAO.personData(userData.getIdpessoa());
                createSession(person);
                return true;
            }        
        }
        return false;           
    }
    
    public void createSession(Pessoa person){
        SessionContext.getInstance().setAttribute("userName", person.getNome());
        SessionContext.getInstance().setAttribute("userId", person.getIdpessoa());        
    }    
}
