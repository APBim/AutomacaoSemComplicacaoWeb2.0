package br.com.chronosacademy.automacaoWeb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class TestWeb {

    @Test
    public void FirstTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize(); // maximiza o navegador

        driver.get("https://www.chronosacademy.com.br/");
        String xpathTitle = "/html/body/div/div/div/div/div/section[2]/div[3]/div/div/div/div/div[1]/div/h4";
        WebElement h4Title = driver.findElement(By.xpath(xpathTitle));
        String textTitle = h4Title.getText();

        assertEquals("Porque Tempo É Conhecimento", textTitle);

        driver.quit();

    }
}
