package br.rs.matheuspadilha.tests;

import br.rs.matheuspadilha.core.BaseTest;
import br.rs.matheuspadilha.pages.HomePage;
import br.rs.matheuspadilha.pages.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class SaldoTest extends BaseTest {
    
    private HomePage page = new HomePage();
    private MenuPage menuPage = new MenuPage();
    
    @Test
    public void testSaldoConta() {
        menuPage.acessarTelaPrincipal();
        Assert.assertEquals("534.00", page.obterSaldoConta("Conta para saldo"));
    }
    
}
