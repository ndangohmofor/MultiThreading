package simple_countDown_latch;

public class SimpleCountDownLatch {
    private int count;
    private final Object lock = new Object();

    public SimpleCountDownLatch(int count) {
        this.count = count;
        if (count < 0) {
            throw new IllegalArgumentException("count cannot be negative");
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
        synchronized (lock) {
            while (this.count > 0) {
                lock.wait();
            }
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
        synchronized (lock) {
            while (this.count > 0) {
                this.count--;
            }
        }
    }

    /**
     * Returns the current count.
     */
    public int getCount() {
        /**
         * Fill in your code
         */
        synchronized (lock) {
            return count;
        }
    }
}
