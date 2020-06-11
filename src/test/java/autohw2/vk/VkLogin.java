package autohw2.vk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class VkLogin {
    private WebDriver driver = new ChromeDriver();
    private static String VK_USERNAME;
    private static String VK_PASSWORD;

    @BeforeClass
    public void prepData(){
        VK_USERNAME = "test";
        VK_PASSWORD = "test";
    }

    @Test
    public void loginVkTest(){
        driver.manage().window().maximize();
        driver.get("https://vk.com");
        WebDriverWait webDriverWait = new WebDriverWait(driver,10);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("index_email")));

        WebElement username = driver.findElement(By.id("index_email"));
        WebElement password = driver.findElement(By.id("index_pass"));
        WebElement lgnButton = driver.findElement(By.id("index_login_button"));

        username.sendKeys(VK_USERNAME);
        password.sendKeys(VK_PASSWORD);
        lgnButton.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement messages = driver.findElement(By.xpath("//span[(contains(text(),'Messages'))]"));
        messages.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement searchField = driver.findElement(By.id("im_dialogs_search"));
        searchField.sendKeys("pasha sukach");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement me = driver.findElement(By.xpath("//span[(@class='_im_dialog_link') and (contains(text(),'Pasha Sukach'))]"));
        me.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement iptBox = driver.findElement(By.xpath("//div[@class='im_editable im-chat-input--text _im_text']"));
        iptBox.sendKeys("test");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement btn = driver.findElement(By.xpath("//button[@class='im-send-btn im-chat-input--send _im_send im-send-btn_send']"));
        btn.click();
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement mesComes = driver.findElement(By.xpath("//div[(@class='im-mess--text wall_module _im_log_body') and (contains(text(),'test'))]"));
        if(mesComes.isDisplayed()){
            System.out.println("Test is successful!");
        }
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
