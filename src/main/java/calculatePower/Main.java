package calculatePower;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        ComplexCalculation cal = new ComplexCalculation();
        BigInteger result = cal.calculateResult(BigInteger.valueOf(100), BigInteger.valueOf(50), BigInteger.valueOf(500), BigInteger.valueOf(100));
        System.out.println(result);
    }
}
