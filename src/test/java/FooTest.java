import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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