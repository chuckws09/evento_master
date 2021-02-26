package model.dao;

import java.util.List;
import model.entity.Espaco;
import model.entity.Pessoa;

public class SalaEventoDAO extends BaseDAO<Espaco> {

    @Override
    public Espaco save(Espaco object) {
        Espaco espaco = super.save(object);
        
        if (espaco == null)
        {
            return null;
        }
        
        entityManager.getTransaction().begin();
        entityManager.createNamedQuery("etapa.clear").executeUpdate();
        entityManager.getTransaction().commit();
        
        PessoaDAO pessoaDAO = new PessoaDAO();
        
        List<Pessoa> listPessoas = pessoaDAO.getList();
        
        try
        {
            for (Pessoa pessoa : listPessoas) {
                pessoaDAO.updateSalaEvento(pessoa);
                pessoaDAO.updateEspacoCafe(pessoa);
            }
        }
        catch(Exception e)
        {
            System.out.println("Erro: " + e.getLocalizedMessage());
        }
        
        return espaco;
    }

    @Override
    public List<Espaco> getList()
    {
        TipoEspacoDAO tipoEspacoDAO = new TipoEspacoDAO();
        
        return entityManager.createNamedQuery("espaco.findByTipo").setParameter("tipo_espaco", tipoEspacoDAO.getById(1)).getResultList();
    }
    
}
