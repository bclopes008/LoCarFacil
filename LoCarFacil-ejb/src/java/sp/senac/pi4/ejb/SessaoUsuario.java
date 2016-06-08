/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.pi4.ejb;

import javax.ejb.Stateless;

/**
 *
 * @author BrunoWilliam
 */
@Stateless
public class SessaoUsuario implements SessaoUsuarioLocal {

    public static boolean createUserSession(String name, String type, int idUser){
        
        //criar sessão das coisas aqui.
        
        return true;
    }
}
