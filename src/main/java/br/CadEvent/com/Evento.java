package br.CadEvent.com;



import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author geisonferreira
 */
@Entity
@Table(name = "Evento")
@NamedQueries({
    @NamedQuery(name = "Evento.findAll", query = "SELECT e FROM Evento e"),
    @NamedQuery(name = "Evento.findByIdevento", query = "SELECT e FROM Evento e WHERE e.idevento = :idevento")})
public class Evento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDEVENTO")
    private Integer idevento;
    @Lob
    @Size(max = 16777215)
    @Column(name = "NOME")
    private String nome;
    @Lob
    @Size(max = 16777215)
    @Column(name = "SIGLA")
    private String sigla;
    @Lob
    @Size(max = 16777215)
    @Column(name = "AREADECONCENTRACAO")
    private String areadeconcentracao;
    @Lob
    @Size(max = 16777215)
    @Column(name = "INSTITUICAOORGANIZADORA")
    private String instituicaoorganizadora;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdevento")
    private List<Edicao> edicaoList;

    public Evento() {
    }

    public Evento(Integer idevento) {
        this.idevento = idevento;
    }

    public Integer getIdevento() {
        return idevento;
    }

    public void setIdevento(Integer idevento) {
        this.idevento = idevento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getAreadeconcentracao() {
        return areadeconcentracao;
    }

    public void setAreadeconcentracao(String areadeconcentracao) {
        this.areadeconcentracao = areadeconcentracao;
    }

    public String getInstituicaoorganizadora() {
        return instituicaoorganizadora;
    }

    public void setInstituicaoorganizadora(String instituicaoorganizadora) {
        this.instituicaoorganizadora = instituicaoorganizadora;
    }

    public List<Edicao> getEdicaoList() {
        return edicaoList;
    }

    public void setEdicaoList(List<Edicao> edicaoList) {
        this.edicaoList = edicaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idevento != null ? idevento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
        if ((this.idevento == null && other.idevento != null) || (this.idevento != null && !this.idevento.equals(other.idevento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dependencia.Evento[ idevento=" + idevento + " ]";
    }
    
}