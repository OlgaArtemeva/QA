import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.Keys;


public class Authorization {
    WebDriver wd;

    @BeforeMethod
    public void prepare() {
        wd = new ChromeDriver();
        wd.get("https://derrick686.softr.app/login");
        wd.manage().window().maximize();
    }

    @Test
//    negative authorization check
    public void ourTestNegative() throws InterruptedException {

        auth("billyeexample.com", "123");
        authCheck(Boolean.TRUE);
    }

    @Test
//    manager authorization check
    public void ourTestPositive() throws InterruptedException {

        auth("billye@example.com", "123456");
        authCheck(Boolean.FALSE);
    }

    @Test
//    check manager authorization after a negative
    public void ourTestNegativePositive() throws InterruptedException {

        auth("billyeexample.com", "123");
        authCheck(Boolean.TRUE);

        auth("billye@example.com", "123456");
        authCheck(Boolean.FALSE);
    }

    @AfterMethod
    public void after() throws InterruptedException {
        wd.close();
        wd.quit();
        Thread.sleep(1000);
    }

    //    entering email, password and clicking a button "sign in"
    public void auth(String email, String password) throws InterruptedException {
        Thread.sleep(1000);
        WebElement authorizationEmail = wd.findElement(By.xpath("/html/body/div[1]/section/div/div/div/div/div[2]/div[3]/input"));
        authorizationEmail.click();
        authorizationEmail.clear();
        authorizationEmail.sendKeys(email);
        Thread.sleep(1000);

        WebElement authorizationPassword = wd.findElement(By.xpath("/html/body/div[1]/section/div/div/div/div/div[2]/div[4]/div/input"));
        authorizationPassword.click();
        authorizationPassword.clear();
        authorizationPassword.sendKeys(password);
        Thread.sleep(1000);

        WebElement signIn = wd.findElement(By.id("sw-sign-in-submit-btn"));
        signIn.click();
        Thread.sleep(2000);
    }

    //    authorization check
    public void authCheck(Boolean flag) {
        String source = wd.getPageSource();
        String errorMessage = "Invalid email or password";
        System.out.println(source.contains(errorMessage));
        Boolean containsText = source.contains(errorMessage);
        Assert.assertEquals(containsText, flag); //  результат выполнения теста (выводится в "Total tests run: 2, Passes: 1, Failures: 1, Skips: 0")
    }


}
