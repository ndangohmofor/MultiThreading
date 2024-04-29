package simple_countDown_latch;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SimpleCountDownLock1 {

    private int count;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public SimpleCountDownLock1(int count) {
        this.count = count;
        if (this.count < 0) {
            throw new IllegalArgumentException("Count cannot be negative");
        }
    }

    /**
     * Causes the current thread to wait until the latch has counted down to zero.
     * If the current count is already zero then this method returns immediately.
     */
    public void await() throws InterruptedException {
        /**
         * Fill in your code
         */
        lock.lock();
        try {
            while (this.count > 0) {
                condition.await();
            }
        } finally {
            lock.unlock();
        }
    }

    /**
     * Decrements the count of the latch, releasing all waiting threads when the count reaches zero.
     * If the current count already equals zero then nothing happens.
     */
    public void countDown() {
        /**
         * Fill in your code
         */
        lock.lock();
        try {
            if (this.count > 0) {
                this.count--;
            }
            if (this.count == 0) {
                condition.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }

    /**
     * Returns the current count.
     */
    public int getCount() {
        /**
         * Fill in your code
         */
    }
}
