import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

//import java.util.logging.Logger;


public class TestBase {

    final static Logger logger = LoggerFactory.getLogger(TestBase.class);

    WebDriver wd;

    @BeforeTest
    public void prepare() throws InterruptedException {
        wd = new ChromeDriver();
        wd.get("https://derrick686.softr.app/login");
        wd.manage().window().maximize();
        logger.info("Starting AllAuthorization");
    }

    @AfterTest
    public void after() throws InterruptedException {
        wd.close();
        wd.quit();
        Thread.sleep(1000);
    }

//    authorization
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

        jumpDown();
        Thread.sleep(500);
        WebElement signIn = wd.findElement(By.id("sw-sign-in-submit-btn"));
        signIn.click();
        Thread.sleep(2000);
    }

    public void jumpDown() {
        Actions actions = new Actions(wd);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }

    public void searchInClients(String searchInClients) throws InterruptedException {
        Thread.sleep(1000);
//        WebElement searchResult = wd.findElement(By.className("search"));
        WebElement searchResult = wd.findElement(By.xpath("/html/body/div[1]/section[2]/div[1]/div/div/div/input"));
        searchResult.click();
        searchResult.clear();
        searchResult.sendKeys(searchInClients);
        Thread.sleep(4000);
    }

    //    authorization check
    public void authCheck(Boolean flag) throws InterruptedException {
        String source = wd.getPageSource();
        Thread.sleep(500);
        String errorMessage = "Invalid email or password";
        System.out.println(source.contains(errorMessage));
        Boolean containsText = source.contains(errorMessage);
        Assert.assertEquals(containsText, flag); //  результат выполнения теста (выводится в "Total tests run: 2, Passes: 1, Failures: 1, Skips: 0")
        Thread.sleep(500);
    }

    //    authorization check for class AllAuthorization
    public void authCheckAll(String errorMessage,Boolean flag) throws InterruptedException {
        String source = wd.getPageSource();
        Thread.sleep(500);
        System.out.println(source.contains(errorMessage));
        Boolean containsText = source.contains(errorMessage);
        Assert.assertEquals(containsText, flag); //  результат выполнения теста (выводится в "Total tests run: 2, Passes: 1, Failures: 1, Skips: 0")
        Thread.sleep(500);
    }

    // logout of client account
    public void logoutClient() throws InterruptedException {
        WebElement authOut = wd.findElement(By.id("navbarDropdown"));
        authOut.click();
        Thread.sleep(500);
        WebElement signOut = wd.findElement(By.xpath("//*[@id=\"home-header3\"]/div/div[1]/ul/li[3]/div/a/span/span"));
//        WebElement signOut = wd.findElement(By.id("\"home-header3\""));
        signOut.click();
        Thread.sleep(500);

        WebElement login = wd.findElement(By.xpath("//*[@id=\"home-header2\"]/div/div[1]/ul/li[2]/a"));
        login.click();
        Thread.sleep(500);
    }

    // logout of manager or consultant account
    public void logoutManagerConsultant() throws InterruptedException {
        WebElement authOut = wd.findElement(By.id("navbarDropdown"));
        authOut.click();
        Thread.sleep(500);

        WebElement signOut = wd.findElement(By.xpath("//*[@id=\"home-header1\"]/div/div[1]/ul/li[5]/div/a/span/span"));
        signOut.click();
        Thread.sleep(500);

        WebElement login = wd.findElement(By.xpath("//*[@id=\"home-header2\"]/div/div[1]/ul/li[2]/a"));
        login.click();
        Thread.sleep(500);
    }
}
