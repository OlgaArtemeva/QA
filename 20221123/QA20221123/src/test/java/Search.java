import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Search extends TestBase {

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
    }

}
