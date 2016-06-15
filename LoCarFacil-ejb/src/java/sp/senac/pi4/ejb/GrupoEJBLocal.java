/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.pi4.ejb;

import java.util.List;
import javax.ejb.Local;
import sp.senac.pi4.ejb.Entities.Grupo;

/**
 *
 * @author b_c_l
 */
@Local
public interface GrupoEJBLocal {
    
    public List<Grupo> listar();
    
}
