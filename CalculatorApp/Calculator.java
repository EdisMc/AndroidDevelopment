package bg.tu.varna.calculator;

public class Calculator {
    private int firstNum, secondNum;

    public Calculator(int firstNum, int secondNum) {
        this.firstNum = firstNum;
        this.secondNum = secondNum;
    }

    public int add() {
        return firstNum + secondNum;
    }

    public int subtract() {
        return firstNum - secondNum;
    }

    public int multiply() {
        return firstNum * secondNum;
    }

    public int divide() {
        return firstNum / secondNum;
    }

}
