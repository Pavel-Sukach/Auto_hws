package autohw1.practical_work2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task1 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();

        driver.get("https://oz.by");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement cart = driver.findElement(By.xpath("//a[@class = 'top-panel__userbar__cart__item']"));
        cart.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement empty = driver.findElement(By.xpath("//div[@class='i-textual i-textual_bordered']"));
        if(empty.isDisplayed()){
            driver.navigate().back();
        }
        else {
            System.out.println("Clear the cart");
        }

        WebElement serchWindow = driver.findElement(By.xpath("//input[@id='top-s']"));
        serchWindow.sendKeys("Программирование");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        serchWindow.submit();

        List<WebElement> results = driver.findElements(By.xpath("//ul[@id='goods-table']/li"));
        results.get(0).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        driver.findElement(By.xpath("//button[@class='b-product-control__button i-button i-button_large i-button_orange addtocart-btn first-button']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//li[@class = 'top-panel__userbar__li top-panel__userbar__cart']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().refresh();

        WebElement element = driver.findElement(By.xpath("//a[@class='goods-table-cell__line goods-table-cell__line_title']"));

        if(element.isDisplayed()){
            System.out.println("Success!");
        }
        else{
            System.out.println("Failure!");
        }

        driver.quit();
    }
}
