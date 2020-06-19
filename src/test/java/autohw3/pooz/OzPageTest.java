package autohw3.pooz;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OzPageTest {
    private OzPage ozPage;

    @BeforeClass
    public void before() {
        ozPage = new OzPage();
        ozPage.navigateToMainPage("https://oz.by/");
    }

    @Test
    public void check(){
        Assert.assertTrue(ozPage.findElements());
    }

    @AfterClass
    public void tearDown() {
        ozPage.close();
    }
}
