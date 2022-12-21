package stepdef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utillity.PropertiesFileReader;

import java.util.Properties;

public class DragNDropDef {
    WebDriver driver;
    PropertiesFileReader obj = new PropertiesFileReader();
    @Given("^Open a chrome browser and enter demo guru url$")
    public void openAChromeBrowserAndEnterDemoGuruUrl() throws Throwable {
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
    @When("^dragging and dropping elements$")
    public void draggingAndDroppingElements() throws InterruptedException {
        //Elements need to be draggable.
        //Element(BANK) which need to drag.
        WebElement From1=driver.findElement(By.xpath("//*[@id='credit2']/a"));

        //Element(DEBIT SIDE) on which need to drop.
        WebElement To1=driver.findElement(By.xpath("//*[@id='bank']/li"));

        //Element(SALES) which need to drag.
        WebElement From2=driver.findElement(By.xpath("//*[@id='credit1']/a"));

        //Element(CREDIT SIDE) on which need to drop.
        WebElement To2=driver.findElement(By.xpath("//*[@id='loan']/li"));

        //Element(500) which need to drag.
        WebElement From3=driver.findElement(By.xpath("//*[@id='fourth']/a"));

        //Element(DEBIT SIDE) on which need to drop.
        WebElement To3=driver.findElement(By.xpath("//*[@id='amt7']/li"));

        //Element(500) which need to drag.
        WebElement From4=driver.findElement(By.xpath("//*[@id='fourth']/a"));

        //Element(CREDIT SIDE) on which need to drop.
        WebElement To4=driver.findElement(By.xpath("//*[@id='amt8']/li"));

        //Using Action class for drag and drop.
        Actions act=new Actions(driver);

        //BANK drag and drop.
        // Action dragAndDrop = act.clickAndHold(From1).moveToElement(To1).release(To1).build();
          act.dragAndDrop(From1, To1).build().perform();



        //SALES drag and drop.
         act.dragAndDrop(From2, To2).build().perform();


        //500 drag and drop debit side.
        act.dragAndDrop(From3, To3).build().perform();



        //500 drag and drop credit side.
         act.dragAndDrop(From4, To4).build().perform();

         Thread.sleep(1500);


        //Verifying the Perfect! message.

    }
    @Then("^verifying if it was successfull$")
    public void veryfyingIfItWasSuccessfull() {
        if(driver.findElement(By.xpath("//a[contains(text(),'Perfect')]")).isDisplayed())
        {
            System.out.println("Perfect Displayed !!!");
        }
        else
        {
            System.out.println("Perfect not Displayed !!!");
        }
        driver.quit();
    }
}
