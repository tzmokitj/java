package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class YoutubeChannelPage {
    // klasa youtubechannelstranice, ucitava webdriver
    //pagefactory klasa webdrivera za implementiranje page object modela
    //get title metoda da izvuce tekstualni title element stranice

    WebDriver driver;
    public YoutubeChannelPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(how= How.LINK_TEXT,using="abc")
    public WebElement SearchTextbox;
    public String getTitle() throws Exception {
        Thread.sleep(2000);
        return driver.getTitle();
    }

}

