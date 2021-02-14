package PageObjects;
import DriverManagement.DriverMangement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IframeObjects {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected void initializeDriver(){
        driver = DriverMangement.getDriver();
        wait = new WebDriverWait(driver, 10);
    }
    protected WebElement getSingleFrame() {
        return driver.findElement(By.id("singleframe"));
    }
    protected WebElement getSingleFrameTextBox() {
        return driver.findElement(By.xpath("/html/body/section/div/div/div/input"));
    }
    protected WebElement getMultipleFramebutton() {
        return driver.findElement(By.xpath("/html/body/section/div[1]/div/div/div/div[1]/div/ul/li[2]/a"));
    }
    protected WebElement getMultipleFrame() {
        return driver.findElement(By.xpath("//*[@id=\"Multiple\"]/iframe"));
    }
    protected WebElement getInnerFrame() {
        return driver.findElement(By.xpath("/html/body/section/div/div/iframe"));
    }
    protected WebElement getInnerFrameTextBox() {
        return driver.findElement(By.xpath("/html/body/section/div/div/div/input"));
    }
}
