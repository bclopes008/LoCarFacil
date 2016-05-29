/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.pi4.entidades;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author bruno.lopes
 */
public class Aluguel {
    
    private int id;
    private String localizacaoRetirada;
    private Date dataRetirada;
    private String horaRetirada;
    private String localizacaoDevolucao;
    private Date dataDevolucao;
    private String horaDevolucao;
    private String grupo;
    private boolean protecao;
    private int bbConf = 0;
    private int assElev = 0;
    private int cadBB = 0;
    private int qtdGps = 0;
    private int dias;
    private String selectAcessorios;
    private BigDecimal valorBbConf;
    private BigDecimal valorAssElev;
    private BigDecimal valorCadBB;
    private BigDecimal valorGps;
    private BigDecimal valorTotal;
    private BigDecimal valorGrupo;
    private BigDecimal valTotalGrupo;

    public Aluguel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocalizacaoRetirada() {
        return localizacaoRetirada;
    }

    public void setLocalizacaoRetirada(String localizacaoRetirada) {
        this.localizacaoRetirada = localizacaoRetirada;
    }

    public Date getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(Date dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public String getHoraRetirada() {
        return horaRetirada;
    }

    public void setHoraRetirada(String horaRetirada) {
        this.horaRetirada = horaRetirada;
    }

    public String getLocalizacaoDevolucao() {
        return localizacaoDevolucao;
    }

    public void setLocalizacaoDevolucao(String localizacaoDevolucao) {
        this.localizacaoDevolucao = localizacaoDevolucao;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getHoraDevolucao() {
        return horaDevolucao;
    }

    public void setHoraDevolucao(String horaDevolucao) {
        this.horaDevolucao = horaDevolucao;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public boolean getProtecao() {
        return protecao;
    }

    public void setProtecao(boolean protecao) {
        this.protecao = protecao;
    }

    public int getBbConf() {
        return bbConf;
    }

    public void setBbConf(int bbConf) {
        this.bbConf = bbConf;
    }

    public int getAssElev() {
        return assElev;
    }

    public void setAssElev(int assElev) {
        this.assElev = assElev;
    }

    public int getCadBB() {
        return cadBB;
    }

    public void setCadBB(int cadBB) {
        this.cadBB = cadBB;
    }

    public int getQtdGps() {
        return qtdGps;
    }

    public void setQtdGps(int qtdGps) {
        this.qtdGps = qtdGps;
    }

    public String getSelectAcessorios() {
        return selectAcessorios;
    }

    public void setSelectAcessorios(String selectAcessorios) {
        this.selectAcessorios = selectAcessorios;
    }

    public BigDecimal getValorBbConf() {
        return valorBbConf;
    }

    public void setValorBbConf(BigDecimal valorBbConf) {
        this.valorBbConf = valorBbConf;
    }

    public BigDecimal getValorAssElev() {
        return valorAssElev;
    }

    public void setValorAssElev(BigDecimal valorAssElev) {
        this.valorAssElev = valorAssElev;
    }

    public BigDecimal getValorCadBB() {
        return valorCadBB;
    }

    public void setValorCadBB(BigDecimal valorCadBB) {
        this.valorCadBB = valorCadBB;
    }

    public BigDecimal getValorGps() {
        return valorGps;
    }

    public void setValorGps(BigDecimal valorGps) {
        this.valorGps = valorGps;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public BigDecimal getValorGrupo() {
        return valorGrupo;
    }

    public void setValorGrupo(BigDecimal valorGrupo) {
        this.valorGrupo = valorGrupo;
    }

    public BigDecimal getValTotalGrupo() {
        return valTotalGrupo;
    }

    public void setValTotalGrupo(BigDecimal valTotalGrupo) {
        this.valTotalGrupo = valTotalGrupo;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }   
    
}
