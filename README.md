## Projeto de automação do site Sr Barriga

Neste projeto, execute a _**SuiteGeral**_, um teste automatizado focado em interagir e validar os campos presentes no site.  
**URL**: https://srbarriga.herokuapp.com

Desenvolvido durante o curso: https://www.udemy.com/course/testes-funcionais-com-selenium-webdriver/

#### :sparkles: Tecnologias
:heavy_check_mark: **Java**  
:heavy_check_mark: **JUnit**  
:heavy_check_mark: **Selenium WebDriver** com driver do **chrome** e **firefox** ja implementado.  

|-Por default o driver do Firefox já esta setado. 

**_Alterando driver_**  -- _Recomendo setar os drivers no path do seu computador._  
No arquivo `src/main/java/br/rs/matheuspadilha/core/Propriedades.java`  
Altere a o valor do `Browsers.FIREFOX`, para o `Browsers.CHROME`  
Chrome: `public static Browsers BROWSER = Browsers.CHROME;`  
Firefox: `public static Browsers BROWSER = Browsers.FIREFOX;` 

**_Alterando Tipo de Execução_** -- Recomendo utilizar o tipo local mesmo.  
Por default ja esta setado no arquivo `src/main/java/br/rs/matheuspadilha/core/Propriedades.java`  
Neste projeto, foi testado e implementado um novo formato de trabalho, além da forma tradicional de execução pelo **local**, temos a execução no **grid** e em **nuvem**.

* Para utilizar o tipo grid, é necessario o driver do selenium server.
* Para utilizar o serviço na nuvem, é preciso contratar um serviço especializado nisso como https://saucelabs.com



#### :vertical_traffic_light: Requisitos 
Idea: **Eclipse** ou **IntelliJ**  
Versão: **Java 8**
