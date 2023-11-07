package page_objects;

import base_class.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.List;


public class SeuBarrigaCriarMovimentacaoPage extends BasePage {

    private By tipoMovimentacao = By.xpath("//*[@id=\"tipo\"]");
    private By dataMovimentacao = By.cssSelector("#data_transacao");
    private By dataPag = By.cssSelector("#data_pagamento");
    private By descricao = By.cssSelector("#descricao");
    private By interessado = By.cssSelector("#interessado");
    private By valor = By.cssSelector("#valor");
    private By conta = By.cssSelector("#conta");
    private By pago = By.cssSelector("#status_pago");
    private By pendente = By.cssSelector("#status_pendente");
    private By bntSalvar = By.cssSelector("body > div.col-lg-10 > form > div.btn-group > button");
    private By txtSalvar = By.cssSelector("body > div.alert.alert-success");
    private By bntSair = By.cssSelector("#navbar > ul > li:nth-child(5) > a");
    private By listaErro = By.xpath("//div[@class='alert alert-danger']//li");
    public SeuBarrigaCriarMovimentacaoPage(WebDriver _browser) {
        super(_browser);
    }
    public void tipoDeMovimetacao(String texto) {
        waitElementVisible(tipoMovimentacao, 5);
        driver.findElement(tipoMovimentacao).click();
        WebElement campoOpcoes = driver.findElement(By.xpath("//*[@id=\"tipo\"]"));
        Select select = new Select(campoOpcoes);
        select.selectByVisibleText(texto);
    }

    public void preencherDataMov(String texto) {
        waitElementVisible(dataMovimentacao, 5);
        driver.findElement(dataMovimentacao).sendKeys(texto);
        actions.sendKeys(Keys.ESCAPE).perform();
    }
    public void preencherDataPag(String texto) {
        waitElementVisible(dataPag, 5);
        driver.findElement(dataPag).sendKeys(texto);
        actions.sendKeys(Keys.ESCAPE).perform();
    }

    public void preencherDescricao(String texto) {
        waitElementVisible(descricao, 5);
        driver.findElement(descricao).sendKeys(texto);
        actions.sendKeys(Keys.ESCAPE).perform();
    }

    public void preencherInteressado(String texto) {
        waitElementVisible(interessado, 5);
        driver.findElement(interessado).sendKeys(texto);
        actions.sendKeys(Keys.ESCAPE).perform();
    }

    public void preencheValor(String texto) {
        waitElementVisible(valor, 5);
        driver.findElement(valor).sendKeys(texto);
        actions.sendKeys(Keys.ESCAPE).perform();
    }

    public void preencheConta(String texto) {
        waitElementVisible(conta, 5);
        driver.findElement(conta).click();
        WebElement campoOpcoes = driver.findElement(By.cssSelector("#conta"));
        Select select = new Select(campoOpcoes);
        select.selectByVisibleText(texto);
    }

    public void preencheSituacao(String texto) {
        if (texto.equals("Pago")){
            WebElement inputElement = driver.findElement(pago);
            inputElement.click();
        } else {
            WebElement inputElement = driver.findElement(pendente);
            inputElement.click();
        }
    }

    public void clicarSalvar() {
        driver.findElement(bntSalvar).click();
    }

    public String getResultSalvar() {
        return driver.findElement(txtSalvar).getText();
    }

    public void clicarSair() {
        driver.findElement(bntSair).click();
    }

    public List<String> getResultErro() {
        List<WebElement> erros =  driver.findElements(listaErro);
        List<String> retorno = new ArrayList<String>();
        for (WebElement erro: erros) {
            retorno.add(erro.getText());
        }
        return retorno;
    }
}
