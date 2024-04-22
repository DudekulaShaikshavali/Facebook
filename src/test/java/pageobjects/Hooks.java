//package pageobjects;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.junit.After;
//import org.junit.Before;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.edge.EdgeOptions;
//import org.openqa.selenium.support.PageFactory;
//
//public class Hooks {
// WebDriver driver;
//    EdgeOptions edge;
//
//
//    @Before
//    public void launch(){
//        edge=new EdgeOptions();
//        edge.addArguments("--remote-allow-origins=*");
//        WebDriverManager.edgedriver().setup();
//        driver=new EdgeDriver(edge);
//        driver.manage().window().maximize();
//    }
//
//    @After
//    public void teardown(){
//        driver.quit();
//    }
//}
