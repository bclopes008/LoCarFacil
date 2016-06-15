/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.pi4.bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import sp.senac.pi4.ejb.SessionContext;

/**
 *
 * @author BrunoWilliam
 */
@ManagedBean
@SessionScoped
public class SessaoBean {
    
    @EJB
    private SessionContext sessionContext;
    
    public String getSession(){
        String name = (String) sessionContext.getAttribute("userName");        
        return name;
    }
    
    public String logout (){
        sessionContext.encerrarSessao();
        return "/identificarUsuario.xhtml";
    }
    
}
