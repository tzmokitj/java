package stepdef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utillity.PropertiesFileReader;

import java.time.Duration;
import java.util.Properties;

public class YoutubeSearchStepDef {
    public static WebDriver driver;
    // public static WebDriverWait driverWait;
    PropertiesFileReader obj= new PropertiesFileReader();
    @Given("^Open chrome browser and enter url$")
    public void open_chrome_browser_and_enter_url() throws Throwable
    {
        Properties properties = obj.getProperty();
        System.setProperty("webdriver.chrome.driver", "/home/uros/Downloads/chromedriver_linux64/chromedriver");
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(properties.getProperty("browser.baseURL"));
        // driver.get("https://www.youtube.com/");
        Thread.sleep(3000);
        //objekat properties, namestanje lokacije hrom drajvera, pravljenje njegove instance i podizanje prozora zatim maksimizovati
        // a webdriver za pocetno pokretanje koristi varijablu browser.baseurl
        //thread.sleep cekanje na egzekuciju naredne akcije u milisekundama
    }
@When("^Enter search criteria$")
    public void enter_search_criteria() throws Throwable
{
    //driver.findElement(By.id("search")).sendKeys("papadubi");
    driver.findElement(By.name("search_query")).sendKeys("srbija brazil 2:1");
    Thread.sleep(1000);
    //izvrsavamo feature akcije bez page objecta, dolazimo do lokatora i dajemo uputstva za unos teksta
}


    @Then("^Click on search button$")
    public void clickOnSearchButton() throws InterruptedException {
        driver.findElement(By.id("search-icon-legacy")).click();
        Thread.sleep(5500);
        //klik na search dugme
    }

    @Then("^click on first link$")
    public void clickOnFirstLink() throws InterruptedException {
        driver.findElement(By.xpath("/html[1]/body[1]/ytd-app[1]/div[1]/ytd-page-manager[1]/ytd-search[1]/div[1]/ytd-two-column-search-results-renderer[1]/div[2]/div[1]/ytd-section-list-renderer[1]/div[2]/ytd-item-section-renderer[1]/div[3]/ytd-video-renderer[1]/div[1]/div[1]/div[1]/div[1]/h3[1]/a[1]/yt-formatted-string[1]")).click();
        Thread.sleep(20000);
        //klik na prvi, odredjeni link(koji nije reklama)

    }

    @Then("^enter fullscreen, turn subtitles$")
    public void enterFullscreenTurnSubtitles() throws InterruptedException  {
        driver.findElement(By.cssSelector("button[title='Full screen (f)']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[title='Subtitles/closed captions (c)']")).click();
        //u plejeru aktiviranje opcije za fullscreen i subtitlova



    }

    @Then("^select info and click on official video$")
    public void selectInfoAndClickOnOfficialVideo() throws InterruptedException {
        driver.findElement(By.xpath("/html[1]/body[1]/ytd-app[1]/div[1]/ytd-page-manager[1]/ytd-watch-flexy[1]/div[3]/div[1]/ytd-player[1]/div[1]/div[1]/div[3]/div[3]/button[1]/span[1]/div[1]")).click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector(".iv-card-primary-link")).click();
        Thread.sleep(5000);
        driver.quit();
        // dodatne informacije u samom plejeru i redirect na oficijalni fifin link/video utakmice :D
    }






    @Then("^setting the volume louder$")
    public void settingTheVolumeLouder() throws InterruptedException {

        Duration timeout = Duration.ofMillis(50);
        WebDriverWait t = new WebDriverWait(driver, timeout);
        t.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//button[@title='Mute (m)'])[1]"))));
        t.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@class='ytp-volume-panel']"))));

        // driver.switchTo().activeElement().click(volumebtn);
        WebElement volumebtn= driver.findElement(By.xpath("(//button[@title='Mute (m)'])[1]"));
        WebElement slider = driver.findElement(By.xpath("//div[@class='ytp-volume-panel']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(volumebtn);
        actions.clickAndHold(slider);
        actions.moveByOffset(100,150);
        actions.build().perform();
        Thread.sleep(3000);
        //Then setting the volume louder
        //slider not interactable element in selenium(check other solutions)
    }


}
