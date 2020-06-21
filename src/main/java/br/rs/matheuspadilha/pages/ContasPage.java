package br.rs.matheuspadilha.pages;

import br.rs.matheuspadilha.core.BasePage;
import org.openqa.selenium.By;

public class ContasPage extends BasePage {
    
    public void setNome(String nome) {
        preencherCampo("nome", nome);
    }
    
    public void salvar() {
        clicarBotaoPorTexto("Salvar");
    }
    
    public String obterMensagemSucesso() {
        return obterTexto(By.xpath("//div[@class='alert alert-success']"));
    }
    
    public String obterMensagemErro() {
        return obterTexto(By.xpath("//div[@class='alert alert-danger']"));
    }
    
    public void clicarAlterarConta(String valor) {
        obterCelula("Conta", valor, "Ações", "tabelaContas")
                .findElement(By.xpath(".//span[@class='glyphicon glyphicon-edit']")).click();
    }
    
    public void clicarExcluirConta(String valor) {
        obterCelula("Conta", valor, "Ações", "tabelaContas")
                .findElement(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']")).click();
    }
}
