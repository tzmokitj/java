package stepdef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import utillity.PropertiesFileReader;

import java.util.Properties;

public class DragnDrop2Def {
    WebDriver driver;
    PropertiesFileReader obj = new PropertiesFileReader();
    @Given("^Open a chrome browser and enter demo guru urls$")
    public void OpenAChromeBrowserAndEnterDemoGuruUrl() throws Throwable {
        Properties properties = obj.getProperty();
        System.setProperty("webdriver.chrome.driver", "/home/uros/Downloads/chromedriver_linux64/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // driver.get(properties.getProperty("browser.baseURL"));
        driver.get("http://demo.guru99.com/test/drag_drop.html");
        Thread.sleep(3000);
        //objekat properties, namestanje lokacije hrom drajvera, pravljenje njegove instance i podizanje prozora zatim maksimizovati
        // a webdriver za pocetno pokretanje koristi varijablu browser.baseurl
        //thread.sleep cekanje na egzekuciju akciju u milisekundama
    }

    @Then("^element is dropped on particular offset$")
    public void elementIsDroppedOnParticularOffset() throws InterruptedException {
        //Element(BANK) which need to drag.
        WebElement From=driver.findElement(By.xpath("//*[@id='credit2']/a"));

        //Using Action class for drag and drop.
        Actions act=new Actions(driver);

        //Drag and Drop by Offset.
        act.dragAndDropBy(From,135, 40).build().perform();
//Element(AMOUNT 5000) to be dragged.
        WebElement From2=driver.findElement(By.xpath("(//a[@class='button button-orange'][normalize-space()='5000'])[1]"));
                //Drag and Drop from2
        act.dragAndDropBy(From2,127,20).build().perform();
        //Element SALES to be dragged.
        WebElement From3=driver.findElement(By.xpath("(//a[normalize-space()='SALES'])[1]"));
        //Drag and Drop from3
        act.dragAndDropBy(From3,131,40).build().perform();
        Thread.sleep(1500);
        driver.quit();
    }


}
