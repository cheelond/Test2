package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class cucumberTest {

    static protected WebDriver driver;

    @Given("I goto BBC site")
    public void i_goto_bbc_site() {
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
        System.out.println("@Given(\"I goto BBC site\")");
    }

    @When("I select news")
    public void i_select_news() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("@When(\"I select news\")");
    }

    @Then("I click on sports")
    public void i_click_on_sports() {
        System.out.println("@Then(\"I click on sports\")");
        // Write code here that turns the phrase above into concrete actions
    }

    @And("I see F1 sports")
    public void i_see_f1_sports() {
        System.out.println("@And(\"I see F1 sports\")");
        // Write code here that turns the phrase above into concrete actions
    }

    @Given("^I goto BBC site with (.*) and (.*)$")
    public void i_goto_bbc_site_with (String datatype1, String datatype2) {
        System.out.println("@Given(\"I goto BBC site\")");
        System.out.println("data1:" + datatype1);
        System.out.println("data2:" + datatype2);
    }

}
