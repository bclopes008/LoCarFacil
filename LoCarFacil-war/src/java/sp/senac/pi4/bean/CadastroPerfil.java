/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.pi4.bean;

import java.util.Date;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import sp.senac.pi4.ejb.UsuarioCadastroEJB;
import sp.senac.pi4.ejb.UsuarioCadastroEJBLocal;
import sp.senac.pi4.ejb.EnderecoCadastroEJBLocal;
import sp.senac.pi4.ejb.PessoaCadastroEJBLocal;

/**
 *
 * @author BrunoWilliam
 */

@ManagedBean
@SessionScoped
public class CadastroPerfil {
    
    @EJB
    private UsuarioCadastroEJBLocal usuarioCadastroEJBLocal;
    @EJB
    private PessoaCadastroEJBLocal pessoaCadastroEJBLocal;
    @EJB
    private EnderecoCadastroEJBLocal enderecoCadastroEJBLocal;
    private String user, password, passwordConfirmation;        
    
    private String name, cpf, celPhone, email;
    private char genre;
    private Date dateBirth = new Date();

    String cep, street, compl, city, streetType, number, neigh, state;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCompl() {
        return compl;
    }

    public void setCompl(String compl) {
        this.compl = compl;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetType() {
        return streetType;
    }

    public void setStreetType(String streetType) {
        this.streetType = streetType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNeigh() {
        return neigh;
    }

    public void setNeigh(String neigh) {
        this.neigh = neigh;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    public char getGenre() {
        return genre;
    }

    public void setGenre(char genre) {
        this.genre = genre;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCelPhone() {
        return celPhone;
    }

    public void setCelPhone(String celPhone) {
        this.celPhone = celPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String userRegister(){        
        System.out.println("rrrrr");
        boolean userRegister = pessoaCadastroEJBLocal.personRegister(name, cpf, celPhone, email, genre, dateBirth);
        if(userRegister == true){
            System.out.println(cep + " " + street+ " " + compl + " " +city+ " " + streetType + " " +number+ " " + neigh + " " + state);
            userRegister = enderecoCadastroEJBLocal.addressRegister(cep, street, compl, city, "", number, neigh, "");
            userRegister = usuarioCadastroEJBLocal.userRegister(user, password, passwordConfirmation);
       }
        return "/identificarUsuario.xhtml";        
    }
    
}
