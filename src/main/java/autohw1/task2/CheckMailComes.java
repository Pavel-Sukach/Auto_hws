package autohw1.task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckMailComes {
    public static void main(String[] args) {
        String text = "test" + (int)(Math.random() * 100);

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
        WebElement enterBtn = driver.findElement(By.xpath("//input[@class='o-control']"));
        enterBtn.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement wrtLetter = driver.findElement(By.xpath("//span[@class='compose-button__txt']"));
        wrtLetter.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement addressEmail = driver.findElement(By.xpath("//input[(@class='container--H9L5q size_s--3_M-_') and (@tabindex='100')]"));
        addressEmail.sendKeys("pavelag1929@mail.ru");

        WebElement subj = driver.findElement(By.name("Subject"));
        subj.sendKeys(text);

        driver.findElement(By.xpath("/html/body/div[15]/div[2]/div/div[2]/div[1]/span[1]/span/span")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[16]/div/div/div[2]/button[1]/span")).click();
        driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/div[2]/div/div/div[1]/span/span")).click();

        driver.navigate().refresh();
        List<WebElement> letter = driver.findElements(By.xpath("//span[@class='ll-sj__normal']"));

        System.out.println(letter.get(0).getText());
        if(letter.get(0).getText().equals(text)){
            System.out.println("Success!");
        }
        driver.quit();
    }
}
