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
@Table(name = "AUDITORIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Auditoria.findAll", query = "SELECT a FROM Auditoria a"),
    @NamedQuery(name = "Auditoria.findByIdauditoria", query = "SELECT a FROM Auditoria a WHERE a.idauditoria = :idauditoria"),
    @NamedQuery(name = "Auditoria.findByIdusuario", query = "SELECT a FROM Auditoria a WHERE a.idusuario = :idusuario"),
    @NamedQuery(name = "Auditoria.findByOperacaorealizada", query = "SELECT a FROM Auditoria a WHERE a.operacaorealizada = :operacaorealizada"),
    @NamedQuery(name = "Auditoria.findByDataoperacao", query = "SELECT a FROM Auditoria a WHERE a.dataoperacao = :dataoperacao")})
public class Auditoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDAUDITORIA")
    private Integer idauditoria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDUSUARIO")
    private int idusuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OPERACAOREALIZADA")
    private Boolean operacaorealizada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATAOPERACAO")
    @Temporal(TemporalType.DATE)
    private Date dataoperacao;

    public Auditoria() {
    }

    public Auditoria(Integer idauditoria) {
        this.idauditoria = idauditoria;
    }

    public Auditoria(Integer idauditoria, int idusuario, Boolean operacaorealizada, Date dataoperacao) {
        this.idauditoria = idauditoria;
        this.idusuario = idusuario;
        this.operacaorealizada = operacaorealizada;
        this.dataoperacao = dataoperacao;
    }

    public Integer getIdauditoria() {
        return idauditoria;
    }

    public void setIdauditoria(Integer idauditoria) {
        this.idauditoria = idauditoria;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public Boolean getOperacaorealizada() {
        return operacaorealizada;
    }

    public void setOperacaorealizada(Boolean operacaorealizada) {
        this.operacaorealizada = operacaorealizada;
    }

    public Date getDataoperacao() {
        return dataoperacao;
    }

    public void setDataoperacao(Date dataoperacao) {
        this.dataoperacao = dataoperacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idauditoria != null ? idauditoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auditoria)) {
            return false;
        }
        Auditoria other = (Auditoria) object;
        if ((this.idauditoria == null && other.idauditoria != null) || (this.idauditoria != null && !this.idauditoria.equals(other.idauditoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sp.senac.pi4.ejb.Entities.Auditoria[ idauditoria=" + idauditoria + " ]";
    }
    
}
