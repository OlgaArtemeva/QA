import org.testng.annotations.Test;

public class AllAuthorization extends TestBase {

    @Test
//    manager authorization check
    public void managerAuthorization() throws InterruptedException {

        auth("billye@example.com", "123456");
        authCheckAll("Invalid email or password",Boolean.FALSE);
        authCheckAll("PROJECT OVERVIEW",Boolean.TRUE);
        authCheckAll("CLIENTS",Boolean.TRUE);
        authCheckAll("TEAM",Boolean.TRUE);
        authCheckAll("INVOICES",Boolean.TRUE);
        logoutManagerConsultant();
    }

    @Test
//    client authorization check
    public void clientAuthorization() throws InterruptedException {

        auth("lucie@example.com", "123456");
        authCheckAll("Invalid email or password",Boolean.FALSE);
        authCheckAll("PROJECTS OVERVIEW",Boolean.TRUE);
        authCheckAll("CLIENTS",Boolean.FALSE);
        authCheckAll("TEAM",Boolean.FALSE);
        authCheckAll("INVOICES",Boolean.TRUE);
        logoutClient();
    }

    @Test
//    consultant authorization check
    public void consultantAuthorization() throws InterruptedException {

        auth("edra@example.com", "123456");
        authCheckAll("Invalid email or password", Boolean.FALSE);
        authCheckAll("Invalid email or password",Boolean.FALSE);
        authCheckAll("PROJECT OVERVIEW",Boolean.TRUE);
        authCheckAll("CLIENTS",Boolean.TRUE);
        authCheckAll("TEAM",Boolean.TRUE);
        authCheckAll("INVOICES",Boolean.TRUE);
        logoutManagerConsultant();
    }

   }
