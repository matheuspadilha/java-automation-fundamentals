package br.rs.matheuspadilha.pages;

import br.rs.matheuspadilha.core.BasePage;

public class HomePage extends BasePage {
    
    public String obterSaldoConta(String nome) {
        return obterCelula("Conta", nome, "Saldo", "tabelaSaldo").getText();
    }
}
