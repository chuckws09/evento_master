package model.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "etapa")
@NamedQueries({
    @NamedQuery(name = "etapa.count", query = "SELECT COUNT(e) FROM Etapa e WHERE e.espaco = :espaco"),
    @NamedQuery(name = "etapa.clear", query = "DELETE FROM Etapa e"),
    @NamedQuery(name = "etapa.findByPessoa", query = "SELECT e FROM Etapa e WHERE e.pessoa = :pessoa"),
    @NamedQuery(name = "etapa.findByEspaco", query = "SELECT e FROM Etapa e WHERE e.espaco = :espaco")
})
public class Etapa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "tipo_etapa_id")
    private TipoEtapa tipoEtapa;
    
    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
    
    @ManyToOne
    @JoinColumn(name = "espaco_id")
    private Espaco espaco;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoEtapa getTipoEtapa() {
        return tipoEtapa;
    }

    public void setTipoEtapa(TipoEtapa tipoEtapa) throws Exception {
        if (tipoEtapa == null)
        {
            throw new IllegalArgumentException("O tipo de etapa não pode ser nulo");
        }
        this.tipoEtapa = tipoEtapa;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) throws Exception {
        if (pessoa == null)
        {
            throw new IllegalArgumentException("A pessoa não pode ser nula");
        }
        this.pessoa = pessoa;
    }

    public Espaco getEspaco() {
        return espaco;
    }

    public void setEspaco(Espaco espaco) throws Exception {
        if (espaco == null)
        {
            throw new IllegalArgumentException("O espaco não pode ser nulo");
        }
        this.espaco = espaco;
    }
    
}
