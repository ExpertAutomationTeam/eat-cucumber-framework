package com.expertautomationteam.stepdef;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginStepDef {

    WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/Users/nacer-zimu/IdeaProjects/eat-jan172022-web-automation-framework/Generic/src/driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Given("^user opens browser and navigates to \"([^\"]*)\"$")
    public void user_opens_browser_and_navigates_to(String url) {
      driver.get(url);
    }

    @When("^user is on login page with title \"([^\"]*)\"$")
    public void user_is_on_login_page_with_title(String title) {
        Assert.assertEquals(title, driver.getTitle());
    }

    @Then("^user enters username \"([^\"]*)\"$")
    public void user_enters_username(String username) {
        driver.findElement(By.xpath("//body/div[1]/div[1]/form[1]/input[1]")).sendKeys(username);
    }

    @Then("^user enters password \"([^\"]*)\"$")
    public void user_enters_password(String password) {
        driver.findElement(By.xpath("//body/div[1]/div[1]/form[1]/input[2]")).sendKeys(password);
    }

    @Then("^user clicks on login button$")
    public void user_clicks_on_login_button() {
        driver.findElement(By.xpath("//body/div[1]/div[1]/form[1]/input[3]")).click();
    }

    @Then("^user should be logged to the application \"([^\"]*)\"$")
    public void user_should_be_logged_to_the_application(String header) {
        driver.switchTo().frame("mainpanel");
        WebElement element =  driver.findElement(By.xpath("//body/table/tbody/tr/td/h2"));
        Assert.assertEquals(header, element.getText());
    }

    @Then("^user should not be logged to the application and stays on the same page \"([^\"]*)\"$")
    public void user_should_not_be_logged_to_the_application_and_stays_on_the_same_page(String title) {
        Assert.assertEquals(title, driver.getTitle());
    }

}
