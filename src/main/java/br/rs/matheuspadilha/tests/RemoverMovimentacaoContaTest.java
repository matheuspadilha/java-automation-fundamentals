package br.rs.matheuspadilha.tests;

import br.rs.matheuspadilha.core.BaseTest;
import br.rs.matheuspadilha.pages.ContasPage;
import br.rs.matheuspadilha.pages.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class RemoverMovimentacaoContaTest extends BaseTest {
    
    private MenuPage menuPage = new MenuPage();
    private ContasPage contasPage = new ContasPage();
    
    @Test
    public void testExcluirContaComMovimentacao() {
        menuPage.acessarTelaListarConta();
        contasPage.clicarExcluirConta("Conta com movimentacao");
        Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemErro() );
    }
    
}
