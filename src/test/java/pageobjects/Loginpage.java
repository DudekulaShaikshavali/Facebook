package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
    WebDriver driver;
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
    @FindBy(how = How.CSS,using ="[aria-label='Your profile']" )
    @CacheLookup
    WebElement profile_css;


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
        profile_css.click();
    }

    public void clickon_logout(){
        Actions ac=new Actions(driver);
        ac.moveToElement(logout_xpath).click().build().perform();
       // logout_xpath.click();

    }

}
