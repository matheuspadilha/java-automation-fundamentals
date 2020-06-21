package br.rs.matheuspadilha.tests;

import br.rs.matheuspadilha.core.BaseTest;
import br.rs.matheuspadilha.pages.MenuPage;
import br.rs.matheuspadilha.pages.MovimentacaoPage;
import static br.rs.matheuspadilha.utils.DataUtils.*;
import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MovimentacaoTest extends BaseTest {
    
    private MenuPage menuPage = new MenuPage();
    private MovimentacaoPage movPage = new MovimentacaoPage();
    
    @Test
    public void testInserirMovimentacao() {
        menuPage.acessarTelaInserirMovimentacao();
        movPage.setDataMovimentacao(obterDataFormatada(new Date()));
        movPage.setDataPagamento(obterDataFormatada(new Date()));
        movPage.setDescricao("Movimentação do Teste");
        movPage.setInteressado("Interessado Qualquer");
        movPage.setValor("5000");
        movPage.setConta("Conta para movimentacoes");
        movPage.setStatusPago();
        movPage.salvar();
        Assert.assertEquals("Movimentação adicionada com sucesso!", movPage.obterMensagemSucesso());
    }
    
    @Test
    public void testCamposObrigatorios() {
        menuPage.acessarTelaInserirMovimentacao();
        movPage.salvar();
        List<String> erros = movPage.obterErros();
//        Assert.assertEquals("Data da Movimentação é obrigatório", erros.get(0)); // não é uma boa forma de se utilizar!
//        Assert.assertTrue(erros.contains("Data da Movimentação é obrigatório")); // boa forma porem trabalhoso!
        Assert.assertTrue(erros.containsAll(Arrays.asList(
                "Data da Movimentação é obrigatório",
                "Data do pagamento é obrigatório",
                "Descrição é obrigatório",
                "Interessado é obrigatório",
                "Valor é obrigatório",
                "Valor deve ser um número"
        )));
        Assert.assertEquals(6, erros.size());
    }
    
    @Test
    public void testInserirMovimentacaoFuturo() {
        menuPage.acessarTelaInserirMovimentacao();
        Date dataFutura = obterDataComDiferencaDias(5);
        movPage.setDataMovimentacao(obterDataFormatada(dataFutura));
        movPage.setDataPagamento(obterDataFormatada(dataFutura));
        movPage.setDescricao("Movimentação do Teste");
        movPage.setInteressado("Interessado Qualquer");
        movPage.setValor("5000");
        movPage.setConta("Conta para movimentacoes");
        movPage.setStatusPago();
        movPage.salvar();
        List<String> erros = movPage.obterErros();
        Assert.assertTrue(erros.contains("Data da Movimentação deve ser menor ou igual à data atual"));
        Assert.assertEquals(1, erros.size());
    }
    
}
