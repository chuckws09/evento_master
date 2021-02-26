package model.entity;

import org.junit.Assert;
import org.junit.Test;

/*import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
*/
public class PessoaTest {
    
    @Test
    public void testNovaPessoa()
    {
        try {
            Pessoa p = new Pessoa();
            p.setNome("Teste");
            p.setSobrenome("Teste");
            Assert.assertTrue(true);
        } catch (Exception ex) {
            System.out.println("Erro: " + ex.getLocalizedMessage());
            Assert.assertTrue(false);
        }
    }
    
    @Test(expected = Exception.class)
    public void testNovaPessoaSemNome() throws Exception
    {
        Pessoa p = new Pessoa();
        p.setNome("");
        p.setSobrenome("Teste");
    }
    
    @Test(expected = Exception.class)
    public void testNovaPessoaSemSobreNome() throws Exception
    {
        Pessoa p = new Pessoa();
        p.setNome("Teste");
        p.setSobrenome("");
    }
}