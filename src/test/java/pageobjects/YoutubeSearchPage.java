package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class YoutubeSearchPage {
    // ucitava webdriver, pravi konstruktor s driverom koji inicira pagefactory
    // @findby pronalazi lokatore skladistene u webelement
    //navigatetoresultpage metoda koja koristi lokatore i odredjenu akciju
    //pagefactory klasa webdrivera za implementiranje page object modela
    WebDriver driver;
    public YoutubeSearchPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(how= How.XPATH,using="//ytd-searchbox[@id='search']")
    public WebElement SearchTextbox;

    @FindBy(how= How.CSS,using="#search-icon-legacy")
    public WebElement SearchButton;


    public void NavigateToResultPage()
    {
        SearchTextbox.sendKeys("gameranxtv");
        SearchButton.click();
    }

    }



