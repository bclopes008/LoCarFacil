/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.pi4.bean;

import javax.ejb.EJB;
import sp.senac.pi4.ejb.ClienteEJBLocal;
import sp.senac.pi4.ejb.Entities.Cliente;


/**
 *
 * @author vinicius.vsantos
 */
public class ClienteBean {
    
    private Cliente cliente;
    
    @EJB
    private ClienteEJBLocal clienteEJB;
    /**
     * Creates a new instance of ClienteBean
     */
    public ClienteBean() {
        cliente = new Cliente();
    }
    
    public String cadastrar(){
        clienteEJB.cadastrarCliente(cliente);
        return "index.xhtml";
    }
    
    public String alterar(){
        clienteEJB.alterarCliente(cliente);
        return "index.xhtml";
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ClienteEJBLocal getClienteEJB() {
        return clienteEJB;
    }

    public void setClienteEJB(ClienteEJBLocal clienteEJB) {
        this.clienteEJB = clienteEJB;
    }
    
    
    
}
