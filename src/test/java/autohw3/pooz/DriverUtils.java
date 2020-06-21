package autohw3.pooz;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverUtils {
    public static WebDriver getDriver(){
        return new ChromeDriver();
    }
}
