package model.dao;

import model.entity.TipoEtapa;

public class TipoEtapaDAO extends BaseDAO<TipoEtapa>{
    
    public TipoEtapa getById(Integer id)
    {
        return entityManager.find(TipoEtapa.class, id);
    }
    
}
