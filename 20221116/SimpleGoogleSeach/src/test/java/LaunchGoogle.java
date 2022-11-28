import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LaunchG {

    WebDriver wd;
    //before test
    @BeforeTest

    public void prepare(){
        wd = new ChromeDriver();
        wd.get("https://google.com");
        wd.manage().window().maximize();
        wd.findElement(By.id("L2AGLb")).click();
    }
    //test
    @Test
    public void ourTest(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
wd.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input");
)
    }

    //after test
    @AfterTest
    public void after(){

    }
}
