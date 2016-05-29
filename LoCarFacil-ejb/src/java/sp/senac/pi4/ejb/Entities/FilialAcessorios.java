/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.pi4.ejb.Entities;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BrunoWilliam
 */
@Entity
@Table(name = "FILIAL_ACESSORIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FilialAcessorios.findAll", query = "SELECT f FROM FilialAcessorios f"),
    @NamedQuery(name = "FilialAcessorios.findByIdfilialaces", query = "SELECT f FROM FilialAcessorios f WHERE f.idfilialaces = :idfilialaces"),
    @NamedQuery(name = "FilialAcessorios.findByQuantidade", query = "SELECT f FROM FilialAcessorios f WHERE f.quantidade = :quantidade")})
public class FilialAcessorios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDFILIALACES")
    private Integer idfilialaces;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTIDADE")
    private int quantidade;
    @JoinColumn(name = "IDACESSORIO", referencedColumnName = "IDACESSORIO")
    @ManyToOne(optional = false)
    private Acessorios idacessorio;
    @JoinColumn(name = "IDFILIAL", referencedColumnName = "IDFILIAL")
    @ManyToOne
    private Filial idfilial;

    public FilialAcessorios() {
    }

    public FilialAcessorios(Integer idfilialaces) {
        this.idfilialaces = idfilialaces;
    }

    public FilialAcessorios(Integer idfilialaces, int quantidade) {
        this.idfilialaces = idfilialaces;
        this.quantidade = quantidade;
    }

    public Integer getIdfilialaces() {
        return idfilialaces;
    }

    public void setIdfilialaces(Integer idfilialaces) {
        this.idfilialaces = idfilialaces;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Acessorios getIdacessorio() {
        return idacessorio;
    }

    public void setIdacessorio(Acessorios idacessorio) {
        this.idacessorio = idacessorio;
    }

    public Filial getIdfilial() {
        return idfilial;
    }

    public void setIdfilial(Filial idfilial) {
        this.idfilial = idfilial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfilialaces != null ? idfilialaces.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FilialAcessorios)) {
            return false;
        }
        FilialAcessorios other = (FilialAcessorios) object;
        if ((this.idfilialaces == null && other.idfilialaces != null) || (this.idfilialaces != null && !this.idfilialaces.equals(other.idfilialaces))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sp.senac.pi4.ejb.Entities.FilialAcessorios[ idfilialaces=" + idfilialaces + " ]";
    }
    
}
