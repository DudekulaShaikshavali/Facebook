package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Test {

    public static void main(String[] args) {
//        EdgeOptions edge=new EdgeOptions();
//        edge.addArguments("--remote-allow-origins=*");
        WebDriverManager.edgedriver().setup();
        WebDriver  driver=new EdgeDriver();//
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("#email")).sendKeys("9381531244");
        driver.findElement(By.cssSelector("#pass")).sendKeys("Shaiksha@1234");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        String title=driver.getTitle();
        System.out.println(title);

    }
}
