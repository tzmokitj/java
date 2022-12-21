package stepdef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownMultipleDef {
    WebDriver driver;

        @Given("^Open a Chrome browser with fruits URL$")
        public void openAChromeBrowserWithFruitsURL() throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "/home/uros/Downloads/chromedriver_linux64/chromedriver");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            // driver.get(properties.getProperty("browser.baseURL"));
            driver.get("http://output.jsbin.com/osebed/2");
            Thread.sleep(3000);

        }

        @When("^selecting multiple dropdown option$")
        public void selectingMultipleDropdownOption() throws InterruptedException {
            Select fruits = new Select(driver.findElement(By.id("fruits")));
            fruits.selectByVisibleText("Banana");
            fruits.selectByIndex(1);
            fruits.deselectAll();
            Thread.sleep(2000);
            fruits.selectByVisibleText("Grape");
            fruits.selectByIndex(2);
            fruits.selectByVisibleText("Apple");
            Thread.sleep(1500);



        }

        @Then("^options are being displayed$")
        public void optionsAreBeingDisplayed() {

            Select fruits = new Select(driver.findElement(By.id("fruits")));
            int text = fruits.getAllSelectedOptions().size();
            boolean text2 = fruits.isMultiple();
            System.out.println("Amount of selected fruits are:" +text);
            System.out.println("Are there multiple options selected:"+ text2);
            driver.quit();

        }
    }


