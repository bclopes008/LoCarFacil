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
public interface EnderecoCadastroEJBLocal {
    public boolean addressRegister(String cep, String street, String compl, String city, String streetType, String number, String neigh, String state);
}
