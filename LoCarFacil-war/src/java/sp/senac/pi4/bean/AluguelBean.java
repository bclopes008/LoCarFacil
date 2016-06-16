/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.pi4.bean;

import sp.senac.pi4.entidades.AluguelWeb;
import sp.senac.pi4.util.Mensagem;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import sp.senac.pi4.ejb.AluguelEJB;
import sp.senac.pi4.ejb.AluguelEJBLocal;
import sp.senac.pi4.ejb.Entities.Aluguel;
import sp.senac.pi4.ejb.Entities.Filial;
import sp.senac.pi4.ejb.Entities.Grupo;
import sp.senac.pi4.ejb.FilialEJBLocal;
import sp.senac.pi4.ejb.GrupoEJBLocal;
import sp.senac.pi4.ejb.SessionContext;

/**
 *
 * @author bruno.lopes
 */
@ManagedBean
@SessionScoped
public class AluguelBean {

    private AluguelWeb aluguelWeb;
    private Aluguel aluguel;
    private Filial filial;
    private Grupo grupo;
    
    @EJB
    private SessionContext sessionContext;    
    @EJB
    private AluguelEJBLocal aluguelEJB;
    @EJB
    private FilialEJBLocal filialEJB;
    @EJB
    private GrupoEJBLocal grupoEJB;

    public AluguelBean() {
        aluguelWeb = new AluguelWeb();
    }

    public AluguelWeb getAluguel() {
        return aluguelWeb;
    }

    public void setAluguel(AluguelWeb aluguel) {
        this.aluguelWeb = aluguel;
    }

    public String escolherGrupo() {
        return "escolherGrupo";
    }

    public String carroSelecionado(String grupo, double valorGrupo) {
        this.aluguelWeb.setGrupo(grupo);
        this.aluguelWeb.setValorGrupo(new BigDecimal(valorGrupo));
        //parei aqui
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        Date data = aluguelWeb.getDataRetirada();
        String dtRt = fmt.format(data);
        dtRt = dtRt.substring(0, 2);
        int diaRet = Integer.parseInt(dtRt);
        
        data = aluguelWeb.getDataDevolucao();
        String dtDv = fmt.format(data);
        dtDv = dtDv.substring(0, 2);
        int diaDev = Integer.parseInt(dtDv);
        this.aluguelWeb.setDias((diaDev - diaRet) + 1);
        resumo(0);
        return "escolherGrupo.xhtml?faces-redirect=true";
    }

    public String protecao() {
        if (aluguelWeb.getGrupo() == null) {
            // Mensagem de sucesso para usuário
            Flash flash = FacesContext.getCurrentInstance()
                    .getExternalContext().getFlash();
            flash.put("mensagem", new Mensagem("erro", "error"));
            return "escolherGrupo";
        }
        return resumo(0);
    }

    public String localData() {
        return "localData";
    }

    public String resumo(int op) {
        double assElev = aluguelWeb.getAssElev() * 15 * aluguelWeb.getDias();
        double bbConf = aluguelWeb.getBbConf() * 15 * aluguelWeb.getDias();
        double cadBb = aluguelWeb.getCadBB() * 15 * aluguelWeb.getDias();
        double gps = aluguelWeb.getQtdGps() * 15 * aluguelWeb.getDias();
        this.aluguelWeb.setValorAssElev(new BigDecimal(assElev));
        this.aluguelWeb.setValorBbConf(new BigDecimal(bbConf));
        this.aluguelWeb.setValorCadBB(new BigDecimal(cadBb));
        this.aluguelWeb.setValorGps(new BigDecimal(gps));
        //parei aqui
        double vTotal = aluguelWeb.getValorGrupo().doubleValue() * aluguelWeb.getDias();
        this.aluguelWeb.setValTotalGrupo(new BigDecimal(vTotal));
        
        this.aluguelWeb.setValorTotal(new BigDecimal(assElev + bbConf + cadBb + gps + vTotal));
        System.err.println(aluguelWeb.getValorTotal());
        
        
        //Número aleatório
        Random gerador = new Random();
        do{
            this.aluguelWeb.setId(gerador.nextInt());
        }while (aluguelWeb.getId() < 1);
        
        
            if (op == 0) {
                return "protecao.xhtml?faces-redirect=true";
            } else {
                if(sessionContext.getAttribute("userName") != null){
                    return "resumo.xhtml";
                }
                else{
                    return "identificarUsuario.xhtml";
                }
            }
        
    }

    public String novaReserva() {
        aluguelWeb = new AluguelWeb();
        return "localData";
    }
    
    public String cadastrarAluguel(){
        aluguelEJB.cadastrarAluguel(aluguel);
        return "resumo.xhtml";
    }

    public List<Grupo> getGrupos(){
        return grupoEJB.listar();
    }
    
}
