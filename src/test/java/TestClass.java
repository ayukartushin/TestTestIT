import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.testit.annotations.DisplayName;
import ru.testit.annotations.Step;
import ru.testit.annotations.Title;
import ru.testit.annotations.WorkItemId;

public class TestClass {

    private WebDriver driver;

    @Before
    public void Open(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
    }

    @After
    public void Close(){
        if (driver != null)
            driver.quit();
    }
    
    @Test
    @WorkItemId("14")
    @Title("АТ.Поиск Отуса в гугл")
    @DisplayName("AT.Google test")
    public void GoogleTest(){
        Step1();
        Step2();
        Assert.assertEquals("OTUS", driver.findElement(By.cssSelector("div.g h3")).getText());
    }

    @Step
    @Title("Открыть гугл")
    private void Step1(){
        driver.get("http://google.com/");
    }
    @Step
    @Title("Поиск")
    private void Step2(){
        driver.findElement(By.name("q")).sendKeys("otus" + Keys.ENTER);
    }
}
