/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.pi4.ejb.Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BrunoWilliam
 */
@Entity
@Table(name = "ALUGUEL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aluguel.findAll", query = "SELECT a FROM Aluguel a"),
    @NamedQuery(name = "Aluguel.findByIdaluguel", query = "SELECT a FROM Aluguel a WHERE a.idaluguel = :idaluguel"),
    @NamedQuery(name = "Aluguel.findByDataretirada", query = "SELECT a FROM Aluguel a WHERE a.dataretirada = :dataretirada"),
    @NamedQuery(name = "Aluguel.findByDataentrega", query = "SELECT a FROM Aluguel a WHERE a.dataentrega = :dataentrega")})
public class Aluguel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDALUGUEL")
    private Integer idaluguel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATARETIRADA")
    @Temporal(TemporalType.DATE)
    private Date dataretirada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATAENTREGA")
    @Temporal(TemporalType.DATE)
    private Date dataentrega;
    @JoinColumn(name = "IDCARRO", referencedColumnName = "IDCARRO")
    @ManyToOne(optional = false)
    private Carro idcarro;
    @JoinColumn(name = "IDCLIENTE", referencedColumnName = "IDCLIENTE")
    @ManyToOne(optional = false)
    private Cliente idcliente;

    public Aluguel() {
    }

    public Aluguel(Integer idaluguel) {
        this.idaluguel = idaluguel;
    }

    public Aluguel(Integer idaluguel, Date dataretirada, Date dataentrega) {
        this.idaluguel = idaluguel;
        this.dataretirada = dataretirada;
        this.dataentrega = dataentrega;
    }

    public Integer getIdaluguel() {
        return idaluguel;
    }

    public void setIdaluguel(Integer idaluguel) {
        this.idaluguel = idaluguel;
    }

    public Date getDataretirada() {
        return dataretirada;
    }

    public void setDataretirada(Date dataretirada) {
        this.dataretirada = dataretirada;
    }

    public Date getDataentrega() {
        return dataentrega;
    }

    public void setDataentrega(Date dataentrega) {
        this.dataentrega = dataentrega;
    }

    public Carro getIdcarro() {
        return idcarro;
    }

    public void setIdcarro(Carro idcarro) {
        this.idcarro = idcarro;
    }

    public Cliente getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Cliente idcliente) {
        this.idcliente = idcliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idaluguel != null ? idaluguel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aluguel)) {
            return false;
        }
        Aluguel other = (Aluguel) object;
        if ((this.idaluguel == null && other.idaluguel != null) || (this.idaluguel != null && !this.idaluguel.equals(other.idaluguel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sp.senac.pi4.ejb.Entities.Aluguel[ idaluguel=" + idaluguel + " ]";
    }
    
}
