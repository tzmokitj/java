package stepdef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gherkin.formatter.model.ScenarioOutline;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utillity.PropertiesFileReader;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DynamicWebTableDef {
    WebDriver driver;
    PropertiesFileReader obj = new PropertiesFileReader();
    @Given("^Open chrome browser and enter guru 99 url$")
    public void OpenChromeBrowserAndEnterGuru99Url() throws InterruptedException, IOException {
        Properties properties = obj.getProperty();
        System.setProperty("webdriver.chrome.driver", "/home/uros/Downloads/chromedriver_linux64/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // driver.get(properties.getProperty("browser.baseURL"));
        driver.get("https://demo.guru99.com/test/web-table-element.php#");
        Thread.sleep(3000);
        //objekat properties, namestanje lokacije hrom drajvera, pravljenje njegove instance i podizanje prozora zatim maksimizovati
        // a webdriver za pocetno pokretanje koristi varijablu browser.baseurl
        //thread.sleep cekanje na egzekuciju akciju u milisekundama

    }
    @Then("^get cell data values printed in console$")
    public void getCellDataValuesPrintedInConsole() throws InterruptedException {
        WebElement baseTable = driver.findElement(By.tagName("table"));

        //To find third row of table
        WebElement tableRow = baseTable.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[3]"));
        String rowtext = tableRow.getText();
        System.out.println("Third row of table : "+rowtext);

        //to get 3rd row's 2nd column data
        WebElement cellIneed = tableRow.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[3]/td[2]"));
        String valueIneed = cellIneed.getText();
        System.out.println("Cell value is : " + valueIneed);
        Thread.sleep(5000);

        // to get 4th row's 5th column data
        WebElement secondCellINeed = driver.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[4]/td[5]"));
        String secondValueINeed = secondCellINeed.getText();
        System.out.println("% Change value is :" +secondValueINeed);

        // to add up current values of row 4 / columns 2 and 5
        String firstPrice = driver.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[2]/td[4]")).getText();
        String secondPrice = driver.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[5]/td[4]")).getText();

        float number = Float.parseFloat(firstPrice);
        float numberTwo = Float.parseFloat(secondPrice);
        float sum = number + numberTwo;
        // to not  concatanate strings!

        System.out.println("Value of first number is:" +number);
        System.out.println("Value of second number is:" +numberTwo);
        System.out.println("Sum is:" + sum);
        driver.quit();

    }
}
