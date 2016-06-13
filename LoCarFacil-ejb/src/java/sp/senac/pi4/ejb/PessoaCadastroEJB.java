/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.pi4.ejb;

import java.util.Date;
import javax.ejb.Local;
import javax.ejb.Stateless;
import sp.senac.pi4.DAO.PessoaDAO;
import sp.senac.pi4.ejb.Entities.Pessoa;

/**
 *
 * @author BrunoWilliam
 */
@Stateless
@Local(PessoaCadastroEJBLocal.class)
public class PessoaCadastroEJB implements PessoaCadastroEJBLocal {
    
@Override
public boolean personRegister(String name, String cpf, String celPhone, String email, char genre, Date dateBirth){
    System.out.println("veio");
    Pessoa person = new Pessoa();
    PessoaDAO personDAO = new PessoaDAO();
    person.setNome(name);
    person.setCpf(cpf);
    person.setEmail(email);
    person.setCelular(celPhone);
    person.setSexo(genre);
    person.setDatanascimento(dateBirth);
    return personDAO.personRegister(person);
}

}
