package br.rs.matheuspadilha.tests;

import br.rs.matheuspadilha.core.BaseTest;
import static br.rs.matheuspadilha.core.DriverFactory.*;

import br.rs.matheuspadilha.core.DriverFactory;
import br.rs.matheuspadilha.pages.MenuPage;
import br.rs.matheuspadilha.pages.ResumoPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ResumoTest extends BaseTest {
    
    private MenuPage menuPage = new MenuPage();
    private ResumoPage resumoPage = new ResumoPage();
    
    @Test
    public void testExcluirMovimentacao() {
        menuPage.acessarTelaResumo();
        resumoPage.excluirMovimentacao();
        Assert.assertEquals("Movimentação removida com sucesso!", resumoPage.obterMensagemSucesso());
    }
    
    @Test
    public void testResumoMensal() {
        menuPage.acessarTelaResumo();
        Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());
        resumoPage.selecionarAno("2016");
        resumoPage.buscar();
        List<WebElement> elementosEncontrados =  DriverFactory.getDriver().findElements(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
        Assert.assertEquals(0, elementosEncontrados.size());
    }
    
}
