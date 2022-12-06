import org.testng.Assert;
import org.testng.annotations.Test;

public class TestExcelData extends TestBase{
    @Test(dataProvider = "excelWrongDataRead", dataProviderClass = DataProviders.class)

    public void BadAuthTestWithDataProviderXls(String email, String password) throws InterruptedException {
        logger.info("Starting negative authorization *.xls (method: BadAuthTestWithDataProviderXls)");
        auth(email, password);
        authCheck(Boolean.TRUE);
    }

    @Test(dataProvider = "excelCorrectDataRead", dataProviderClass = DataProviders.class)

    public void GoodAuthTestWithDataProviderXls(String email, String password) throws InterruptedException {
        logger.info("Starting positive authorization via *.xls (method: GoodAuthTestWithDataProviderXls)");
        auth(email, password);
        authCheck(Boolean.FALSE);
        logoutIlya();
    }

    @Test(dataProvider = "csvWrongDataRead", dataProviderClass = DataProviders.class)

    public void BadAuthTestWithDataProviderCsv(String email, String pwd) throws InterruptedException {
        logger.info("Starting negative authorization via *.csv (method: BadAuthTestWithDataProviderCsv)");
        auth(email, pwd);
        authCheck(Boolean.TRUE);
    }

    @Test(dataProvider = "csvCorrectDataRead", dataProviderClass = DataProviders.class)
    public void GoodAuthTestWithDataProviderCsv(String email, String pwd) throws InterruptedException {
        logger.info("Starting positive authorization via *.csv (method: GoodAuthTestWithDataProviderCsv)");
        auth(email, pwd);
        authCheck(Boolean.FALSE);
        logoutIlya();
    }


}
