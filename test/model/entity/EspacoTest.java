package model.entity;

import org.junit.Assert;
import org.junit.Test;

public class EspacoTest {
    
    @Test
    public void testNovoEspaco()
    {
        try
        {
            Espaco e = new Espaco();
            e.setNome("Teste");
            e.setLotacao(1);
            e.setTipoEspaco(new TipoEspaco());
            Assert.assertTrue(true);
        }
        catch (Exception e)
        {
            System.out.println("Erro: " + e.getLocalizedMessage());
            Assert.assertTrue(false);
        }
    }
    
    @Test(expected = Exception.class)
    public void testNovoEspacoSemNome() throws Exception
    {
        Espaco e = new Espaco();
        e.setNome("");
        e.setLotacao(1);
        e.setTipoEspaco(new TipoEspaco());
    }
    
    @Test(expected = Exception.class)
    public void testNovoEspacoLotacaoInvalida() throws Exception
    {
        Espaco e = new Espaco();
        e.setNome("Teste");
        e.setLotacao(0);
        e.setTipoEspaco(new TipoEspaco());
    }
    
    @Test(expected = Exception.class)
    public void testNovoEspacoTipoEspacoNulo() throws Exception
    {
        Espaco e = new Espaco();
        e.setNome("Teste");
        e.setLotacao(1);
        e.setTipoEspaco(null);
    }
    
}
