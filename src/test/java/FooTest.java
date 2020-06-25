import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;

@RunWith(Parameterized.class)
class FooTest {
    WebDriver driver;
    String site;

    public void ParameterizedTest(String site) {this.site = site;}

    @Before
    public void setup() {
        System.out.println("before");;
    }

    @Test
    void gotoGoogle() {
        System.out.println("gotoGoogle");
        System.setProperty("webdriver.chrome.driver", "c://webdriver//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.co.uk");
        //test
        driver.close();
    }

    @Test
    void gotoBBC() {
        System.out.println("news.bbc.co.uk");
        System.setProperty("webdriver.chrome.driver", "c://webdriver//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://news.bbc.co.uk");
        driver.close();
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown");

    }
    @Parameterized.Parameters()
        public static Iterable<? extends Object> data() {
        return Arrays.asList(
          "https://news.bbc.co.uk",
          "https:..www.google.co.uk"
        );

    }
}