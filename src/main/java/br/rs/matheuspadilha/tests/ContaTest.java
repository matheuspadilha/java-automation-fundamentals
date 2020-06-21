package br.rs.matheuspadilha.tests;

import br.rs.matheuspadilha.core.BaseTest;
import br.rs.matheuspadilha.pages.ContasPage;
import br.rs.matheuspadilha.pages.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class ContaTest extends BaseTest {
    
    private MenuPage menuPage = new MenuPage();
    private ContasPage contasPage = new ContasPage();
    
    @Test
    public void testInserirConta(){
        menuPage.acessarTelaInserirConta();
        contasPage.setNome("Conta do Teste");
        contasPage.salvar();
        Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());
    }
    
    @Test
    public void testAlterarConta() {
        menuPage.acessarTelaListarConta();
        contasPage.clicarAlterarConta("Conta para alterar");
        contasPage.setNome("Conta alterada");
        contasPage.salvar();
        Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());
    }
    
    @Test
    public void testInserirContaMesmoNome() {
        menuPage.acessarTelaInserirConta();
        contasPage.setNome("Conta mesmo nome");
        contasPage.salvar();
        Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemErro());
    }
    
}
