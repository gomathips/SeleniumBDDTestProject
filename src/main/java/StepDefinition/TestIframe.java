package StepDefinition;
import DriverManagement.DriverMangement;
import PageObjects.IframeObjects;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.concurrent.TimeUnit;

public class TestIframe extends IframeObjects {
    @Before
    public void start(){
        initializeDriver();
    }

    @Given("^User is on Iframe window$")
    public void user_is_on_Iframe_window()  throws Throwable{
        driver.get(DriverMangement.getURL());
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("singleframe")));
    }

    @When("^User navigate into the single iframe window$")
    public void user_enter_the_text_in_single_iframe_window() throws Throwable{
        WebElement singleframe = getSingleFrame();
        driver.switchTo().frame(singleframe);

    }

    @Then("^Enter the text message \"([^\"]*)\"$")
    public void enter_the_text_message(String msg) throws Throwable {
        WebElement singleframetextbox = getSingleFrameTextBox();
        singleframetextbox.sendKeys(msg);
        driver.switchTo().defaultContent();
    }

    @When("^User navigate into the multiple iframe window$")
    public void user_switch_to_iframe_within_iframe_window_and_enter_text()  throws Throwable{
        WebElement multipleframebutton = getMultipleFramebutton();
        multipleframebutton.click();
        WebElement multipleframe = getMultipleFrame();
        driver.switchTo().frame(multipleframe);
        WebElement multipleframe1 = getInnerFrame();
        driver.switchTo().frame(multipleframe1);
    }

    @Then("^Enter the text message for inner frame \"([^\"]*)\"$")
    public void enter_the_text_message_for_inner_frame(String msg) throws Throwable {
        WebElement multipleframetextbox = getInnerFrameTextBox();
        multipleframetextbox.sendKeys(msg);
        driver.switchTo().defaultContent();
        Thread.sleep(1000); //Just to verify the textbox visually
    }

    @After
    public void stop() throws Throwable {
        DriverMangement.stopDriver();
    }
}
