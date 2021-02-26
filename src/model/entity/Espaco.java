package model.entity;

import java.io.Serializable;
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

@Entity
@Table(name = "espaco")
@NamedQueries(
    @NamedQuery(name = "espaco.findByTipo", query = "SELECT e FROM Espaco e WHERE e.tipoEspaco = :tipo_espaco")
)
public class Espaco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "tipo_espaco_id")
    private TipoEspaco tipoEspaco;
    
    @Column
    private String nome;
    
    @Column
    private Integer lotacao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoEspaco getTipoEspaco() {
        return tipoEspaco;
    }

    public void setTipoEspaco(TipoEspaco tipoEspaco) throws Exception
    {
        if (tipoEspaco == null)
        {
            throw new IllegalArgumentException("O tipo de espaço não pode ser vazio!");
        }
        
        this.tipoEspaco = tipoEspaco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception
    {
        if (nome.isEmpty())
        {
            throw new IllegalArgumentException("O nome não pode estar vazio!");
        }
        
        this.nome = nome;
    }

    public Integer getLotacao() {
        return lotacao;
    }

    public void setLotacao(Integer lotacao) throws Exception
    {        
        if (lotacao <= 0)
        {
            throw new IllegalArgumentException("A lotação deve ser no mínimo de 1 pessoa");
        }
        
        this.lotacao = lotacao;
    }
    
}
