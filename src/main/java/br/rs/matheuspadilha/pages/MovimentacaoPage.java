package br.rs.matheuspadilha.pages;

import br.rs.matheuspadilha.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static br.rs.matheuspadilha.core.DriverFactory.*;

import java.util.ArrayList;
import java.util.List;

public class MovimentacaoPage extends BasePage {

    public void setDataMovimentacao(String data) {
        preencherCampo("data_transacao", data);
    }
    
    public void setDataPagamento(String data) {
        preencherCampo("data_pagamento", data);
    }
    
    public void setDescricao(String descricao) {
        preencherCampo("descricao", descricao);
    }
    
    public void setInteressado(String interessado) {
        preencherCampo("interessado", interessado);
    }
    
    public void setValor(String valor) {
        preencherCampo("valor", valor);
    }
    
    public void setConta(String conta) {
        selecionarCombo("conta", conta);
    }
    
    public void setStatusPago() {
        clicarRadio("status_pago");
    }
    
    public void salvar() {
        clicarBotaoPorTexto("Salvar");
    }
    
    public String obterMensagemSucesso() {
        return obterTexto(By.xpath("//div[@class='alert alert-success']"));
    }
    
    public List<String> obterErros() {
        List<WebElement> erros = getDriver().findElements(By.xpath("//div[@class='alert alert-danger']//li"));
        List<String> retorno = new ArrayList<String>();
        for (WebElement erro: erros) {
            retorno.add(erro.getText());
        }
        
        return retorno;
    }
    
}
