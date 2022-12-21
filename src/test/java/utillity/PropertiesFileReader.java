package utillity;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {
    public Properties getProperty() throws IOException
    {
        //objekat javine klase properties i njenih funkcija, pokretanje browser base url, u slucaju da ne uspe da uhvati eror i printuje
        FileInputStream inputStream=null;
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/test/resources/browser-config.properties"));
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    return properties;


}
    }