package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class YoutubeResultsPage {
    // ucitava webdriver, pravi konstruktor s driverom koji inicira pagefactory
    // @findby pronalazi lokatore skladistene u webelement
    //navigatetochannelpage metoda koja koristi lokatore i odredjenu akciju
    //pagefactory klasa webdrivera za implementiranje page object modela
    WebDriver driver;
    public YoutubeResultsPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(how= How.LINK_TEXT,using="gameranx")
    public WebElement ChannelNameLink;
    public void NavigateToChannelName() throws InterruptedException {
        Thread.sleep(2000);
        ChannelNameLink.click();
        Thread.sleep(2000);
    }

}
