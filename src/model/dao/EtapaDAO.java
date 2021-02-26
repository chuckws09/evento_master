package model.dao;

import java.util.List;
import model.entity.Espaco;
import model.entity.Etapa;
import model.entity.Pessoa;

public class EtapaDAO extends BaseDAO<Etapa>{
        
    public Integer getQtdeOcupado(Espaco e)
    {        
        return ((Long) entityManager.createNamedQuery("etapa.count").setParameter("espaco", e).getSingleResult()).intValue();
    }
    
    public List<Etapa> getByPessoa(Pessoa p)
    {
        return entityManager.createNamedQuery("etapa.findByPessoa").setParameter("pessoa", p).getResultList();
    }
    
    public List<Etapa> getByEspaco(Espaco e)
    {
        return entityManager.createNamedQuery("etapa.findByEspaco").setParameter("espaco", e).getResultList();
    }
}
