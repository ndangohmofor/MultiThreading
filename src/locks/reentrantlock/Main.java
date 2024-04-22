package locks.reentrantlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static class PriceContainer {

        private Lock lockObject = new ReentrantLock();
        private double bitcoinPrice;
        private double etherPrice;
        private double litecoinPrice;
        private double bitcoinCashPrice;
        private double ripplePrice;

        public Lock getLockObject() {
            return lockObject;
        }

        public void setLockObject(Lock lockObject) {
            this.lockObject = lockObject;
        }

        public double getBitcoinPrice() {
            return bitcoinPrice;
        }

        public void setBitcoinPrice(double bitcoinPrice) {
            this.bitcoinPrice = bitcoinPrice;
        }

        public double getEtherPrice() {
            return etherPrice;
        }

        public void setEtherPrice(double etherPrice) {
            this.etherPrice = etherPrice;
        }

        public double getLitecoinPrice() {
            return litecoinPrice;
        }

        public void setLitecoinPrice(double litecoinPrice) {
            this.litecoinPrice = litecoinPrice;
        }

        public double getBitcoinCashPrice() {
            return bitcoinCashPrice;
        }

        public void setBitcoinCashPrice(double bitcoinCashPrice) {
            this.bitcoinCashPrice = bitcoinCashPrice;
        }

        public double getRipplePrice() {
            return ripplePrice;
        }

        public void setRipplePrice(double ripplePrice) {
            this.ripplePrice = ripplePrice;
        }
    }

    public static class PriceUpdater extends Thread {
        private PriceContainer priceContainer;
        private Random random = new Random();

        public PriceUpdater(PriceContainer priceContainer) {
            this.priceContainer = priceContainer;
        }

        @Override
        public void run() {
            while (true) {
                priceContainer.getLockObject().lock();
                try {
                    priceContainer.setBitcoinPrice(random.nextInt(20000));
                    priceContainer.setEtherPrice(random.nextInt(2000));
                    priceContainer.setLitecoinPrice(random.nextInt(500));
                    priceContainer.setBitcoinCashPrice(random.nextInt(5000));
                    priceContainer.setRipplePrice(random.nextDouble());
                } finally {
                    priceContainer.getLockObject().unlock();
                }
            }
        }
    }
}