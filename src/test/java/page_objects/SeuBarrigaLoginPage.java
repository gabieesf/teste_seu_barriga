package page_objects;

import base_class.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SeuBarrigaLoginPage extends BasePage {

    private String url = "https://seubarriga.wcaquino.me";
    private By linkCadastro = By.xpath("//div[@id='bs-example-navbar-collapse-1']/ul/li[2]/a");
    private By inputUser = By.cssSelector("#email");
    private By inputPass = By.cssSelector("#senha");
    private By btnLogin = By.cssSelector("body > div.jumbotron.col-lg-4 > form > button");
    public SeuBarrigaLoginPage(WebDriver _browser) {
        super(_browser);
    }

    public void abrir() {
        driver.get(url);
    }

    public void preencherUsername() {
        waitElementVisible(inputUser, 5);
        driver.findElement(inputUser).sendKeys("1307@email.com");
        actions.sendKeys(Keys.ESCAPE).perform();
    }

    public void preencherPassword() {
        waitElementVisible(inputPass, 5);
        driver.findElement(inputPass).sendKeys("1234");
        actions.sendKeys(Keys.ESCAPE).perform();
    }

    public void clicarBtnEntrar() {
        waitElementVisible(btnLogin, 5);
        driver.findElement(btnLogin).click();
    }

    public void clicarLinkCadastro() {
        driver.findElement(linkCadastro).click();
    }
}
