/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.pi4.ejb;

import javax.ejb.Local;
import sp.senac.pi4.ejb.Entities.Aluguel;

/**
 *
 * @author vsantos
 */
@Local
public interface AluguelEJBLocal {
    public void devolucao(Aluguel aluguel);
}
