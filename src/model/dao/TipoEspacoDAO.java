package model.dao;

import model.entity.TipoEspaco;

public class TipoEspacoDAO extends BaseDAO<TipoEspaco>{
    
    public TipoEspaco getById(Integer id)
    {
        return entityManager.find(TipoEspaco.class, id);
    }
    
}
