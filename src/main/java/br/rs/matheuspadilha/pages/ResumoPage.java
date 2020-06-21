package br.rs.matheuspadilha.pages;

import br.rs.matheuspadilha.core.BasePage;
import org.openqa.selenium.By;

public class ResumoPage extends BasePage {
    
    public void excluirMovimentacao(){
        clicarButton(By.xpath("//span[@class='glyphicon glyphicon-remove-circle']"));
    }
    
    public String obterMensagemSucesso() {
        return obterTexto(By.xpath("//div[@class='alert alert-success']"));
    }
    
    public void selecionarAno(String ano) {
        selecionarCombo("ano", ano);
    }
    
    public void buscar() {
        clicarButton(By.xpath("//input[@value='Buscar']"));
    }
    
}
