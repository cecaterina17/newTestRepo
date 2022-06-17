package Helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropReader {

    private String url = "";
    private String browser = "";
    private String version = "";
    private String runOn = "";
    private String sauceUser = "";
    private String sauceKey = "";
    private String os = "";

    public PropReader() {
        // Why properties? its Data.properties right?
        Properties prop = new Properties();
        try {
            // method should read prop file and put values into above vars
            InputStream is = new FileInputStream("Data.properties");
            prop.load(is); // <-- values get loaded into prop

            if (System.getProperty("browser") != null) {
                browser = System.getProperty("browser");
            } else {
                browser = prop.getProperty("browser");
            }

            if (System.getProperty("runOn") != null) {
                runOn = System.getProperty("runOn");
            } else {
                runOn = prop.getProperty("runOn");
            }

            // you can assign value to local variables
            url = prop.getProperty("url");
            //browser = prop.getProperty("browser");
            version = prop.getProperty("version");
            //runOn = prop.getProperty("runOn");
            sauceUser = prop.getProperty("sauceUser");
            sauceKey = prop.getProperty("sauceKey");
            os = prop.getProperty("os");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Secure way to return private variables. Do not let people access to variables directly
    public String getSauceUser() {
        return sauceUser;
    }
    public String getSauceKey() {
        return sauceKey;
    }
    public String getOs() {
        return os;
    }
    public String getBrowser() {
        return browser;
    }
    public String getVersion() {
        return version;
    }
    public String getRunOn() {
        return runOn;
    }

}
