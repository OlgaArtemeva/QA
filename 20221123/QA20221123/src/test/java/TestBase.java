import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {
    WebDriver wd;

    @BeforeTest
    public void prepare() throws InterruptedException {
        wd = new ChromeDriver();
        wd.get("https://derrick686.softr.app/login");
        wd.manage().window().maximize();
        jumpDown();
        auth("billye@example.com", "123456");
        wd.manage().window().maximize();
        wd.get("https://derrick686.softr.app/clients"); // можно так или надо перейти через элемент "клиенты"
    }

    @AfterTest
    public void after() throws InterruptedException {
        wd.close();
        wd.quit();
        Thread.sleep(1000);
    }

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
}
