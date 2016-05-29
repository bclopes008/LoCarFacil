/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.pi4.bean;

import sp.senac.pi4.entidades.Aluguel;
import sp.senac.pi4.util.Mensagem;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

/**
 *
 * @author bruno.lopes
 */
@ManagedBean
@SessionScoped
public class AluguelBean {

    private Aluguel aluguel;

    public AluguelBean() {
        aluguel = new Aluguel();
    }

    public Aluguel getAluguel() {
        return aluguel;
    }

    public void setAluguel(Aluguel aluguel) {
        this.aluguel = aluguel;
    }

    public String escolherGrupo() {
        return "escolherGrupo";
    }

    public String carroSelecionado(String grupo, double valorGrupo) {
        this.aluguel.setGrupo(grupo);
        this.aluguel.setValorGrupo(new BigDecimal(valorGrupo));
        //parei aqui
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        Date data = aluguel.getDataRetirada();
        String dtRt = fmt.format(data);
        dtRt = dtRt.substring(0, 2);
        int diaRet = Integer.parseInt(dtRt);
        
        data = aluguel.getDataDevolucao();
        String dtDv = fmt.format(data);
        dtDv = dtDv.substring(0, 2);
        int diaDev = Integer.parseInt(dtDv);
        this.aluguel.setDias((diaDev - diaRet) + 1);
        resumo(0);
        return "escolherGrupo.xhtml?faces-redirect=true";
    }

    public String protecao() {
        if (aluguel.getGrupo() == null) {
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
        double assElev = aluguel.getAssElev() * 15 * aluguel.getDias();
        double bbConf = aluguel.getBbConf() * 15 * aluguel.getDias();
        double cadBb = aluguel.getCadBB() * 15 * aluguel.getDias();
        double gps = aluguel.getQtdGps() * 15 * aluguel.getDias();
        this.aluguel.setValorAssElev(new BigDecimal(assElev));
        this.aluguel.setValorBbConf(new BigDecimal(bbConf));
        this.aluguel.setValorCadBB(new BigDecimal(cadBb));
        this.aluguel.setValorGps(new BigDecimal(gps));
        //parei aqui
        double vTotal = aluguel.getValorGrupo().doubleValue() * aluguel.getDias();
        this.aluguel.setValTotalGrupo(new BigDecimal(vTotal));
        
        this.aluguel.setValorTotal(new BigDecimal(assElev + bbConf + cadBb + gps + vTotal));
        System.err.println(aluguel.getValorTotal());
        
        //Número aleatório
        Random gerador = new Random();
        do{
            this.aluguel.setId(gerador.nextInt());
        }while (aluguel.getId() < 1);
        if (op == 0) {
            return "protecao.xhtml?faces-redirect=true";
        } else {
            return "resumo";
        }
    }

    public String novaReserva() {
        aluguel = new Aluguel();
        return "localData";
    }

}
