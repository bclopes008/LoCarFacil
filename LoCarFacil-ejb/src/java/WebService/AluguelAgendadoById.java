/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sp.senac.pi4.ejb.Entities.Aluguel;

/**
 *
 * @author vinicius.vsantos
 */
@WebService(serviceName = "AluguelAgendadoById")
@Stateless()
public class AluguelAgendadoById {

    @PersistenceContext
    private EntityManager em;

    /**
     * Operação de Web service
     *
     * @param id do aluguel solicitado pelo sistema LoCarFacil
     * @return Aluguel com os dados agendados pelo sistema LoCarFacil
     */
    @WebMethod(operationName = "AluguelAgendadoById")
    public Aluguel getAluguelById(@WebParam(name = "IdAluguel") int id) {
        Query q = em.createNamedQuery("Aluguel.findByIdaluguel");
        q.setParameter(1, id);
        return (Aluguel) q.getSingleResult();
    }

    /**
     * Operação de Web service
     */
}
