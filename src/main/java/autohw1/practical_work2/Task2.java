package autohw1.practical_work2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task2 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://oz.by");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        ArrayList<String> expectedResults = new ArrayList<>();
        expectedResults.add("Продукты, деликатесы");
        expectedResults.add("Книги");
        expectedResults.add("Косметика, парфюмерия");
        expectedResults.add("Дом, сад, зоотовары");
        expectedResults.add("Развлечения, творчество");
        expectedResults.add("Канцтовары, учёба");
        expectedResults.add("Сувениры, подарки");
        expectedResults.add("Детям и мамам");
        expectedResults.add("Туризм, отдых, спорт");
        expectedResults.add("Техника, электроника");
        expectedResults.add("Здоровье, медтехника");
        expectedResults.add("Книги");

        List<WebElement> actualResults = driver.findElements(By.xpath("//li[@class='main-nav__list__li main-nav__list__li_wnav']"));

        boolean check = true;

        if(actualResults.size() == expectedResults.size()) {
            for (int i = 0; i < actualResults.size(); i++){
                if(!expectedResults.get(i).equals(actualResults.get(i).getText())){
                    System.out.println("There is an error here!");
                    check = false;
                }
            }
        }
        if(check){
            System.out.println("Collections are equal!");
        }
        driver.quit();
    }
}
