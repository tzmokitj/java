package stepdef;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageobjects.YoutubeChannelPage;
import pageobjects.YoutubeResultsPage;
import pageobjects.YoutubeSearchPage;
import utillity.PropertiesFileReader;

import java.util.Properties;


public class YoutubeChannelValidations {
    public static WebDriver driver;
    PropertiesFileReader obj = new PropertiesFileReader();

    @Given("^Open Chrome browser with URL$")
    public void openChromeBrowserWithURL() throws Throwable {
        Properties properties = obj.getProperty();
        System.setProperty("webdriver.chrome.driver", "/home/uros/Downloads/chromedriver_linux64/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(properties.getProperty("browser.baseURL"));
        // driver.get("https://www.youtube.com/");
        Thread.sleep(3000);
        //objekat properties, namestanje lokacije hrom drajvera, pravljenje njegove instance i podizanje prozora zatim maksimizovati
        // a webdriver za pocetno pokretanje koristi varijablu browser.baseurl
        //thread.sleep cekanje na egzekuciju akciju u milisekundama
    }

    @When("^Search gameranxtv$")
    // objekat search stranice i njena metoda da popuni tekstom zatim klikne
    public void searchGameranxtv() throws Throwable {
        new YoutubeSearchPage(driver).NavigateToResultPage();
        Thread.sleep(2000);
    }

    @And("^Click on channel name$")
    // objekat channel stranice i njena metoda da  klikne(uzima lokator i funkciju)
    public void clickOnChannelName() throws Throwable {
        new YoutubeResultsPage(driver).NavigateToChannelName();
    }

    @Then("^Validate channel name$")
    // asertovanje, uporedjivanje dva stringa, ocekivane i trenutne(dobijene objektom stranice i njegovim title elementom)
    // u slucaju da se ne podudaraju test pada i ispisuje poruku
    public void validateChannelName() throws Throwable {
        String expectedChannelName = "gameranx - YouTube";
        String actualChannelName = new YoutubeChannelPage(driver).getTitle();
        Assert.assertEquals(actualChannelName, expectedChannelName, "Channel names are not matching");
        Thread.sleep(3000);
        driver.quit();
    }

}
