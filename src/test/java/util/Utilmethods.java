package util;

import customexp.BrowserNotFoundExpection;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class Utilmethods {

public WebDriver driver;
   public WebDriverWait wait;

    public  static void capturescreen(WebDriver driver,String path){
        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File src=screenshot.getScreenshotAs(OutputType.FILE);
            File target=new File(ComUtils.getProjectDirectory() + "//screenshots\\"+path + ".png");
            FileUtils.copyFile(src,target);
        }catch (Exception e){
            e.printStackTrace();

        }
    }
    public void enterText(WebElement element,String text){
       this.createWebElement(element).sendKeys(text);
    }
public WebElement createWebElement(WebElement element) {
        if (element instanceof By){
            By byElement=(By)element;
            return driver.findElement(byElement);
        }else {
           return  (WebElement)element;
        }
}

public void subimt(WebElement element){
        this.createWebElement(element).submit();
}
    public void clickonWebelement(WebElement element){
       this.createWebElement(element).click();
    }

    public void clearAndText(WebElement element,String input){
        this.createWebElement(element).clear();
            enterText(element,input);
    }
public void getWebElementText(WebElement element) {
        this.createWebElement(element).getText();
}
    public void clickUsingJavascriptExecutor(WebElement element){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",createWebElement(element));
    }
public WebElement waifForWebElement(String xpath){
   wait=new WebDriverWait(driver, Duration.ofSeconds(10));
   WebElement element= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
   element.isDisplayed();
   return element;

}
public void actionclick(WebElement element, WebDriver driver){
    Actions actions=new Actions(driver);
    actions.moveToElement(createWebElement(element)).click().build().perform();
}
    public void rightClick(WebElement element, WebDriver driver){
        Actions ac=new Actions(driver);
        ac.contextClick(createWebElement(element)).build().perform();

    }
    public void doubleClick(WebElement element,WebDriver driver){
        Actions ac=new Actions(driver);
        ac.doubleClick(createWebElement(element)).build().perform();
    }

    public void dragAnddro(WebDriver driver,WebElement source, WebElement target){
        Actions ac=new Actions(driver);
        ac.dragAndDrop(createWebElement(source),createWebElement(target)).build().perform();
    }

    public List<WebElement> getListofWebElements(WebElement element) {
        return driver.findElements((By)createWebElement(element));
    }

    public void selectDropDown(WebElement element,String selection,SelectOptions options){
        Select select=new Select(element);
        switch (options){
            case SELECTYBYVISIBLETEXT:
                select.selectByVisibleText(selection);
                break;
            case SELECTBYINDEX:
                select.selectByIndex(Integer.parseInt(selection));
                break;
            case SELECTBYVALUE:
                select.selectByValue(selection);
                break;

            default:
                    throw new IllegalArgumentException("please select right option from selectoptions");
        }
    }
}
