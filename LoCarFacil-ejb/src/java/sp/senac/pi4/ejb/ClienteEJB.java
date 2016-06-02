/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.pi4.ejb;

import javax.ejb.Stateless;
import sp.senac.pi4.ejb.Entities.Cliente;

/**
 *
 * @author vsantos
 */
@Stateless
public class ClienteEJB implements ClienteEJBLocal {

    @Override
    public void cadastrarCliente(Cliente cliente){
        
    }

    @Override
    public void alterarCliente(Cliente cliente) {
        
    }

    @Override
    public void inativarCliente(Cliente cliente) {
        
    }
}
