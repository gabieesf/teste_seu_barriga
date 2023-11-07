package page_objects;

import base_class.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeuBarrigaHomePage extends BasePage {
    private By linkListarConta = By.xpath("//*[@id=\"navbar\"]/ul/li[2]/ul/li[2]/a");
    private By linkCriarMovimentacao = By.xpath("//*[@id=\"navbar\"]/ul/li[3]/a");
    private By bntcontas = By.xpath("//*[@id=\"navbar\"]/ul/li[2]/a");

    public SeuBarrigaHomePage(WebDriver _browser) {
        super(_browser);
    }

    public void clicarBntContas() {
        driver.findElement(bntcontas).click();
    }

    public void clicarListarContas() {
        driver.findElement(linkListarConta).click();;
    }

    public void criarMovimentacao() {
        driver.findElement(linkCriarMovimentacao).click();;
    }




}
