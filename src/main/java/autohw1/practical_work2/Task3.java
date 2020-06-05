package autohw1.practical_work2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Task3 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://oz.by");
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

        List<WebElement> linksList = driver.findElements(By.xpath("//li[@class='top-panel__hnav__li top-panel__hnav__li_r']/child::*"));
        linksList.get(0).click();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        //WebElement closeLink = driver.findElement(By.xpath("//a[contains(text(), 'закрыть это окно')]"));
        //closeLink.click();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

        Set<String> handles = driver.getWindowHandles();
        for(String s : handles){
            driver.switchTo().window(s);
        }

        List<WebElement> closeLinkList = driver.findElements(By.xpath("//center/child::*"));
        closeLinkList.get(1).click();
        System.out.println("Payment window is closed!");
        driver.quit();

    }
}
