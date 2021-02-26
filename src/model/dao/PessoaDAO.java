package model.dao;

import java.util.List;
import model.entity.Espaco;
import model.entity.Etapa;
import model.entity.Pessoa;

public class PessoaDAO extends BaseDAO<Pessoa> {

    @Override
    public Pessoa save(Pessoa object) {
        Pessoa pessoa = super.save(object);
        
        if (pessoa == null)
        {
            return null;
        }

        try
        {
            updateSalaEvento(pessoa);

            updateEspacoCafe(pessoa);
        }
        catch(Exception e)
        {
            System.out.println("Erro: " + e.getLocalizedMessage());
        }
        
        return pessoa;
        
    }
    
    public void updateSalaEvento(Pessoa pessoa) throws Exception
    {
        Espaco espaco = null;
        
        EtapaDAO etapaDAO = new EtapaDAO();
        
        /* Salas de envento */
        SalaEventoDAO salaEventoDAO = new SalaEventoDAO();
        
        List<Espaco> listEspacos = salaEventoDAO.getList();
            
        TipoEtapaDAO tipoEtapaDAO = new TipoEtapaDAO();
        
        if (!listEspacos.isEmpty())
        {

            double mudarSalaCalculo = Math.ceil((double) pessoa.getId() / (double) listEspacos.size());

            boolean mudarSala = mudarSalaCalculo % 2 == 0;

            /* Sala */
            espaco = getEspacoVazio(listEspacos, etapaDAO, espaco, pessoa.getId() % 2 == 0 && mudarSala && listEspacos.size() % 2 == 0);
            
            if (espaco == null)
            {
                return;
            }
            
            Etapa etapa1sala = new Etapa();
            etapa1sala.setEspaco(espaco);
            etapa1sala.setPessoa(pessoa);
            etapa1sala.setTipoEtapa(tipoEtapaDAO.getById(1));

            etapaDAO.save(etapa1sala);

            if (mudarSala)
            {
                espaco = getEspacoVazio(listEspacos, etapaDAO, espaco, pessoa.getId() % 2 == 0 && mudarSala && listEspacos.size() % 2 == 0);
            }

            Etapa etapa2sala = new Etapa();
            etapa2sala.setEspaco(espaco);
            etapa2sala.setPessoa(pessoa);
            etapa2sala.setTipoEtapa(tipoEtapaDAO.getById(2));

            etapaDAO.save(etapa2sala);
        }
    }
    
    public void updateEspacoCafe(Pessoa pessoa) throws Exception
    {
        TipoEtapaDAO tipoEtapaDAO = new TipoEtapaDAO();
        
        Espaco espaco = null;
        
        EtapaDAO etapaDAO = new EtapaDAO();
        /* Espaços café */
        EspacoCafeDAO espacoCafeDAO = new EspacoCafeDAO();
        
        List<Espaco> listEspacosCafe = espacoCafeDAO.getList();
        
        if (!listEspacosCafe.isEmpty())
        {
        
            /* Café */
            espaco = getEspacoVazio(listEspacosCafe, etapaDAO, espaco, pessoa.getId() % 2 == 0 && listEspacosCafe.size() % 2 == 0);
            
            if (espaco == null)
            {
                return;
            }

            Etapa etapa1cafe = new Etapa();
            etapa1cafe.setEspaco(espaco);
            etapa1cafe.setPessoa(pessoa);
            etapa1cafe.setTipoEtapa(tipoEtapaDAO.getById(1));

            etapaDAO.save(etapa1cafe);
            
            Espaco espaco2 = getEspacoVazio(listEspacosCafe, etapaDAO, espaco, pessoa.getId() % 2 == 0 && listEspacosCafe.size() % 2 == 0);
            
            if (espaco2 == espaco)
            {
                return;
            }

            Etapa etapa2cafe = new Etapa();
            etapa2cafe.setEspaco(espaco2);
            etapa2cafe.setPessoa(pessoa);
            etapa2cafe.setTipoEtapa(tipoEtapaDAO.getById(2));

            etapaDAO.save(etapa2cafe);
        }
    }
        
    private Espaco getEspacoVazio(List<Espaco> listEspacos, EtapaDAO etapaDAO, Espaco espaco, boolean mudar)
    {
        
        float menorOcupacao = Integer.MAX_VALUE;
        
        for (Espaco listEspaco : listEspacos)
        {
            float ocupacao = (float) etapaDAO.getQtdeOcupado(listEspaco) / (float) 2;
            
            if (listEspacos.size() == 1 && listEspaco.getTipoEspaco().getId() == 2)
            {
                ocupacao *= 2;
            }
            
            if (mudar && ocupacao % 1 != 0)
            {
                espaco = listEspaco;
                
                return espaco;
            }
            
            if (menorOcupacao >= ocupacao && listEspaco.getLotacao() > ocupacao)
            {                
                menorOcupacao = ocupacao;
                espaco = listEspaco;
            }
        }
        
        return espaco;
    }
    
}
