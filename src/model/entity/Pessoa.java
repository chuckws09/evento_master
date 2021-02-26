package model.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa")
@NamedQueries(
    @NamedQuery(name = "findAll", query = "SELECT p FROM Pessoa p")
)
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column
    private String nome;
    @Column
    private String sobrenome;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        if (nome.isEmpty())
        {
            throw new IllegalArgumentException("O nome não pode estar vazio!");
        }
        
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) throws Exception {
        if (sobrenome.isEmpty())
        {
            throw new IllegalArgumentException("O sobrenome não pode estar vazio!");
        }
        
        this.sobrenome = sobrenome;
    }
    
}
