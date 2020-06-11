package autohw1.task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CheckMail {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://mail.ru/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement login = driver.findElement(By.xpath("//input[@name='login']"));
        login.sendKeys("pavelag1929");
        driver.findElement(By.xpath("//label[@id='mailbox:submit']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement password = driver.findElement(By.xpath("//input[@id='mailbox:password']"));
        password.sendKeys("asjaroddze09890");
        driver.findElement(By.xpath("//input[@class='o-control']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement letterList = driver.findElement(By.xpath("//div[@class='letter-list letter-list_has-letters']"));
        if(letterList.isDisplayed()){
            System.out.println("Login is successful!");
        }

        driver.quit();
    }
}
