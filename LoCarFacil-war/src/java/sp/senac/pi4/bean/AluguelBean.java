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
import sp.senac.pi4.ejb.ClienteEJBLocal;
import sp.senac.pi4.ejb.Entities.Aluguel;
import sp.senac.pi4.ejb.Entities.Carro;
import sp.senac.pi4.ejb.Entities.Filial;
import sp.senac.pi4.ejb.Entities.Grupo;
import sp.senac.pi4.ejb.FilialEJBLocal;
import sp.senac.pi4.ejb.GrupoEJBLocal;
import sp.senac.pi4.ejb.LoginEJBLocal;
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
    @EJB
    private LoginEJBLocal loginEJBLocal;
    @EJB
    private ClienteEJBLocal clienteEJB;
    
    private String user, password;

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
        this.aluguelWeb.setHorarioRetirada(this.aluguelWeb.getHoraRetirada() + ":" + this.aluguelWeb.getMinRetirada());
        this.aluguelWeb.setHorarioDevolucao(this.aluguelWeb.getHoraDevolucao() + ":" + this.aluguelWeb.getMinDevolucao());
        return "escolherGrupo";
    }

    public String carroSelecionado(int id, String grupo, String descricao, double valorGrupo, String img) {
    //public String carroSelecionado(String grupo, double valorGrupo) {
        this.aluguelWeb.setIdGrupo(id);
        this.aluguelWeb.setGrupo(grupo);
        this.aluguelWeb.setDescricao(descricao);
        this.aluguelWeb.setImg(img);
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
        identifica(0);
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
        return identifica(0);
    }

    public String localData() {
        return "localData";
    }

    /*ALTERADO*/ public void calculos() {
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
    }

    /*ALTERADO*/ public String resumo() {
        calculos();

        //Número aleatório
        Random gerador = new Random();
        do {
            this.aluguelWeb.setId(gerador.nextInt());
        } while (aluguelWeb.getId() < 1);
        Carro carro = new Carro(aluguelWeb.getIdGrupo());
        aluguel.setIdcarro(carro);
        aluguel.setIdcliente(clienteEJB.listarByName(user));
        aluguel.setDataentrega(aluguelWeb.getDataDevolucao());
        aluguel.setDataretirada(aluguelWeb.getDataRetirada());
        return "resumo.xhtml";
    }

    /*ALTERADO*/ public String identifica(int op) {
        calculos();
        if (op == 0) {
            return "protecao.xhtml?faces-redirect=true";
        } else {
            if(sessionContext.getAttribute("userName") != null){
                    return "resumo.xhtml";
                }
                else{
                    return "identificacaoAluguel.xhtml";
                }
        }
    }

    public String novaReserva() {
        aluguelWeb = new AluguelWeb();
        return "localData";
    }

    public String cadastrarAluguel() {
        aluguelEJB.cadastrarAluguel(aluguel);
        return "resumo";
    }

    public List<Grupo> getGrupos() {
        return grupoEJB.listar();
    }

    /*ALTERADO*/ public String loginValidationRental() {
        boolean isThere = loginEJBLocal.loginValidation(user, password);
        String pag;
        if (isThere == true) {
            pag = resumo();
        } else {
            pag = identifica(1);
        }
        return pag;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
