package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class BaseDAO<T> {
    
    protected EntityManager entityManager;
    
    public BaseDAO()
    {
        entityManager = Persistence.createEntityManagerFactory("ProjetoPU").createEntityManager();
    }
    
    public T save(T object)
    {
        try
        {
            entityManager.getTransaction().begin();
            T obj = entityManager.merge(object);
            entityManager.getTransaction().commit();
            return obj;
        }
        catch (Exception e)
        {
            entityManager.getTransaction().rollback();
            System.out.println("Erro ao salvar: " + e.getLocalizedMessage());
            return null;
        }
    }
    
    public List<T> getList()
    {
        return entityManager.createNamedQuery("findAll").getResultList();
    }
}
