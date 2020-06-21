package br.rs.matheuspadilha.suites;

import br.rs.matheuspadilha.core.DriverFactory;
import br.rs.matheuspadilha.pages.LoginPage;
import br.rs.matheuspadilha.tests.*;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ContaTest.class,
        MovimentacaoTest.class,
        RemoverMovimentacaoContaTest.class,
        SaldoTest.class,
        ResumoTest.class
})
public class SuiteGeral {
    
    private static LoginPage page = new LoginPage();
    
    @BeforeClass
    public static void reset() {
        page.acessarTelaInicial();
        page.setEmail("userTeste@email.com");
        page.setPassword("password");
        page.entrar();
        page.resetar();
        DriverFactory.killDriver();
    }
    
}
