package stepdef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utillity.PropertiesFileReader;

import java.util.List;
import java.util.Properties;


public class DynamicTableDef {
    WebDriver driver;
    PropertiesFileReader obj = new PropertiesFileReader();
// WEB TABLE ELEMENTS - DYNAMIC TABLE - https://demo.guru99.com/test/web-table-element.php# //
@Given("^Open chrome browser and enter urls$")
public void openChromeBrowserWithURL() throws Throwable {
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

    @When("^Find table Company at dynamic table$")
    public void FindTableCompanyAtDynamicTable() throws InterruptedException {
// proveravamo broj kolona i redova u tabeli //
        List<WebElement> columns = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/thead/tr/th"));

        // ovde ispisemo nazive kolona
        for (WebElement column : columns
        ) {
            System.out.println("Name of column in table: " + column.getAccessibleName());
            System.out.println();

        }

        System.out.println("Number of columns: " + columns.size());
        // ovde sad isto to,samo za redove
        List<WebElement> rows = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr"));
        System.out.println("Number of rows: " + rows.size());
        Thread.sleep(2000);


        // sada pronalazimo specifican element u tabeli i proveravamo njegov sadrzaj,konkretno 8.red

        // sada ispisemo tekst koji sadrzi taj red , 8.
        WebElement tableRow = driver.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[8]"));
        System.out.println();
        System.out.println("Content of 8th row: " + tableRow.getText());

        //sada hocemo da ispisemo sadrzaj 4.kolone u 8.redu
        WebElement dataTableRow = driver.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[8]/td[4]"));
        System.out.println("Content of 4th column of 8th row: " + dataTableRow.getText());

        //------------------------------------------------------------------------------------------------------------------------

        // sada hocemo da ispitamo gde se u tabeli nalazi red kojem je naziv kompanije Central Bank
        System.out.println("----------------------------------------------------------------");
        System.out.println();

        // da bi locirali tabelu
        WebElement table = driver.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody"));

        List<WebElement> rows_table = table.findElements(By.tagName("tr"));

        int numberOfContainingRowHDIL = -1;
        //sada cemo napraviti for petlju koja ce prolaziti najpre kroz sve redove
        for (int rowNum = 0; rowNum < rows_table.size(); rowNum++) {

            //sada cemo da lociramo svaku kolonu u datom redu
            List<WebElement> columnsRow = rows_table.get(rowNum).findElements(By.tagName("td"));
            System.out.println("Number of cells in row number: " + rowNum + " are: " + columnsRow.size());

            for (int columnNum = 0; columnNum < columnsRow.size(); columnNum++) {

                // sada cemo ispisati tekst svake kolone u datom redu
                System.out.println("Sadrzaj celije u redu: " + rowNum + " , koloni: " + columnNum + " : " + columnsRow.get(columnNum).getText());

                if (columnsRow.get(columnNum).getText().contains("HDIL")) {
                    numberOfContainingRowHDIL = rowNum;


                }
            }
            System.out.println();
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println();
        }

        if (numberOfContainingRowHDIL != -1) {
            System.out.println();
            System.out.println("***************************************");
            System.out.println("Number of row where is HDIL: " + numberOfContainingRowHDIL);
            System.out.println("***************************************");
            System.out.println();
        } else {
            System.out.println();
            System.out.println("***************************************");
            System.out.println("Number of row where is HDIL: NO FOUND ");
            System.out.println("***************************************");
            System.out.println();
        }


        //Thread.sleep(20000);
        driver.quit();
    }


    @Then("^Show number of rows and columns$")
    public void ShowNumberOfRowsAndColumns() throws InterruptedException {

    }
}
