/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.pi4.ejb;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import sp.senac.pi4.DAO.UsuarioDAO;
import sp.senac.pi4.ejb.Entities.Usuario;

/**
 *
 * @author BrunoWilliam
 */
@Stateless
@Local(UsuarioCadastroEJBLocal.class)
public class UsuarioCadastroEJB implements UsuarioCadastroEJBLocal {

    @Override
    public boolean userRegister(String userLogin, String password, String passwordConfirmation){
        if(password.equals(passwordConfirmation)){
            Usuario user = new Usuario();
            UsuarioDAO userDAO = new UsuarioDAO();
            user.setLoginuser(userLogin);
            user.setSenha(password);
            user.setIdpessoa(2);
            System.out.println("Chegou aqui");
            return userDAO.userRegister(user);
        }
        else{
            return false;
        }
    }
    
}
