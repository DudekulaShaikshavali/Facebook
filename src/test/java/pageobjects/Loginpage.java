package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Loginpage {
    WebDriver driver;
    WebDriverWait wait;
    public Loginpage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

//    @FindBy(xpath = "//*[@id='email']")
@FindBy(how = How.XPATH,using = "//*[@id='email']")
     @CacheLookup
    WebElement mobile_number_css;

    //@FindBy(xpath = "//*[@id='pass']")
    @FindBy(how = How.XPATH,using ="//*[@id='pass']")
    @CacheLookup
    WebElement password_css;

    //@FindBy(xpath = "//button[text()='Log in']")
    @FindBy(how = How.XPATH,using ="//button[text()='Log in']")
    @CacheLookup
    WebElement loginbutton_xpath;

    // @FindBy(css="[aria-label='Your profile']")
    @FindBy(how = How.XPATH,using ="//div[@class='x78zum5 x1n2onr6']" )
    @CacheLookup
    WebElement profile;


    //@FindBy(xpath ="//span[text()='Log out']" )
    @FindBy(how = How.XPATH,using ="//span[text()='Log out']" )
    @CacheLookup
    WebElement logout_xpath;

    public void setMobile_number_css(String mobile_number){
        mobile_number_css.sendKeys(mobile_number);
    }

    public void setPassword_css(String password){
        password_css.sendKeys(password);
    }

    public void clickon_login(){
        loginbutton_xpath.click();
    }

    public void click_profile(){
//        JavascriptExecutor js=(JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click();",profile);
        Actions ac=new Actions(driver);
        ac.contextClick(profile).click().build().perform();
    }

    public void clickon_logout(){
        Actions ac=new Actions(driver);
    ac.moveToElement(logout_xpath).click().build().perform();
       // logout_xpath.click();

    }

}
