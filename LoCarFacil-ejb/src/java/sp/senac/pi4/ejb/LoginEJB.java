/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.pi4.ejb;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import sp.senac.pi4.DAO.UsuarioDAO;

/**
 *
 * @author BrunoWilliam
 */
@Stateless
public class LoginEJB implements LoginEJBLocal {
        
    @Override
    public boolean loginValidation(String user, String password){
        System.out.println(user + "CARALHO" + password);
        UsuarioDAO userDAO = new UsuarioDAO();
        List<String> users = new ArrayList<String>();
        users = userDAO.isThereUser(user,password);
        //if(!users.isEmpty()){
            String name = users.get(0);
            System.out.println(users.get(0) + "Chegou");
            String id = users.get(1);
            return true;
        //}
        //else{
          //  return false;
        //}        
    }
    

    
    
}
