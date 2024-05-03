package thread.virtual_threads;

import java.util.ArrayList;
import java.util.List;

public class VirtualThreadsDemo {
    private static final int NUMBER_OF_VIRTUAL_THREADS = 100;

    public static void main(String[] args) throws InterruptedException {
        List<Thread> virtualThreads = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_VIRTUAL_THREADS; i++) {
            Thread thread = Thread.ofVirtual().unstarted(new BlockingTask());
            virtualThreads.add(thread);
        }

        for (Thread thread : virtualThreads) {
            thread.start();
        }

        for (Thread thread : virtualThreads) {
            thread.join();
        }
    }

    public static class BlockingTask implements Runnable {
        @Override
        public void run() {
            System.out.println("Inside thread: " + Thread.currentThread() + " before blocking call");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Inside thread: " + Thread.currentThread() + " after blocking call");
        }
    }
}
