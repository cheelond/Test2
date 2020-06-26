import net.bytebuddy.dynamic.scaffold.MethodRegistry;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.sql.*;
import java.util.Arrays;

@RunWith(Parameterized.class)
class FooTest {
    static protected WebDriver driver;
    String site;

    public void ParameterizedTest(String site) {this.site = site;}

    @BeforeAll
     public static void setup() {
        System.setProperty("webdriver.chrome.driver", "c://webdriver//chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("window-size=0x0");
        driver = new ChromeDriver(chromeOptions);
        System.out.println("beforeall - initlised webdriver");;
    }

    @Test
    public void gotoBBC() {
        System.out.println("news.bbc.co.uk");
        driver.get("http://news.bbc.co.uk");
    }

    @Test
    public void gotoGoogle() {
        System.out.println("gotoGoogle");
        driver.get("http://www.google.co.uk");
    }

    @Test
    public void databaseTest(){
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