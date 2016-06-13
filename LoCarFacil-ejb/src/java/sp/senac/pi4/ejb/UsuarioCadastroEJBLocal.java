/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.pi4.ejb;

import javax.ejb.Local;

/**
 *
 * @author BrunoWilliam
 */
@Local
public interface UsuarioCadastroEJBLocal {
    public boolean userRegister(String userLogin, String password, String passwordConfirmation);    
}
