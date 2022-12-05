import org.testng.Assert;
import org.testng.annotations.Test;

public class TestExcelData extends TestBase{
    @Test(dataProvider = "excelWrongDataRead", dataProviderClass = DataProviders.class)
    public void BadAuthTestWithDataProvider(String email, String pwd) throws InterruptedException {
        auth(email, pwd);
        String text = "Invalid email or password";
        Assert.assertEquals(wd.getPageSource().contains(text),Boolean.TRUE);
    }
}
