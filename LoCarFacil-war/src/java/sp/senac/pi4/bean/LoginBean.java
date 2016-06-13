/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.pi4.bean;

import java.util.ArrayList;
import javax.ejb.EJB;
import sp.senac.pi4.ejb.LoginEJBLocal;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author BrunoWilliam
 */
@ManagedBean
@SessionScoped
public class LoginBean {
    
    @EJB
    private LoginEJBLocal loginEJBLocal;    
    private String user, password;
    
    public void fazerLogin()
    {
        System.out.println("consegui!" + user + " - " + password);
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public LoginEJBLocal getLoginEjb() {
        return loginEJBLocal;
    }

    public void setLoginEjb(LoginEJBLocal loginEjb) {
        this.loginEJBLocal = loginEjb;
    }
    
    
   public String loginValidation(){       
       System.out.println("UM" + user);       
       boolean isThere = loginEJBLocal.loginValidation(user, password);
       if(isThere == true){
           return "/protecao.xhtml";
       }
       else{
           return "/identificarUsuario.xhtml";
       }
       
   }
     
}
