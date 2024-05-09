package stepsdef;

import customexp.BrowserNotFoundExpection;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import util.ComUtils;
import util.WebDriverUtils;

import java.io.FileReader;
import java.util.Properties;

public class DriverFactory {
    public static WebDriver driver;
    public String fileSeperator= ComUtils.getFileSeperator();
    public String path=fileSeperator + "src" + fileSeperator + "test" + fileSeperator + "resources" + fileSeperator + "application.properties";
    public Properties properties;
@Before("@selenium")
    public void beforeMethod(){
String projectLocation=ComUtils.getProjectDirectory();
String fileLocation=projectLocation + path;
getProperties(fileLocation);

String environment=properties.getProperty("env");
String key="env."+environment;
String url= properties.getProperty(key);


String browser= properties.getProperty("browser");
driver=getDriver(browser);
new WebDriverUtils(driver).implicitlyWaitmethod(10);
driver.manage().window().maximize();
driver.get(url);

    }

    public static WebDriver getDriver(){
    return driver;
    }

    @After("@selenium")
    public void shutdownDriver(){
    driver.close();
    }

    public void getProperties(String path){
    properties=new Properties();
    try{
        FileReader reader=new FileReader(path);
        properties.load(reader);
    }catch (Exception e){
        e.printStackTrace();

    }

    }

    public WebDriver getDriver(String browser){
    switch (browser){
        case "chrome":
         return new ChromeDriver();
        case "firefox":
          return new FirefoxDriver();
        case "edge":
           return new EdgeDriver();
        default:
            throw new BrowserNotFoundExpection("supports only chrome,firefox,edge drivers only");
    }
    }
}
