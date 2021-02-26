package model.entity;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author cwsez
 */
public class EtapaTest {
    
    @Test
    public void testNovaEtapa() {
        try
        {
            Etapa e = new Etapa();
            e.setEspaco(new Espaco());
            e.setPessoa(new Pessoa());
            e.setTipoEtapa(new TipoEtapa());
            Assert.assertTrue(true);
        }
        catch (Exception e)
        {
            System.out.println("Erro: " + e);
            Assert.assertTrue(false);
        }
    }
    
    @Test(expected = Exception.class)
    public void testNovaEtapaEspacoNulo() throws Exception
    {
        Etapa e = new Etapa();
        e.setEspaco(null);
        e.setPessoa(new Pessoa());
        e.setTipoEtapa(new TipoEtapa());
    }
    
    @Test(expected = Exception.class)
    public void testNovaEtapaPessoaNulo() throws Exception
    {
        Etapa e = new Etapa();
        e.setEspaco(new Espaco());
        e.setPessoa(null);
        e.setTipoEtapa(new TipoEtapa());
    }
    
    @Test(expected = Exception.class)
    public void testNovaEtapaTipoEtapaNulo() throws Exception
    {
        Etapa e = new Etapa();
        e.setEspaco(new Espaco());
        e.setPessoa(new Pessoa());
        e.setTipoEtapa(null);
    }
    
}
