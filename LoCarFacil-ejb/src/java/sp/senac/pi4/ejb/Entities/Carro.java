/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.pi4.ejb.Entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author BrunoWilliam
 */
@Entity
@Table(name = "CARRO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carro.findAll", query = "SELECT c FROM Carro c"),
    @NamedQuery(name = "Carro.findByIdcarro", query = "SELECT c FROM Carro c WHERE c.idcarro = :idcarro"),
    @NamedQuery(name = "Carro.findByAnofabricacao", query = "SELECT c FROM Carro c WHERE c.anofabricacao = :anofabricacao"),
    @NamedQuery(name = "Carro.findByModelo", query = "SELECT c FROM Carro c WHERE c.modelo = :modelo"),
    @NamedQuery(name = "Carro.findByIdfilial", query = "SELECT c FROM Carro c WHERE c.idfilial = :idfilial"),
    @NamedQuery(name = "Carro.findByIdgrupo", query = "SELECT c FROM Carro c WHERE c.idgrupo = :idgrupo"),
    @NamedQuery(name = "Carro.findByImagem", query = "SELECT c FROM Carro c WHERE c.imagem = :imagem"),
    @NamedQuery(name = "Carro.findByChassi", query = "SELECT c FROM Carro c WHERE c.chassi = :chassi"),
    @NamedQuery(name = "Carro.findByCor", query = "SELECT c FROM Carro c WHERE c.cor = :cor"),
    @NamedQuery(name = "Carro.findByPlaca", query = "SELECT c FROM Carro c WHERE c.placa = :placa"),
    @NamedQuery(name = "Carro.findByAno", query = "SELECT c FROM Carro c WHERE c.ano = :ano"),
    @NamedQuery(name = "Carro.findByRenavam", query = "SELECT c FROM Carro c WHERE c.renavam = :renavam"),
    @NamedQuery(name = "Carro.findByTipocombustivel", query = "SELECT c FROM Carro c WHERE c.tipocombustivel = :tipocombustivel")})
public class Carro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCARRO")
    private Integer idcarro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ANOFABRICACAO")
    @Temporal(TemporalType.DATE)
    private Date anofabricacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "MODELO")
    private String modelo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDFILIAL")
    private int idfilial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDGRUPO")
    private int idgrupo;
    @Size(max = 200)
    @Column(name = "IMAGEM")
    private String imagem;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "CHASSI")
    private String chassi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "COR")
    private String cor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "PLACA")
    private String placa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ANO")
    @Temporal(TemporalType.DATE)
    private Date ano;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "RENAVAM")
    private String renavam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "TIPOCOMBUSTIVEL")
    private String tipocombustivel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcarro")
    private Collection<Aluguel> aluguelCollection;
    @JoinColumn(name = "IDFABRICANTE", referencedColumnName = "IDFABRICANTE")
    @ManyToOne(optional = false)
    private Fabricante idfabricante;

    public Carro() {
    }

    public Carro(Integer idcarro) {
        this.idcarro = idcarro;
    }

    public Carro(Integer idcarro, Date anofabricacao, String modelo, int idfilial, int idgrupo, String chassi, String cor, String placa, Date ano, String renavam, String tipocombustivel) {
        this.idcarro = idcarro;
        this.anofabricacao = anofabricacao;
        this.modelo = modelo;
        this.idfilial = idfilial;
        this.idgrupo = idgrupo;
        this.chassi = chassi;
        this.cor = cor;
        this.placa = placa;
        this.ano = ano;
        this.renavam = renavam;
        this.tipocombustivel = tipocombustivel;
    }

    public Integer getIdcarro() {
        return idcarro;
    }

    public void setIdcarro(Integer idcarro) {
        this.idcarro = idcarro;
    }

    public Date getAnofabricacao() {
        return anofabricacao;
    }

    public void setAnofabricacao(Date anofabricacao) {
        this.anofabricacao = anofabricacao;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getIdfilial() {
        return idfilial;
    }

    public void setIdfilial(int idfilial) {
        this.idfilial = idfilial;
    }

    public int getIdgrupo() {
        return idgrupo;
    }

    public void setIdgrupo(int idgrupo) {
        this.idgrupo = idgrupo;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Date getAno() {
        return ano;
    }

    public void setAno(Date ano) {
        this.ano = ano;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getTipocombustivel() {
        return tipocombustivel;
    }

    public void setTipocombustivel(String tipocombustivel) {
        this.tipocombustivel = tipocombustivel;
    }

    @XmlTransient
    public Collection<Aluguel> getAluguelCollection() {
        return aluguelCollection;
    }

    public void setAluguelCollection(Collection<Aluguel> aluguelCollection) {
        this.aluguelCollection = aluguelCollection;
    }

    public Fabricante getIdfabricante() {
        return idfabricante;
    }

    public void setIdfabricante(Fabricante idfabricante) {
        this.idfabricante = idfabricante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcarro != null ? idcarro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carro)) {
            return false;
        }
        Carro other = (Carro) object;
        if ((this.idcarro == null && other.idcarro != null) || (this.idcarro != null && !this.idcarro.equals(other.idcarro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sp.senac.pi4.ejb.Entities.Carro[ idcarro=" + idcarro + " ]";
    }
    
}
