/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.pi4.ejb;

import javax.ejb.Local;
import javax.ejb.Stateless;
import sp.senac.pi4.DAO.EnderecoDAO;
import sp.senac.pi4.ejb.Entities.Cliente;
import sp.senac.pi4.ejb.Entities.Endereco;

/**
 *
 * @author BrunoWilliam
 */
@Stateless
@Local(EnderecoCadastroEJBLocal.class)
public class EnderecoCadastroEJB implements EnderecoCadastroEJBLocal {
    
    @Override
    public boolean addressRegister(String cep, String street, String compl, String city, String streetType, String number, String neigh, String state, int idPerson){
        Endereco address = new Endereco();
        EnderecoDAO addressDAO = new EnderecoDAO();
        address.setIdcliente(idPerson);
        address.setCep(cep);
        address.setBairro(neigh);
        address.setNumero(number);
        address.setLogradouro(street);
        address.setComplemento(compl);
        address.setCidade(city);
        address.setTipoendereco(streetType);
        address.setEstado(state);
        return addressDAO.addressRegister(address);
        
    }

}
