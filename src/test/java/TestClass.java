import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestClass {

    private WebDriver driver;

    @After
    public void Close(){
        if (driver != null)
            driver.quit();
    }
    
    @Test
    public void GoogleTest(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);


        driver.get("http://google.com/");
        driver.findElement(By.name("q")).sendKeys("otus" + Keys.ENTER);
        Assert.assertEquals("OTUS", driver.findElement(By.cssSelector("div.g h3")).getText());
    }
}
