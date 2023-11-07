package support;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.logging.Level;
import java.util.logging.Logger;


public class BrowserFactory {
    public static enum Browser {
        CHROME,
        CHROME_HEADLESS,
    }

    public static WebDriver getBrownser() {
        return getBrownser(Browser.CHROME_HEADLESS);
    }

    public static WebDriver getBrownser(Browser nav) {
        WebDriver navegador;
        ChromeOptions options;

        // reduzindo output do webdriver
        Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);

        switch(nav) {
            case CHROME:
                // reduzindo output do webdriver
                System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");

                WebDriverManager.chromedriver().setup();
                options = new ChromeOptions();
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-crash-reporter");
                options.addArguments("--disable-extensions");
                options.addArguments("--disable-in-process-stack-traces");
                options.addArguments("--disable-logging");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--disable-notifications");
                options.addArguments("--log-level=3");
                options.addArguments("--output=/dev/null");
                navegador = new ChromeDriver(options);
                navegador.manage().window().maximize();
                break;
            case CHROME_HEADLESS:
                // reduzindo output do webdriver
                System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");

                WebDriverManager.chromedriver().setup();
                options = new ChromeOptions();
                options.addArguments("--lang=pt-BR");
                options.addArguments("--headless");
                options.addArguments("--disable-gpu");
                options.addArguments("--window-size=1920,1080");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-crash-reporter");
                options.addArguments("--disable-extensions");
                options.addArguments("--disable-in-process-stack-traces");
                options.addArguments("--disable-logging");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--disable-notifications");
                options.addArguments("--log-level=3");
                options.addArguments("--output=/dev/null");
                navegador = new ChromeDriver(options);
                break;
            default:
                navegador = null;
                new Exception("Browser Nao Suportado");
        }
        return navegador;
    }
}
