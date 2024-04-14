package threadTermination;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new LongComputation(new BigInteger("2"), new BigInteger("10")));
        thread.start();
    }

    private static class BlockingTask implements Runnable {
        @Override
        public void run() {
            //do things
            try {
                Thread.sleep(50000);
            } catch (InterruptedException e) {
                System.out.println("Existing blocking thread");
            }
        }
    }

    public static class LongComputation implements Runnable {

        private BigInteger base;
        private BigInteger power;

        public LongComputation(BigInteger base, BigInteger power){
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            System.out.println(base + "^" + power + " = " + pow(base, power));
        }

        private BigInteger pow(BigInteger base, BigInteger power) {
            BigInteger result = BigInteger.ONE;
            for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
                result = result.multiply(base);
            }
            return result;
        }
    }
}