package br.rs.matheuspadilha.pages;

import br.rs.matheuspadilha.core.BasePage;
import br.rs.matheuspadilha.core.DriverFactory;

public class LoginPage extends BasePage {
    
    public void acessarTelaInicial() {
        DriverFactory.getDriver().get("https://srbarriga.herokuapp.com");
    }
    
    public void setEmail(String email) {
        preencherCampo("email", email);
    }
    
    public void setPassword(String password) {
        preencherCampo("senha", password);
    }
    
    public void entrar() {
        clicarBotaoPorTexto("Entrar");
    }
    
    public void logar() {
        setEmail("userTeste@email.com");
        setPassword("password");
        entrar();
    }
    
    public void resetar() {
        clicarLink("reset");
    }
    
}
