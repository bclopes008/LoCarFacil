/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.pi4.ejb;

import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 *
 * @author BrunoWilliam
 */
@Stateless
public class LoginEJB implements LoginEJBLocal {

    public boolean loginValidation(String user, String password){
        //procurar aqui no banco e retornar o codigo da pessoa
            //procurar a pessoa e trazer o nome, id e tipo de pessoa
            
        ArrayList<String> person = new ArrayList<String>();
        person.add("2");
        person.add("William");
        person.add("Manager");
        
        return true;
    }
    
    
    
}
