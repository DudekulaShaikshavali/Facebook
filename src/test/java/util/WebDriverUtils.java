package util;

import customexp.MandatoryElementNotFound;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverUtils {
    public WebDriver driver;
    public Wait wait;

    public WebDriverUtils(WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitForAnElement(By by){
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitForAnElement(By by, WaitConditions conditions){
        switch (conditions){
            case ELEMENTOBEVISIBLE:
                wait.until(ExpectedConditions.elementToBeClickable(by));
            case PRESENCEOFELEMENT:
                wait.until(ExpectedConditions.presenceOfElementLocated(by));
            case ELEMENTTOBECLICKABLE:
                wait.until(ExpectedConditions.elementToBeClickable(by));
        }
    }

    public void waitForPageLoad(){
        JavascriptExecutor js=(JavascriptExecutor) driver;
      if(js.executeScript("return document.readyState").toString().equals("complete")){
          System.out.println("Page is loaded");
      }
    }

    public void verifyMandatoryElementsInPage(By by){
        waitForAnElement(by);
        if (!driver.findElement(by).isDisplayed()){
            throw new MandatoryElementNotFound("mandatory elements not found in the page:"+by);
        }
    }

    public void implicitlyWaitmethod(int seconds){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }
}
