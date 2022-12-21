package stepdef;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownMenuDef {
    WebDriver driver;

    @Given("^Open a Chrome browser with country register URL$")
    public void openAChromeBrowserWithCountryRegisterURL() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/uros/Downloads/chromedriver_linux64/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // driver.get(properties.getProperty("browser.baseURL"));
        driver.get("http://demo.guru99.com/test/newtours/register.php");
        Thread.sleep(3000);

    }

    @When("^selecting dropdown option$")
    public void selectingDropdownOption() throws InterruptedException {
        Select drpCountry = new Select(driver.findElement(By.name("country")));
        drpCountry.selectByVisibleText("ARGENTINA");
        Thread.sleep(5000);


    }

    @Then("^option is being displayed$")
    public void optionIsBeingDisplayed() throws InterruptedException {
        Select drpCountry = new Select(driver.findElement(By.name("country")));
        String text = drpCountry.getFirstSelectedOption().getText();
        drpCountry.selectByIndex(7);
        Thread.sleep(2000);
        String text2 = drpCountry.getFirstSelectedOption().getText();
        System.out.println("Firstly selected country is:" +text);
        System.out.println("Lastly selected country is:" +text2);
        driver.quit();
    }
}
