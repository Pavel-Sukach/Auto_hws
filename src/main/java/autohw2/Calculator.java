package autohw2;

public class Calculator {
    int oper1;
    int oper2;

    public Calculator(int oper1, int oper2){
        this.oper1 = oper1;
        this.oper2 = oper2;
    }

    public int addition(){
        return oper1 + oper2;
    }
    public int subtraction(){
        return oper1 - oper2;
    }
    public int multiplication(){
        return oper1 * oper2;
    }
    public double division(){
        return (double)(oper1 / oper2);
    }
    public int square(){
        return oper1 * oper1;
    }

    public static void main(String[] args) {
        //Calculator calculator = new Calculator(6, 3);
        //calculator.addition();
        //calculator.subtraction();
        //calculator.multiplication();
        //calculator.division();
        //calculator.square();
    }
}
