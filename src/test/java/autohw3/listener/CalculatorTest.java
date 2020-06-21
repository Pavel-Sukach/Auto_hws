package autohw3.listener;

import autohw3.listeners.MyTestListener;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(value = MyTestListener.class)
public class CalculatorTest {

    @BeforeClass
    public void init(){
        System.out.println("Calculator testing has started");
    }

    @Test(dataProvider = "dataSum")
    public void sum(double a){
        double expectedResult = 50;
        double actualResult = 25 + a;
        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void multiply(){
        double expectedResult = 25;
        double actualResult = 5 * 5;
        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void division(){
        double expectedResult = 2;
        double actualResult = 10 / 5;
        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void subtraction(){
        double expectedResult = 0;
        double actualResult = 100 - 100;
        Assert.assertEquals(expectedResult,actualResult);
        throw new SkipException("Skip this exception!");
    }

    @DataProvider(name = "dataSum")
    public Object[] provideDate(){
        return new Object[][]{{1},{100},{4},{5},{25}};
    }
}
