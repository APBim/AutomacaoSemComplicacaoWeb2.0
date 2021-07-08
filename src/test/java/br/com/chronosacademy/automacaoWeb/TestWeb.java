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
    public void firstTest(){

        String xpathTitle = "//section[2]//h4";
        WebElement h4Title = driver.findElement(By.xpath(xpathTitle));
        String textTitle = h4Title.getText();

        assertEquals("Porque Tempo É Conhecimento", textTitle);

    }

    @Test
    public void secondTest(){
        String xpathButton = "//section[2]/div[3]//a";
        WebElement btnTitle = driver.findElement(By.xpath(xpathButton));
        btnTitle.click();

        String xpathTitle = "//section[2]//h2";
        WebElement h2Title = driver.findElement(By.xpath(xpathTitle));
        assertEquals("AUTOMAÇÃO SEM COMPLICAÇÃO WEB 2.0", h2Title.getText());


    }

    @After
    public void finishTest(){

        driver.quit();
    }
}
