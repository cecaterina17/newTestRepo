package Web;

import Helper.PropReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MyDriver {

    private static WebDriver driver;

    public static void launchUrlOnNewWindow(String url) {
        PropReader pReader = new PropReader();
        switch (pReader.getRunOn().toLowerCase()){
            case "sauce":
                DesiredCapabilities caps = null;
                //"https://oauth-giorgi.webdev-0c045:2a3ce3b8-df00-49dd-b3d7-eb8c1f63a8a9@ondemand.us-west-1.saucelabs.com:443/wd/hub";
                String sauceUrl = "https://" + pReader.getSauceUser() + ":" + pReader.getSauceKey() + "@ondemand.us-west-1.saucelabs.com:443/wd/hub";
                switch (pReader.getBrowser().toLowerCase()) {
                    case "chrome":
                        caps = DesiredCapabilities.chrome();
                        caps.setCapability("version", pReader.getVersion());
                        caps.setCapability("platform", pReader.getOs());
                        break;
                    case "firefox":
                        caps = DesiredCapabilities.firefox();
                        caps.setCapability("version", pReader.getVersion());
                        caps.setCapability("platform", pReader.getOs());
                        break;
                }
                try {
                    driver = new RemoteWebDriver(new URL(sauceUrl),caps);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
                break;

            case "local":
                System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                break;
        }
        driver.get(url);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitWindows() {
        driver.quit();
    }
}