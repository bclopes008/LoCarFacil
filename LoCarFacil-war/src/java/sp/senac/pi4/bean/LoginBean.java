/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.pi4.bean;

import java.util.ArrayList;
import javax.ejb.EJB;
import sp.senac.pi4.ejb.LoginEJB;
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
    private LoginEJB loginEjb;    
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

    public LoginEJB getLoginEjb() {
        return loginEjb;
    }

    public void setLoginEjb(LoginEJB loginEjb) {
        this.loginEjb = loginEjb;
    }
    
    
   public boolean loginValidation(){
       
       System.out.println("UM" + user);
       
       boolean isThere = loginEjb.loginValidation(user, password);
       return isThere;
   }
     
}
