import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

public class Search extends TestBase {

    @BeforeClass

    //    manager authorization
    public void authManager() throws InterruptedException {
        auth("billye@example.com", "123456");
//        wd.manage().window().maximize();
        wd.get("https://derrick686.softr.app/clients"); // можно так или надо перейти через элемент "клиенты"

    }

    @Test
    public void findNegative() throws InterruptedException {
        searchInClients("HKJHKJ");
    }

    @Test
    public void findCompany2() throws InterruptedException {
        searchInClients("Montag");
    }

    @Test
    public void findCompany1() throws InterruptedException {
        searchInClients("Worman");
    }

    @Test
    public void findName1() throws InterruptedException {
        searchInClients("Loree");
    }

    @Test
    public void findName2() throws InterruptedException {
        searchInClients("Lucie");
        jumpDown();
        rememberSelection("Lucie");
    }

    public void rememberSelection(String search) throws InterruptedException {
//        WebElement company = wd.findElements(By.xpath("//h3[@data-id=“.....”]"));
//        System.out.println(company.getText());

//        WebElement[] companyList = wd.findElements(By.xpath("//*[@id=\"list2\"]/div[2]/div/div/div[1]/div[1]/div/div[2]/div/div[2]/div"));
//        System.out.println(Arrays.toString(companyList.getText());

//        WebElement company = wd.findElement(By.id("_i7sulsj9u12"));
//        WebElement nameMail = wd.findElement(By.id("_74d6j1573"));

//        String source = wd.getPageSource();
//        Thread.sleep(500);
//        String errorMessage = search;
//        System.out.println(source.contains(errorMessage));
//        Boolean containsText = source.contains(errorMessage);
//        Assert.assertEquals(containsText, flag); //  результат выполнения теста (выводится в "Total tests run: 2, Passes: 1, Failures: 1, Skips: 0")
//        Thread.sleep(500);
    }

    public void сheckSearch(Boolean flag) throws InterruptedException {
        String source = wd.getPageSource();
        Thread.sleep(500);
        String errorMessage = "Invalid email or password";
        System.out.println(source.contains(errorMessage));
        Boolean containsText = source.contains(errorMessage);
        Assert.assertEquals(containsText, flag); //  результат выполнения теста (выводится в "Total tests run: 2, Passes: 1, Failures: 1, Skips: 0")
        Thread.sleep(500);
    }

}
