package stepdef;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utillity.PropertiesFileReader;

public class YoutubeLoginDef {
    public static WebDriver driver;
    PropertiesFileReader obj = new PropertiesFileReader();

        @When("^click on sign in button$")
        public void clickOnSignInButton() throws InterruptedException {
            driver.findElement(By.xpath("/html[1]/body[1]/ytd-app[1]/div[1]/div[1]/ytd-masthead[1]/div[3]/div[3]/div[2]/ytd-button-renderer[1]/yt-button-shape[1]/a[1]/yt-touch-feedback-shape[1]/div[1]/div[2]")).click();
            Thread.sleep(3000);

        }


        @And("^click on suggested logged out user$")
        public void clickOnSuggestedLoggedOutUser() throws InterruptedException {
driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/span[1]/section[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[2]/div[1]")).click();
Thread.sleep(2000);
        }
    @And("^provide password, click next$")
            public void providePasswordClickNext() throws InterruptedException {
            String password = "w1Ck3d123";
            driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/span[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")).sendKeys(password);
            Thread.sleep(2000);
            driver.findElement(By.xpath("(//div[@class='VfPpkd-RLmnJb'])[2]")).click();

    }

        @Then("^user should be logged in$")
    public void userShouldBeLoggedIn() {

        }

}
