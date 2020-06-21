package autohw3.pooz;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
    public static void waitForElement(WebDriver driver, WebElement element){
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(element));
    }
}
