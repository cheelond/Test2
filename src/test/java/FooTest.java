import org.apache.commons.io.FileUtils;
import org.junit.Ignore;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
class FooTest {
    static protected WebDriver driver;
    String site;

    public void ParameterizedTest(String site) {this.site = site;}

    @BeforeAll
     public static void setup() {
        System.setProperty("webdriver.chrome.driver", "c://webdriver//chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("enable-automation");
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--disable-browser-side-navigation");
        chromeOptions.addArguments("--disable-gpu");

        driver = new ChromeDriver(chromeOptions);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        System.out.println("beforeall - initlised webdriver");;
    }

    @Ignore
    public void gotoBBC() {
        System.out.printf("***\n");
        System.out.println("gotoBBC test called");
        System.out.printf("***\n");
        driver.get("http://news.bbc.co.uk");
    }

    @Test
    public void gotoGoogle() throws IOException {
        System.out.printf("***\n");
        System.out.println("gotoGoogle test called");
        System.out.printf("***\n");
        driver.get("http://www.google.co.uk");
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("c:\\temp\\screenshot.png"));
        }catch (Exception e){
            e.getMessage();
        }
    }

    @Test
    public void databaseTest(){
        System.out.printf("***\n");
        System.out.println("databaseTest test called");
        System.out.printf("***\n");

        Connection conn = null;

        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            String dbURL = "jdbc:sqlserver://ELSA;databaseName=DWTable";
            String user = "sa";
            String pass = "letmein";
            conn = DriverManager.getConnection(dbURL, user, pass);
            if (conn != null) {
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());

                String sql = "select * from student";

                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery(sql);

                while  (result.next()){
                    String firstname = result.getString("Firstname");
                    String surname = result.getString("Surname");

                    System.out.println("Firstname: " + firstname);
                    System.out.println("Surname: " + surname);
                }

                conn.close();
            }

        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    @AfterEach
    public void tearDown() {
        System.out.println("AfterEach");

    }

    @AfterAll
    static public void end(){
        System.out.println("end");
        driver.close();
    }
    @Parameterized.Parameters()
        public static Iterable<? extends Object> data() {
        return Arrays.asList(
          "https://news.bbc.co.uk",
          "https:..www.google.co.uk"
        );

    }
}