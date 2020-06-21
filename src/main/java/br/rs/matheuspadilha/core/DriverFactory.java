package br.rs.matheuspadilha.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import static br.rs.matheuspadilha.core.Propriedades.*;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    
    private  static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>(){
        @Override
        protected synchronized WebDriver initialValue() {
            return initDriver();
        }
    };
    
    private DriverFactory() {}
    
    public static WebDriver getDriver() {
        return threadDriver.get();
    }
    
    public static WebDriver initDriver() {
        WebDriver driver = null;
        if (TIPO_EXECUCAO == TipoExecucao.LOCAL) {
            switch (BROWSER) {
                case FIREFOX:
                    System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/lib/drivers/firefox/geckodriver");
                    driver = new FirefoxDriver();
                    break;
                case CHROME:
                    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/lib/drivers/chrome/chromedriver");
                    driver = new ChromeDriver();
                    break;
            }
        }
        
        if (TIPO_EXECUCAO == TipoExecucao.GRID) {
            DesiredCapabilities cap = null;
            switch (BROWSER) {
                case FIREFOX: cap = DesiredCapabilities.firefox(); break;
                case CHROME: cap = DesiredCapabilities.chrome(); break;
            }
            
            try {
                driver = new RemoteWebDriver(new URL("http://<url_ip_local>:4444/wd/hub"), cap);
            } catch (MalformedURLException e) {
                System.err.println("Falha conexão com o GRID!");
                e.printStackTrace();
            }
            
        }
    
        if (TIPO_EXECUCAO == TipoExecucao.NUVEM) {
            DesiredCapabilities cap = null;
            switch (BROWSER) {
                case FIREFOX: cap = DesiredCapabilities.firefox(); break;
                case CHROME: cap = DesiredCapabilities.chrome(); break;
            }
        
            try {
                driver = new RemoteWebDriver(new URL("http://<url_nuvem>:4444/wd/hub"), cap);
            } catch (MalformedURLException e) {
                System.err.println("Falha conexão com o GRID!");
                e.printStackTrace();
            }
        
        }
        driver.manage().window().maximize();
        
        return driver;
    }
    
    public static void killDriver() {
        WebDriver driver = getDriver();
        if (driver != null){
            driver.quit();
            driver = null;
        }
        
        if (threadDriver != null) {
            threadDriver.remove();
        }
    }
    
}
