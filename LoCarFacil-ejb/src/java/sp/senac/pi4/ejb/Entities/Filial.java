/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.pi4.ejb.Entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author BrunoWilliam
 */
@Entity
@Table(name = "FILIAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Filial.findAll", query = "SELECT f FROM Filial f"),
    @NamedQuery(name = "Filial.findByIdfilial", query = "SELECT f FROM Filial f WHERE f.idfilial = :idfilial"),
    @NamedQuery(name = "Filial.findByNome", query = "SELECT f FROM Filial f WHERE f.nome = :nome"),
    @NamedQuery(name = "Filial.findByCidade", query = "SELECT f FROM Filial f WHERE f.cidade = :cidade"),
    @NamedQuery(name = "Filial.findByEstado", query = "SELECT f FROM Filial f WHERE f.estado = :estado"),
    @NamedQuery(name = "Filial.findByDiretorresponsavel", query = "SELECT f FROM Filial f WHERE f.diretorresponsavel = :diretorresponsavel")})
public class Filial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDFILIAL")
    private Integer idfilial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "NOME")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CIDADE")
    private String cidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ESTADO")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "DIRETORRESPONSAVEL")
    private String diretorresponsavel;
    @OneToMany(mappedBy = "idfilial")
    private Collection<FilialAcessorios> filialAcessoriosCollection;

    public Filial() {
    }

    public Filial(Integer idfilial) {
        this.idfilial = idfilial;
    }

    public Filial(Integer idfilial, String nome, String cidade, String estado, String diretorresponsavel) {
        this.idfilial = idfilial;
        this.nome = nome;
        this.cidade = cidade;
        this.estado = estado;
        this.diretorresponsavel = diretorresponsavel;
    }

    public Integer getIdfilial() {
        return idfilial;
    }

    public void setIdfilial(Integer idfilial) {
        this.idfilial = idfilial;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDiretorresponsavel() {
        return diretorresponsavel;
    }

    public void setDiretorresponsavel(String diretorresponsavel) {
        this.diretorresponsavel = diretorresponsavel;
    }

    @XmlTransient
    public Collection<FilialAcessorios> getFilialAcessoriosCollection() {
        return filialAcessoriosCollection;
    }

    public void setFilialAcessoriosCollection(Collection<FilialAcessorios> filialAcessoriosCollection) {
        this.filialAcessoriosCollection = filialAcessoriosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfilial != null ? idfilial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Filial)) {
            return false;
        }
        Filial other = (Filial) object;
        if ((this.idfilial == null && other.idfilial != null) || (this.idfilial != null && !this.idfilial.equals(other.idfilial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sp.senac.pi4.ejb.Entities.Filial[ idfilial=" + idfilial + " ]";
    }
    
}
