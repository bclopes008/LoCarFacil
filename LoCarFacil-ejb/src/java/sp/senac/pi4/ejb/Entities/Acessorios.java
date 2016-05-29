/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.pi4.ejb.Entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "ACESSORIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acessorios.findAll", query = "SELECT a FROM Acessorios a"),
    @NamedQuery(name = "Acessorios.findByIdacessorio", query = "SELECT a FROM Acessorios a WHERE a.idacessorio = :idacessorio"),
    @NamedQuery(name = "Acessorios.findByNomeacessorio", query = "SELECT a FROM Acessorios a WHERE a.nomeacessorio = :nomeacessorio"),
    @NamedQuery(name = "Acessorios.findByImagem", query = "SELECT a FROM Acessorios a WHERE a.imagem = :imagem"),
    @NamedQuery(name = "Acessorios.findByQuantidade", query = "SELECT a FROM Acessorios a WHERE a.quantidade = :quantidade"),
    @NamedQuery(name = "Acessorios.findByPreco", query = "SELECT a FROM Acessorios a WHERE a.preco = :preco")})
public class Acessorios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDACESSORIO")
    private Integer idacessorio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "NOMEACESSORIO")
    private String nomeacessorio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "IMAGEM")
    private String imagem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTIDADE")
    private int quantidade;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECO")
    private int preco;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idacessorio")
    private Collection<FilialAcessorios> filialAcessoriosCollection;

    public Acessorios() {
    }

    public Acessorios(Integer idacessorio) {
        this.idacessorio = idacessorio;
    }

    public Acessorios(Integer idacessorio, String nomeacessorio, String imagem, int quantidade, int preco) {
        this.idacessorio = idacessorio;
        this.nomeacessorio = nomeacessorio;
        this.imagem = imagem;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Integer getIdacessorio() {
        return idacessorio;
    }

    public void setIdacessorio(Integer idacessorio) {
        this.idacessorio = idacessorio;
    }

    public String getNomeacessorio() {
        return nomeacessorio;
    }

    public void setNomeacessorio(String nomeacessorio) {
        this.nomeacessorio = nomeacessorio;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
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
        hash += (idacessorio != null ? idacessorio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acessorios)) {
            return false;
        }
        Acessorios other = (Acessorios) object;
        if ((this.idacessorio == null && other.idacessorio != null) || (this.idacessorio != null && !this.idacessorio.equals(other.idacessorio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sp.senac.pi4.ejb.Entities.Acessorios[ idacessorio=" + idacessorio + " ]";
    }
    
}
