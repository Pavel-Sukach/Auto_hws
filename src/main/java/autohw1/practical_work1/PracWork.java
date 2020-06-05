package autohw1.practical_work1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class PracWork {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        Thread.sleep(3000);

        WebElement searchField = driver.findElement(By.xpath("//input[@class = \"gLFyf gsfi\"]"));
        searchField.sendKeys("metanit java");
        searchField.submit();
        Thread.sleep(3000);

        List<WebElement> results = driver.findElements(By.xpath("//*[@href='https://metanit.com/java/tutorial/']"));
        results.get(0).click();
        Thread.sleep(3000);

        WebElement h1 = driver.findElement(By.xpath("//h1[contains(text(), 'Руководство по языку программирования Java')]"));

        if (h1.isDisplayed()) {
            System.out.println("заголовок найден" + h1);
        } else {
            System.out.println("заголовок не найден");
        }

        driver.quit();
    }
}
