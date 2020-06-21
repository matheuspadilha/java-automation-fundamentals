package br.rs.matheuspadilha.core;

import br.rs.matheuspadilha.pages.LoginPage;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static br.rs.matheuspadilha.core.DriverFactory.*;

public class BaseTest {
    
    private static LoginPage page = new LoginPage();
    
    @Rule
    public TestName testName = new TestName();
    
    @Before
    public void inicializa() {
        page.acessarTelaInicial();
        page.logar();
    }
    
    @After
    public void finaliza() throws IOException {
        TakesScreenshot ss = (TakesScreenshot) getDriver();
        File arquivo = ss.getScreenshotAs(OutputType.FILE);
        SimpleDateFormat data = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
    
        FileUtils.copyFile(arquivo, new File("target" + File.separator + "screenshot" + File.separator + testName.getMethodName() + data.format(new Date()) + ".jpg"));
    
        if (Propriedades.FECHAR_BROWSER){
            killDriver();
        }
    }
    
}
