/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.pi4.ejb;

import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author BrunoWilliam
 */
@Local
public interface PessoaCadastroEJBLocal {
    public boolean personRegister(String name, String cpf, String celPhone, String email, char genre, Date dateBirth);    
}
