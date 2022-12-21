package stepdef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import utillity.PropertiesFileReader;

import java.util.Properties;

public class FileUploadDef {
    WebDriver driver;
    PropertiesFileReader obj = new PropertiesFileReader();

    @Given("^Open a Chrome browser with URL$")
    public void openAChromeBrowserWithURL() throws Throwable {
        Properties properties = obj.getProperty();
        System.setProperty("webdriver.chrome.driver", "/home/uros/Downloads/chromedriver_linux64/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // driver.get(properties.getProperty("browser.baseURL"));
        driver.get("https://kitchen.applitools.com/ingredients/file-picker");
        Thread.sleep(3000);
        //objekat properties, namestanje lokacije hrom drajvera, pravljenje njegove instance i podizanje prozora zatim maksimizovati
        // a webdriver za pocetno pokretanje koristi varijablu browser.baseurl
        //thread.sleep cekanje na egzekuciju akciju u milisekundama
    }
    @When("^upload a jpg file to website$")
        public void weClickOnChooseFileOption() throws Throwable {
        String absFilePath ="/home/uros/Desktop/garfield.jpg";
        // System.out.println("Absolute path to the file" +absFilePath);
        driver.findElement(By.id("photo-upload")).sendKeys(absFilePath);
        }

        @Then("^image is being displayed$")
    public void uploadAJpgFileToWebsite() throws InterruptedException {
        boolean photo = driver.findElement(By.xpath("(//img[@alt='Preview of uploaded file'])[1]")).isDisplayed();
            Assert.assertTrue(photo,"image not being shown");
            Thread.sleep(4000);
            driver.quit();
        }
    }