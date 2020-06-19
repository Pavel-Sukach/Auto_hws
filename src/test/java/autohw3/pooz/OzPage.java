package autohw3.pooz;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OzPage {
    private WebDriver driver = DriverUtils.getDriver();

    @FindBy(xpath = "//a[@class='top-panel__userbar__cart__item']")
    private WebElement cartBtn;
    @FindBy(xpath = "//*[@id='top-page']/descendant::a[@class='top-panel__userbar__auth']")
    private WebElement enterBtn;
    @FindBy(xpath = "//li[@class='main-nav__list__li main-nav__list__li_wnav']")
    private WebElement filter;

    public OzPage() {
        PageFactory.initElements(driver, this);
    }

    public OzPage(WebElement cartBtn, WebElement enterBtn, WebElement filter) {
        this.cartBtn = cartBtn;
        this.enterBtn = enterBtn;
        this.filter = filter;
    }

    public void navigateToMainPage(String url){
        driver.get(url);
    }

    public boolean findElements(){
        WaitUtils.waitForElement(driver, filter);
        return cartBtn.isDisplayed() && enterBtn.isDisplayed() && filter.isDisplayed();
    }

    public void close(){
        driver.quit();
    }
}
