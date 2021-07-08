package br.com.chronosacademy.automacaoWeb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class TestWeb {

    WebDriver driver;

    @Before
    public void startTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.chronosacademy.com.br/");
    }

    //@Ignore
    @Test
    public void FirstTest(){

        String xpathTitle = "/html/body/div/div/div/div/div/section[2]/div[3]/div/div/div/div/div[1]/div/h4";
        WebElement h4Title = driver.findElement(By.xpath(xpathTitle));
        String textTitle = h4Title.getText();

        assertEquals("Porque Tempo É Conhecimento", textTitle);

    }

    @Test
    public void secondTest(){
        String xpathBotao = "/html/body/div/div/div/div/div/section[2]/div[3]/div/div/div/div/div[2]/div/div/a";
        WebElement btnTitulo = driver.findElement(By.xpath(xpathBotao));
        btnTitulo.click();

        String xpathTitulo = "/html/body/div/div/div/div/section[2]/div/div/div/div/div/section/div/div/div/div/div/div/div/h2";
        WebElement h2Titulo = driver.findElement(By.xpath(xpathTitulo));
        assertEquals("AUTOMAÇÃO SEM COMPLICAÇÃO WEB 2.0", h2Titulo.getText());


    }

    @After
    public void finishTest(){
        driver.quit();
    }
}
