package autohw2.calculator;

import autohw2.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeClass
    public void prep(){
        calculator = new Calculator(8,2);
    }

    @Test
    public void add(){
        int expRes = 10;
        int actResult = calculator.addition();
        Assert.assertEquals(expRes,actResult);
    }

    @Test
    public void subtr(){
        int expRes = 6;
        int actResult = calculator.subtraction();
        Assert.assertEquals(expRes,actResult);
    }

    @Test
    public void mult(){
        int expSum = 16;
        int actResult = calculator.multiplication();
        Assert.assertEquals(expSum,actResult);
    }

    @Test
    public void div(){
        double expSum = 4;
        double actResult = calculator.division();
        Assert.assertEquals(expSum,actResult);
    }

    @Test
    public void squ(){
        int expSum = 64;
        int actResult = calculator.square();
        Assert.assertEquals(expSum,actResult);
    }
}
