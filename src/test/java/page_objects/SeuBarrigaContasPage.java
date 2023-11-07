package page_objects;

import base_class.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeuBarrigaContasPage extends BasePage {
    public SeuBarrigaContasPage(WebDriver _browser) {
        super(_browser);
    }

    public boolean contacadastrda(){
        WebElement tabela = driver.findElement(By.id("tabelaContas"));
        java.util.List<WebElement> linhas = tabela.findElements(By.xpath(".//tr"));
        if (linhas.size() > 1){
            return true;
        } else {
            return false;
        }
    }

}
