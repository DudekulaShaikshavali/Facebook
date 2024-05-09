package stepsdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import pageobjects.Loginpage;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Stepdefinitions {
public WebDriver driver;
Loginpage lp;
 Logger logger;

    @Given("User launch the browser")
    public void user_launch_the_browser() {
   logger=LogManager.getLogger(Loginpage.class);
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        logger.info("browser is launched");

    }



    @When("Navigate into face book url as {string}")
    public void navigate_into_face_book_url_as(String url) {
driver.get(url);
logger.info("url  is launching");
//config=new ReadConfig();
//config.getFacebook_Url();
    }

    @When("Enter the mobilenumber as {string} and password as {string}")
    public void enter_the_mobilenumber_as_and_password_as(String mobile, String pass) {
        lp=new Loginpage(driver);
        lp.setMobile_number_css(mobile);
        logger.info("mobilenumber is entered");
        lp.setPassword_css(pass);
        logger.info("password is entered");

    }

    @When("Click on login button")
    public void click_on_login_button() {
lp.clickon_login();
logger.info("login button is clicked");
    }
    @When("Page title should be {string}")
    public void page_title_should_be(String title) {

if(driver.getPageSource().contains("Login was unsuccessful")){
    driver.close();
    Assert.assertTrue(false);
    logger.info("if title not matched it will throw assertion error");
}else {
    Assert.assertEquals(title,driver.getTitle());
    logger.info("comaring both titles are same or not");
}
    }
    @When("Click on logout button")
    public void click_on_logout_button() {
        lp.click_profile();
        logger.info("profile button is clicked");
lp.clickon_logout();
logger.info("logout button is clicked");
    }
    @Then("Close the browser")
    public void close_the_browser() {
        driver.quit();
        logger.info("driver is closed");
//hk.teardown();
    }


}
